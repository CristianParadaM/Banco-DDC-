package view.viewLogin;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import controller.ControllerApp;
import model.TextPrompt;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;
import view.viewJFrameMain.JFrameMainWindow;

/**
 * Clase que maneja el objeto JPanelForgotPassWord.java
 *
 * @author Cristian David Parada Martinez
 * @date 10/05/2021
 *
 */
public class JPanelForgotPassWord extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JLabel jLabelUser;
	private JTextField jTextFieldUser;
	private JTextPane jTextPaneQuestion;
	private JTextField jTextFieldAnswer;
	private JButton jButtonVerify;
	private JButton jButtonArrowBack;

	/**
	 * Constructor de JPanelForgotPassWord
	 */
	public JPanelForgotPassWord(Dimension size) {
		super();
		this.jLabelUser = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_USER));
		this.jTextFieldUser = new JTextField();
		this.gbc = new GridBagConstraints();
		this.jTextPaneQuestion = new JTextPane();
		this.jTextFieldAnswer = new JTextField();
		this.jButtonVerify = new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_VERIFY_FP), ControllerApp.getInstance(),
				Constants.COMMAND_JBUTTON_VERIFY_FOGOTP, 0, 30, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false);
		this.jButtonArrowBack = new JButtonsDDC(Constants.MESSAGE_JBUTTON_ARROW_BACK, JFrameMainWindow.getInstance(),
				Constants.COMMAND_JBUTTON_ARROW_BACK_FORGOTP, 0, 30, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false);
		this.setSize(size.width / 2, size.height);
		init();
	}

	/**
	 * Metodo que organiza y añade los componentes graficos
	 * 
	 */
	private void init() {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);

		gbc.weightx = 1;
		gbc.fill = 1;
		gbc.insets = new Insets(10, 30, 30, 30);
		JLabel jLabel = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_FORGOTPASS),
				JLabel.CENTER);
		jLabel.setFont(CyFPaletteApp.FONT_CONTENT_SUBTITLES);
		jLabel.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabel, gbc);

		gbc.gridy = 1;
		gbc.insets.bottom = 0;
		this.jLabelUser.setFont(CyFPaletteApp.FONT_CONTENT);
		this.jLabelUser.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabelUser, gbc);

		gbc.insets.top = 0;
		gbc.gridy = 2;
		this.jTextFieldUser.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		this.jTextFieldUser.setForeground(CyFPaletteApp.COLOR_BORDER);
		this.jTextFieldUser.setBackground(CyFPaletteApp.COLOR_TRANSPARENT);
		this.jTextFieldUser.setBorder(BorderFactory.createLineBorder(CyFPaletteApp.COLOR_BORDER, 3));
		this.jTextFieldUser.setPreferredSize(new Dimension(0, 30));
		this.jTextFieldUser.setOpaque(false);
		this.jTextFieldUser.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == ' ') {
					e.consume();
				}
				if (jTextFieldUser.getText().length() == 15) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		TextPrompt textPrompt = new TextPrompt(Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_USER),
				jTextFieldUser);
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);
		this.add(jTextFieldUser, gbc);

		gbc.insets.top = 20;
		gbc.gridy = 3;
		this.add(new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_QUESTION_FP),
				ControllerApp.getInstance(),
				Constants.COMMAND_JBUTTON_QUESTION_FP, 300, 30, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false), gbc);
		gbc.gridy = 4;

		jTextPaneQuestion.setFont(CyFPaletteApp.FONT_CONTENT);
		jTextPaneQuestion.setPreferredSize(new Dimension(0, 100));
		jTextPaneQuestion.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
		jTextPaneQuestion.setForeground(CyFPaletteApp.COLOR_MAIN);
		jTextPaneQuestion.setOpaque(false);
		jTextPaneQuestion.setEditable(false);
		this.add(jTextPaneQuestion, gbc);

		gbc.gridy = 5;
		jTextFieldAnswer.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		jTextFieldAnswer.setForeground(CyFPaletteApp.COLOR_BORDER);
		jTextFieldAnswer.setBackground(CyFPaletteApp.COLOR_TRANSPARENT);
		jTextFieldAnswer.setBorder(BorderFactory.createLineBorder(CyFPaletteApp.COLOR_BORDER, 3));
		jTextFieldAnswer.setPreferredSize(new Dimension(0, 30));
		jTextFieldAnswer.setOpaque(false);
		jTextFieldAnswer.setEnabled(false);
		TextPrompt textPrompt2 = new TextPrompt(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_ANSWER_FP), jTextFieldAnswer);
		textPrompt2.changeAlpha(0.35f);
		textPrompt2.changeStyle(Font.ITALIC);
		this.add(jTextFieldAnswer, gbc);
		gbc.gridy = 6;
		gbc.insets = new Insets(10, 30, 0, 30);
		jButtonVerify.setEnabled(false);
		this.add(jButtonVerify, gbc);
		gbc.gridy = 7;
		this.add(jButtonArrowBack, gbc);
		gbc.gridy = 8;
		this.add(Box.createRigidArea(new Dimension(0, 130)), gbc);

	}
	
	/**
	 * Metodo que retorna el valor del username digitado en Olvide mi contraseña
	 * @return
	 */
	public String getUsernameFP() {
		return this.jTextFieldUser.getText();
	}
	
	/**
	 * Metodo que cambia el texto de la caja de texto de la pregunta
	 * @param text
	 */
	public void setTextJTextPaneFP(String text) {
		this.jTextPaneQuestion.setText(text);
	}

	/**
	 * Metodo que habilita o deshabilita el boton verificar y la caja de texto de respuesta
	 * @param isEnabled
	 */
	public void setEnabledFP(boolean isEnabled) {
		this.jTextFieldAnswer.setText("");
		this.jTextFieldAnswer.setEnabled(isEnabled);
		this.jButtonVerify.setEnabled(isEnabled);
	}
	
	/**
	 * Metodo que retorna la respuesta escrita en la caja de texto de respuesta
	 * @return
	 */
	public String getAnswerFP() {
		return this.jTextFieldAnswer.getText();
	}
}
