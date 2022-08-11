/**
 * 
 */
package view.viewRegister;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;
import view.viewJFrameMain.JFrameMainWindow;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 13/05/2021
 */
public class JDialogRegister extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanelRegister jPanelRegister;
	private jPanelQuestion jPanelQuestion;
	private JLabel jLabelTitle;

	public JDialogRegister(JFrame frame) {
		super(frame);
		this.jPanelRegister = new JPanelRegister();
		this.jPanelQuestion = new jPanelQuestion();
		this.jLabelTitle = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_REGISTER_TITLE),
				JLabel.CENTER);
		init();
	}

	/**
	 * Metodo que
	 */
	private void init() {
		this.setContentPane(new JPanelBackGroundRegister());
		this.setUndecorated(true);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		jLabelTitle.setFont(CyFPaletteApp.FONT_TITLES);
		jLabelTitle.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabelTitle, BorderLayout.NORTH);
		this.add(jPanelRegister, BorderLayout.CENTER);
		this.setVisible(true);
		buildButtons();
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (e.getComponent() instanceof JDialogRegister) {
					setLocation(getLocationOnScreen().x + e.getX() - getWidth() / 2,
							getLocationOnScreen().y + e.getY() - getHeight() / 2);
				}
			}
		});
	}

	/**
	 * Metodo que activa las preguntas
	 *
	 */
	public void activateQuestion() {
		this.jPanelRegister.setVisible(false);
		this.setLayout(new BorderLayout());
		this.add(jLabelTitle, BorderLayout.NORTH);
		this.add(jPanelQuestion, BorderLayout.CENTER);
		this.jPanelQuestion.setVisible(true);
	}

	/**
	 * Metodo que desactiva el panel de preguntas
	 */
	public void desactivateQuestion() {
		this.jPanelQuestion.setVisible(false);
		this.setLayout(new BorderLayout());
		this.add(jLabelTitle, BorderLayout.NORTH);
		this.add(jPanelRegister, BorderLayout.CENTER);
		this.jPanelRegister.setVisible(true);
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
		JButton buttonBack = new JButtonsDDC(Constants.MESSAGE_JBUTTON_ARROW_BACK, JFrameMainWindow.getInstance(),
				Constants.COMMAND_JBUTTON_ARROW_BACK_REGISTER, 50, 20, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false);
		this.getContentPane().add(buttonExit).setBounds(getWidth() - 50, 0, buttonExit.getPreferredSize().width,
				buttonExit.getPreferredSize().height);
		this.getContentPane().add(buttonBack).setBounds(getWidth() - 100, 0, buttonExit.getPreferredSize().width,
				buttonExit.getPreferredSize().height);
	}

	/**
	 * Metodo que obtiene el nombre de registro
	 * 
	 * @return nombre de usuario
	 */
	public String getNameRegister() {
		return jPanelRegister.getNameRegister();
	}

	/**
	 * Metodo que obtiene el apellido de registro
	 * 
	 * @return apellido de usuario
	 */
	public String getLastNameRegister() {
		return jPanelRegister.getLastNameRegister();
	}

	/**
	 * Metodo que obtiene el numero de documento de registro
	 * 
	 * @return numero de documento de usuario
	 */
	public String getDocumentNumberRegister() {
		return jPanelRegister.getDocumentNumberRegister();
	}

	/**
	 * Metodo que obtiene la fecha de nacimiento de registro
	 * 
	 * @return fecha de nacimiento de usuario
	 */
	public String getDateOfBirthRegister() {
		return jPanelRegister.getDateOfBirthRegister();
	}

	/**
	 * Metodo que obtiene el username de registro
	 * 
	 * @return username de usuario
	 */
	public String getUserNameRegister() {
		return jPanelRegister.getUserNameRegister();
	}

	/**
	 * Metodo que obtiene la contraseña de registro
	 * 
	 * @return contraseña de usuario
	 */
	public String getPasswordRegister() {
		return jPanelRegister.getPasswordRegister();
	}

	/**
	 * Metodo que obtiene la confirmacion de contraseña de registro
	 * 
	 * @return confirmacion contraseña de usuario
	 */
	public String getConfirmPasswordRegister() {
		return jPanelRegister.getConfirmPasswordRegister();
	}

	/**
	 * Metodo que obtiene el tipo de cuenta de registro
	 * 
	 * @return tipo de cuenta de usuario
	 */
	public String getTypeAccountRegister() {
		return jPanelRegister.getTypeAccountRegister();
	}

	/**
	 * Metodo que obtiene el monto inicial de registro
	 * 
	 * @return monto inicial de usuario
	 */
	public String getInitialAmountRegister() {
		return jPanelRegister.getInitialAmountRegister();
	}

	/**
	 * Metodo que obtiene la contraseña de la cuenta de registro
	 * 
	 * @return contraseña de la cuenta de usuario
	 */
	public String getPasswordAccountRegister() {
		return jPanelRegister.getPasswordAccountRegister();
	}

	/**
	 * Metodo que obtiene la contraseña de la cuenta de registro
	 * 
	 * @return contraseña de la cuenta de usuario
	 */
	public String getConfirmPasswordAccountRegister() {
		return jPanelRegister.getConfirmPasswordAccountRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectNameRegister() {
		jPanelRegister.setIncorrectNameRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectLastNameRegister() {
		jPanelRegister.setIncorrectLastNameRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectDocumentNumberRegister() {
		jPanelRegister.setIncorrectDocumentNumberRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectDateOfBirthRegister() {
		jPanelRegister.setIncorrectDateOfBirthRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectUserNameRegister() {
		jPanelRegister.setIncorrectUserNameRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectPasswordRegister() {
		jPanelRegister.setIncorrectPasswordRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectConfirmPasswordRegister() {
		jPanelRegister.setIncorrectConfirmPasswordRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectInitialAmountRegister() {
		jPanelRegister.setIncorrectInitialAmountRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectPasswordAccountRegister() {
		jPanelRegister.setIncorrectPasswordAccountRegister();
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectConfirmPasswordAccountRegister() {
		jPanelRegister.setIncorrectConfirmPasswordAccountRegister();
	}

	//
	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectNameRegister() {
		jPanelRegister.setCorrectNameRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectLastNameRegister() {
		jPanelRegister.setCorrectLastNameRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectDocumentNumberRegister() {
		jPanelRegister.setCorrectDocumentNumberRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectDateOfBirthRegister() {
		jPanelRegister.setCorrectDateOfBirthRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectUserNameRegister() {
		jPanelRegister.setCorrectUserNameRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectPasswordRegister() {
		jPanelRegister.setCorrectPasswordRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectConfirmPasswordRegister() {
		jPanelRegister.setCorrectConfirmPasswordRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectInitialAmountRegister() {
		jPanelRegister.setCorrectInitialAmountRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectPasswordAccountRegister() {
		jPanelRegister.setCorrectPasswordAccountRegister();
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectConfirmPasswordAccountRegister() {
		jPanelRegister.setCorrectConfirmPasswordAccountRegister();
	}

	/**
	 * Metodo que obtiene la pregunta seleccionada
	 * @return pregunta seleccionada
	 */
	public int getQuestionSelected() {
		return jPanelQuestion.getQuestionSelected();
	}
	/**
	 * Metodo que obtiene la respuesta
	 * @return respuesta seleccionada
	 */
	public String getAnswer() {
		return jPanelQuestion.getAnswer();
	}
	/**
	 * Metodo que obtiene la confirmacion de respuesta
	 * @return respuesta seleccionada
	 */
	public String getConfirmationAnswer() {
		return jPanelQuestion.getConfirmationAnswer();
	}
}
