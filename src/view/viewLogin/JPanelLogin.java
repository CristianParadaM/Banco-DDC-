package view.viewLogin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.Constants;
import view.CyFPaletteApp;

/** Clase que maneja el objeto JPanelLogin.java
 *
 * @author Cristian David Parada Martinez
 * @date 2/05/2021
 *
 */
public class JPanelLogin extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanelInformationJDialog jPanelInformation;
	private JLabel jLabelTitle;

	/** Constructor de JPanelLogin
	 * 
	 */
	public JPanelLogin() {
		super();
		this.jPanelInformation = new JPanelInformationJDialog();
		this.jLabelTitle = new JLabel(Constants.getInstance().getProperty(Constants.TITLE_JLABEL_WINDOW),JLabel.CENTER);
		inti();
	}

	/** Metodo que organiza y añade los componentes graficos
	 * 
	 */
	private void inti() {
		this.setOpaque(false);
		Font font = CyFPaletteApp.FONT_TITLES;
		Hashtable<TextAttribute, Integer> map = new Hashtable<TextAttribute, Integer>();
	    map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	    font = font.deriveFont(map);		
	    this.jLabelTitle.setFont(font);
		this.jLabelTitle.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelTitle.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(jLabelTitle,BorderLayout.NORTH);
		this.add(jPanelInformation,BorderLayout.CENTER);
	}
	
	/**
	 * Metodo que retorna el valor del jtextField username
	 * @return
	 */
	public String getjTextFieldUserText() {
		return  jPanelInformation.getjTextFieldUserText();
	}
	
	/**
	 * Metodo que retorna el valor del jtextField password
	 * @return
	 */
	public String getjPasswordFieldText() {
		return jPanelInformation.getjPasswordFieldText();
	}
	
	/**
	 * Metodo que retorna si esta seleccionado el check box de permanecer conectado
	 * @return
	 */
	public boolean isSelectedCheckBoxLogin() {
		return jPanelInformation.isSelectedCheckBoxLogin();
	}
	
}
