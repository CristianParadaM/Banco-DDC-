package view.viewJFrameMain;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;

/**
 * Clase que maneja el objeto JPanelOptionsJPLateral.java
 *
 * @author Cristian David Parada Martinez
 * @date 11/05/2021
 *
 */
public class JPanelOptionsJPLateral extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JPanelConfigFrame configFrame;

	/**
	 * Constructor de JPanelOptionsJPLateral
	 * 
	 */
	public JPanelOptionsJPLateral() {
		super();
		this.gbc = new GridBagConstraints();
		this.configFrame = new JPanelConfigFrame();
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());

		gbc.fill = 1;
		gbc.insets = new Insets(20, 30, 0, 30);
		gbc.weightx = 1;
		gbc.gridwidth = 2;
		this.add(new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_DEPOSIT),
				JFrameMainWindow.getInstance(), Constants.COMMAND_JBUTTON_DEPOSIT, 0, 40, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false), gbc);

		gbc.gridy = 1;
		gbc.insets.top = 15;
		this.add(new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_WITHDRAWALS),
				JFrameMainWindow.getInstance(), Constants.COMMAND_JBUTTON_WITHDRAWALS, 0, 40, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false), gbc);

		gbc.gridy = 2;
		this.add(new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_TRANSFERM),
				JFrameMainWindow.getInstance(), Constants.COMMAND_JBUTTON_TRANSFERM, 0, 40, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false), gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.weighty = 1;
		this.add(Box.createRigidArea(new Dimension(0, 10)), gbc);

		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		this.add(Box.createRigidArea(new Dimension(30, 20)), gbc);

		gbc.gridx = 1;
		gbc.gridheight = 2;
		gbc.insets = new Insets(0, 0, 10, 30);
		gbc.fill = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		configFrame.setVisible(configFrame.isActive()); // TODO
		configFrame.setPreferredSize(new Dimension(0, 100));
		this.add(configFrame, gbc);

		gbc.gridy = 5;
		gbc.gridx = 0;
		gbc.insets = new Insets(0, 0, 10, 0);
		gbc.gridwidth = 1;
		gbc.fill = 0;
		gbc.weightx = 0;
		this.add(new JButtonsDDC(new ImageIcon(Constants.PATH_CONFIG_ICON), JFrameMainWindow.getInstance(),
				Constants.COMMAND_BUTTON_CONFIG_JFRAME, 30, 30, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false), gbc);

	}

	/**
	 * @return the configFrame
	 */
	public boolean isActive() {
		return configFrame.isActive();
	}

	/**
	 * @return the configFrame
	 */
	public void setActive(boolean b) {
		configFrame.setActive(b);
	}

}
