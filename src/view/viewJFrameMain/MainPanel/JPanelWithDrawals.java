package view.viewJFrameMain.MainPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
 * Clase que maneja el objeto JPanelWithDrawalsFrame.java
 *
 * @author Cristian David Parada Martinez
 * @date 18/05/2021
 *
 */
public class JPanelWithDrawals extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int SIZE_BUTTON_WIDTH = 200;
	public static final int SIZE_BUTTON_HEIGHT = 30;
	private GridBagConstraints gbc;
	private JLabel title;
	private JLabel countMoney;
	private JLabel countMessage;
	private JTextField jTextFieldWithDrawals;
	private JLabel passwordMessage;
	private JPasswordField jPasswordField;
	private JPanel jpanelOptions;

	public JPanelWithDrawals(double money) {
		this.gbc = new GridBagConstraints();
		this.title = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_WITHDRAWALS), JLabel.CENTER);
		this.countMoney = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_AMOUNT_OF_MONEY) + money,
				JLabel.CENTER);
		this.countMessage = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_WITHDRAWALS),
				JLabel.CENTER);
		this.passwordMessage = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_ENTER_BANK_PASSWORD),
				JLabel.CENTER);
		this.jpanelOptions = new JPanel();
		this.jTextFieldWithDrawals = new JTextField();
		this.jPasswordField = new JPasswordField();
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.setVisible(false);
		this.jpanelOptions.setOpaque(false);
		this.jpanelOptions.setLayout(new GridBagLayout());

		this.title.setFont(CyFPaletteApp.FONT_TITLES);
		this.title.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(title, BorderLayout.NORTH);
		this.add(jpanelOptions, BorderLayout.CENTER);

		gbc.weightx = 1;
		gbc.gridwidth = 2;
		gbc.insets.bottom = 90;
		countMoney.setForeground(CyFPaletteApp.COLOR_MAIN);
		countMoney.setFont(CyFPaletteApp.FONT_CONTENT);
		this.jpanelOptions.add(countMoney, gbc);

		gbc.gridwidth = 1;
		gbc.gridy = 1;
		gbc.insets.bottom = 0;
		gbc.insets.top = 30;
		countMessage.setForeground(CyFPaletteApp.COLOR_MAIN);
		countMessage.setFont(CyFPaletteApp.FONT_CONTENT);
		this.jpanelOptions.add(countMessage, gbc);

		gbc.gridx = 1;
		jTextFieldWithDrawals.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		jTextFieldWithDrawals.setForeground(CyFPaletteApp.COLOR_MAIN);
		jTextFieldWithDrawals.setOpaque(false);
		jTextFieldWithDrawals.setPreferredSize(new Dimension(400, 30));
		jTextFieldWithDrawals.setBorder(BorderFactory.createLineBorder(CyFPaletteApp.COLOR_BORDER));
		jTextFieldWithDrawals.setText("$ ");
		jTextFieldWithDrawals.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (((int)e.getKeyChar())<48 || ((int)e.getKeyChar())>57) {
					e.consume();
				}
				if (jTextFieldWithDrawals.getText().length() >= Constants.MAX_LENGTH_MONEY) {
					e.consume();
				}
				if (jTextFieldWithDrawals.getText().length() <= 2) {
					jTextFieldWithDrawals.setText("$ ");
				}
			}
		});
		this.jpanelOptions.add(jTextFieldWithDrawals, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		passwordMessage.setFont(CyFPaletteApp.FONT_CONTENT);
		passwordMessage.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jpanelOptions.add(passwordMessage, gbc);

		gbc.gridx = 1;
		this.jPasswordField.setFont(CyFPaletteApp.FONT_CONTENT);
		this.jPasswordField.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jPasswordField.setOpaque(false);
		this.jPasswordField.setBorder(BorderFactory.createLineBorder(CyFPaletteApp.COLOR_BORDER));
		this.jPasswordField.setPreferredSize(new Dimension(400, 30));
		this.jPasswordField.setLayout(new BorderLayout());
		this.jPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == ' ') {
					e.consume();
				}
				if (String.valueOf(jPasswordField.getPassword()).length() == Constants.MAX_LENGTH_PASSWORD) {
					e.consume();
				}
			}
		});
		TextPrompt textPrompt = new TextPrompt(Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_PASS),
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
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);
		this.jpanelOptions.add(jPasswordField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.insets.top = 60;
		this.jpanelOptions.add(new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_ACCEPT),
				ControllerApp.getInstance(), Constants.COMMAND_ACCEPT_WITHDRAWALS, SIZE_BUTTON_WIDTH, SIZE_BUTTON_HEIGHT,
				CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false), gbc);

		gbc.gridy = 4;
		gbc.insets.top = 10;
		this.jpanelOptions.add(new JButtonsDDC(Constants.MESSAGE_JBUTTON_ARROW_BACK, JFrameMainWindow.getInstance(),
				Constants.COMMAND_JBUTTON_ARROW_BACK_WITHDRAWALS, SIZE_BUTTON_WIDTH, SIZE_BUTTON_HEIGHT,
				CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false), gbc);
	}
	/**
	 * Metodo que obtiene contraseña de la cuenta
	 * @return contraseña de la cuenta
	 */
	public String getPasswordAccountWithDrawals() {
		return String.valueOf(jPasswordField.getPassword());
	}
	/**
	 * Metodo que obtiene el dinero a retirar
	 * @return dinero a retirar
	 */
	public String getMoneyToWithDrawals() {
		return jTextFieldWithDrawals.getText().substring(2);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(5, 5, getWidth() - 10, getHeight() - 10);
		super.paintComponent(g);
	}

}
