/**
 * 
 */
package model;

import java.time.LocalDateTime;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 2/05/2021
 */
public class BankingTransaction {
	private String userName;
	private LocalDateTime date;
	private EnumTypeTransaction type;
	private double moneyAmount;
	
	/**
	 * Constructor de BankingTransaction
	 * @param date
	 * @param type
	 * @param moneyAmount
	 */
	public BankingTransaction(String userName, LocalDateTime date, EnumTypeTransaction type, double moneyAmount) {
		super();
		this.userName = userName;
		this.date = date.withNano(0);
		this.type = type;
		this.moneyAmount = moneyAmount;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}
	/**
	 * @return the type
	 */
	public EnumTypeTransaction getType() {
		return type;
	}
	/**
	 * @return the moneyAmount
	 */
	public double getMoneyAmount() {
		return moneyAmount;
	}
	
	
}
