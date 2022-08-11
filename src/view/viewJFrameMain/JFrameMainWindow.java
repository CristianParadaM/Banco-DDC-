package view.viewJFrameMain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import javax.swing.JFrame;
import controller.ControllerApp;
import view.Constants;
import view.CyFPaletteApp;
import view.viewJFrameMain.MainPanel.JPanelMain;
import view.viewLogin.JDialogLogin;

/**
 * Clase que maneja el objeto JFrameMainWindow.java
 *
 * @author Cristian David Parada Martinez
 * @date 2/05/2021
 *
 */
public class JFrameMainWindow extends JFrame implements ActionListener, ItemListener{

	protected static JFrameMainWindow mainWindow = null;
	private static final long serialVersionUID = 1L;
	private JDialogLogin dialogLogin;
	private JPanelMain jPanelMain;
	private JPanelBackGroundJFrame backGroundJFrame;
	private int numberAccount;
	private String username;
	private String name;
	private String lastName;
	private String typeAccount;
	private LocalDate dateLastConnection;
	private double money;
	private JPanelLateral jPanelLateral;
	private JPanelHeader jPanelHeader;
	
	public static JFrameMainWindow getInstance() {
		if (mainWindow == null) {
			mainWindow = new JFrameMainWindow();
		}
		return mainWindow;
	}

	/**
	 * Constructor de JFrameMainWindow
	 * 
	 * @throws HeadlessException
	 */
	private JFrameMainWindow() {
		super(Constants.getInstance().getProperty(Constants.TITLE_APPNAME));
		this.backGroundJFrame = new JPanelBackGroundJFrame();
		this.username = "";
		this.numberAccount = 0;
		this.name = "";
		this.lastName = "";
		this.typeAccount = "";
		this.dateLastConnection = LocalDate.now();
		this.money =0;
	}
	
	/**
	 * Metodo que
	 * 
	 */
	public void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1600,900);
		this.setMinimumSize(new Dimension(1500,800));
		this.setLocationRelativeTo(null);
		this.addWindowListener(ControllerApp.getInstance());
		//
//		this.setContentPane(backGroundJFrame);
//		this.setLayout(new BorderLayout());
//		this.name = "Cristian";
//		this.lastName = "Parada";
//		this.numberAccount = 302354324;
//		this.username = "crisUser";
//		this.typeAccount = "CURRENT_ACCOUNT";
//		this.money = 2342312;
//		this.jPanelHeader = new JPanelHeader(name, lastName);
//		this.add(jPanelHeader, BorderLayout.NORTH);
//		this.jPanelLateral = new JPanelLateral();
//		this.jPanelLateral.setPreferredSize(new Dimension((getWidth()/4)-3, 0));
//		this.jPanelMain = new JPanelMain(numberAccount, username, typeAccount, money);
//		this.add(jPanelMain, BorderLayout.CENTER);
//		this.add(jPanelLateral, BorderLayout.WEST);
//		this.setVisible(true); //TODO quitar
    	//
	}
	
	/**
	 * Metodo que inicia el login
	 */
	public void initLoginDefault() {
		this.dialogLogin = new JDialogLogin(this);
		this.dialogLogin.createComponents();
	}
	
	/** Metodo que inicializa el panel principal
	 */
	public void createComponents() {
		this.backGroundJFrame = new JPanelBackGroundJFrame();
		this.setContentPane(backGroundJFrame);
		this.setLayout(new BorderLayout());
		this.jPanelHeader = new JPanelHeader(name, lastName);
		this.add(jPanelHeader, BorderLayout.NORTH);
		this.jPanelLateral = new JPanelLateral();
		this.jPanelLateral.setPreferredSize(new Dimension((getWidth()/4)-3, 0));
		this.jPanelMain = new JPanelMain(numberAccount, username, typeAccount, money, dateLastConnection);
		this.add(jPanelMain, BorderLayout.CENTER);
		this.add(jPanelLateral, BorderLayout.WEST);
		this.setVisible(true);
	}

	/**
	 * Metodo que cambia el tema al fondo del frame
	 * @param newPath
	 */
	public void setPathAndRepaintTheme(String newPath) {
		this.backGroundJFrame.setPathAndRepaintTheme(newPath);
	}
	
	/**
	 * Metodo que pone la informacion del usuario
	 * @param name
	 * @param lastName
	 * @param numberAccount
	 * @param username
	 * @param typeAccount
	 * @param money
	 */
	public void setInformation(String name, String lastName, int numberAccount, String username, String typeAccount, double money, LocalDate date) {
		this.name = name;
		this.lastName = lastName;
		this.numberAccount = numberAccount;
		this.username = username;
		this.typeAccount = typeAccount;
		this.money = money;
		this.dateLastConnection = date;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.COMMAND_JBUTTON_MY_MOVEMENTS:
			break;
		case Constants.COMMAND_CROSS_EXIT:
			this.dialogLogin.exitJDialogLogin();
			this.dispose();
			break;
		case Constants.COMMAND_JBUTTON_ARROW_BACK_FORGOTP:
			this.dialogLogin.desactiveForgotPass();
			break;
		case Constants.COMMAND_HELP:
			this.dialogLogin.activateCredits();
			break;
		case Constants.COMMAND_JBUTTON_ARROW_BACK_CREDITS:
			this.dialogLogin.desactivateCredits();
			break;
		case Constants.COMMAND_JBUTTON_FORGOTPASS:
			this.dialogLogin.activeForgotPass();
			break;
		case Constants.COMMAND_BUTTON_CONFIG_JFRAME:
			if (!jPanelLateral.isActive()) {
				jPanelLateral.setActive(true);
			}else {
				jPanelLateral.setActive(false);
			}
			break;
		case Constants.COMMAND_JBUTTON_REGISTER:
			this.dialogLogin.activeRegister();
			break;
		case Constants.COMMAND_JBUTTON_ARROW_BACK_REGISTER:
			this.dialogLogin.desactiveRegister();
			break;
		case Constants.COMMAND_JBUTTON_ARROW_BACK_QUESTIONS:
			this.dialogLogin.desactivateQuestion();
			break;
		case Constants.COMMAND_JBUTTON_ABOUT_US_JFRAME:
			this.jPanelMain.activeCredits();
			if (jPanelMain.isVisibleConfig()) {
				jPanelMain.setVisibleConfig(false);
			}
			break;
		case Constants.COMMAND_JBUTTON_ARROW_BACK_CREDITS_JFRAME:
			this.jPanelMain.desactiveCredits();
			break;
		case Constants.COMMAND_CONFIG_CORNER_JFRAME:
			if (!jPanelMain.isVisibleConfig()) {
				jPanelMain.setVisibleConfig(true);
			}else {
				jPanelMain.setVisibleConfig(false);
			}
			break;
		case Constants.COMMAND_JBUTTON_PRINT:
			jPanelMain.printTable();
			break;
		case Constants.COMMAND_JBUTTON_ARROW_BACK_BANKING_TRANSACTION:
			this.jPanelMain.desactivateBankinTransaction();
			break;
			//
		case Constants.COMMAND_JBUTTON_SETTING:
			this.jPanelMain.activateConfigurations();
			break;
		case Constants.COMMAND_BEHIND:
			this.jPanelMain.desactivateConfigurations();
			break;
		case Constants.COMMAND_JBUTTON_DEPOSIT:
			this.jPanelMain.activeDeposit();
			break;
		case Constants.COMMAND_JBUTTON_ARROW_BACK_DEPOSIT:
			this.jPanelMain.desactivateDeposit();
			break;
		case Constants.COMMAND_JBUTTON_WITHDRAWALS:
			this.jPanelMain.activeWithDrawals();
			break;
		case Constants.COMMAND_JBUTTON_ARROW_BACK_WITHDRAWALS:
			this.jPanelMain.desactivateWithDrawals();
			break;
		case Constants.COMMAND_JBUTTON_TRANSFERM:
			this.jPanelMain.activeTransaction();
			break;
		case Constants.COMMAND_JBUTTON_ARROW_BACK_TRANSFER:
			this.jPanelMain.desactiveTransaction();
			break;
		}
	}

	/**
	 * Metodo que visualiza el panel con la tabla de transacciones bancarias
	 * @param info informacion de transacciones bancarias a mostrar
	 */
	public void activateBankinTransaction(Object[][] info) {
		this.jPanelMain.activateBankinTransaction(info);
	}
	
	public void actualice() {
		this.setVisible(false);
		this.getContentPane().removeAll();
		createComponents();
	}
	
	/**
	 * Metodo que retorna el nombre de usuario digitado en olvido su contraseña
	 * 
	 * @return username
	 */
	public String getUsernameFP() {
		return dialogLogin.getUsernameFP();
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (jPanelLateral!= null && jPanelLateral.isActive()) {
			switch (((String) e.getItem())) {
			case "Español":
				Constants.getInstance().changeLanguajeEN();
				jPanelLateral.setActive(false);
				actualice();
				break;
			case "English":
				Constants.getInstance().changeLanguajeES();
				jPanelLateral.setActive(false);
				actualice();
				break;
			case "Oscuro":
				CyFPaletteApp.changeThemeDark();
				jPanelLateral.setActive(false);
				actualice();
				break;
			case "Claro":
				CyFPaletteApp.changeThemeLight();
				jPanelLateral.setActive(false);
				actualice();
				break;
			case "Dark":
				CyFPaletteApp.changeThemeDark();
				jPanelLateral.setActive(false);
				actualice();
				break;
			case "Light":
				CyFPaletteApp.changeThemeLight();
				jPanelLateral.setActive(false);
				actualice();
				break;
			}
		}
	}
	
	/**
	 * Metodo que actualiza el jdialogLogin
	 */
	public void actualiceLogin() {
		dialogLogin.actualice();
	}
	
	/**
	 * Metodo que retorna si esta seleccionado el check box de permanecer conectado
	 * @return
	 */
	public boolean isSelectedCheckBoxLogin() {
		return dialogLogin.isSelectedCheckBoxLogin();
	}
	
	/**
	 * Metodo que cambia el texto de pregunta de olvido su contraseña
	 * 
	 * @param text
	 */
	public void setTextJTextFieldFP(String text) {
		this.dialogLogin.setTextJTextFieldFP(text);
	}

	/**
	 * Metodo que desactiva o activa los botones y cajas de texto de olvido su
	 * contraseña
	 */
	public void setEnabledFP(boolean isEnabled) {
		this.dialogLogin.setEnabledFP(isEnabled);
	}

	/**
	 * Metodo que devuelve la respuesta digitada en olvido su contraseña
	 * 
	 * @return
	 */
	public String getAnswerFP() {
		return this.dialogLogin.getAnswerFP();
	}
	
	/**
	 * Metodo que retorna el valor del username
	 * 
	 * @return
	 */
	public String getjTextFieldUserText() {
		return dialogLogin.getjTextFieldUserText();
	}

	/**
	 * Metodo que retorna valor de password del usuario
	 * 
	 * @return
	 */
	public String getjPasswordFieldText() {
		return dialogLogin.getjPasswordFieldText();
	}
	
	/**
	 * Metodo que cierra el dialog login
	 *
	 */
	public void disposeLogin() {
		this.dialogLogin.dispose();
	}
	
	/**
	 * Metodo que retorna si esta activo el panel de configuraciones 
	 * @return
	 */
	public boolean isActiveConfigDialog() {
		return dialogLogin.isActive();
	}
	
	/**
	 * Metodo que cambia el estado del panel de configuraciones
	 */
	public void setActiveConfigDialog(boolean b) {
		dialogLogin.setActive(b);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.jPanelLateral.setPreferredSize(new Dimension((getWidth()/4)-3, 0));
		repaint();
	}
	/**
	 * Metodo que activa el panel de deposito
	 */
	public void activeDeposit() {
		jPanelMain.activeDeposit();
	}
	/**
	 * Metodo que activa el panel de retiro
	 */
	public void activeWhitDrawals() {
		jPanelMain.activeWithDrawals();
	}
	/**
	 * Metodo que activa el panel de transferencia
	 */
	public void activeTransfer() {
		jPanelMain.activeTransaction();
	}
	
	/**
	 * @return the jPanelLateral
	 */
	public JPanelLateral getjPanelLateral() {
		return jPanelLateral;
	}
	
	/** Metodo que desactiva el panel de registro
	 */
	public void desactiveRegister() {
		this.dialogLogin.desactiveRegister();
	}
	
	/**
	 * Metodo que activa el panel de preguntas de Crea Tu cuenta
	 */
	public void activateQuestion() {
		this.dialogLogin.activateQuestion();
	}
	/**
	 * Metodo que desactiva el panel de preguntas
	 */
	public void desactivateQuestion() {
		this.dialogLogin.desactivateQuestion();
	}
	
	/**
	 * Metodo que obtiene el nombre de registro
	 * @return nombre de usuario
	 */
	public String getNameRegister() {
		return dialogLogin.getNameRegister();
	}
	
	/**
	 * Metodo que obtiene el apellido de registro
	 * @return apellido de usuario
	 */
	public String getLastNameRegister() {
		return dialogLogin.getLastNameRegister();
	}
	
	/**
	 * Metodo que obtiene el numero de documento de registro
	 * @return numero de documento de usuario
	 */
	public String getDocumentNumberRegister() {
		return dialogLogin.getDocumentNumberRegister();
	}

	/**
	 * Metodo que obtiene la fecha de nacimiento de registro
	 * @return fecha de nacimiento de usuario
	 */
	public String getDateOfBirthRegister() {
		return dialogLogin.getDateOfBirthRegister();
	}
	
	/**
	 * Metodo que obtiene el username de registro
	 * @return username de usuario 
	 */
	public String getUserNameRegister() {
		return dialogLogin.getUserNameRegister();
	}
	
	/**
	 * Metodo que obtiene la contraseña de registro
	 * @return contraseña de usuario
	 */
	public String getPasswordRegister() {
		return dialogLogin.getPasswordRegister();
	}
	
	/**
	 * Metodo que obtiene la confirmacion de contraseña de registro
	 * @return confirmacion contraseña de usuario
	 */
	public String getConfirmPasswordRegister() {
		return dialogLogin.getConfirmPasswordRegister();
	}
	/**
	 * Metodo que obtiene el tipo de cuenta de registro
	 * @return tipo de cuenta de usuario
	 */
	public String getTypeAccountRegister() {
		return dialogLogin.getTypeAccountRegister();
	}
	/**
	 * Metodo que obtiene el monto inicial de registro
	 * @return monto inicial de usuario
	 */
	public String getInitialAmountRegister() {
		return dialogLogin.getInitialAmountRegister();
	}
	/**
	 * Metodo que obtiene la contraseña de la cuenta de registro
	 * @return contraseña de la cuenta de usuario
	 */
	public String getPasswordAccountRegister() {
		return dialogLogin.getPasswordAccountRegister();
	}
	/**
	 * Metodo que obtiene la contraseña de la cuenta de registro
	 * @return contraseña de la cuenta de usuario
	 */
	public String getConfirmPasswordAccountRegister() {
		return dialogLogin.getConfirmPasswordAccountRegister();
	}
	
	
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectNameRegister() {
		dialogLogin.setIncorrectNameRegister();
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectLastNameRegister() {
		dialogLogin.setIncorrectLastNameRegister();
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectDocumentNumberRegister() {
		dialogLogin.setIncorrectDocumentNumberRegister();
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectDateOfBirthRegister() {
		dialogLogin.setIncorrectDateOfBirthRegister();
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectUserNameRegister() {
		dialogLogin.setIncorrectUserNameRegister();
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectPasswordRegister() {
		dialogLogin.setIncorrectPasswordRegister();
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectConfirmPasswordRegister() {
		dialogLogin.setIncorrectConfirmPasswordRegister();
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectInitialAmountRegister() {
		dialogLogin.setIncorrectInitialAmountRegister();
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectPasswordAccountRegister() {
		dialogLogin.setIncorrectPasswordAccountRegister();
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectConfirmPasswordAccountRegister() {
		dialogLogin.setIncorrectConfirmPasswordAccountRegister();
	}
	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectNameRegister() {
		dialogLogin.setCorrectNameRegister();
	}
	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectLastNameRegister() {
		dialogLogin.setCorrectLastNameRegister();
	}
	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectDocumentNumberRegister() {
		dialogLogin.setCorrectDocumentNumberRegister();
	}
	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectDateOfBirthRegister() {
		dialogLogin.setCorrectDateOfBirthRegister();
	}
	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectUserNameRegister() {
		dialogLogin.setCorrectUserNameRegister();
	}
	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectPasswordRegister() {
		dialogLogin.setCorrectPasswordRegister();
	}
	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectConfirmPasswordRegister() {
		dialogLogin.setCorrectConfirmPasswordRegister();
	}
	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectInitialAmountRegister() {
		dialogLogin.setCorrectInitialAmountRegister();
	}
	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectPasswordAccountRegister() {
		dialogLogin.setCorrectPasswordAccountRegister();
	}
	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectConfirmPasswordAccountRegister() {
		dialogLogin.setCorrectConfirmPasswordAccountRegister();
	}
	
	/**
	 * Metodo que obtiene la pregunta seleccionada
	 * @return pregunta seleccionada
	 */
	public int getQuestionSelected() {
		return dialogLogin.getQuestionSelected();
	}
	
	/**
	 * Metodo que obtiene la respuesta
	 * @return respuesta seleccionada
	 */
	public String getAnswer() {
		return dialogLogin.getAnswer();
	}
	/**
	 * Metodo que obtiene la confirmacion de respuesta
	 * @return respuesta seleccionada
	 */
	public String getConfirmationAnswer() {
		return dialogLogin.getConfirmationAnswer();
	}
	/**
	 * Metodo que obtiene contraseña de la cuenta
	 * @return contraseña de la cuenta
	 */
	public String getPasswordAccountDeposit() {
		return jPanelMain.getPasswordAccountDeposit();
	}
	/**
	 * Metodo que obtiene el dinero a depostiar
	 * @return dinero a depositar
	 */
	public String getMoneyToDeposit() {
		return jPanelMain.getMoneyToDeposit();
	}
	/**
	 * Metodo que obtiene contraseña de la cuenta
	 * @return contraseña de la cuenta
	 */
	public String getPasswordAccountWithDrawals() {
		return jPanelMain.getPasswordAccountWithDrawals();
	}
	/**
	 * Metodo que obtiene el dinero a retirar
	 * @return dinero a retirar
	 */
	public String getMoneyToWithDrawals() {
		return jPanelMain.getMoneyToWithDrawals();
	}
	/**
	 * Metodo que obtiene contraseña de la cuenta
	 * @return contraseña de la cuenta
	 */
	public String getPasswordAccountTransaction() {
		return jPanelMain.getPasswordAccountTransaction();
	}
	/**
	 * Metodo que el numero de cuenta del remitente
	 * @return numero de cuenta del remitente
	 */
	public String getNumberAccountToDeposit() {
		return jPanelMain.getNumberAccountToDeposit();
	}
	
	/**
	 * Metodo que obtiene el dinero a transferir
	 * @return dinero a transferir
	 */
	public String getMoneyToTransfer() {
		return jPanelMain.getMoneyToTransfer();
	}
	
}
