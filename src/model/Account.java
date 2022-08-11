/**
 * 
 */
package model;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 2/05/2021
 */
public class Account {
	private int numberAccount;
	private EnumTypeAccount typeAccount;
	private String passwordAcount;
	private double money;
	
	/**
	 * Constructor de Account
	 * @param numberAccount
	 * @param typeAccount
	 * @param passwordAcount
	 */
	public Account(int numberAccount, EnumTypeAccount typeAccount, String passwordAcount, double money) {
		super();
		this.numberAccount = numberAccount;
		this.typeAccount = typeAccount;
		this.passwordAcount = passwordAcount;
		this.money = money;
	}

	/**
	 * @return the numberAccount
	 */
	public int getNumberAccount() {
		return numberAccount;
	}

	/**
	 * @return the typeAccount
	 */
	public EnumTypeAccount getTypeAccount() {
		return typeAccount;
	}

	/**
	 * @return the passwordAcount
	 */
	public String getPasswordAcount() {
		return passwordAcount;
	}
	
	/**
	 * @param passwordAcount the passwordAcount to set
	 */
	public void setPasswordAcount(String passwordAcount) {
		this.passwordAcount = passwordAcount;
	}
	
	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}
	
	/**
	 * Añade dinero a la cuenta bancaria
	 * @param money dinero a añadir
	 */
	public void addMoney(double money) {
		this.money = this.money + money;
	}
	
	/**
	 * Retira dinero de la cuenta bancaria
	 * @param money dinero a retirar
	 * @return true si se pudo retirar con exito o false si no
	 */
	public boolean removeMoney(double money) {
		if (this.money >= money) {
			this.money = this.money - money;
			return true;
		}
		return false;
	}
}
