package view.viewLogin;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import view.Constants;
import view.CyFPaletteApp;

/** Clase que maneja el objeto JPanelBackGround.java
 *
 * @author Cristian David Parada Martinez
 * @date 2/05/2021
 *
 */
public class JPanelBackGround extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Image background;

	/** Constructor de JPanelBackGround
	 * @param background
	 */
	public JPanelBackGround() {
		super();
		this.background = new ImageIcon(CyFPaletteApp.PATH_BACKGROUND).getImage();
		init();
	}

	/** Metodo que organiza y añade los componentes graficos
	 */
	private void init() {
		this.setOpaque(false);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0,getWidth(),getHeight(), this);
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(0, 0, getWidth()/2, getHeight());
		g.setColor(CyFPaletteApp.COLOR_MAIN);
		g.setFont(CyFPaletteApp.FONT_CONTENT_SUBTITLES);
		g.drawString(Constants.VERSION_APP, getWidth()-150, getHeight()-30);
		super.paint(g);
	}
	
}	
