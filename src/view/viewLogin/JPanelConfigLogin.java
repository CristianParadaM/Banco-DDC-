package view.viewLogin;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.ControllerApp;
import view.Constants;
import view.CyFPaletteApp;

/** Clase que maneja el objeto JPanelConfig.java
 *
 * @author Cristian David Parada Martinez
 * @date 4/05/2021
 *
 */
public class JPanelConfigLogin extends JPanel{

	private static final long serialVersionUID = 1L;
	private boolean isActive;
	private JComboBox<String> comboBoxLanguaje;
	private JComboBox<String> comboBoxTheme;
	private JLabel jLabelSelectLanguaje;
	private JLabel jLabelTheme;
	
	/** Constructor de JPanelConfig
	 */
	public JPanelConfigLogin() {
		super();
		this.comboBoxLanguaje = new JComboBox<String>();
		this.comboBoxTheme = new JComboBox<String>();
		this.jLabelSelectLanguaje = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_SELECT_LANGUAJE));
		this.jLabelTheme = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JCOMBOBOX_CHANGE_THEME));
		this.isActive = false;
		init();
	}

	/** Metodo que ordena y añade los componentes graficos
	 * 
	 */
	private void init() {
		
		this.setLayout(null);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createLineBorder(CyFPaletteApp.COLOR_MAIN));
		this.setPreferredSize(new Dimension(250, 100));
		
		//label seleccionar lenguaje
		jLabelSelectLanguaje.setOpaque(false);
		jLabelSelectLanguaje.setFont(CyFPaletteApp.FONT_BUTTONS);
		jLabelSelectLanguaje.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabelSelectLanguaje).setBounds(0,5,150,20);
		
		//combo box seleccionar lenguaje
		comboBoxLanguaje.setOpaque(false);
		comboBoxLanguaje.setBackground(CyFPaletteApp.COLOR_BACKGROUND);
		comboBoxLanguaje.setForeground(CyFPaletteApp.COLOR_MAIN);
		comboBoxLanguaje.addItemListener(ControllerApp.getInstance());
		
		comboBoxLanguaje.addItem(Constants.getInstance().getProperty(Constants.MESSAGE_JCOMBOBOX_ESPANISH));
		comboBoxLanguaje.addItem(Constants.getInstance().getProperty(Constants.MESSAGE_JCOMBOBOX_ENGLISH));
		this.add(comboBoxLanguaje).setBounds(150,5,90,20);
		
		//label seleccionar fuente
		jLabelTheme.setFont(CyFPaletteApp.FONT_BUTTONS);
		jLabelTheme.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabelTheme).setBounds(0,30,150,20);
		
		//combo box seleccionar tema
		comboBoxTheme.setBackground(CyFPaletteApp.COLOR_BACKGROUND);
		comboBoxTheme.setForeground(CyFPaletteApp.COLOR_MAIN);
		comboBoxTheme.addItemListener(ControllerApp.getInstance());
		
		comboBoxTheme.addItem(Constants.getInstance().getProperty(Constants.MESSAGE_JCOMBOBOX_SELECT));
		comboBoxTheme.addItem(Constants.getInstance().getProperty(Constants.MESSAGE_JCOMBOBOX_THEME_DARK));
		comboBoxTheme.addItem(Constants.getInstance().getProperty(Constants.MESSAGE_JCOMBOBOX_THEME_LIGHT));
		this.add(comboBoxTheme).setBounds(150,30,90,20);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	/** Metodo para cambiar el valor de isActive
	 * @param b
	 */
	public void setActive(boolean b) {
		this.isActive = b;
	}
	
	/**
	 * Metodo que retorna si el panel de configuraciones esta o no activo
	 * @return
	 */
	public boolean isActive() {
		return this.isActive;
	}

	/**
	 * Metodo retorna el lenguaje seleccionado del combo box
	 * @return
	 */
	public String getLanguajeSelected() {
		return (String)this.comboBoxLanguaje.getSelectedItem();
	}
	
	/**
	 * Metodo que retorna el tema seleccionado por el combo box
	 * @return
	 */
	public String getThemeSelected() {
		return (String)this.comboBoxTheme.getSelectedItem();
	}
	
}
