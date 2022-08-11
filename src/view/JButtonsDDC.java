package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Clase que maneja el objeto MyJButton.java
 *
 * @author Cristian David Parada Martinez
 * @date 4/05/2021
 *
 */
public class JButtonsDDC extends JButton{

	private static final long serialVersionUID = 1L;
	private Color colorBackGround;
	private Color colorBackGroundAux;

	/**
	 * Constructor de MyJButton
	 * 
	 * @param nameOrIcon
	 */
	public JButtonsDDC(Object nameOrIcon, ActionListener actionListener, String actionCommand, int width, int heigth,
			Color colorForeGround, Color colorBackGroundP, boolean isScaled) {
		this.colorBackGround = colorBackGroundP;
		this.colorBackGroundAux = colorBackGround;
		if (nameOrIcon instanceof String) {
			this.setText((String) nameOrIcon);
			this.setFont(CyFPaletteApp.FONT_BUTTONS);
		} else {
			if (isScaled) {
				ImageIcon imageScaled = new ImageIcon(
						((ImageIcon) nameOrIcon).getImage().getScaledInstance(width / 2, heigth, Image.SCALE_DEFAULT));
				this.setIcon(imageScaled);
			} else {
				this.setIcon((ImageIcon) nameOrIcon);
			}
		}
		this.setOpaque(false);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setForeground(colorForeGround);
		this.addActionListener(actionListener);
		this.setActionCommand(actionCommand);
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setPreferredSize(new Dimension(width, heigth));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (isEnabled()) {
					colorBackGround = CyFPaletteApp.COLOR_BACKGROUND_SECUNDARY;
				}
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				colorBackGround = colorBackGroundAux;
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(colorBackGround);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}
