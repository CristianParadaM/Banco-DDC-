/**
 * 
 */
package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.BankingTransaction;
import model.EnumTypeTransaction;
import model.text.MyString;


/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 6/05/2021
 */
public class ListBankingTransactionPersistence {
	public static final String PATH_NAME = "src/res/files/listBankingTransaction.xyz";
	private File bankingTransactionjList;
	private RandomAccessFile accessFile;
	
	/**
	 * 134 byte : String = userName
	 * 260 byte: String = date
	 * 4 byte: int = EnumTypeTransaction
	 * 8 byte: double = money
	 */
	
	public static final int RECORD_SIZE = 320;
	public static final int USERNAME_BYTE = 15;
	public static final int DATE_BYTE = 19;
	
	/**
	 * Constructor de ListBankingTransactionPersistence
	 */
	public ListBankingTransactionPersistence() {
		this.bankingTransactionjList = new File(PATH_NAME);
		try {
			this.accessFile = new RandomAccessFile(bankingTransactionjList, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Añade un movimiento bancario al archivo de persistencia
	 * @param bankingTransaction movimiento bancario a añadir
	 */
	public void add(BankingTransaction bankingTransaction) {
		int size = (int) (bankingTransactionjList.length()/RECORD_SIZE);
		try {
			accessFile.seek(size*RECORD_SIZE);
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(bankingTransaction.getUserName(), USERNAME_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(""+bankingTransaction.getDate().withNano(0), DATE_BYTE)));
			accessFile.writeInt(bankingTransaction.getType().ordinal());
			accessFile.writeDouble(bankingTransaction.getMoneyAmount());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Retorna la lista de movimientos bancarios del archivo de persistencia
	 * @return arrayList con la lista
	 */
	public ArrayList<BankingTransaction> getGroupBankingTransaction() {
		ArrayList<BankingTransaction> arrayList = new ArrayList<>();
		for (int i = 0; i < size(); i++) {
			arrayList.add(getBankingTransaction(i));
		}
		return arrayList;
	}
	
	/**
	 * Retorna el movimiento bancario de la posicion index
	 * @param index posicion
	 * @return movimiento bancario en la posicion
	 */
	public BankingTransaction getBankingTransaction(int index){
		BankingTransaction bankingTransaction = null;
		try {
			if (index < size()) {
				accessFile.seek(index*RECORD_SIZE);
				bankingTransaction = new BankingTransaction(MyString.instanceOf().unCrypt(accessFile.readUTF()).trim(), LocalDateTime.parse(MyString.instanceOf().unCrypt(accessFile.readUTF()).trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), EnumTypeTransaction.values()[accessFile.readInt()], accessFile.readDouble());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bankingTransaction;
	}
	
	/**
	 * Metodo que retorna la cantidad de movimientos bancarios en el archivo bankingTransactionjList
	 * @return cantidad de usuarios
	 */
	public int size() {
		return (int) (bankingTransactionjList.length()/RECORD_SIZE);
	}
	
}
