/**
 * 
 */
package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 6/05/2021
 */
public class Bank {
	public static final String NAME = "DDC";
	public static final String ADDRESS = "Tunja Calle 39-b N° 7-55";
	public static final String ID = "12345";
	public static final double INTERST = 0.015;

	private GroupUser users;
	private GroupBankingTransactionUser bankingTransactions;

	public Bank(ArrayList<User> users, ArrayList<BankingTransaction> bankingTransactions) {
		super();
		this.users = new GroupUser(users);
		this.bankingTransactions = new GroupBankingTransactionUser(bankingTransactions);
	}
	
	/**
	 * Verifica si una fecha tiene una diferencia de 18 o mas con la fecha actual
	 * @param dateOfBirth fecha con la cual se va a comparar
	 * @return true si es mayor o igual a 18 o false si no
	 */
	public boolean isAdult(LocalDate dateOfBirth) {
		Period period = Period.between(dateOfBirth, LocalDate.now());
		return period.getYears() >= 18;
	}

	/**
	 * Añade el interes mensual del banco a la cuenta de un usuario si ya ha pasdo
	 * el mes
	 * 
	 * @param userName nombre de usuario
	 * @return true si se añadio interes o false si no
	 */
	public double addBankInterest(String userName) {
		int userPosition = users.search(userName, 0, users.size());
		if (userPosition != -1) {
			User user = users.get(userPosition);
			int differenceMonth = differenceMonth(user.getLastConnection(), LocalDate.now());
			if (differenceMonth > 0) {
				addMoneyUser(user.getAccount().getNumberAccount(),
						differenceMonth * (user.getAccount().getMoney() * INTERST));
				return differenceMonth * (user.getAccount().getMoney() * INTERST);
			}
		}
		return 0;
	}

	/**
	 * Calcula la diferencia en meses entre dos fechas
	 * 
	 * @param date1 primera fecha
	 * @param date2 segunda fecha
	 * @return diferencia en meses como entero
	 */
	private int differenceMonth(LocalDate date1, LocalDate date2) {
		if (date2.getYear() == date1.getYear()) {
			return Math.abs(date2.getMonthValue() - date1.getMonthValue());
		} else if (date2.getYear() != date1.getYear() && date2.getMonthValue() < date1.getMonthValue()) {
			return Math
					.abs((12 * (date2.getYear() - date1.getYear())) - (date1.getMonthValue() - date2.getMonthValue()));
		} else if (date2.getYear() != date1.getYear() && date2.getMonthValue() > date1.getMonthValue()) {
			return Math
					.abs((12 * (date2.getYear() - date1.getYear())) + (date2.getMonthValue() - date1.getMonthValue()));
		} else {
			return Math.abs((12 * (date2.getYear() - date1.getYear())));
		}
	}

	/**
	 * Añade dinero a la cuenta bancaria de un usuario
	 * 
	 * @param numberAccount numero de la cuenta bancaria
	 * @param money         dinero a añadir
	 * @return true si se añadio con exito o false si no
	 */
	public boolean addMoneyUser(int numberAccount, double money) {
		int userPosition = users.search(numberAccount);
		if (userPosition != -1) {
			users.get(userPosition).getAccount().addMoney(money);
			return true;
		}
		return false;
	}

	/**
	 * Retira dinero de la cuenta bancaria de un usuario
	 * 
	 * @param numberAccount numero de cuenta
	 * @param money         dinero a retirar
	 * @return true si se retiro con exito o false si no
	 */
	public boolean removeMoneyUser(int numberAccount, double money) {
		int userPosition = users.search(numberAccount);
		if (userPosition != -1) {
			return users.get(userPosition).getAccount().removeMoney(money);
		}
		return false;
	}

	/**
	 * Valida que los datos de un usuario se han los correctos
	 * 
	 * @param userName nombre de usuario
	 * @param password contraseña del usuario
	 * @return true si los datos son correctos o false si no
	 */
	public boolean validateDataUser(String userName, String password) {
		int positionUser = users.search(userName, 0, users.size());
		if (positionUser != -1) {
			User user = users.get(positionUser);
			if (user.getPassword().equals(password) && user.getState() == State.ACTIVE) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the users
	 */
	public GroupUser getUsers() {
		return users;
	}

	/**
	 * @return the bankingTransactions
	 */
	public GroupBankingTransactionUser getBankingTransactions() {
		return bankingTransactions;
	}

}
