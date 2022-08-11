package view.viewJFrameMain.MainPanel;

import java.awt.Graphics;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

import view.Constants;
import view.CyFPaletteApp;

/**
 * Clase que maneja el objeto JLabelLastConnection.java
 *
 * @author Cristian David Parada Martinez
 * @date 12/05/2021
 *
 */
public class JLabelLastConnection extends JLabel implements Runnable {

	private static final long serialVersionUID = 1L;
	private String lastConnection;
	private LocalDate date;

	/**
	 * Constructor de JLabelLastConnection
	 * 
	 */
	public JLabelLastConnection(LocalDate date) {
		super();
		this.date = date;
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.setFont(CyFPaletteApp.FONT_SLOGAN);
		this.setHorizontalAlignment(JLabel.CENTER);
	}

	@Override
	public void run() {
		this.lastConnection = Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_LAST_CONNECTION)
				+ date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		try {
			for (int i = 0; i < lastConnection.length(); i++) {
				this.setText(this.getText() + lastConnection.charAt(i));
				Thread.sleep(100);
			}
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		this.setText("");
		run();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

}
