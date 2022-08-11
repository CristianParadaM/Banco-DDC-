package view.viewJFrameMain;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.ControllerApp;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;

/**
 * Clase que maneja el objeto JPanelConfigCorner.java
 *
 * @author Cristian David Parada Martinez
 * @date 17/05/2021
 *
 */
public class JPanelConfigCorner extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de JPanelConfigCorner
	 * 
	 */
	public JPanelConfigCorner() {
		super();
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setVisible(false);
		this.setOpaque(false);
		this.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
		this.setPreferredSize(new Dimension(200, 100));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = 1;
		gbc.weightx = 1;
		this.add(new JButtonsDDC("Configuraciones", JFrameMainWindow.getInstance(), Constants.COMMAND_JBUTTON_SETTING,
				0, 30, CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_TRANSPARENT, false), gbc);
		gbc.gridy = 1;
		this.add(new JButtonsDDC("Sobre Nosotros", JFrameMainWindow.getInstance(),
				Constants.COMMAND_JBUTTON_ABOUT_US_JFRAME, 0, 30, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_TRANSPARENT, false), gbc);
		gbc.gridy = 2;
		this.add(new JButtonsDDC("Cerrar Sesion", ControllerApp.getInstance(), Constants.COMMAND_JBUTTON_LOG_OUT, 0, 30,
				CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_TRANSPARENT, false), gbc);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

}
