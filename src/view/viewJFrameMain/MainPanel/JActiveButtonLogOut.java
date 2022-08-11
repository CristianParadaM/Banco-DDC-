package view.viewJFrameMain.MainPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.ControllerApp;

/** Clase que maneja el objeto JPanel4.java
 *
 * @author Cristian David Parada Martinez
 * @date 8/05/2021
 *
 */
public class JActiveButtonLogOut extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon;
	private String pathImage;
	
	/** Constructor de JPanel3
	 * 
	 */
	public JActiveButtonLogOut() {
		super();
		this.pathImage = "src/res/CerrarSesion.png";
		init();
	}
	
	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.setBorder(new LineBorder(Color.BLACK,3));
		this.setPreferredSize(new Dimension(150, 150));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.addMouseListener(ControllerApp.getInstance());
	}

	/**
	 * @param pathImage the pathImage to set
	 */
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.imageIcon = new ImageIcon(pathImage);
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

}
