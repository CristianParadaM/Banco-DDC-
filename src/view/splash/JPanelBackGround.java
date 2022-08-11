package view.splash;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * Clase que maneja el objeto JPanelBackGround.java
 *
 * @author Cristian David Parada Martinez
 * @date 2/05/2021
 *
 */
public class JPanelBackGround extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de JPanelBackGround
	 * 
	 * @param background
	 */
	public JPanelBackGround() {
		super();
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setOpaque(false);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(new GradientPaint(0.0f, 0.0f, new Color(57, 255, 193).darker(), getWidth(), getHeight(),
				new Color(16, 0, 93).darker()));
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

}
