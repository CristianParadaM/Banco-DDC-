package view.viewJFrameMain;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import view.Constants;
import view.CyFPaletteApp;

/** Clase que maneja el objeto JPanelLateral.java
 *
 * @author Cristian David Parada Martinez
 * @date 11/05/2021
 *
 */
public class JPanelLateral extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelHeaderMainMenu;
	private JLabel jLabelFooter;
	private JPanelOptionsJPLateral jPanelOptionsJPLateral;
	
	/** Constructor de JPanelLateral
	 * 
	 */
	public JPanelLateral() {
		super();
		this.jLabelHeaderMainMenu = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_MAIN_MENU), JLabel.CENTER);
		this.jLabelFooter = new JLabel(Constants.VERSION_APP, JLabel.CENTER);
		this.jPanelOptionsJPLateral = new JPanelOptionsJPLateral();
		init();
	}

	/** Metodo que
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		
		this.jLabelHeaderMainMenu.setFont(CyFPaletteApp.FONT_TITLE_JPANEL_LATERAL);
		this.jLabelHeaderMainMenu.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelHeaderMainMenu.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER_INVERT,1));
		this.add(jLabelHeaderMainMenu, BorderLayout.NORTH);
		
		this.add(jPanelOptionsJPLateral, BorderLayout.CENTER);
		
		this.jLabelFooter.setFont(CyFPaletteApp.FONT_CONTENT);
		this.jLabelFooter.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelFooter.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER_INVERT,1));
		this.jLabelFooter.setPreferredSize(new Dimension(0,50));
		this.add(jLabelFooter, BorderLayout.SOUTH);
	}
	
	/**
	 * @return the configFrame
	 */
	public boolean isActive() {
		return jPanelOptionsJPLateral.isActive();
	}
	
	/**
	 * @return the configFrame
	 */
	public void setActive(boolean b) {
		jPanelOptionsJPLateral.setActive(b);
	}
	
}
