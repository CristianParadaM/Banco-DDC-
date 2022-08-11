package view.viewJFrameMain.MainPanel;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControllerApp;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;
import view.viewJFrameMain.JFrameMainWindow;

public class JPanelSetting extends JPanel {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private JLabel titleLoad;
	private JPanelSettingImage image;

	public JPanelSetting() {
		super();
		this.gbc = new GridBagConstraints();
		this.titleLoad = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_TITLE_CONFIGURATION),
				JLabel.CENTER);
		this.image = new JPanelSettingImage();
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		this.setVisible(false);

		titleLoad.setForeground(CyFPaletteApp.COLOR_MAIN);
		titleLoad.setFont(CyFPaletteApp.FONT_TITLES);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = 1;

		this.add(titleLoad, gbc);
		gbc.gridy = 1;

		this.add(image, gbc);

		gbc.gridy = 2;
		gbc.fill = 0;
		gbc.weighty = 0;
		gbc.insets= new Insets(0, 0, 5, 0);
		this.add(
				new JButtonsDDC(Constants.getInstance().getProperty(Constants.JBUTTON_CHANGE_PASSWORD),
						ControllerApp.getInstance(), Constants.COMMAND_CHANGE_PASSWORD, Constants.SIZE_WIDTH_BUTTON,
						Constants.SIZE_HEIGHT_BUTTON, CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false),
				gbc);
		
		gbc.gridy = 3;
		this.add(
				new JButtonsDDC(Constants.getInstance().getProperty(Constants.JBUTTON_DELETE_ACCOUNT),
						ControllerApp.getInstance(), Constants.COMMAND_DELETE_ACCOUNT, Constants.SIZE_WIDTH_BUTTON,
						Constants.SIZE_HEIGHT_BUTTON, CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false),
				gbc);
		
		gbc.gridy = 4;
		gbc.insets.bottom=150;
		this.add(
				new JButtonsDDC(Constants.getInstance().getProperty(Constants.JBUTTON_BEHIND),
						JFrameMainWindow.getInstance(), Constants.COMMAND_BEHIND, Constants.SIZE_WIDTH_BUTTON,
						Constants.SIZE_HEIGHT_BUTTON, CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false),
				gbc);

		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(5, 5, getWidth()-10, getHeight()-10);
		super.paintComponent(g);
	}

}
