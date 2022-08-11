/**
 * 
 */
package view.viewJFrameMain.MainPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.CyFPaletteApp;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 17/05/2021
 */
public class JPanelBankingTransaction extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitle;
	private MyJTableInfoTransaction jTableInfoTransaction;
	private JPanelButtonsBankingTransaction buttonsBankingTransaction;
	/**
	 * Constructor de JPanelBankingTransaction
	 */
	public JPanelBankingTransaction(Object[][] info) {
		super();
		this.jLabelTitle = new JLabel("Ver mis movimientos bancarios");
		this.jTableInfoTransaction = new MyJTableInfoTransaction(info);
		this.buttonsBankingTransaction = new JPanelButtonsBankingTransaction(this);
		init();
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(10, 50, 10, 50);
	}

	/**
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		jLabelTitle.setPreferredSize(new Dimension(0,100));
		jLabelTitle.setFont(CyFPaletteApp.FONT_TITLES);
		jLabelTitle.setForeground(CyFPaletteApp.COLOR_MAIN);
		jLabelTitle.setHorizontalAlignment(JLabel.CENTER);
		this.add(jLabelTitle, BorderLayout.NORTH);
		
		this.add(jTableInfoTransaction, BorderLayout.CENTER);
		
		this.add(buttonsBankingTransaction, BorderLayout.SOUTH);
	}

	/**
	 * Metodo para imprimir la tabla de transacciones bancarias
	 */
	public void printTable() {
		this.jTableInfoTransaction.printTable();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		this.jTableInfoTransaction.filter(buttonsBankingTransaction.textFilter(), buttonsBankingTransaction.getSelected());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
