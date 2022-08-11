package view.viewJFrameMain.MainPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.Constants;
import view.CyFPaletteApp;

/** Clase que maneja el objeto JPanelOptionsMain.java
 *
 * @author Cristian David Parada Martinez
 * @date 12/05/2021
 *
 */
public class JPanelOptionsMain extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JLabel jLabelWelcomeAgain;
	private JPanelInformationUser jPanelInformationUser;
	private JLabel jLabelDepositMoney;
	private JLabel jLabelWithDrawals;
	private JLabel jLabelTransferMoney;
	private JLabel jLabelLogOut;
	
	
	/** Constructor de JPanelOptionsMain
	 * 
	 */
	public JPanelOptionsMain(int numberAccount, String username, String typeAccount, double money) {
		super();
		this.gbc= new GridBagConstraints();
		this.jLabelWelcomeAgain = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_WELCOME_AGAIN), JLabel.CENTER);
		this.jPanelInformationUser = new JPanelInformationUser(numberAccount, username, typeAccount, money);
		this.jLabelDepositMoney = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_DEPOSIT), JLabel.CENTER);
		this.jLabelWithDrawals = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_WITHDRAWALS), JLabel.CENTER);
		this.jLabelTransferMoney = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_TRANSFERM), JLabel.CENTER);
		this.jLabelLogOut = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_LOGOUT), JLabel.CENTER);
		init();
	}

	/** Metodo que
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		gbc.fill = 1; gbc.weightx = 1; gbc.gridwidth = 4;
		
		jLabelWelcomeAgain.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		jLabelWelcomeAgain.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabelWelcomeAgain,gbc);
		
		gbc.gridy =1; gbc.insets = new Insets(10, 300, 0, 300);
		this.add(jPanelInformationUser,gbc);
		
		gbc.gridy =2; gbc.weighty=1;
		this.add(Box.createRigidArea(new Dimension(0,0)),gbc);
		
		gbc.insets= new Insets(10, 10, 0, 10);
		gbc.gridy=3;
		gbc.gridx=0;
		gbc.gridwidth = 1;
		gbc.fill = 0;
		gbc.weighty=0;
		this.add(new JActiveButtonDepositMoney(), gbc);
		
		gbc.gridx =1;
		this.add(new JActiveButtonWithDrawals(), gbc);
		
		gbc.gridx =2;
		this.add(new JActiveButtonTransferMoney(), gbc);
		
		gbc.gridx =3;
		this.add(new JActiveButtonLogOut(), gbc);
		
		gbc.gridx = 0; gbc.gridy=4; gbc.fill = 1; gbc.insets = new Insets(0, 0, 20, 0);
		this.jLabelDepositMoney.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelDepositMoney.setFont(CyFPaletteApp.FONT_BUTTONS);
		this.add(jLabelDepositMoney, gbc);
		
		gbc.gridx = 1;
		this.jLabelWithDrawals.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelWithDrawals.setFont(CyFPaletteApp.FONT_BUTTONS);
		this.add(jLabelWithDrawals, gbc);
		
		gbc.gridx = 2; 
		this.jLabelTransferMoney.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelTransferMoney.setFont(CyFPaletteApp.FONT_BUTTONS);
		this.add(jLabelTransferMoney, gbc);
		
		gbc.gridx = 3;
		this.jLabelLogOut.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelLogOut.setFont(CyFPaletteApp.FONT_BUTTONS);
		this.add(jLabelLogOut, gbc);
	}

	
}
