package view.viewJFrameMain.MainPanel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.time.LocalDate;

import javax.swing.JPanel;

import view.viewJFrameMain.JPanelCreditsFrame;

/** Clase que maneja el objeto JPanelMain.java
 *
 * @author Cristian David Parada Martinez
 * @date 6/05/2021
 *
 */
public class JPanelMain extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JPanelOptionsMain jPanelOptionsMain;
	private JLabelLastConnection jLabelLastConnection;
	private JPanelCreditsFrame jPanelCredits;
	private JPanelContainerConfig jPanelContainerConfig;
	private JPanelBankingTransaction jPanelBankingTransaction;
	private JPanelSetting jPanelSettings;
	private JPanelTransaction JPanelTransaction;
	private JPanelDeposit jPanelDeposit;
	private JPanelWithDrawals jPanelWithDrawals;
	
	/** Constructor de JPanelMain
	 * @param jLabelTitle
	 */
	public JPanelMain(int numberAccount, String username, String typeAccount, double money, LocalDate date) {
		super();
		this.jPanelOptionsMain = new JPanelOptionsMain(numberAccount, username, typeAccount, money);
		this.jLabelLastConnection = new JLabelLastConnection(date);
		this.jPanelContainerConfig = new JPanelContainerConfig();
		this.jPanelBankingTransaction = new JPanelBankingTransaction(null);
		this.jPanelCredits = new JPanelCreditsFrame();
		this.jPanelSettings = new JPanelSetting();
		this.jPanelDeposit = new JPanelDeposit(money);
		this.jPanelWithDrawals = new JPanelWithDrawals(money);
		this.JPanelTransaction = new JPanelTransaction(money);
		init();
	}

	/** Metodo que
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(jPanelContainerConfig, BorderLayout.NORTH);
		this.add(jPanelOptionsMain, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);
		new Thread(jLabelLastConnection).start();
	}
	
	/**
	 * Metodo que activa los creditos
	 *
	 */
	public void activeCredits() {
		this.setLayout(new BorderLayout());
		this.jPanelOptionsMain.setVisible(false);
		this.jPanelCredits.setVisible(true);
		this.jPanelBankingTransaction.setVisible(false);
		this.jPanelDeposit.setVisible(false);
		this.JPanelTransaction.setVisible(false);
		this.jPanelWithDrawals.setVisible(false);
		this.jPanelSettings.setVisible(false);
		this.add(jPanelCredits, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);
	}
	
	/**
	 * Metodo que desactiva
	 *
	 */
	public void desactiveCredits() {
		this.setLayout(new BorderLayout());
		jPanelCredits.setVisible(false);
		this.jPanelOptionsMain.setVisible(true);
		this.add(jPanelContainerConfig, BorderLayout.NORTH);
		this.add(jPanelOptionsMain, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);
	}
	
	/**
	 * Metodo que visualiza el panel con la tabla de transacciones bancarias
	 * @param info informacion de transacciones bancarias a mostrar
	 */
	public void activateBankinTransaction(Object[][] info) {
		this.setLayout(new BorderLayout());
		this.jPanelBankingTransaction = new JPanelBankingTransaction(info);
		jPanelOptionsMain.setVisible(false);
		this.add(jPanelBankingTransaction, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);
	}
	
	/**
	 * Metodo que visualiza el panel con el menu principal
	 */
	public void desactivateBankinTransaction() {
		this.setLayout(new BorderLayout());
		jPanelBankingTransaction.setVisible(false);
		jPanelOptionsMain.setVisible(true);
		this.add(jPanelContainerConfig, BorderLayout.NORTH);
		this.add(jPanelOptionsMain, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);
	}

	/**
	 * Metodo para imprimir la tabla de transacciones bancarias
	 */
	public void printTable() {
		this.jPanelBankingTransaction.printTable();
	}
	
	/**
	 * Metodo que mira si las configuraciones estan visibles
	 * @return true o false
	 */
	public boolean isVisibleConfig() {
		return jPanelContainerConfig.isVisibleConfig();
	}
	
	/**
	 * Metodo que cambia la visibilidad de las configuraciones
	 */
	public void setVisibleConfig(boolean b) {
		this.jPanelContainerConfig.setVisibleConfig(b);
	}
	
	//------------------
	
	/**
	 * Metodo que activa las configuraciones
	 *
	 */
	public void activateConfigurations() {
		this.jPanelOptionsMain.setVisible(false);
		this.jPanelBankingTransaction.setVisible(false);
		this.jPanelCredits.setVisible(false);
		this.jPanelWithDrawals.setVisible(false);
		this.JPanelTransaction.setVisible(false);
		this.jPanelDeposit.setVisible(false);
		this.setLayout(new BorderLayout());
		jPanelSettings.setVisible(true);
		this.add(jPanelSettings, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);

	}
	
	/**
	 * Metodo que desactiva las configuraciones
	 *
	 */
	public void desactivateConfigurations() {
		this.jPanelOptionsMain.setVisible(true);
		this.jPanelSettings.setVisible(false);
		this.setLayout(new BorderLayout());
		this.add(jPanelContainerConfig, BorderLayout.NORTH);
		this.add(jPanelOptionsMain, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);

	}
	
	/**
	 * Metodo que activa el panel de transferencia
	 */
	public void activeTransaction() {
		this.setLayout(new BorderLayout());
		this.jPanelOptionsMain.setVisible(false);
		this.jPanelCredits.setVisible(false);
		this.jPanelBankingTransaction.setVisible(false);
		this.jPanelSettings.setVisible(false);
		this.jPanelWithDrawals.setVisible(false);
		this.jPanelDeposit.setVisible(false);
		this.JPanelTransaction.setVisible(true);
		this.add(JPanelTransaction, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);
	}
	/**
	 * Metodo que desactiva el panel de transferencia
	 */
	public void desactiveTransaction() {
		this.setLayout(new BorderLayout());
		this.JPanelTransaction.setVisible(false);
		this.jPanelOptionsMain.setVisible(true);
		this.add(jPanelContainerConfig, BorderLayout.NORTH);
		this.add(jPanelOptionsMain, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);
	}
	/**
	 * Metodo que activa el panel de deposito
	 */
	public void activeDeposit() {
		this.setLayout(new BorderLayout());
		this.jPanelCredits.setVisible(false);
		this.jPanelBankingTransaction.setVisible(false);
		this.jPanelOptionsMain.setVisible(false);
		this.jPanelSettings.setVisible(false);
		this.jPanelWithDrawals.setVisible(false);
		this.JPanelTransaction.setVisible(false);
		this.jPanelDeposit.setVisible(true);
		this.add(jPanelDeposit, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);
	}
	
	/**
	 * Metodo que desactiva el panel de deposito
	 */
	public void desactivateDeposit() {
		this.setLayout(new BorderLayout());
		this.jPanelOptionsMain.setVisible(true);
		this.jPanelDeposit.setVisible(false);
		this.add(jPanelContainerConfig, BorderLayout.NORTH);
		this.add(jPanelOptionsMain, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);
	}
	
	
	/**
	 * Metodo que activa el panel de retiro
	 */
	public void activeWithDrawals() {
		this.jPanelOptionsMain.setVisible(false);
		this.jPanelCredits.setVisible(false);
		this.jPanelBankingTransaction.setVisible(false);
		this.jPanelOptionsMain.setVisible(false);
		this.jPanelDeposit.setVisible(false);
		this.jPanelSettings.setVisible(false);
		this.JPanelTransaction.setVisible(false);
		this.jPanelWithDrawals.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(jPanelWithDrawals, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);
	}
	
	/**
	 * Metodo que desactiva el panel de retiro
	 */
	public void desactivateWithDrawals() {
		this.setLayout(new BorderLayout());
		this.jPanelOptionsMain.setVisible(true);
		this.jPanelWithDrawals.setVisible(false);
		this.add(jPanelContainerConfig, BorderLayout.NORTH);
		this.add(jPanelOptionsMain, BorderLayout.CENTER);
		this.add(jLabelLastConnection, BorderLayout.SOUTH);
	}
	/**
	 * Metodo que obtiene contraseña de la cuenta
	 * @return contraseña de la cuenta
	 */
	public String getPasswordAccountDeposit() {
		return jPanelDeposit.getPasswordAccountDeposit();
	}
	/**
	 * Metodo que obtiene el dinero a depostiar
	 * @return dinero a depositar
	 */
	public String getMoneyToDeposit() {
		return jPanelDeposit.getMoneyToDeposit();
	}
	/**
	 * Metodo que obtiene contraseña de la cuenta
	 * @return contraseña de la cuenta
	 */
	public String getPasswordAccountWithDrawals() {
		return jPanelWithDrawals.getPasswordAccountWithDrawals();
	}
	/**
	 * Metodo que obtiene el dinero a retirar
	 * @return dinero a retirar
	 */
	public String getMoneyToWithDrawals() {
		return jPanelWithDrawals.getMoneyToWithDrawals();
	}
	/**
	 * Metodo que obtiene contraseña de la cuenta
	 * @return contraseña de la cuenta
	 */
	public String getPasswordAccountTransaction() {
		return JPanelTransaction.getPasswordAccountTransaction();
	}
	/**
	 * Metodo que el numero de cuenta del remitente
	 * @return numero de cuenta del remitente
	 */
	public String getNumberAccountToDeposit() {
		return JPanelTransaction.getNumberAccountToDeposit();
	}
	
	/**
	 * Metodo que obtiene el dinero a transferir
	 * @return dinero a transferir
	 */
	public String getMoneyToTransfer() {
		return JPanelTransaction.getMoneyToTransfer();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		jPanelContainerConfig.setBounds(0, 0, getWidth(), 110);
		repaint();
		super.paintComponent(g);
	}
	
}
