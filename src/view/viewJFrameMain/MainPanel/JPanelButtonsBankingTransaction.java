/**
 * 
 */
package view.viewJFrameMain.MainPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;
import view.viewJFrameMain.JFrameMainWindow;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 17/05/2021
 */
public class JPanelButtonsBankingTransaction extends JPanel{
	private static final long serialVersionUID = 1L;

	public JPanelButtonsBankingTransaction(KeyListener keyListener) {
		super();
		init(keyListener);
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(20, 20, 20, 20);
	}

	/**
	 * 
	 */
	private void init(KeyListener keyListener) {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		
		JButtonsDDC buttonClose = new JButtonsDDC(
				Constants.MESSAGE_JBUTTON_ARROW_BACK,
				JFrameMainWindow.getInstance(),
				Constants.COMMAND_JBUTTON_ARROW_BACK_BANKING_TRANSACTION, 60, 20,
				CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false);
		this.add(buttonClose, BorderLayout.WEST);
		
		JPanel jPanelSearch = new JPanel();
		jPanelSearch.setOpaque(false);
		jPanelSearch.setLayout(new BoxLayout(jPanelSearch, BoxLayout.X_AXIS));
		jPanelSearch.add(Box.createRigidArea(new Dimension(100, 0)));
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setPreferredSize(new Dimension(100, 30));
		comboBox.setOpaque(false);
		comboBox.setRenderer(new BasicComboBoxRenderer(){
			
		    private static final long serialVersionUID = 1L;

			@Override
		    public Component getListCellRendererComponent(JList<?> list, Object value,
		            int index, boolean isSelected, boolean cellHasFocus) {
		        JComponent result = (JComponent)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		        result.setOpaque(false);
		        return result;
		    }
			
			@Override
			public void setBorder(Border border) {
				super.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
			}
			
			@Override
			public void setForeground(Color fg) {
				super.setForeground(CyFPaletteApp.COLOR_MAIN);
			}
			
			@Override
			public void setFont(Font font) {
				super.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
			}
			
		});
		comboBox.setBackground(CyFPaletteApp.COLOR_BORDER_INVERT);
		comboBox.setForeground(CyFPaletteApp.COLOR_MAIN);
		comboBox.addItem(Constants.getInstance().getProperty(Constants.MESSAGE_JCOMBOBOX_DATE));
		comboBox.addItem(Constants.getInstance().getProperty(Constants.MESSAGE_JCOMBOBOX_TYPE));
		jPanelSearch.add(comboBox);
		
		jPanelSearch.add(Box.createRigidArea(new Dimension(10, 0)));
		
		JTextField textField = new JTextField();
		textField.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		textField.setForeground(CyFPaletteApp.COLOR_MAIN);
		textField.setOpaque(false);
		textField.addKeyListener(keyListener);
		jPanelSearch.add(textField);
		jPanelSearch.add(Box.createRigidArea(new Dimension(100, 0)));
		this.add(jPanelSearch, BorderLayout.CENTER);
		
		JButtonsDDC buttonImprimir = new JButtonsDDC(
				Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_PRINT),
				JFrameMainWindow.getInstance(),
				Constants.COMMAND_JBUTTON_PRINT, 150, 20,
				CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false);
		this.add(buttonImprimir, BorderLayout.EAST);
	}
	
	public String textFilter() {
		return ((JTextField)((JPanel)this.getComponent(1)).getComponent(3)).getText();
	}
	
	public int getSelected() {
		return ((JComboBox<?>)((JPanel)this.getComponent(1)).getComponent(1)).getSelectedIndex();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(CyFPaletteApp.COLOR_BACKGROUND);
		g.fillRect(2, 2, getWidth()-4, getHeight()-4);
		super.paintComponent(g);
	}
}
