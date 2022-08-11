package view.viewJFrameMain;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.Constants;
import view.CyFPaletteApp;

/**
 * Clase que maneja el objeto JPanelPhoto.java
 *
 * @author Cristian David Parada Martinez
 * @date 11/05/2021
 *
 */
public class JPanelPhoto extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon imagePhoto;

	/**
	 * Constructor de JPanelPhoto
	 * 
	 */
	public JPanelPhoto() {
		super();
		this.imagePhoto = new ImageIcon(Constants.PATH_IMAGE_PHOTO_DEFAULT);
		try {
			init();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que
	 * @throws IOException 
	 * 
	 */
	private void init() throws IOException {
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(60, 60));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String path = "";
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					JFileChooser chooser = new JFileChooser();
					FileFilter filtroImagen = new FileNameExtensionFilter("Archivos JPG, PNG, JPEG, BMP, GIF, TIFF",
							"jpg", "png", "jpeg", "bmp", "gif", "tiff");
					chooser.setFileFilter(filtroImagen);
					int option = chooser.showOpenDialog(chooser);
					if (option == JFileChooser.APPROVE_OPTION) {
						path = chooser.getSelectedFile().getAbsolutePath();
						imagePhoto = new ImageIcon(path);
						repaint();
					}

				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException | NullPointerException e1) {
				}
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.setColor(CyFPaletteApp.COLOR_TRANSPARENT);
		graphics2d.setClip(new Ellipse2D.Double(0, 0, getWidth(), getHeight()));
		graphics2d.drawImage(imagePhoto.getImage(), 0, 0, getWidth(), getHeight(), this);

	}

}
