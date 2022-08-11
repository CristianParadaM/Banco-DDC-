/**
 * 
 */
package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Account;
import model.EnumRecoveryQuestion;
import model.EnumTypeAccount;
import model.State;
import model.User;
import model.text.MyString;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 2/05/2021
 */
public class UserListPersistence {
	public static final String PATH = "src/res/files/userList.xyz";
	private File userList;
	private RandomAccessFile accessFile;
	
	/*
	 * 4 byte : int = id
	 * 134 byte : String = userName
	 * 179 byte: String = name
	 * 179 byte: String = lastName
	 * 1 byte: byte: recoveryQuestion
	 * 179 byte: String = answer
	 * 4 byte: int = numberAccount
	 * 1 byte: int = typeAcount
	 * 89 byte: String = passwordAcount
	 * 8 byte: double = money
	 * 89 byte: String = passwordUser
	 * 1 byte: int = state
	 * 89 byte: String = dateOfBirth
	 * 89 byte: String = lastConnection
	 */
	
	public static final int RECORD_SIZE = 1062;
	public static final int USERNAME_BYTE = 15;
	public static final int NAME_BYTE = 20;
	public static final int LASTNAME_BYTE = 20;
	public static final int PASSWORD_BYTE = 10;
	public static final int ANSWER_BYTE = 20;
	public static final int DATE_BYTE = 10;
	
	/**
	 * Constructor de UserListPersistence
	 */
	public UserListPersistence() {
		super();
		this.userList = new File(PATH);
		try {
			this.accessFile = new RandomAccessFile(userList, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Añade un usuario a la lista de persistencia
	 * @param user usuario a añadir
	 */
	public void add(User user){
		try {
			accessFile.seek(size()*RECORD_SIZE);
			accessFile.writeInt(user.getId());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getUserName(), USERNAME_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getName(), NAME_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getLastName(), LASTNAME_BYTE)));
			accessFile.writeByte(user.getRecoveryQuestion().ordinal());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getAnswer(), ANSWER_BYTE)));
			accessFile.writeInt(user.getAccount().getNumberAccount());
			accessFile.writeByte(user.getAccount().getTypeAccount().ordinal());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getAccount().getPasswordAcount(), PASSWORD_BYTE)));
			accessFile.writeDouble(user.getAccount().getMoney());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getPassword(), PASSWORD_BYTE)));
			accessFile.writeByte(user.getState().ordinal());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(""+user.getDateOfBirth(), DATE_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(""+user.getLastConnection(), DATE_BYTE)));
			sort();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * retorna una lista con todos los usuarios del archivo de persistencia
	 * @return lista de usuarios
	 */
	public ArrayList<User> getUsers(){
		ArrayList<User> arrayList = new ArrayList<>();
		for (int i = 0; i < size(); i++) {
			arrayList.add(getUser(i));
		}
		return arrayList;
	}
	
	/**
	 * Realiza una busqueda binaria con el nombre de un usuario
	 * @param userName nombre del usuario
	 * @param start inicio de la busqued binaria
	 * @param end fin de la busqueda binaria
	 * @return usuario con el nombre pasado por parametro si existe
	 */
	public int search(String userName, int start, int end) {
		if (size() == 0) {
			return -1;
		}else if (getUser(((end-start)/2)+start).getUserName().equals(userName)) {
			return ((end-start)/2)+start;
		}else if (start+1 == end) {
			return -1;
		}else if(getUser(((end-start)/2)+start).getUserName().compareTo(userName) > 0) {
			return search(userName, start, ((end-start)/2)+start);
		}else {
			return search(userName, ((end-start)/2)+start, end);
		}
	}
	
	/**
	 * Retorna el usuario de la posicion index
	 * @param index posicion
	 * @return usuario en la posicion
	 * @throws IOException 
	 */
	public User getUser(int index){
		User user = null;
		try {
			if (index < size()) {	
				accessFile.seek(index*RECORD_SIZE);
				user = new User(accessFile.readInt(), MyString.instanceOf().unCrypt(accessFile.readUTF()).trim(), MyString.instanceOf().unCrypt(accessFile.readUTF()).trim(), MyString.instanceOf().unCrypt(accessFile.readUTF()).trim(), EnumRecoveryQuestion.values()[accessFile.readByte()], MyString.instanceOf().unCrypt(accessFile.readUTF()).trim(),  new Account(accessFile.readInt(), EnumTypeAccount.values()[accessFile.readByte()], MyString.instanceOf().unCrypt(accessFile.readUTF()).trim(), accessFile.readDouble()), MyString.instanceOf().unCrypt(accessFile.readUTF()).trim(), State.values()[accessFile.readByte()], LocalDate.parse(MyString.instanceOf().unCrypt(accessFile.readUTF()).trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				user.setLastConnection(LocalDate.parse(MyString.instanceOf().unCrypt(accessFile.readUTF()).trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * Metodo que retorna la cantidad de usuarios en el archivo userList
	 * @return cantidad de usuarios
	 */
	public int size() {
		return (int) (userList.length()/RECORD_SIZE);
	}
	
	/**
	 * Remplaza el usuario de la posicion index por el usuario pasado por parametro
	 * @param user usuario que quiere colocar en la posicion index
	 * @param index posicion el la cual va a estar el usuario
	 */
	public void replaceUser(User user, int index) {
		try {
			accessFile.seek(index*RECORD_SIZE);
			accessFile.writeInt(user.getId());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getUserName(), USERNAME_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getName(), NAME_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getLastName(), LASTNAME_BYTE)));
			accessFile.writeByte(user.getRecoveryQuestion().ordinal());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getAnswer(), ANSWER_BYTE)));
			accessFile.writeInt(user.getAccount().getNumberAccount());
			accessFile.writeByte(user.getAccount().getTypeAccount().ordinal());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getAccount().getPasswordAcount(), PASSWORD_BYTE)));
			accessFile.writeDouble(user.getAccount().getMoney());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getPassword(), PASSWORD_BYTE)));
			accessFile.writeByte(user.getState().ordinal());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(""+user.getDateOfBirth(), DATE_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(""+user.getLastConnection(), DATE_BYTE)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Remplaza el usuario de la posicion index por el usuario pasado por parametro
	 * @param user usuario que quiere colocar en la posicion index
	 * @param index posicion el la cual va a estar el usuario
	 */
	public void replaceUser(User user) {
		try {
			accessFile.seek(search(user.getUserName(), 0, size())*RECORD_SIZE);
			accessFile.writeInt(user.getId());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getUserName(), USERNAME_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getName(), NAME_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getLastName(), LASTNAME_BYTE)));
			accessFile.writeByte(user.getRecoveryQuestion().ordinal());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getAnswer(), ANSWER_BYTE)));
			accessFile.writeInt(user.getAccount().getNumberAccount());
			accessFile.writeByte(user.getAccount().getTypeAccount().ordinal());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getAccount().getPasswordAcount(), PASSWORD_BYTE)));
			accessFile.writeDouble(user.getAccount().getMoney());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(user.getPassword(), PASSWORD_BYTE)));
			accessFile.writeByte(user.getState().ordinal());
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(""+user.getDateOfBirth(), DATE_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(""+user.getLastConnection(), DATE_BYTE)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo de ordenamiento alfabeticamente
	 * @throws IOException 
	 */
	public void sort() throws IOException {
		boolean order = false;
		int count = 0;
		while (!order) {
			count = 0;
			User firstUser = getUser(0);
			for (int i = 0; i < size()-1; i++) {
				User secondUser = getUser(i+1);
				if (firstUser.getUserName().compareTo(secondUser.getUserName()) > 0) {
					replaceUser(secondUser, i);
					replaceUser(firstUser, (i+1));
					count++;
				}
				firstUser = secondUser;
			}
			order = count==0;
		}
	}
}
