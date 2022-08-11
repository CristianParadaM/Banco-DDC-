package model.text;

import java.util.ArrayList;
import java.util.Random;

/**
 * Libreria de manejo de cadenas de caracteres
 * 
 * @author Cristian David Parada Martinez
 * @Date 17/02/2021
 *
 */
public class MyString {
	
	private static MyString myString= null;
	
	public static MyString instanceOf() {
		if (myString == null) {
			myString = new MyString();
		}
		return myString;
	}
	
	private MyString() {
		
	}
	
	public static final String PASSWORD_CRYPT = "fsafafs";
	
	/**
	 * Metodo que genera una cadena de caracteres de una longitud con un caracter
	 * dado
	 * 
	 * @param length    longitud de la cadena
	 * @param character caracter que conforma la cadena
	 * @return cadena de la longitud dada y el caracter dado
	 */
	public String generateSequence(int length, char character) {
		String result = "";
		for (int i = 0; i < length; i++) {
			result += character;
		}
		return result;
	}

	/**
	 * Metodo que centra un texto en un ancho determinado
	 * 
	 * @param length  ancho donde se centra
	 * @param message mensaje a centrar
	 * @return el mensaje centrado en la cadena de la longitud
	 */
	public String center(int length, String message) {
		message = (message.length() > length) ? message.substring(0, length - 2) : message;
		return generateSequence((length - message.length()) / 2, ' ') + message
				+ generateSequence(length - ((length - message.length()) / 2 + message.length()), ' ');
	}

	/**
	 * Metodo que justifica un texto dado una longitud
	 * 
	 * @param length  longitud
	 * @param message texto a justificar
	 * @return arrayList con las lineas de texto justificado
	 */
	public ArrayList<String> wordGrap(int length, String message) {
		ArrayList<String> arrayList = new ArrayList<>();
		if (message.length() < length) {
			message = message.trim();
			arrayList.add(message + generateSequence(length - message.length(), ' '));
		} else {
			String aux = cutWord(message.substring(0, length));
			arrayList.add(justify(length, aux.trim()));
			arrayList.addAll(wordGrap(length, message.substring(aux.length(), message.length())));
		}
		return arrayList;
	}

	/**
	 * Metodo que corta una frase
	 * 
	 * @param message mensaje
	 * @return mensaje cortado
	 */
	private String cutWord(String message) {
		for (int i = message.length() - 1; i >= 0; i--) {
			if (message.charAt(i) == ' ') {
				message = message.substring(0, i);
				break;
			}
		}
		return message;
	}

	/**
	 * 
	 * Metodo que justifica una sola linea dado una longitud
	 * 
	 * @param length  longitud
	 * @param message mensaje a justificar
	 * @return mensaje justificado
	 */
	public String justify(int length, String message) {
		message = message.replaceAll("\\s{1,}", " ");
		if (!message.contains(" ")) {
			return message + generateSequence(length - message.length(), ' ');
		}	
		while (message.length() < length) {
			for (int i = 0; i < message.length(); i++) {
				if (message.length() < length) {
					if (message.charAt(i) == ' ') {
						message = message.substring(0, i) + " " + message.substring(i, message.length());
						i++;
					}
				} else
					break;
			}
		}
		return message;
	}
	
	/**
	 * Metodo que redimensiona un mensaje a un determinado tamaño agregandole espacios al final
	 * @param message
	 * @param length
	 * @return
	 */
	public String resizeMessage(String message, int length) {
		int count =  length - message.length();
		for (int i = 0; i < count; i++) {
			message+=" ";
		}
		return message;
	}
		/**
		 * Encripta un mensaje
		 * @param message mensaje a encriptar
		 * @return mensaje encriptado
		 */
		public String crypt(String message) {
			String aux = "";
			int count = 0;
			for (int i = 0; i < message.length(); i++) {
				aux += Integer.toBinaryString(message.charAt(i)+PASSWORD_CRYPT.charAt(count++))+" ";
				count = count == PASSWORD_CRYPT.length()?0:count;
			}
			aux = aux.trim();
			String result = "";
			for (int i = 0; i < aux.length()-1; i+=2) {
				result += aux.charAt(i+1);
				result += aux.charAt(i);
			}
			return aux.length()%2==0?result:result+aux.charAt(aux.length()-1);
		}
		
		/**
		 * Desencripta un mensaje
		 * @param message mensaje a desencriptar
		 * @return mensaje desencriptado
		 */
		public String unCrypt(String message) {
			String aux = "";
			for (int i = 0; i < message.length()-1; i+=2) {
				aux += message.charAt(i+1);
				aux += message.charAt(i);
			}
			aux = message.length()%2==0?aux:aux+message.charAt(message.length()-1);
			String[] binario = aux.split(" ");
			String result = "";
			int count = 0;
			for (int i = 0; i < binario.length; i++) {
				result += (char)(Integer.parseInt(binario[i],2)-PASSWORD_CRYPT.charAt(count++));
				count = count == PASSWORD_CRYPT.length()?0:count;
			}
			return result;
		}
		
		/*
		 * Metodo que genera una palabra aleatoria
		 */
		public String generateRandomWord(int size) {
			String word="";
			Random random = new Random();
			for (int i = 0; i < size; i++) {
				word+=(char)(random.ints(65, 90).findFirst().getAsInt());
			}
			return word;
		}

}
