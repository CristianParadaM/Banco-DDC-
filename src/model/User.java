/**
 * 
 */
package model;

import java.time.LocalDate;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 2/05/2021
 */
public class User {
	private int id;
	private String userName;
	private String name;
	private String lastName;
	private EnumRecoveryQuestion recoveryQuestion;
	private String answer;
	private Account account;
	private String password;
	private State state;
	private LocalDate dateOfBirth;
	private LocalDate lastConnection;
	
	public User(int id, String userName, String name, String lastName, EnumRecoveryQuestion recoveryQuestion, String answer, Account account, String password, State state, LocalDate dateOfBirth) {
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.recoveryQuestion = recoveryQuestion;
		this.answer = answer;
		this.account = account;
		this.password = password;
		this.state = state;
		this.dateOfBirth = dateOfBirth;
		this.lastConnection = LocalDate.now();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @return the recoveryQuestion
	 */
	public EnumRecoveryQuestion getRecoveryQuestion() {
		return recoveryQuestion;
	}
	
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	
	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
	
	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * @return the lastConnection
	 */
	public LocalDate getLastConnection() {
		return lastConnection;
	}
	/**
	 * @param lastConnection the lastConnection to set
	 */
	public void setLastConnection(LocalDate lastConnection) {
		this.lastConnection = lastConnection;
	}
	
	
}
