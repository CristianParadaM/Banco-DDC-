/**
 * 
 */
package view.viewRegister;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import view.CyFPaletteApp;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 14/05/2021
 */
public class JPanelBackGroundRegister extends JPanel{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de JPanelBackGroundSplash
	 */
	public JPanelBackGroundRegister() {
		super();
		setOpaque(false);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(new ImageIcon(CyFPaletteApp.PATH_BACKGROUND).getImage(),0,0,getWidth(),getHeight(), this);	
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRoundRect(10, 60, getWidth()-20, getHeight()-70, 60,60);
		super.paint(g);
	}
}
