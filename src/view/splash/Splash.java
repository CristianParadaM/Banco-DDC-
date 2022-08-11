package view.splash;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

/**
 * Clase que maneja el objeto Splash.java
 *
 * @author Cristian David Parada Martinez
 * @date 19/05/2021
 *
 */
public class Splash extends JWindow implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int SLEEP_TIME = 4000;
	private JLabel icon;
	private JLabel description;
	private MyJProgressBar bar;
	private GridBagConstraints gridBagConstraints;
	
	private String infoCredits;
	private String pathImage;
	private Font font;

	public Splash(String infoCredits, String pathImage, Font font) {
		super();
		this.gridBagConstraints = new GridBagConstraints();
		this.infoCredits = infoCredits;
		this.pathImage = pathImage;
		this.font = font;
		this.bar = new MyJProgressBar(SLEEP_TIME);
		new Thread(this).start();
		init();
	}

	public void init() {
		this.setContentPane(new JPanelBackGround());
		this.setLayout(new GridBagLayout());
		this.setSize(650, 350);
		this.setLocationRelativeTo(null);
		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 60, 60));
		buildSplash();
	}

	/**
	 * Metodo que construye el splash
	 */
	public void buildSplash() {
		addImage();
		addPresentationScreen();
		addBar();
		this.setVisible(true);
	}

	/**
	 * Metodo que adiciona el logo
	 */
	public void addImage() {
		ImageIcon imgIcon = new ImageIcon(pathImage);
		Image imgScale = imgIcon.getImage().getScaledInstance(getWidth() / 3 * 2, getHeight() / 2, Image.SCALE_SMOOTH);
		this.icon = new JLabel(new ImageIcon(imgScale));
		gridBagConstraints.weighty = 10;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		this.add(icon, gridBagConstraints);

	}

	/**
	 * Metodo que adiciona la presentacion
	 *
	 */
	public void addPresentationScreen() {
		this.description = new JLabel(infoCredits, JLabel.CENTER);
		this.description.setFont(font);
		this.description.setForeground(Color.WHITE);
		gridBagConstraints.weighty = 1;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		this.add(this.description, gridBagConstraints);
	}

	/**
	 * Metodo que adiciona la barra de progreso
	 *
	 */
	public void addBar() {
		gridBagConstraints.weightx = 2;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(10, 10, 10, 10);
		new Thread(bar).start();
		this.add(bar, gridBagConstraints);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(SLEEP_TIME);
			this.dispose();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
