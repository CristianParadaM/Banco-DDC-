/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 2/05/2021
 */
public class GroupBankingTransactionUser extends ArrayList<BankingTransaction>{
	private static final long serialVersionUID = 1L;
	private Comparator<BankingTransaction> comparator; 
	/**
	 * Constructor de GroupBankingTransactionUser
	 * @param userName
	 */
	public GroupBankingTransactionUser(ArrayList<BankingTransaction> arrayList) {
		super(arrayList);
		comparator = new Comparator<BankingTransaction>() {

			@Override
			public int compare(BankingTransaction o1, BankingTransaction o2) {
				return o1.getUserName().compareTo(o2.getUserName());
			}
		};
		this.sort(comparator);
	}
	
	/**
	 * añade un usuario a la lista
	 */
	public boolean addBankingTransaction(BankingTransaction bankingTransaction) {
		if (this.add(bankingTransaction)) {
			this.sort(comparator);
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna los movimientos bancarios pertenecientes al nombre de usuario pasado por parametro ordenados por fecha
	 * @param userName nombre de usuario
	 * @return lista con los movimientos bancarios
	 */
	public ArrayList<BankingTransaction> getBankingTransactionUser(String userName){
		ArrayList<BankingTransaction> list = new ArrayList<>();
		boolean aux = false;
		for (int i = 0; i < this.size(); i++) {
			aux = this.get(i).getUserName().equals(userName)?true:false;
			if (this.get(i).getUserName().equals(userName)) {
				list.add(this.get(i));
			}else if (list.size() > 0 && aux == false) {
				break;
			}
		}
		list.sort(new Comparator<BankingTransaction>() {
			@Override
			public int compare(BankingTransaction o1, BankingTransaction o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
		});
		return list;
	}
}
