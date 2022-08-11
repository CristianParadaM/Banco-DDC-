package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import model.Account;
import model.Bank;
import model.BankingTransaction;
import model.EnumRecoveryQuestion;
import model.EnumTypeAccount;
import model.EnumTypeTransaction;
import model.State;
import model.User;
import persistence.LastConnectionPersistence;
import persistence.ListBankingTransactionPersistence;
import persistence.UserListPersistence;
import view.Constants;
import view.CyFPaletteApp;
import view.viewApp;
import view.viewJFrameMain.MainPanel.JActiveButtonDepositMoney;
import view.viewJFrameMain.MainPanel.JActiveButtonLogOut;
import view.viewJFrameMain.MainPanel.JActiveButtonTransferMoney;
import view.viewJFrameMain.MainPanel.JActiveButtonWithDrawals;

/**
 * Clase que maneja el objeto Controller.java
 *
 * @author Cristian David Parada Martinez 
 * @date 6/05/2021
 *
 */
public class ControllerApp implements ActionListener, ItemListener, WindowListener, MouseListener {

	private static ControllerApp controllerApp = null;
	private viewApp viewApp;
	private Bank bank;
	private UserListPersistence listPersistence;
	private ListBankingTransactionPersistence listBankingTransactionPersistence;
	private LastConnectionPersistence connectionPersistence;
	private User actualUser;
	private User recoveryUser;
	private boolean createUser;

	/**
	 * Metodo estatico que retorna la instancia de ControllerApp
	 */
	public static ControllerApp getInstance() {
		if (controllerApp == null) {
			controllerApp = new ControllerApp();
		}
		return controllerApp;
	}

	/**
	 * Constructor de Controller
	 * 
	 * @param jFrameMainWindow
	 */
	private ControllerApp() {
		super();
		this.viewApp = new viewApp();
		this.listPersistence = new UserListPersistence();
		this.listBankingTransactionPersistence = new ListBankingTransactionPersistence();
		this.bank = new Bank(listPersistence.getUsers(),
				listBankingTransactionPersistence.getGroupBankingTransaction());
		this.actualUser = null;
		this.connectionPersistence = new LastConnectionPersistence();
		this.createUser = false;
	}

	/**
	 * Metodo que inicia la aplicacion
	 */
	public void runApp() {
		this.viewApp.showSplash();  
		this.viewApp.showFrame();
		int index = bank.getUsers().search(connectionPersistence.getUserName(), 0, bank.getUsers().size());
		if (index != -1) {
			actualUser = bank.getUsers().get(index);
			initLoginPreviusUser();
		} else {
			this.viewApp.showFrameInitialLogin();
		}
	}

	/**
	 * Metodo que inicia sesion con el usuario que ha marcado permanecer conectado
	 */
	private void initLoginPreviusUser() {
		this.viewApp.setInformation(actualUser.getName(), actualUser.getLastName(),
				actualUser.getAccount().getNumberAccount(), actualUser.getUserName(),
				actualUser.getAccount().getTypeAccount().name(), actualUser.getAccount().getMoney(),
				actualUser.getLastConnection());
		if (this.connectionPersistence.getTheme() != CyFPaletteApp.THEME_ORDINAL) {
			CyFPaletteApp.changeThemeLight();
		}
		if (!this.connectionPersistence.getLenguaje().equals(Constants.LANGUAJE_ACTUAL)) {
			Constants.getInstance().changeLanguajeEN();
		}
		viewApp.getjFrameMainWindow().createComponents();
	}

	/**
	 * Metodo que retorna una matriz con la informacion de las transacciones
	 * bancarias del usuario
	 * 
	 * @return matriz con la informacion
	 */
	public Object[][] getInfoBankingTransaction() {
		ArrayList<BankingTransaction> arrayList = bank.getBankingTransactions()
				.getBankingTransactionUser(actualUser.getUserName());
		Object[][] info = new Object[arrayList.size()][3];
		for (int i = 0; i < arrayList.size(); i++) {
			info[i][0] = arrayList.get(i).getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss"));
			info[i][1] = Constants.getInstance().getProperty("" + arrayList.get(i).getType());
			info[i][2] = arrayList.get(i).getMoneyAmount();
		}
		return info;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.COMMAND_JBUTTON_LOGIN:
			login();
			break;
		case Constants.COMMAND_JBUTTON_MY_MOVEMENTS:
			this.viewApp.activateBankinTransaction(getInfoBankingTransaction());
			break;
		case Constants.COMMAND_JBUTTON_QUESTION_FP:
			verifyQuestionFP();
			break;
		case Constants.COMMAND_JBUTTON_VERIFY_FOGOTP:
			verifyAnswerFP();
			break;
		case Constants.COMMAND_JBUTTON_LOG_OUT:
			logOut();
			break;
		case Constants.COMMAND_JBUTTON_NEXT_REGISTER:
			preValidateUser();
			break;
		case Constants.COMMAND_JBUTTON_SEND_CREATE_ACCOUNT:
			this.createUser = true;
			preValidateUser();
			break;
		case Constants.COMMAND_DELETE_ACCOUNT:
			deleteAccount();
			break;
		case Constants.COMMAND_CHANGE_PASSWORD:
			changePass();
			break;
		case Constants.COMMAND_ACCEPT_DEPOSIT:
			depositMoney();
			break;
		case Constants.COMMAND_ACCEPT_WITHDRAWALS:
			withDrawals();
			break;
		case Constants.COMMAND_ACCEPT_TRANSFER:
			transferMoney();
			break;
		}
	}

	/**
	 * Metodo que maneja la accion de transferir dinero
	 */
	private void transferMoney() {
		String passWordAccount = viewApp.getPasswordAccountTransaction();
		if (passWordAccount.equals(actualUser.getAccount().getPasswordAcount())) {
			int numberAccountToTransfer = Integer.parseInt(viewApp.getNumberAccountToDeposit());
			int index = bank.getUsers().search(numberAccountToTransfer);
			if (index != -1) {
				User user = bank.getUsers().get(index);
				if (user.getState() == State.ACTIVE) {
					double money = Double.parseDouble(viewApp.getMoneyToTransfer());
					if (bank.removeMoneyUser(actualUser.getAccount().getNumberAccount(), money)) {

						bank.addMoneyUser(user.getAccount().getNumberAccount(), money);

						BankingTransaction bankingTransaction = new BankingTransaction(user.getUserName(),
								LocalDateTime.now(), EnumTypeTransaction.DEPOSIT_MONEY, money);
						bank.getBankingTransactions().addBankingTransaction(bankingTransaction);
						listBankingTransactionPersistence.add(bankingTransaction);
						listPersistence.replaceUser(user);

						JOptionPane.showMessageDialog(null,
								Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_MONEY_TRANSFER),
								Constants.getInstance().getProperty(Constants.MESSAGE_CONGRATULATIONS),
								JOptionPane.DEFAULT_OPTION);

						BankingTransaction bankingTransaction2 = new BankingTransaction(actualUser.getUserName(),
								LocalDateTime.now(), EnumTypeTransaction.TRANSFER_MONEY, money);
						bank.getBankingTransactions().addBankingTransaction(bankingTransaction2);
						listBankingTransactionPersistence.add(bankingTransaction2);
						listPersistence.replaceUser(actualUser);

						this.viewApp.setInformation(actualUser.getName(), actualUser.getLastName(),
								actualUser.getAccount().getNumberAccount(), actualUser.getUserName(),
								actualUser.getAccount().getTypeAccount().name(), actualUser.getAccount().getMoney(),
								actualUser.getLastConnection());

						this.viewApp.actualiceJFrame();
					} else {
						JOptionPane.showMessageDialog(null,
								Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_NOT_FOUNDS), "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null,
							Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_USER_DONT_EXIST), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null,
						Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_USER_DONT_EXIST), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null,
					Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_INVALID_PASS), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que maneja la accion de depositar dinero
	 */
	private void withDrawals() {
		String passWordAccount = viewApp.getPasswordAccountWithDrawals();
		if (passWordAccount.equals(actualUser.getAccount().getPasswordAcount())) {
			double money = Double.parseDouble(viewApp.getMoneyToWithDrawals());
			if (bank.removeMoneyUser(actualUser.getAccount().getNumberAccount(), money)) {
				JOptionPane.showMessageDialog(null,
						Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_MONEY_WITHDRAWALS),
						Constants.getInstance().getProperty(Constants.MESSAGE_CONGRATULATIONS),
						JOptionPane.DEFAULT_OPTION);
				this.viewApp.setInformation(actualUser.getName(), actualUser.getLastName(),
						actualUser.getAccount().getNumberAccount(), actualUser.getUserName(),
						actualUser.getAccount().getTypeAccount().name(), actualUser.getAccount().getMoney(),
						actualUser.getLastConnection());

				BankingTransaction bankingTransaction = new BankingTransaction(actualUser.getUserName(),
						LocalDateTime.now(), EnumTypeTransaction.WITHDRAWALS, money);
				bank.getBankingTransactions().addBankingTransaction(bankingTransaction);
				listBankingTransactionPersistence.add(bankingTransaction);
				listPersistence.replaceUser(actualUser);
				this.viewApp.actualiceJFrame();
			} else {
				JOptionPane.showMessageDialog(null,
						Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_NOT_FOUNDS), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null,
					Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_INVALID_PASS), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que maneja la accion de depositar dinero
	 */
	private void depositMoney() {
		String passWordAccount = viewApp.getPasswordAccountDeposit();
		if (passWordAccount.equals(actualUser.getAccount().getPasswordAcount())) {
			double money = Double.parseDouble(viewApp.getMoneyToDeposit());
			bank.addMoneyUser(actualUser.getAccount().getNumberAccount(), money);
			JOptionPane.showMessageDialog(null,
					Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_MONEY_DEPOSIT),
					Constants.getInstance().getProperty(Constants.MESSAGE_CONGRATULATIONS), JOptionPane.DEFAULT_OPTION);
			this.viewApp.setInformation(actualUser.getName(), actualUser.getLastName(),
					actualUser.getAccount().getNumberAccount(), actualUser.getUserName(),
					actualUser.getAccount().getTypeAccount().name(), actualUser.getAccount().getMoney(),
					actualUser.getLastConnection());
			BankingTransaction bankingTransaction = new BankingTransaction(actualUser.getUserName(),
					LocalDateTime.now(), EnumTypeTransaction.DEPOSIT_MONEY, money);
			bank.getBankingTransactions().addBankingTransaction(bankingTransaction);
			listBankingTransactionPersistence.add(bankingTransaction);
			listPersistence.replaceUser(actualUser);
			this.viewApp.actualiceJFrame();
		} else {
			JOptionPane.showMessageDialog(null,
					Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_INVALID_PASS), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que maneja la accion de cambiar contraseña
	 */
	private void changePass() {
		String actualPass = JOptionPane
				.showInputDialog(Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_PASS_ACTUAL));
		if (actualPass != null) {
			if (actualPass.equals(actualUser.getPassword())) {
				String newPass = "";
				newPass = JOptionPane.showInputDialog(
						Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_YOUR_NEW_PASS));
				if (newPass.length() > 10) {
					JOptionPane.showMessageDialog(null,
							Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_PASS_LENGTH), "Error",
							JOptionPane.ERROR_MESSAGE);
					changePass();
				} else {
					actualUser.setPassword(newPass);
					listPersistence.replaceUser(actualUser);
					JOptionPane.showMessageDialog(null,
							Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_CAN_CHANGE_PASS),
							Constants.getInstance().getProperty(Constants.MESSAGE_CONGRATULATIONS),
							JOptionPane.OK_OPTION);
				}
			} else {
				JOptionPane.showMessageDialog(null,
						Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_INVALID_PASS), "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	/**
	 * Metodo que maneja la accion de borrar cuenta
	 */
	private void deleteAccount() {
		if (JOptionPane.showConfirmDialog(null,
				Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE__YOU_CAN_DELETE_ACC)) == 0) {
			if (bank.getUsers().deleteUser(actualUser.getUserName())) {
				JOptionPane.showMessageDialog(null,
						Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_DELETE_ACC),
						Constants.getInstance().getProperty(Constants.MESSAGE_DELETE), JOptionPane.OK_OPTION);
				connectionPersistence.registerDefaultData();
				listPersistence.replaceUser(actualUser);
				this.viewApp.getjFrameMainWindow().setVisible(false);
				this.viewApp.showFrameInitialLogin();
			} else {
				JOptionPane.showMessageDialog(null,
						Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_CANT_DELETE_ACC), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Metodo que maneja la opcion de registrarse
	 */
	private void preValidateUser() {
		String name = viewApp.getNameRegister();
		String lastname = viewApp.getLastNameRegister();
		String numberDocument = viewApp.getDocumentNumberRegister();
		String date = viewApp.getDateOfBirthRegister();
		String username = viewApp.getUserNameRegister();
		String password = viewApp.getPasswordRegister();
		String confirmpassword = viewApp.getConfirmPasswordRegister();
		String typeAccount = viewApp.getTypeAccountRegister();
		String initialAmount = viewApp.getInitialAmountRegister();
		String passAccount = viewApp.getPasswordAccountRegister();
		String confirmPassAccount = viewApp.getConfirmPasswordAccountRegister();
		validateInfoRegister(name, lastname, numberDocument, date, username, password, confirmpassword, typeAccount,
				initialAmount, passAccount, confirmPassAccount);
	}

	/**
	 * Metodo que valida la informacion y crea un usuario
	 */
	private void validateInfoRegister(String name, String lastName, String numberDocument, String date, String username,
			String password, String confirmPassword, String typeAccount, String initialMoney, String passAccount,
			String confirmPassAccount) {

		int count = 0;
		if (!name.isBlank() && name.length() <= 20) {
			count++;
			viewApp.setCorrectNameRegister();
		} else {
			viewApp.setIncorrectNameRegister();
		}
		if (!lastName.isBlank() && lastName.length() <= 20) {
			count++;
			viewApp.setCorrectLastNameRegister();
		} else {
			viewApp.setIncorrectLastNameRegister();
		}

		if (!numberDocument.isBlank()) {
			count++;
			viewApp.setCorrectDocumentNumberRegister();
		} else {
			viewApp.setIncorrectDocumentNumberRegister();
		}
		int index = bank.getUsers().search(username, 0, bank.getUsers().size());
		if (!username.isBlank() && index == -1) {
			count++;
			viewApp.setCorrectUserNameRegister();
		} else {
			viewApp.setIncorrectUserNameRegister();
		}

		if (!date.isBlank()) {
			if (bank.isAdult(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
					&& LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).isBefore(LocalDate.now())) {
				count++;
				viewApp.setCorrectDateOfBirthRegister();
			} else {
				viewApp.setIncorrectDateOfBirthRegister();
			}
		} else {
			viewApp.setIncorrectDateOfBirthRegister();
		}

		if (!password.isBlank()) {
			if (password.equals(confirmPassword)) {
				viewApp.setCorrectPasswordRegister();
				viewApp.setCorrectConfirmPasswordRegister();
				count++;
			} else {
				viewApp.setIncorrectPasswordRegister();
				viewApp.setIncorrectConfirmPasswordRegister();
			}
		} else {
			viewApp.setIncorrectPasswordRegister();
			if (confirmPassword.isBlank()) {
				viewApp.setIncorrectConfirmPasswordRegister();
			}
		}
		if (!initialMoney.isBlank() && Double.parseDouble(initialMoney) >= 100000) {
			count++;
			viewApp.setCorrectInitialAmountRegister();
		} else {
			viewApp.setIncorrectInitialAmountRegister();
		}
		if (!passAccount.isBlank()) {
			if (passAccount.equals(confirmPassAccount)) {
				count++;
				viewApp.setCorrectPasswordAccountRegister();
				viewApp.setCorrectConfirmPasswordAccountRegister();
			} else {
				viewApp.setIncorrectPasswordAccountRegister();
				viewApp.setIncorrectConfirmPasswordAccountRegister();
			}
		} else {
			viewApp.setIncorrectPasswordAccountRegister();
			if (confirmPassAccount.isBlank()) {
				viewApp.setIncorrectConfirmPasswordAccountRegister();
			}
		}
		if (count == 8) {
			this.viewApp.activateQuestion();
			if (createUser) {
				int question = viewApp.getQuestionSelected();
				String answer = viewApp.getAnswer();
				String confirmateAnswer = viewApp.getConfirmationAnswer();
				int valueTypeAccount = typeAccount
						.equals(Constants.getInstance().getProperty(Constants.SAVINGS_ACCOUNT)) ? 0 : 1;

				if (answer.equals(confirmateAnswer)) {
					connectionPersistence.setNumberAccount(connectionPersistence.getNumberAccount() + 1);

					User user = new User(Integer.parseInt(numberDocument), username, name, lastName,
							EnumRecoveryQuestion.values()[question], confirmateAnswer,
							new Account(connectionPersistence.getNumberAccount(),
									EnumTypeAccount.values()[valueTypeAccount], passAccount,
									Double.parseDouble(initialMoney)),
							confirmPassword, State.ACTIVE,
							LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					bank.getUsers().addUser(user);
					listPersistence.add(user);
					JOptionPane.showMessageDialog(null,
							Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_USER_CREATE),
							Constants.getInstance().getProperty(Constants.CONGRATULATIONS), JOptionPane.DEFAULT_OPTION);
					viewApp.desactiveRegister();

				} else {
					JOptionPane.showMessageDialog(null,
							Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_ANSWERS_DONT_SIMILAR),
							"error", JOptionPane.ERROR_MESSAGE);
				}
				createUser = false;
			}
		} else {
			JOptionPane.showMessageDialog(null,
					Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_SOME_REGISTER_ERROR), "error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que maneja la accion de cerrar sesion
	 */
	private void logOut() {
		if (JOptionPane.showConfirmDialog(null,
				Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_WANT_LOGOUT)) == 0) {
			this.actualUser.setLastConnection(LocalDate.now());
			listPersistence.replaceUser(actualUser);
			this.connectionPersistence.registerDefaultData();
			this.viewApp.getjFrameMainWindow().setVisible(false);
			this.viewApp.showFrameInitialLogin();
		}
	}

	/**
	 * Metodo que verifica la respuesta puesta en Olvido su contraseña
	 */
	private void verifyAnswerFP() {
		String verifyAnswer = viewApp.getAnswerFP();
		if (verifyAnswer.equals(recoveryUser.getAnswer())) {
			JOptionPane.showMessageDialog(null,
					Constants.getInstance().getProperty(Constants.MESSAGE_YOUR_PASSWORD_IS)
							+ recoveryUser.getPassword(),
					Constants.getInstance().getProperty(Constants.CONGRATULATIONS), JOptionPane.DEFAULT_OPTION);
		} else {
			JOptionPane.showMessageDialog(null,
					Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_INCORRECT_ANSWER), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que verifica si el usuario existe y pone la pregunta registrada en
	 * olvido su contraseña
	 */
	private void verifyQuestionFP() {
		String username = viewApp.getUsernameFP();
		int index = bank.getUsers().search(username, 0, bank.getUsers().size());
		if (index != -1) {
			this.recoveryUser = bank.getUsers().get(index);
			if (recoveryUser.getState() == State.ACTIVE) {
				viewApp.setTextJTextFieldFP(Constants.getInstance().getProperty(
						Constants.getMessageRecoveryQuestion(recoveryUser.getRecoveryQuestion().ordinal())));
				viewApp.setEnabledFP(true);
			} else {
				viewApp.setEnabledFP(false);
				viewApp.setTextJTextFieldFP(Constants.getInstance().getProperty(Constants.MESSAGE_CANT_FIND_USER));
			}
		} else {
			viewApp.setEnabledFP(false);
			viewApp.setTextJTextFieldFP(Constants.getInstance().getProperty(Constants.MESSAGE_CANT_FIND_USER));
		}
	}

	/**
	 * Metodo que hace las validaciones respectivas al darle click al boton iniciar
	 * sesion
	 */
	private void login() {
		if (viewApp.getjTextFieldUserText().isBlank() && viewApp.getjPasswordFieldText().isBlank()) {
			JOptionPane.showMessageDialog(null,
					Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_EMPTY_DATA), "Error",
					JOptionPane.ERROR_MESSAGE);
		} else if (viewApp.getjTextFieldUserText().isBlank() || viewApp.getjPasswordFieldText().isBlank()) {
			JOptionPane.showMessageDialog(null,
					Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_INCORRECT_DATA), "Error",
					JOptionPane.WARNING_MESSAGE);
		} else {
			String username = viewApp.getjTextFieldUserText();
			String password = viewApp.getjPasswordFieldText();
			if (bank.validateDataUser(username, password)) {
				actualUser = bank.getUsers().get(bank.getUsers().search(username, 0, bank.getUsers().size()));
				if (viewApp.isSelectedCheckBoxLogin()) {
					this.connectionPersistence.registerData(username, password, Constants.LANGUAJE_ACTUAL,
							CyFPaletteApp.THEME_ORDINAL);
				}
				double moneyInterest = bank.addBankInterest(actualUser.getUserName());
				if (moneyInterest > 0) {
					BankingTransaction bankingTransaction = new BankingTransaction(actualUser.getUserName(),
							LocalDateTime.now(), EnumTypeTransaction.INTEREST, moneyInterest);
					bank.getBankingTransactions().add(bankingTransaction);
					listBankingTransactionPersistence.add(bankingTransaction);
					listPersistence.replaceUser(actualUser);
				}

				this.viewApp.setInformation(actualUser.getName(), actualUser.getLastName(),
						actualUser.getAccount().getNumberAccount(), actualUser.getUserName(),
						actualUser.getAccount().getTypeAccount().name(), actualUser.getAccount().getMoney(),
						actualUser.getLastConnection());

				viewApp.disposeLogin();
				viewApp.getjFrameMainWindow().createComponents();
			} else {
				JOptionPane.showMessageDialog(null,
						Constants.getInstance().getProperty(Constants.MESSAGE_JOPTIONPANE_INCORRECT_DATA), "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		try {
			if (viewApp.isActiveConfigDialog()) {
				switch (((String) e.getItem())) {
				case Constants.SPANISH_ES:
					Constants.getInstance().changeLanguajeEN();
					viewApp.setActiveConfigDialog(false);
					viewApp.actualiceLogin();
					break;
				case Constants.ENGLISH_EN:
					Constants.getInstance().changeLanguajeES();
					viewApp.setActiveConfigDialog(false);
					viewApp.actualiceLogin();
					break;
				case Constants.THEMEDARK_ES:
					CyFPaletteApp.changeThemeDark();
					viewApp.setActiveConfigDialog(false);
					viewApp.actualiceLogin();
					break;
				case Constants.THEMELIGTH_ES:
					CyFPaletteApp.changeThemeLight();
					viewApp.setActiveConfigDialog(false);
					viewApp.actualiceLogin();
					break;
				case Constants.THEMEDARK_EN:
					CyFPaletteApp.changeThemeDark();
					viewApp.setActiveConfigDialog(false);
					viewApp.actualiceLogin();
					break;
				case Constants.THEMELIGHT_EN:
					CyFPaletteApp.changeThemeLight();
					viewApp.setActiveConfigDialog(false);
					viewApp.actualiceLogin();
					break;
				}
			}
		} catch (NullPointerException e1) {
		}
		if (viewApp.getjPanelLateral() != null && viewApp.getjPanelLateral().isActive()) {
			switch (((String) e.getItem())) {
			case Constants.SPANISH_ES:
				Constants.getInstance().changeLanguajeEN();
				viewApp.getjPanelLateral().setActive(false);
				viewApp.actualiceJFrame();
				connectionPersistence.setLenguaje("EN");
				break;
			case Constants.ENGLISH_EN:
				Constants.getInstance().changeLanguajeES();
				viewApp.getjPanelLateral().setActive(false);
				viewApp.actualiceJFrame();
				connectionPersistence.setLenguaje("ES");
				break;
			case Constants.THEMEDARK_ES:
				CyFPaletteApp.changeThemeDark();
				viewApp.getjPanelLateral().setActive(false);
				viewApp.actualiceJFrame();
				connectionPersistence.setTheme(CyFPaletteApp.THEME_ORDINAL);
				break;
			case Constants.THEMELIGTH_ES:
				CyFPaletteApp.changeThemeLight();
				viewApp.getjPanelLateral().setActive(false);
				viewApp.actualiceJFrame();
				connectionPersistence.setTheme(CyFPaletteApp.THEME_ORDINAL);
				break;
			case Constants.THEMEDARK_EN:
				CyFPaletteApp.changeThemeDark();
				viewApp.getjPanelLateral().setActive(false);
				viewApp.actualiceJFrame();
				connectionPersistence.setTheme(CyFPaletteApp.THEME_ORDINAL);
				break;
			case Constants.THEMELIGHT_EN:
				CyFPaletteApp.changeThemeLight();
				viewApp.getjPanelLateral().setActive(false);
				viewApp.actualiceJFrame();
				connectionPersistence.setTheme(CyFPaletteApp.THEME_ORDINAL);
				break;
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		double moneyInterest = bank.addBankInterest(actualUser.getUserName());
		if (moneyInterest > 0) {
			BankingTransaction bankingTransaction = new BankingTransaction(actualUser.getUserName(),
					LocalDateTime.now(), EnumTypeTransaction.INTEREST, moneyInterest);
			bank.getBankingTransactions().add(bankingTransaction);
			listBankingTransactionPersistence.add(bankingTransaction);
			listPersistence.replaceUser(actualUser);
			this.viewApp.setInformation(actualUser.getName(), actualUser.getLastName(),
					actualUser.getAccount().getNumberAccount(), actualUser.getUserName(),
					actualUser.getAccount().getTypeAccount().name(), actualUser.getAccount().getMoney(),
					actualUser.getLastConnection());
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.actualUser.setLastConnection(LocalDate.now());
		listPersistence.replaceUser(actualUser);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getComponent() instanceof JActiveButtonDepositMoney) {
			((JActiveButtonDepositMoney) e.getComponent()).setPathImage(Constants.PATH_DEPOSIT_MONEY_IMG);
			((JActiveButtonDepositMoney) e.getComponent()).setBorder(new LineBorder(Color.BLACK, 3));
			((JActiveButtonDepositMoney) e.getComponent()).repaint();
		} else if (e.getComponent() instanceof JActiveButtonWithDrawals) {
			((JActiveButtonWithDrawals) e.getComponent()).setPathImage(Constants.PATH_WITHDRAWALS_IMG);
			((JActiveButtonWithDrawals) e.getComponent()).setBorder(new LineBorder(Color.BLACK, 3));
			((JActiveButtonWithDrawals) e.getComponent()).repaint();
		} else if (e.getComponent() instanceof JActiveButtonTransferMoney) {
			((JActiveButtonTransferMoney) e.getComponent()).setPathImage(Constants.PATH_TRANSFER_IMG);
			((JActiveButtonTransferMoney) e.getComponent()).setBorder(new LineBorder(Color.BLACK, 3));
			((JActiveButtonTransferMoney) e.getComponent()).repaint();
		} else {
			((JActiveButtonLogOut) e.getComponent()).setPathImage(Constants.PATH_LOGOUT_IMG);
			((JActiveButtonLogOut) e.getComponent()).setBorder(new LineBorder(Color.BLACK, 3));
			((JActiveButtonLogOut) e.getComponent()).repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() instanceof JActiveButtonDepositMoney) {
			((JActiveButtonDepositMoney) e.getComponent()).setPathImage(Constants.PATH_DEPOSIT_MONEY_GIF);
			((JActiveButtonDepositMoney) e.getComponent()).setBorder(new LineBorder(Color.WHITE, 3));
			((JActiveButtonDepositMoney) e.getComponent()).repaint();
		} else if (e.getComponent() instanceof JActiveButtonWithDrawals) {
			((JActiveButtonWithDrawals) e.getComponent()).setPathImage(Constants.PATH_WITHDRAWALS_GIF);
			((JActiveButtonWithDrawals) e.getComponent()).setBorder(new LineBorder(Color.WHITE, 3));
			((JActiveButtonWithDrawals) e.getComponent()).repaint();
		} else if (e.getComponent() instanceof JActiveButtonTransferMoney) {
			((JActiveButtonTransferMoney) e.getComponent()).setPathImage(Constants.PATH_TRANSFER_GIF);
			((JActiveButtonTransferMoney) e.getComponent()).setBorder(new LineBorder(Color.WHITE, 3));
			((JActiveButtonTransferMoney) e.getComponent()).repaint();
		} else {
			((JActiveButtonLogOut) e.getComponent()).setPathImage(Constants.PATH_LOGOUT_GIF);
			((JActiveButtonLogOut) e.getComponent()).setBorder(new LineBorder(Color.WHITE, 3));
			((JActiveButtonLogOut) e.getComponent()).repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent() instanceof JActiveButtonDepositMoney) {
			viewApp.activeDeposit();
		} else if (e.getComponent() instanceof JActiveButtonWithDrawals) {
			viewApp.activeWhitDrawals();
		} else if (e.getComponent() instanceof JActiveButtonTransferMoney) {
			viewApp.activeTransfer();
		} else {
			logOut();
		}
	}

	public static void main(String[] args) {
		ControllerApp.getInstance().runApp();
	}
}
