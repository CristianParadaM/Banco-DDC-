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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import controller.ControllerApp;
import model.TextPrompt;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;
import view.viewJFrameMain.JFrameMainWindow;

public class JPanelTransaction extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int SIZE_BUTTON_WIDTH = 200;
	public static final int SIZE_BUTTON_HEIGHT = 30;

	private GridBagConstraints gbc;
	private JPanel jPanelOptions;
	private JLabel jLabelTitle;
	private JLabel jLabelUserSend;
	private JLabel jlabelActualMoney;
	private JLabel jLabelCountMessage;
	private JLabel jLabelPassword;
	private JTextField jTextFieldUserSend;
	private JTextField jTextFieldSendMoney;
	private JPasswordField jPasswordField;

	public JPanelTransaction(double money) {
		this.gbc = new GridBagConstraints();
		this.jlabelActualMoney = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_AMOUNT_OF_MONEY)+money, JLabel.CENTER);
		this.jPanelOptions = new JPanel();
		this.jLabelTitle = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_TITLE_TRANSACTION),
				JLabel.CENTER);
		this.jLabelUserSend = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_SHIPPING_ACCOUNT),
				JLabel.CENTER);
		this.jLabelCountMessage = new JLabel(
				Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_MONEY_TO_SEND), JLabel.CENTER);
		this.jLabelPassword = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_ENTER_BANK_PASSWORD),
				JLabel.CENTER);
		this.jTextFieldUserSend = new JTextField();
		this.jTextFieldSendMoney = new JTextField();
		this.jPasswordField = new JPasswordField();
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.setVisible(false);
		this.jPanelOptions.setLayout(new GridBagLayout());
		this.jPanelOptions.setOpaque(false);
		this.add(jPanelOptions, BorderLayout.CENTER);

		this.jLabelTitle.setFont(CyFPaletteApp.FONT_TITLES);
		this.jLabelTitle.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabelTitle, BorderLayout.NORTH);

		gbc.weightx = 1;
		gbc.gridwidth = 2;
		gbc.fill = 1;
		gbc.insets.bottom = 90;
		this.jlabelActualMoney.setFont(CyFPaletteApp.FONT_CONTENT);
		this.jlabelActualMoney.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jPanelOptions.add(jlabelActualMoney, gbc);

		gbc.gridwidth = 1;
		gbc.gridy = 1;
		gbc.fill = 0;
		gbc.insets.bottom = 20;
		this.jLabelUserSend.setFont(CyFPaletteApp.FONT_CONTENT);
		this.jLabelUserSend.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jPanelOptions.add(jLabelUserSend, gbc);

		gbc.gridy = 2;
		this.jLabelCountMessage.setFont(CyFPaletteApp.FONT_CONTENT);
		this.jLabelCountMessage.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jPanelOptions.add(jLabelCountMessage, gbc);

		gbc.gridy = 3;
		this.jLabelPassword.setFont(CyFPaletteApp.FONT_CONTENT);
		this.jLabelPassword.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jPanelOptions.add(jLabelPassword, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		this.jTextFieldUserSend.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		this.jTextFieldUserSend.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jTextFieldUserSend.setPreferredSize(new Dimension(400, 30));
		this.jTextFieldUserSend.setOpaque(false);
		this.jTextFieldUserSend.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
		this.jTextFieldUserSend.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (((int)e.getKeyChar())<48 || ((int)e.getKeyChar())>57) {
					e.consume();
				}
			}
		});
		TextPrompt textPrompt = new TextPrompt(Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_USER_TO_SEND),
				jTextFieldUserSend);
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);
		this.jPanelOptions.add(jTextFieldUserSend, gbc);

		gbc.gridy = 2;
		this.jTextFieldSendMoney.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		this.jTextFieldSendMoney.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jTextFieldSendMoney.setPreferredSize(new Dimension(400, 30));
		this.jTextFieldSendMoney.setOpaque(false);
		this.jTextFieldSendMoney.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
		this.jTextFieldSendMoney.setText("$ ");
		this.jTextFieldSendMoney.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (((int)e.getKeyChar())<48 || ((int)e.getKeyChar())>57) {
					e.consume();
				}
				if (jTextFieldSendMoney.getText().length() >= Constants.MAX_LENGTH_MONEY) {
					e.consume();
				}
				if (jTextFieldSendMoney.getText().length() <= 2) {
					jTextFieldSendMoney.setText("$ ");
				}
			}
		});
		this.jPanelOptions.add(jTextFieldSendMoney, gbc);

		gbc.gridy = 3;
		this.jPasswordField.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		this.jPasswordField.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jPasswordField.setPreferredSize(new Dimension(400, 30));
		this.jPasswordField.setOpaque(false);
		this.jPasswordField.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
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
		gbc.insets.bottom = 50;
		textPrompt2.changeAlpha(0.35f);
		textPrompt2.changeStyle(Font.ITALIC);
		this.jPanelOptions.add(jPasswordField, gbc);

		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets.bottom = 10;
		this.jPanelOptions.add(new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_ACCEPT),
				ControllerApp.getInstance(), Constants.COMMAND_ACCEPT_TRANSFER, SIZE_BUTTON_WIDTH, SIZE_BUTTON_HEIGHT,
				CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false), gbc);

		gbc.gridy = 5;
		this.jPanelOptions.add(new JButtonsDDC(Constants.MESSAGE_JBUTTON_ARROW_BACK, JFrameMainWindow.getInstance(),
				Constants.COMMAND_JBUTTON_ARROW_BACK_TRANSFER, SIZE_BUTTON_WIDTH, SIZE_BUTTON_HEIGHT,
				CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false), gbc);

	}
	/**
	 * Metodo que obtiene contraseña de la cuenta
	 * @return contraseña de la cuenta
	 */
	public String getPasswordAccountTransaction() {
		return String.valueOf(jPasswordField.getPassword());
	}
	/**
	 * Metodo que el numero de cuenta del remitente
	 * @return numero de cuenta del remitente
	 */
	public String getNumberAccountToDeposit() {
		return jTextFieldUserSend.getText();
	}
	
	/**
	 * Metodo que obtiene el dinero a transferir
	 * @return dinero a transferir
	 */
	public String getMoneyToTransfer() {
		return jTextFieldSendMoney.getText().substring(2);
	}
	
	

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(5, 5, getWidth() - 10, getHeight() - 10);
		super.paintComponent(g);
	}

}
