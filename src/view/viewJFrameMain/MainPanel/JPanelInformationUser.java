package view.viewJFrameMain.MainPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.ControllerApp;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;

/**
 * Clase que maneja el objeto JPanelInformationUser.java
 *
 * @author Cristian David Parada Martinez
 * @date 12/05/2021
 *
 */
public class JPanelInformationUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JLabel jLabelMyAccount;
	private JLabel jLabelMyUserName;
	private JLabel jLabelMyAccountParameter;
	private JLabel jLabelMyUserNameParameter;
	private JLabel jLabelMyTypeAccount;
	private JLabel jLabelMyMoney;
	private JLabel jLabelMyTypeAccountParameter;
	private JLabel jLabelMyMoneyParameter;
	private JButton jButtonMovements;

	/**
	 * Constructor de JPanelInformationUser
	 * 
	 */
	public JPanelInformationUser(int numberAccount, String username, String typeAccount, double money) {
		super();
		this.gbc = new GridBagConstraints();
		this.jLabelMyAccount = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_MY_ACCOUNT),
				JLabel.CENTER);
		this.jLabelMyUserName = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_MY_USERNAME),
				JLabel.CENTER);
		this.jLabelMyAccountParameter = new JLabel(""+numberAccount, JLabel.CENTER);
		this.jLabelMyUserNameParameter = new JLabel(username, JLabel.CENTER);
		this.jLabelMyTypeAccount = new JLabel(
				Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_TYPE_ACCOUNT), JLabel.CENTER);
		this.jLabelMyMoney = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_ACTUAL_MONEY),
				JLabel.CENTER);
		this.jLabelMyTypeAccountParameter = new JLabel(Constants.getInstance().getProperty(typeAccount), JLabel.CENTER);
		this.jLabelMyMoneyParameter = new JLabel("$"+money, JLabel.CENTER);
		this.jButtonMovements = new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_MY_MOVEMENTS),
				ControllerApp.getInstance(), Constants.COMMAND_JBUTTON_MY_MOVEMENTS, 0, 40, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_TRANSPARENT, false);
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setPreferredSize(new Dimension(0, 300));
		this.setOpaque(false);
		this.setBorder(new LineBorder(CyFPaletteApp.COLOR_BACKGROUND_SECUNDARY));
		this.setLayout(new GridBagLayout());

		gbc.weightx = 1;
		gbc.fill = 1;
		gbc.insets = new Insets(0, 10, 0, 10);
		this.jLabelMyAccount.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelMyAccount.setFont(CyFPaletteApp.FONT_CONTENT_SUBTITLES);
		this.add(jLabelMyAccount, gbc);

		gbc.gridx = 1;
		this.jLabelMyUserName.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelMyUserName.setFont(CyFPaletteApp.FONT_CONTENT_SUBTITLES);
		this.add(jLabelMyUserName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.jLabelMyAccountParameter.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelMyAccountParameter.setFont(CyFPaletteApp.FONT_CONTENT);
		this.add(jLabelMyAccountParameter, gbc);

		gbc.gridx = 1;
		this.jLabelMyUserNameParameter.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelMyUserNameParameter.setFont(CyFPaletteApp.FONT_CONTENT);
		this.add(jLabelMyUserNameParameter, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets.top = 30;
		this.jLabelMyTypeAccount.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelMyTypeAccount.setFont(CyFPaletteApp.FONT_CONTENT_SUBTITLES);
		this.add(jLabelMyTypeAccount, gbc);

		gbc.gridx = 1;
		this.jLabelMyMoney.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelMyMoney.setFont(CyFPaletteApp.FONT_CONTENT_SUBTITLES);
		this.add(jLabelMyMoney, gbc);

		gbc.gridx = 0;
		gbc.insets.top = 10;
		gbc.gridy = 3;
		this.jLabelMyTypeAccountParameter.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelMyTypeAccountParameter.setFont(CyFPaletteApp.FONT_CONTENT);
		this.add(jLabelMyTypeAccountParameter, gbc);

		gbc.gridx = 1;
		this.jLabelMyMoneyParameter.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelMyMoneyParameter.setFont(CyFPaletteApp.FONT_CONTENT);
		this.add(jLabelMyMoneyParameter, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(80, 10, 5, 10);
		jButtonMovements.setBorderPainted(true);
		jButtonMovements.setBorder(new LineBorder(CyFPaletteApp.COLOR_BACKGROUND_SECUNDARY));
		this.add(jButtonMovements, gbc);

	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

}
