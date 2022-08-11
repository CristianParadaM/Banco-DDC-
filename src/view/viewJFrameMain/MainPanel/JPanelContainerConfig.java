package view.viewJFrameMain.MainPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.JPanel;
import view.viewJFrameMain.JPanelConfigCorner;

/** Clase que maneja el objeto JPanelContainerConfig.java
 *
 * @author Cristian David Parada Martinez
 * @date 17/05/2021
 *
 */
public class JPanelContainerConfig extends JPanel {

	private static final long serialVersionUID = 1L;
	JPanelConfigCorner configCorner;
	
	/** Constructor de JPanelContainerConfig
	 */
	public JPanelContainerConfig() {
		super();
		this.configCorner = new JPanelConfigCorner();
		init();
	}

	/** Metodo que
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx =1; gbc.insets.top=5; gbc.insets.right=5; gbc.anchor = GridBagConstraints.EAST;
		this.add(Box.createRigidArea(new Dimension(0,100)),gbc);
		gbc.gridx=1;
		this.add(configCorner, gbc);
	}
	
	public boolean isVisibleConfig() {
		return configCorner.isVisible();
	}
	
	public void setVisibleConfig(boolean b) {
		this.configCorner.setVisible(b);
	}
}
