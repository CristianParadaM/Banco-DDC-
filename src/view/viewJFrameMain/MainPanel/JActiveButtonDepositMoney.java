package view.viewJFrameMain.MainPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.ControllerApp;


/**
 * Clase que maneja el objeto JPanel1.java
 *
 * @author Cristian David Parada Martinez
 * @date 7/05/2021
 *
 */
public class JActiveButtonDepositMoney extends JPanel{

	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon;
	private String pathImage;

	/**
	 * Constructor de JPanel1
	 * 
	 */
	public JActiveButtonDepositMoney() {
		super();
		this.pathImage = "src/res/money.png";
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.setBorder(new LineBorder(Color.BLACK, 3));
		this.setPreferredSize(new Dimension(150, 150));
		this.addMouseListener(ControllerApp.getInstance());
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
