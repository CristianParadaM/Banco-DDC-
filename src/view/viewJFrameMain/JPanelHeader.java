package view.viewJFrameMain;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;

/**
 * Clase que maneja el objeto JPanelHeader.java
 *
 * @author Cristian David Parada Martinez
 * @date 11/05/2021
 *
 */
public class JPanelHeader extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanelPhoto jPanelPhoto;
	private GridBagConstraints gbc;
	private JLabel jLabelName;

	/**
	 * Constructor de JPanelHeader
	 */
	public JPanelHeader(String nameUser, String lastName) {
		super();
		this.jPanelPhoto = new JPanelPhoto();
		this.gbc = new GridBagConstraints();
		this.jLabelName = new JLabel(nameUser + " " + lastName);
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(0, 90));
		this.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER_INVERT));
		gbc.weightx = 1;
		this.add(Box.createRigidArea(new Dimension(getWidth() / 3 * 2, 0)), gbc);
		gbc.gridx = 1;
		gbc.weightx = 0;
		this.add(jPanelPhoto, gbc);
		gbc.gridx = 2;
		gbc.insets.left = 5;
		this.jLabelName.setFont(CyFPaletteApp.FONT_CONTENT_SUBTITLES);
		this.jLabelName.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabelName, gbc);
		gbc.insets = new Insets(5, 10, 5, 0);
		gbc.gridx = 3;
		this.add(new JButtonsDDC(new ImageIcon("src/res/tresPuntos.png"), JFrameMainWindow.getInstance(), Constants.COMMAND_CONFIG_CORNER_JFRAME, 50, 60,
				CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_TRANSPARENT, true), gbc); //TODO

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(new ImageIcon("src/res/logo.png").getImage(), 5, 2, getWidth() / 9, getHeight() - 5, this);
	}

}
