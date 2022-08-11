package view.viewLogin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;
import view.viewJFrameMain.JFrameMainWindow;
import view.viewRegister.JDialogRegister;

/**
 * Clase que maneja el objeto JDialogLogin.java
 *
 * @author Cristian David Parada Martinez
 * @date 2/05/2021
 *
 */
public class JDialogLogin extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanelLogin jPanelLogin;
	private JPanelImageLogo jPanelImageLogo;
	private JPanelConfigLogin jPanelConfig;
	private JPanelForgotPassWord forgotPassWord;
	private JPanelCredits jPanelCredits;
	private JPanelBackGround backGround;
	private JDialogRegister jDialogRegister;
	private JFrame frame;

	/**
	 * Constructor de JDialogLogin
	 * 
	 */
	public JDialogLogin(JFrame frame) {
		super(frame);
		this.frame = frame;
		this.backGround = new JPanelBackGround();
		this.jPanelConfig = new JPanelConfigLogin();
		this.jPanelCredits = new JPanelCredits(getSize());
		init();
	}

	/**
	 * Metodo que organiza y añade los componentes graficos
	 * 
	 */
	private void init() {
		this.setUndecorated(true);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (e.getComponent() instanceof JDialogLogin) {
					setLocation(getLocationOnScreen().x + e.getX() - getWidth() / 2,
							getLocationOnScreen().y + e.getY() - getHeight() / 2);
				}
			}
		});
	}

	/**
	 * Metodo que agrega independientemente los botones de accion de la ventana de
	 * login, como lo son el de cerrar, ayuda y configuraciones al login de manera
	 * absoluta
	 * 
	 */
	private void buildButtons() {
		this.setLayout(null);
		JButton buttonExit = new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_CROSS_EXIT),
				JFrameMainWindow.getInstance(), Constants.COMMAND_CROSS_EXIT, 50, 20, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false);
		JButton buttonHelp = new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_HELP),
				JFrameMainWindow.getInstance(), Constants.COMMAND_HELP, 50, 20, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false);
		JButton buttonConfig = new JButtonsDDC(new ImageIcon(Constants.PATH_CONFIG_ICON), this,
				Constants.COMMAND_BUTTON_CONFIG_JDIALOG, 30, 30, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false);
		this.getContentPane().add(buttonExit).setBounds(getWidth() - 50, 0, buttonExit.getPreferredSize().width,
				buttonExit.getPreferredSize().height);
		this.getContentPane().add(buttonHelp).setBounds(getWidth() - 100, 0, buttonExit.getPreferredSize().width,
				buttonExit.getPreferredSize().height);
		this.getContentPane().add(buttonConfig).setBounds(20, getHeight() - 50, buttonConfig.getPreferredSize().width,
				buttonConfig.getPreferredSize().height);

	}

	/**
	 * Metodo que cierra el panel de configuraciones y lo desactiva
	 */
	public void desactivateConfig() {
		this.remove(jPanelConfig);
		jPanelConfig.setActive(false);
	}

	/**
	 * Metodo que activa el panel de configuraciones y lo coloca en la esquina
	 * inferior izquierda
	 * 
	 */
	public void activateConfig() {
		this.add(jPanelConfig).setBounds(52, getHeight() - 119, jPanelConfig.getPreferredSize().width,
				jPanelConfig.getPreferredSize().height);
		jPanelConfig.setActive(true);
	}

	/**
	 * Metodo que cierra este JDialogLogin
	 */
	public void exitJDialogLogin() {
		this.setVisible(false);
		this.dispose();
	}

	/**
	 * metodo que retorna si el panel de configuraciones esta activo
	 */
	public boolean isActive() {
		return jPanelConfig.isActive();
	}

	/**
	 * Metodo que retorna el valor del username
	 * 
	 * @return
	 */
	public String getjTextFieldUserText() {
		return jPanelLogin.getjTextFieldUserText();
	}

	/**
	 * Metodo que retorna valor de password del usuario
	 * 
	 * @return
	 */
	public String getjPasswordFieldText() {
		return jPanelLogin.getjPasswordFieldText();
	}

	/**
	 * Metodo que cambia el estado del panel de configuraciones
	 * 
	 * @param b
	 */
	public void setActive(boolean b) {
		jPanelConfig.setActive(b);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.COMMAND_BUTTON_CONFIG_JDIALOG:
			if (!isActive()) {
				activateConfig();
				this.repaint();
			} else {
				desactivateConfig();
				this.repaint();
			}
			break;

		}
	}

	/**
	 * Metodo que activa el panel olvido su contraseña
	 */
	public void activeForgotPass() {
		this.jPanelLogin.setVisible(false);
		this.forgotPassWord = new JPanelForgotPassWord(getSize());
		this.add(forgotPassWord, 0);
	}

	/**
	 * Metodo que desactiva el panel olvido su contraseña
	 */
	public void desactiveForgotPass() {
		this.forgotPassWord.setVisible(false);
		this.jPanelLogin.setVisible(true);
		this.add(jPanelLogin, 0);
	}

	/**
	 * Metodo que retorna el nombre de usuario digitado en olvido su contraseña
	 * 
	 * @return username
	 */
	public String getUsernameFP() {
		return forgotPassWord.getUsernameFP();
	}

	/**
	 * Metodo que cambia el texto de pregunta de olvido su contraseña
	 * 
	 * @param text
	 */
	public void setTextJTextFieldFP(String text) {
		this.forgotPassWord.setTextJTextPaneFP(text);
	}

	/**
	 * Metodo que desactiva o activa los botones y cajas de texto de olvido su
	 * contraseña
	 */
	public void setEnabledFP(boolean isEnabled) {
		this.forgotPassWord.setEnabledFP(isEnabled);
	}

	/**
	 * Metodo que devuelve la respuesta digitada en olvido su contraseña
	 * 
	 * @return
	 */
	public String getAnswerFP() {
		return this.forgotPassWord.getAnswerFP();
	}

	/**
	 * Metodo que activa el panel de creditos
	 */
	public void activateCredits() {
		if (forgotPassWord != null && forgotPassWord.isVisible()) {
			this.forgotPassWord.setVisible(false);
		}
		if (jPanelLogin.isVisible()) {
			this.jPanelLogin.setVisible(false);
		}
		this.jPanelCredits.setVisible(true);
		this.add(jPanelCredits).setBounds(0, 0, getWidth() / 2, getHeight());
	}

	/**
	 * Metodo que desactiva el panel de creditos
	 */
	public void desactivateCredits() {
		this.jPanelCredits.setVisible(false);
		this.jPanelLogin.setVisible(true);
		this.add(jPanelLogin, 0);
	}

	public void actualice() {
		this.setVisible(false);
		this.getContentPane().removeAll();
		createComponents();
	}

	/**
	 * Metodo que inicializa el panel principal
	 */
	public void createComponents() {
		this.backGround = new JPanelBackGround();
		this.setContentPane(backGround);
		this.setLayout(new GridLayout());
		this.jPanelImageLogo = new JPanelImageLogo();
		this.jPanelLogin = new JPanelLogin();
		this.jPanelConfig = new JPanelConfigLogin();
		this.jPanelCredits = new JPanelCredits(getSize());
		this.add(jPanelLogin);
		this.add(jPanelImageLogo);
		this.setVisible(true);
		buildButtons();
	}

	/**
	 * Metodo que retorna si esta seleccionado el check box de permanecer conectado
	 * 
	 * @return
	 */
	public boolean isSelectedCheckBoxLogin() {
		return jPanelLogin.isSelectedCheckBoxLogin();
	}

	/**
	 * Metodo que desactiva el panel de registro
	 */
	public void desactiveRegister() {
		this.jDialogRegister.dispose();
		this.setVisible(true);
	}

	/**
	 * Metodo que activa el panel de creditos
	 */
	public void activeRegister() {
		this.setVisible(false);
		this.jDialogRegister = new JDialogRegister(frame);
	}

	/**
	 * Metodo que activa el panel de preguntas de Crea Tu cuenta
	 */
	public void activateQuestion() {
		this.jDialogRegister.activateQuestion();
	}

	/**
	 * Metodo que desactiva el panel de preguntas
	 */
	public void desactivateQuestion() {
		this.jDialogRegister.desactivateQuestion();
	}

	/**
	 * Metodo que obtiene el nombre de registro
	 * 
	 * @return nombre de usuario
	 */
	public String getNameRegister() {
		return jDialogRegister.getNameRegister();
	}

	/**
	 * Metodo que obtiene el apellido de registro
	 * 
	 * @return apellido de usuario
	 */
	public String getLastNameRegister() {
		return jDialogRegister.getLastNameRegister();
	}

	/**
	 * Metodo que obtiene el numero de documento de registro
	 * 
	 * @return numero de documento de usuario
	 */
	public String getDocumentNumberRegister() {
		return jDialogRegister.getDocumentNumberRegister();
	}

	/**
	 * Metodo que obtiene la fecha de nacimiento de registro
	 * 
	 * @return fecha de nacimiento de usuario
	 */
	public String getDateOfBirthRegister() {
		return jDialogRegister.getDateOfBirthRegister();
	}

	/**
	 * Metodo que obtiene el username de registro
	 * 
	 * @return username de usuario
	 */
	public String getUserNameRegister() {
		return jDialogRegister.getUserNameRegister();
	}

	/**
	 * Metodo que obtiene la contraseña de registro
	 * 
	 * @return contraseña de usuario
	 */
	public String getPasswordRegister() {
		return jDialogRegister.getPasswordRegister();
	}

	/**
	 * Metodo que obtiene la confirmacion de contraseña de registro
	 * 
	 * @return confirmacion contraseña de usuario
	 */
	public String getConfirmPasswordRegister() {
		return jDialogRegister.getConfirmPasswordRegister();
	}

	/**
	 * Metodo que obtiene el tipo de cuenta de registro
	 * 
	 * @return tipo de cuenta de usuario
	 */
	public String getTypeAccountRegister() {
		return jDialogRegister.getTypeAccountRegister();
	}

	/**
	 * Metodo que obtiene el monto inicial de registro
	 * 
	 * @return monto inicial de usuario
	 */
	public String getInitialAmountRegister() {
		return jDialogRegister.getInitialAmountRegister();
	}

	/**
	 * Metodo que obtiene la contraseña de la cuenta de registro
	 * 
	 * @return contraseña de la cuenta de usuario
	 */
	public String getPasswordAccountRegister() {
		return jDialogRegister.getPasswordAccountRegister();
	}

	/**
	 * Metodo que obtiene la contraseña de la cuenta de registro
	 * 
	 * @return contraseña de la cuenta de usuario
	 */
	public String getConfirmPasswordAccountRegister() {
		return jDialogRegister.getConfirmPasswordAccountRegister();
	}

	//
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectNameRegister() {
		jDialogRegister.setIncorrectNameRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectLastNameRegister() {
		jDialogRegister.setIncorrectLastNameRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectDocumentNumberRegister() {
		jDialogRegister.setIncorrectDocumentNumberRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectDateOfBirthRegister() {
		jDialogRegister.setIncorrectDateOfBirthRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectUserNameRegister() {
		jDialogRegister.setIncorrectUserNameRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectPasswordRegister() {
		jDialogRegister.setIncorrectPasswordRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectConfirmPasswordRegister() {
		jDialogRegister.setIncorrectConfirmPasswordRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectInitialAmountRegister() {
		jDialogRegister.setIncorrectInitialAmountRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectPasswordAccountRegister() {
		jDialogRegister.setIncorrectPasswordAccountRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectConfirmPasswordAccountRegister() {
		jDialogRegister.setIncorrectConfirmPasswordAccountRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectNameRegister() {
		jDialogRegister.setCorrectNameRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectLastNameRegister() {
		jDialogRegister.setCorrectLastNameRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectDocumentNumberRegister() {
		jDialogRegister.setCorrectDocumentNumberRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectDateOfBirthRegister() {
		jDialogRegister.setCorrectDateOfBirthRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectUserNameRegister() {
		jDialogRegister.setCorrectUserNameRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectPasswordRegister() {
		jDialogRegister.setCorrectPasswordRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectConfirmPasswordRegister() {
		jDialogRegister.setCorrectConfirmPasswordRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectInitialAmountRegister() {
		jDialogRegister.setCorrectInitialAmountRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectPasswordAccountRegister() {
		jDialogRegister.setCorrectPasswordAccountRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectConfirmPasswordAccountRegister() {
		jDialogRegister.setCorrectConfirmPasswordAccountRegister();
	}

	/**
	 * Metodo que obtiene la pregunta seleccionada
	 * @return pregunta seleccionada
	 */
	public int getQuestionSelected() {
		return jDialogRegister.getQuestionSelected();
	}
	
	/**
	 * Metodo que obtiene la respuesta
	 * @return respuesta seleccionada
	 */
	public String getAnswer() {
		return jDialogRegister.getAnswer();
	}
	/**
	 * Metodo que obtiene la confirmacion de respuesta
	 * @return respuesta seleccionada
	 */
	public String getConfirmationAnswer() {
		return jDialogRegister.getConfirmationAnswer();
	}
}
