package view.viewJFrameMain;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;

/** Clase que maneja el objeto JPanelCreditsFrame.java
 *
 * @author Cristian David Parada Martinez
 * @date 17/05/2021
 *
 */
public class JPanelCreditsFrame extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JLabel jLabelTitle;

	/**
	 * Constructor de JPanelHelp
	 * 
	 */
	public JPanelCreditsFrame() {
		super();
		this.jLabelTitle = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_ABOUT_US), JLabel.CENTER);
		this.gbc = new GridBagConstraints();
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
		Font font = CyFPaletteApp.FONT_TITLES;
		Hashtable<TextAttribute, Integer> map = new Hashtable<TextAttribute, Integer>();
		map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		font = font.deriveFont(map);
		this.jLabelTitle.setFont(font);
		this.jLabelTitle.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.jLabelTitle.setOpaque(false);
		this.add(jLabelTitle, gbc);
		gbc.gridy = 1;
		gbc.insets.top = 70;
		gbc.weighty = 1;
		JTextPane jTextPane = new JTextPane();
		jTextPane.setOpaque(false);
		jTextPane.setPreferredSize(new Dimension(0, 550));
		jTextPane.setFont(CyFPaletteApp.FONT_CONTENT);
		jTextPane.setForeground(CyFPaletteApp.COLOR_MAIN);
		jTextPane.setEditable(false);
		jTextPane.setText(Constants.getInstance().getProperty(Constants.CREDITS));
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setOpaque(false);
		jScrollPane.setViewportView(jTextPane);
		jScrollPane.getViewport().setOpaque(false);
		jScrollPane.getVerticalScrollBar().setOpaque(false);
		jScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15,0));
		jScrollPane.setBorder(new LineBorder(CyFPaletteApp.COLOR_TRANSPARENT));
		this.add(jScrollPane, gbc);

		gbc.gridy = 2;
		gbc.insets = new Insets(20, 400, 20, 400);
		gbc.weighty=0;
		this.add(new JButtonsDDC(Constants.MESSAGE_JBUTTON_ARROW_BACK, JFrameMainWindow.getInstance(), Constants.COMMAND_JBUTTON_ARROW_BACK_CREDITS_JFRAME, 0, 30,
				CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false), gbc);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(5, 5, getWidth()-10, getHeight()-10);
		super.paintComponent(g);
	}
}
