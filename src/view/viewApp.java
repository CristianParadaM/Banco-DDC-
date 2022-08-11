package view;

import java.awt.Font;
import java.time.LocalDate;

import view.splash.Splash;
import view.viewJFrameMain.JFrameMainWindow;
import view.viewJFrameMain.JPanelLateral;

/**
 * Clase que maneja el objeto viewApp.java
 *
 * @author Cristian David Parada Martinez
 * @date 6/05/2021
 *
 */
public class viewApp {

	private JFrameMainWindow jFrameMainWindow;

	/**
	 * Metodo que ejecuta el init de la ventana principal
	 */
	public void showFrame() {
		this.jFrameMainWindow = JFrameMainWindow.getInstance();
		this.jFrameMainWindow.init();
	}

	/**
	 * Metodo que visualiza el panel con la tabla de transacciones bancarias
	 * 
	 * @param info informacion de transacciones bancarias a mostrar
	 */
	public void activateBankinTransaction(Object[][] info) {
		this.jFrameMainWindow.activateBankinTransaction(info);
	}

	/**
	 * Metodo que
	 */
	public void showFrameInitialLogin() {
		this.jFrameMainWindow.initLoginDefault();
	}

	public void showSplash() {
		new Splash(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_APP_DESCRIPTION_SPLASH),
				Constants.PATH_IMAGE_LOGO, new Font("Arial", Font.PLAIN, 14));
		try {
			Thread.sleep(Splash.SLEEP_TIME);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * @return the jFrameMainWindow
	 */
	public JFrameMainWindow getjFrameMainWindow() {
		return jFrameMainWindow;
	}

	public void setInformation(String name, String lastName, int numberAccount, String username, String typeAccount,
			double money, LocalDate date) {
		jFrameMainWindow.setInformation(name, lastName, numberAccount, username, typeAccount, money, date);
	}

	/**
	 * Metodo que retorna el nombre de usuario digitado en olvido su contraseña
	 * 
	 * @return username
	 */
	public String getUsernameFP() {
		return jFrameMainWindow.getUsernameFP();
	}

	/**
	 * Metodo que actualiza el jdialogLogin
	 */
	public void actualiceLogin() {
		jFrameMainWindow.actualiceLogin();
	}

	/**
	 * Metodo que retorna si esta seleccionado el check box de permanecer conectado
	 * 
	 * @return
	 */
	public boolean isSelectedCheckBoxLogin() {
		return jFrameMainWindow.isSelectedCheckBoxLogin();
	}

	/**
	 * @return the jPanelLateral
	 */
	public JPanelLateral getjPanelLateral() {
		return jFrameMainWindow.getjPanelLateral();
	}

	public void actualiceJFrame() {
		this.jFrameMainWindow.actualice();
	}

	/**
	 * Metodo que cambia el texto de pregunta de olvido su contraseña
	 * 
	 * @param text
	 */
	public void setTextJTextFieldFP(String text) {
		this.jFrameMainWindow.setTextJTextFieldFP(text);
	}

	/**
	 * Metodo que desactiva o activa los botones y cajas de texto de olvido su
	 * contraseña
	 */
	public void setEnabledFP(boolean isEnabled) {
		this.jFrameMainWindow.setEnabledFP(isEnabled);
	}

	/**
	 * Metodo que devuelve la respuesta digitada en olvido su contraseña
	 * 
	 * @return
	 */
	public String getAnswerFP() {
		return this.jFrameMainWindow.getAnswerFP();
	}

	/**
	 * Metodo que retorna el valor del username
	 * 
	 * @return
	 */
	public String getjTextFieldUserText() {
		return jFrameMainWindow.getjTextFieldUserText();
	}

	/**
	 * Metodo que retorna valor de password del usuario
	 * 
	 * @return
	 */
	public String getjPasswordFieldText() {
		return jFrameMainWindow.getjPasswordFieldText();
	}

	/**
	 * Metodo que cierra el dialog login
	 *
	 */
	public void disposeLogin() {
		this.jFrameMainWindow.disposeLogin();
	}

	/**
	 * Metodo que retorna si esta activo el panel de configuraciones
	 * 
	 * @return
	 */
	public boolean isActiveConfigDialog() {
		return jFrameMainWindow.isActiveConfigDialog();
	}

	/**
	 * Metodo que activa el panel de preguntas de Crea Tu cuenta
	 */
	public void activateQuestion() {
		this.jFrameMainWindow.activateQuestion();
	}

	/**
	 * Metodo que desactiva el panel de preguntas
	 */
	public void desactivateQuestion() {
		this.jFrameMainWindow.desactivateQuestion();
	}

	/**
	 * Metodo que desactiva el panel de registro
	 */
	public void desactiveRegister() {
		this.jFrameMainWindow.desactiveRegister();
	}

	/**
	 * Metodo que cambia el estado del panel de configuraciones
	 */
	public void setActiveConfigDialog(boolean b) {
		this.jFrameMainWindow.setActiveConfigDialog(b);
	}

	/**
	 * Metodo que obtiene el nombre de registro
	 * 
	 * @return nombre de usuario
	 */
	public String getNameRegister() {
		return jFrameMainWindow.getNameRegister();
	}

	/**
	 * Metodo que obtiene el apellido de registro
	 * 
	 * @return apellido de usuario
	 */
	public String getLastNameRegister() {
		return jFrameMainWindow.getLastNameRegister();
	}

	/**
	 * Metodo que obtiene el numero de documento de registro
	 * 
	 * @return numero de documento de usuario
	 */
	public String getDocumentNumberRegister() {
		return jFrameMainWindow.getDocumentNumberRegister();
	}

	/**
	 * Metodo que obtiene la fecha de nacimiento de registro
	 * 
	 * @return fecha de nacimiento de usuario
	 */
	public String getDateOfBirthRegister() {
		return jFrameMainWindow.getDateOfBirthRegister();
	}

	/**
	 * Metodo que obtiene el username de registro
	 * 
	 * @return username de usuario
	 */
	public String getUserNameRegister() {
		return jFrameMainWindow.getUserNameRegister();
	}

	/**
	 * Metodo que obtiene la contraseña de registro
	 * 
	 * @return contraseña de usuario
	 */
	public String getPasswordRegister() {
		return jFrameMainWindow.getPasswordRegister();
	}

	/**
	 * Metodo que obtiene la confirmacion de contraseña de registro
	 * 
	 * @return confirmacion contraseña de usuario
	 */
	public String getConfirmPasswordRegister() {
		return jFrameMainWindow.getConfirmPasswordRegister();
	}

	/**
	 * Metodo que obtiene el tipo de cuenta de registro
	 * 
	 * @return tipo de cuenta de usuario
	 */
	public String getTypeAccountRegister() {
		return jFrameMainWindow.getTypeAccountRegister();
	}

	/**
	 * Metodo que obtiene el monto inicial de registro
	 * 
	 * @return monto inicial de usuario
	 */
	public String getInitialAmountRegister() {
		return jFrameMainWindow.getInitialAmountRegister();
	}

	/**
	 * Metodo que obtiene la contraseña de la cuenta de registro
	 * 
	 * @return contraseña de la cuenta de usuario
	 */
	public String getPasswordAccountRegister() {
		return jFrameMainWindow.getPasswordAccountRegister();
	}

	/**
	 * Metodo que obtiene la contraseña de la cuenta de registro
	 * 
	 * @return contraseña de la cuenta de usuario
	 */
	public String getConfirmPasswordAccountRegister() {
		return jFrameMainWindow.getConfirmPasswordAccountRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectNameRegister() {
		jFrameMainWindow.setIncorrectNameRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectLastNameRegister() {
		jFrameMainWindow.setIncorrectLastNameRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectDocumentNumberRegister() {
		jFrameMainWindow.setIncorrectDocumentNumberRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectDateOfBirthRegister() {
		jFrameMainWindow.setIncorrectDateOfBirthRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectUserNameRegister() {
		jFrameMainWindow.setIncorrectUserNameRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectPasswordRegister() {
		jFrameMainWindow.setIncorrectPasswordRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectConfirmPasswordRegister() {
		jFrameMainWindow.setIncorrectConfirmPasswordRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectInitialAmountRegister() {
		jFrameMainWindow.setIncorrectInitialAmountRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectPasswordAccountRegister() {
		jFrameMainWindow.setIncorrectPasswordAccountRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectConfirmPasswordAccountRegister() {
		jFrameMainWindow.setIncorrectConfirmPasswordAccountRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectNameRegister() {
		jFrameMainWindow.setCorrectNameRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectLastNameRegister() {
		jFrameMainWindow.setCorrectLastNameRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectDocumentNumberRegister() {
		jFrameMainWindow.setCorrectDocumentNumberRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectDateOfBirthRegister() {
		jFrameMainWindow.setCorrectDateOfBirthRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectUserNameRegister() {
		jFrameMainWindow.setCorrectUserNameRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectPasswordRegister() {
		jFrameMainWindow.setCorrectPasswordRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectConfirmPasswordRegister() {
		jFrameMainWindow.setCorrectConfirmPasswordRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectInitialAmountRegister() {
		jFrameMainWindow.setCorrectInitialAmountRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectPasswordAccountRegister() {
		jFrameMainWindow.setCorrectPasswordAccountRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectConfirmPasswordAccountRegister() {
		jFrameMainWindow.setCorrectConfirmPasswordAccountRegister();
	}

	/**
	 * Metodo que obtiene la pregunta seleccionada
	 * @return pregunta seleccionada
	 */
	public int getQuestionSelected() {
		return jFrameMainWindow.getQuestionSelected();
	}

	/**
	 * Metodo que obtiene la respuesta
	 * @return respuesta seleccionada
	 */
	public String getAnswer() {
		return jFrameMainWindow.getAnswer();
	}

	/**
	 * Metodo que obtiene la confirmacion de respuesta
	 * @return respuesta seleccionada
	 */
	public String getConfirmationAnswer() {
		return jFrameMainWindow.getConfirmationAnswer();
	}

	/**
	 * Metodo que obtiene contraseña de la cuenta
	 * @return contraseña de la cuenta
	 */
	public String getPasswordAccountDeposit() {
		return jFrameMainWindow.getPasswordAccountDeposit();
	}

	/**
	 * Metodo que obtiene el dinero a depostiar
	 * @return dinero a depositar
	 */
	public String getMoneyToDeposit() {
		return jFrameMainWindow.getMoneyToDeposit();
	}

	/**
	 * Metodo que obtiene contraseña de la cuenta
	 * @return contraseña de la cuenta
	 */
	public String getPasswordAccountWithDrawals() {
		return jFrameMainWindow.getPasswordAccountWithDrawals();
	}

	/**
	 * Metodo que obtiene el dinero a retirar
	 * @return dinero a retirar
	 */
	public String getMoneyToWithDrawals() {
		return jFrameMainWindow.getMoneyToWithDrawals();
	}

	/**
	 * Metodo que obtiene contraseña de la cuenta
	 * @return contraseña de la cuenta
	 */
	public String getPasswordAccountTransaction() {
		return jFrameMainWindow.getPasswordAccountTransaction();
	}

	/**
	 * Metodo que el numero de cuenta del remitente
	 * @return numero de cuenta del remitente
	 */
	public String getNumberAccountToDeposit() {
		return jFrameMainWindow.getNumberAccountToDeposit();
	}

	/**
	 * Metodo que obtiene el dinero a transferir
	 * @return dinero a transferir
	 */
	public String getMoneyToTransfer() {
		return jFrameMainWindow.getMoneyToTransfer();
	}

	/**
	 * Metodo que activa el panel de deposito
	 */
	public void activeDeposit() {
		jFrameMainWindow.activeDeposit();
	}

	/**
	 * Metodo que activa el panel de retiro
	 */
	public void activeWhitDrawals() {
		jFrameMainWindow.activeWhitDrawals();
	}

	/**
	 * Metodo que activa el panel de transferencia
	 */
	public void activeTransfer() {
		jFrameMainWindow.activeTransfer();
	}
}
