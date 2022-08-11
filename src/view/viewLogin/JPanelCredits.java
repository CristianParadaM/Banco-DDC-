package view.viewLogin;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;
import view.viewJFrameMain.JFrameMainWindow;

/**
 * Clase que maneja el objeto JPanelHelp.java
 *
 * @author Cristian David Parada Martinez
 * @date 11/05/2021
 *
 */
public class JPanelCredits extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JLabel jLabelTitle;

	/**
	 * Constructor de JPanelHelp
	 * 
	 */
	public JPanelCredits(Dimension dimension) {
		super();
		this.jLabelTitle = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_ABOUT_US), JLabel.CENTER);
		this.gbc = new GridBagConstraints();
		this.setSize(dimension.width / 2, dimension.height);
		init();
	}

	/**
	 * Metodo que organiza y añade los componentes graficos
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		this.setVisible(false);
		
		gbc.fill = 1;
		gbc.insets = new Insets(10, 30, 0, 30);
		gbc.weightx = 1;
		Font font = CyFPaletteApp.FONT_CONTENT_SUBTITLES;
		Hashtable<TextAttribute, Integer> map = new Hashtable<TextAttribute, Integer>();
		map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		font = font.deriveFont(map);
		this.jLabelTitle.setFont(font);
		this.jLabelTitle.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelTitle.setOpaque(false);
		this.add(jLabelTitle, gbc);
		gbc.gridy = 1;
		gbc.insets.top = 30;
		gbc.weighty=1;
		JTextPane jTextPane = new JTextPane();
		jTextPane.setOpaque(false);
		jTextPane.setPreferredSize(new Dimension(0, 350));
		jTextPane.setFont(CyFPaletteApp.FONT_CONTENT);
		jTextPane.setForeground(CyFPaletteApp.COLOR_MAIN);
		jTextPane.setEditable(false);
		jTextPane.setText(Constants.getInstance().getProperty(Constants.CREDITS));
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setOpaque(false);
		jScrollPane.setViewportView(jTextPane);
		jScrollPane.getViewport().setOpaque(false);
		jScrollPane.getVerticalScrollBar().setOpaque(false);
		jScrollPane.getHorizontalScrollBar().setOpaque(false);
		jScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));
		jScrollPane.setBorder(new LineBorder(CyFPaletteApp.COLOR_TRANSPARENT));
		
		this.add(jScrollPane, gbc);
		gbc.weighty=0;
		gbc.gridy = 2;
		gbc.insets.top = 20;
		this.add(new JButtonsDDC(Constants.MESSAGE_JBUTTON_ARROW_BACK, JFrameMainWindow.getInstance(), Constants.COMMAND_JBUTTON_ARROW_BACK_CREDITS, 0, 30,
				CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false), gbc);
		gbc.gridy = 3;
		this.add(Box.createRigidArea(new Dimension(0, 100)), gbc);
	}

}
