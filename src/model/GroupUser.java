/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 6/05/2021
 */
public class GroupUser extends ArrayList<User>{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de GroupUser
	 */
	public GroupUser(ArrayList<User> users) {
		super(users);
	}
	
	/**
	 * Cambia el estado de un usuario a inactivo
	 * @param userName nombre de usuario
	 */
	public boolean deleteUser(String userName) {
		int position = search(userName, 0, this.size());
		if (position != -1 && this.get(position).getAccount().getMoney()==0) {
			this.get(position).setState(State.INACTIVE);
			return true;
		}
		return false;
	}
	
	/**
	 * Añade un usuario a users
	 * @param user usuario a añadir
	 */
	public void addUser(User user) {
		this.add(user);
		this.sort(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return o1.getUserName().compareTo(o2.getUserName());
			}	
		});
	}
	
	/**
	 * Realiza una busqueda binaria con el nombre de un usuario
	 * @param userName nombre del usuario
	 * @param start inicio de la busqued binaria
	 * @param end fin de la busqueda binaria
	 * @return posicion en la que se encuentra el ususario o -1 si no esta
	 */
	public int search(String userName, int start, int end) {
		if (this.size() == 0) {
			return -1;
		}else if (this.get(((end-start)/2)+start).getUserName().equals(userName)) {
			return ((end-start)/2)+start;
		}else if (start+1 == end) {
			return -1;
		}else if(this.get(((end-start)/2)+start).getUserName().compareTo(userName) > 0) {
			return search(userName, start, ((end-start)/2)+start);
		}else {
			return search(userName, ((end-start)/2)+start, end);
		}
	}
	
	/**
	 * Realiza una busqueda de usuario por su numero de cuenta
	 * @param numberAccount numero de cuenta del usuario a buscar
	 * @return posicion del usuario si es que existe
	 */
	public int search(int numberAccount) {
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).getAccount().getNumberAccount() == numberAccount) {
				return i;
			}
		}
		return -1;
	}
	
}
