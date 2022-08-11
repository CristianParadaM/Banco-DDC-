package view.viewLogin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.ControllerApp;
import model.TextPrompt;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;
import view.viewJFrameMain.JFrameMainWindow;

/**
 * Clase que maneja el objeto JPanelInformation.java
 *
 * @author Cristian David Parada Martinez
 * @date 2/05/2021
 *
 */
public class JPanelInformationJDialog extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int MAX_LENGHT_USERNAME = 15;
	public static final int MAX_LENGHT_PASSWORD = 10;
	private GridBagConstraints gbc;
	private JLabel jLabelUser;
	private JLabel jLabelPasword;
	private JTextField jTextFieldUser;
	private JPasswordField jPasswordField;
	private JButton jButtonLogin;
	private JButton jButtonRegister;
	private JButton jButtonForgotPass;
	private JCheckBox jCheckBoxLogin;

	/**
	 * Constructor de JPanelInformation
	 * 
	 */
	public JPanelInformationJDialog() {
		super();
		this.jLabelUser = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_USER));
		this.jLabelPasword = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_PASS));
		this.jTextFieldUser = new JTextField();
		this.jPasswordField = new JPasswordField();
		this.jButtonLogin = new JButtonsDDC(new ImageIcon(Constants.PATH_JBUTTON_LOGIN), ControllerApp.getInstance(),
				Constants.COMMAND_JBUTTON_LOGIN, 250, 30, CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND,
				false);
		this.jButtonRegister = new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_REGISTER),
				JFrameMainWindow.getInstance(), Constants.COMMAND_JBUTTON_REGISTER, 250, 30, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false);
		this.jButtonForgotPass = new JButtonsDDC(
				Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_FORGOTPASS), JFrameMainWindow.getInstance(),
				Constants.COMMAND_JBUTTON_FORGOTPASS, 250, 30, CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND,
				false);
		this.jCheckBoxLogin = new JCheckBox(Constants.getInstance().getProperty(Constants.MESSAGE_JCHECKBOX_LOGIN));
		this.gbc = new GridBagConstraints();
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);

		gbc.insets = new Insets(15, 30, 0, 50);
		gbc.weightx = 1;
		gbc.fill = 1;

		this.jLabelUser.setFont(CyFPaletteApp.FONT_CONTENT);
		this.jLabelUser.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabelUser, gbc);

		gbc.insets.top = 0;
		gbc.gridy = 1;
		this.jTextFieldUser.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		this.jTextFieldUser.setForeground(CyFPaletteApp.COLOR_BORDER);
		this.jTextFieldUser.setBackground(new Color(0, 0, 0, 0));
		this.jTextFieldUser.setBorder(BorderFactory.createLineBorder(CyFPaletteApp.COLOR_BORDER, 3));
		this.jTextFieldUser.setPreferredSize(new Dimension(0, 60));
		this.jTextFieldUser.setOpaque(false);
		this.jTextFieldUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == ' ') {
					e.consume();
				}
				if (jTextFieldUser.getText().length() == MAX_LENGHT_USERNAME) {
					e.consume();
				}
			}
		});
		TextPrompt textPrompt = new TextPrompt(Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_USER),
				jTextFieldUser);
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);
		this.add(jTextFieldUser, gbc);

		gbc.insets.top = 25;
		gbc.gridy = 2;
		this.jLabelPasword.setFont(CyFPaletteApp.FONT_CONTENT);
		this.jLabelPasword.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabelPasword, gbc);

		gbc.insets.top = 0;
		gbc.gridy = 3;
		this.jPasswordField.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		this.jPasswordField.setForeground(CyFPaletteApp.COLOR_BORDER);
		this.jPasswordField.setOpaque(false);
		this.jPasswordField.setBorder(BorderFactory.createLineBorder(CyFPaletteApp.COLOR_BORDER, 3));
		this.jPasswordField.setPreferredSize(new Dimension(0, 60));
		this.jPasswordField.setLayout(new BorderLayout());
		this.jPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == ' ') {
					e.consume();
				}
				if (String.valueOf(jPasswordField.getPassword()).length() == MAX_LENGHT_PASSWORD) {
					e.consume();
				}
			}
		});
		TextPrompt textPrompt2 = new TextPrompt(Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_PASS),
				jPasswordField);
		this.jPasswordField.add(new JButtonsDDC(new ImageIcon(CyFPaletteApp.PATH_SHOW_PASS), new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jPasswordField.getEchoChar() == '•') {
					jPasswordField.setEchoChar((char) 0);
				} else {
					jPasswordField.setEchoChar('•');
				}
			}

		}, "", 50, 20, Color.WHITE, CyFPaletteApp.COLOR_TRANSPARENT, true), BorderLayout.EAST);
		textPrompt2.changeAlpha(0.35f);
		textPrompt2.changeStyle(Font.ITALIC);
		this.add(jPasswordField, gbc);

		gbc.gridy = 4;
		jCheckBoxLogin.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		jCheckBoxLogin.setForeground(CyFPaletteApp.COLOR_MAIN);
		jCheckBoxLogin.setOpaque(false);
		jCheckBoxLogin.setFocusPainted(false);
		jCheckBoxLogin.setRolloverEnabled(false);
		this.add(jCheckBoxLogin, gbc);

		gbc.insets.top = 40;
		gbc.gridy = 5;
		gbc.insets.right = 350;
		this.jButtonLogin.setRolloverEnabled(false);
		this.add(jButtonLogin, gbc);

		gbc.gridy = 6;
		gbc.insets.right = 50;
		gbc.insets.top = 20;
		this.jButtonRegister.setRolloverEnabled(false);
		this.add(jButtonRegister, gbc);

		gbc.gridy = 7;
		this.jButtonForgotPass.setRolloverEnabled(false);
		this.add(jButtonForgotPass, gbc);

		gbc.gridy = 8;
		gbc.insets = new Insets(150, 0, 0, 0);
		this.add(Box.createRigidArea(new Dimension(0, 0)), gbc);
	}

	/**
	 * Metodo que retorna el nombre de usuario digitado en la caja de texto de
	 * username
	 * 
	 * @return
	 */
	public String getjTextFieldUserText() {
		return jTextFieldUser.getText();
	}

	/**
	 * Metodo que retorna en String el valor de la caja de contraseña
	 * 
	 * @return
	 */
	public String getjPasswordFieldText() {
		return String.valueOf(jPasswordField.getPassword());
	}
	
	/**
	 * Metodo que retorna si esta seleccionado el check box de permanecer conectado
	 * @return
	 */
	public boolean isSelectedCheckBoxLogin() {
		return jCheckBoxLogin.isSelected();
	}

}
