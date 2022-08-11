package view.viewJFrameMain;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import view.CyFPaletteApp;

/** Clase que maneja el objeto JPanelBackGroundJFrame.java
 *
 * @author Cristian David Parada Martinez
 * @date 5/05/2021
 *
 */
public class JPanelBackGroundJFrame extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ImageIcon backGround;
	private String pathBackGround;

	/** Constructor de JPanelBackGroundJFrame
	 * @param backGround
	 */
	public JPanelBackGroundJFrame() {
		super();
		this.pathBackGround = CyFPaletteApp.PATH_BACKGROUND;
		init();
	}

	/** Metodo que
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new GridLayout());
	}
	
	public void setPathAndRepaintTheme(String newPath) {
		this.pathBackGround = newPath;
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		this.backGround = new ImageIcon(pathBackGround);
		g.drawImage(backGround.getImage(), 0, 0,getWidth(),getHeight(), this);
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(0, 90, getWidth()/4, getHeight());
		super.paint(g);
	}
	
}
