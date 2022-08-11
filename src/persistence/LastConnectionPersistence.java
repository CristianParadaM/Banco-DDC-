package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import model.text.MyString;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 11/05/2021
 */
public class LastConnectionPersistence {
	public static final String PATH = "src/res/files/lastConnection.xyz";
	private File lastConenection;
	private RandomAccessFile accessFile;
	
	public static final int USERNAME_BYTE = 15;
	public static final int PASSWORD_BYTE = 10;
	public static final String DEFAULT_STRING = "";
	public static final String DEFAULT_LENGUAJE = "ES";
	public static final int DEFAULT_THEME = 1;
	
	/**
	 * Constructor de LastConnectionPersistence
	 */
	public LastConnectionPersistence() {
		super();
		this.lastConenection = new File(PATH);
		try {
			this.accessFile = new RandomAccessFile(lastConenection, "rw");
			if (lastConenection.length() == 0) {
				registerDefaultData();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retorna el ultimo numero de cuenta registrado
	 * @return long
	 */
	public int getNumberAccount() {
		int numberAccount = 0;
		try {
			accessFile.seek(247);
			numberAccount = accessFile.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numberAccount;
	}
	
	/**
	 * Modifica el ultimo numero de cuenta registrado
	 */
	public void setNumberAccount(int numberAccount) {
		try {
			accessFile.seek(247);
			accessFile.writeInt(numberAccount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Registra los datos de ultima coneccion del archivo de persistencia
	 * @param userName nombre de usuario
	 * @param password contraseña del usuario
	 * @param lenguaje idioma
	 * @param theme tema
	 */
	public void registerData(String userName, String password, String lenguaje, byte theme) {
		try {
			accessFile.seek(0);
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(userName, USERNAME_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(password, PASSWORD_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(lenguaje));
			accessFile.writeByte(theme);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Registra los datos default para cualquier usuario
	 */
	public void registerDefaultData() {
		try {
			accessFile.seek(0);
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(DEFAULT_STRING, USERNAME_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(MyString.instanceOf().resizeMessage(DEFAULT_STRING, PASSWORD_BYTE)));
			accessFile.writeUTF(MyString.instanceOf().crypt(DEFAULT_LENGUAJE));
			accessFile.writeByte(DEFAULT_THEME);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Obtiene el nombre de usuario del archivo de ultima coneccion
	 * @return nombre de usuario si exite o un string vacio si no
	 */
	public String getUserName() {
		String userName = "";
		try {
			accessFile.seek(0);
			userName = MyString.instanceOf().unCrypt(accessFile.readUTF()).trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userName;
	}
	
	/**
	 * Obtiene la contreseña del usuario del archivo de ultima coneccion
	 * @return contraseña del usuario si exite o un string vacio si no
	 */
	public String getPassword() {
		String password = "";
		try {
			accessFile.seek(136);
			password = MyString.instanceOf().unCrypt(accessFile.readUTF()).trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return password;
	}
	
	/**
	 * Obtiene el idioma de la ultima coneccion
	 * @return idioma de la ultima coneccion
	 */
	public String getLenguaje() {
		String lenguaje = "";
		try {
			accessFile.seek(227);
			lenguaje = MyString.instanceOf().unCrypt(accessFile.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lenguaje;
	}
	
	/**
	 * Obtiene el tema de la ultima coneccion
	 * @return tema de la ultima coneccion
	 */
	public byte getTheme() {
		byte theme = 0;
		try {
			accessFile.seek(246);
			theme = accessFile.readByte();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return theme;
	}
	
	/**
	 * Cambia el tema guardado en el archivo de persistencia por el pasado por parametro
	 * @param theme nuevo tema
	 */
	public void setTheme(Byte theme) {
		try {
			accessFile.seek(246);
			accessFile.writeByte(theme);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Cambia el idioma guardado en el archivo de persistencia por el pasado por parametro
	 * @param lenguaje nuevo idioma
	 */
	public void setLenguaje(String lenguaje) {
		try {
			accessFile.seek(227);
			accessFile.writeUTF(MyString.instanceOf().crypt(lenguaje));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
