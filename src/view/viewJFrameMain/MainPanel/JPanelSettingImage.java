package view.viewJFrameMain.MainPanel;

import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.Constants;


public class JPanelSettingImage extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel jLabel;
	private int countMakeoverEffect;
	private Timer timer;
	private TimerTask task;
	private String[] load;

	public JPanelSettingImage() {
		super();
		this.load = new String[] { Constants.PATH_SETTING_OPTION_1, Constants.PATH_SETTING_OPTION_2,
				Constants.PATH_SETTING_OPTION_3 };
		this.countMakeoverEffect = 0;
		init();
	}

	/** Metodo que
	 * 
	 */
	private void init() {
		this.setLayout(new GridLayout());
		this.setOpaque(false);
		loadImages();
	}

	public void loadImages() {
		int fast = 1;
		int totalFast = fast * 5000;
		jLabel = new JLabel();
		jLabel.setIcon(new ImageIcon(load[2]));
		jLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(jLabel);
		task = new TimerTask() {

			@Override
			public void run() {

				switch (countMakeoverEffect) {
				case 0: {
					countMakeoverEffect = 1;
					jLabel.setIcon(new ImageIcon(load[0]));
					break;

				}
				case 1: {
					countMakeoverEffect = 2;
					jLabel.setIcon(new ImageIcon(load[1]));
					break;

				}
				case 2: {
					countMakeoverEffect = 0;
					jLabel.setIcon(new ImageIcon(load[2]));
					break;

				}

				}
			}
		};

		timer = new Timer();
		timer.scheduleAtFixedRate(task, totalFast, totalFast);
	}

}
