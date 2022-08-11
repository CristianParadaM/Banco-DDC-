package test;

import java.time.LocalDate;

import model.Account;
import model.EnumRecoveryQuestion;
import model.EnumTypeAccount;
import model.State;
import model.User;
import persistence.UserListPersistence;

/**
 * Clase que maneja el objeto TestUsers.java
 *
 * @author Cristian David Parada Martinez
 * @date 8/05/2021
 *
 */
public class TestUsers {
	public static void main(String[] args) {
		UserListPersistence listPersistence = new UserListPersistence();
		
		listPersistence.add(new User(1234, "crisUser", "Cristian David", "Parada Martinez", EnumRecoveryQuestion.FAVORITE_TEAM,
				"Colombia", new Account(1234, EnumTypeAccount.SAVINGS_ACCOUNT, "passAcc", 10000), "crisPass",
				State.ACTIVE, LocalDate.of(2001, 9, 21)));
		listPersistence.add(new User(12223, "diegoUser", "Diego Fernando", "Alba Novoa", EnumRecoveryQuestion.NAME_FAVORITE_TEACHER,
				"Carlos", new Account(1223, EnumTypeAccount.SAVINGS_ACCOUNT, "passAcc", 10000), "diegoPass",
				State.ACTIVE, LocalDate.of(2001, 9, 21)));
		listPersistence.add(new User(433321, "daniUser", "Daniel Felipe", "Suarez Bohorquez", EnumRecoveryQuestion.MODEL_CAR,
				"Lamborguini", new Account(433321, EnumTypeAccount.SAVINGS_ACCOUNT, "passAcc", 10000), "daniPass",
				State.ACTIVE, LocalDate.of(2001, 9, 21)));
		
	}
}
