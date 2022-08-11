package view.viewLogin;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.Constants;
import view.CyFPaletteApp;

/**
 * Clase que maneja el objeto JPanelImageLogo.java
 *
 * @author Cristian David Parada Martinez
 * @date 2/05/2021
 *
 */
public class JPanelImageLogo extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon;
	private JLabel jLabelSloganApp;

	/**
	 * Constructor de JPanelImageLogo
	 * 
	 */
	public JPanelImageLogo() {
		super();
		this.imageIcon = new ImageIcon(Constants.PATH_IMAGE_LOGO);
		this.jLabelSloganApp = new JLabel("<html><center>"+Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_SLOGAN_APP)+"</center></html>", JLabel.CENTER);
		init();
	}

	/**
	 * Metodo que organiza y añade los componentes graficos
	 * 
	 */
	private void init() {
		this.setLayout(new GridLayout(2,1));
		this.setOpaque(false);
		this.add(Box.createRigidArea(new Dimension(0,0)));
		jLabelSloganApp.setVerticalAlignment(JLabel.TOP);
		jLabelSloganApp.setFont(CyFPaletteApp.FONT_SLOGAN);
		jLabelSloganApp.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabelSloganApp);
		
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight()/2 , this);
		super.paint(g);
	}

}
