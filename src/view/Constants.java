package view;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase que maneja el objeto Constants.java
 *
 * @author Cristian David Parada Martinez
 * @date 2/05/2021
 *
 */
public class Constants extends Properties {

	private static final long serialVersionUID = 1L;
	private static Constants constants = null;
	public static String LANGUAJE_ACTUAL = "ES";
	public static final String INTEREST = "INTEREST";
	
	public static final int MAX_LENGTH_NAMES = 20;
	public static final int MAX_LENGTH_USERNAME = 15;
	public static final int MAX_LENGTH_NUMBER_DOCUMENT = 20;
	public static final int MAX_LENGTH_MONEY = 15;
	public static final int MAX_LENGTH_PASSWORD = 10;
	public static final int MAX_LENGTH_PASSWORD_ACCOUNT = 6;

	public static final String TITLE_JLABEL_WINDOW = "TITLE_JLABEL_WINDOW";
	public static final String TITLE_APPNAME = "TITLE_APPNAME";
	public static final String VERSION_APP = "Version 1.0 ";
	public static final String CURRENT_ACCOUNT = "CURRENT_ACCOUNT";
	public static final String SAVINGS_ACCOUNT = "SAVINGS_ACCOUNT";
	public static final String MESSAGE_CANT_FIND_USER = "MESSAGE_CANT_FIND_USER";
	public static final String CONGRATULATIONS = "CONGRATULATIONS";
	public static final String MESSAGE_YOUR_PASSWORD_IS = "MESSAGE_YOUR_PASSWORD_IS";
	public static final String CREDITS = "CREDITS";

	// COMMANDSCyFPaletteApp
	public static final String COMMAND_CROSS_EXIT = "COMMAND_CROSS_EXIT";
	public static final String COMMAND_HELP = "COMMAND_HELP";
	public static final String COMMAND_BUTTON_CONFIG_JDIALOG = "COMMAND_BUTTON_CONFIG_JDIALOG";
	public static final String COMMAND_COMBOBOX_THEME = "COMMAND_COMBOBOX_THEME";
	public static final String COMMAND_JBUTTON_LOGIN = "COMMAND_JBUTTON_LOGIN";
	public static final String COMMAND_JBUTTON_WITHDRAWALS = "COMMAND_JBUTTON_WITHDRAWALS";
	public static final String COMMAND_JBUTTON_REGISTER = "COMMAND_JBUTTON_REGISTER";
	public static final String COMMAND_JBUTTON_FORGOTPASS = "COMMAND_JBUTTON_FORGOTPASS";
	public static final String COMMAND_JBUTTON_SEND_CREATE_ACCOUNT = "COMMAND_JBUTTON_SEND_CREATE_ACCOUNT";
	public static final String COMMAND_COMBOBOX_LANGUAJE = "COMMAND_COMBOBOX_LANGUAJE";
	public static final String COMMAND_JBUTTON_ABOUT_US_JFRAME = "COMMAND_JBUTTON_ABOUT_US_JFRAME";
	public static final String COMMAND_JBUTTON_ARROW_BACK_REGISTER = "COMMAND_JBUTTON_ARROW_BACK_REGISTER";
	public static final String COMMAND_JBUTTON_MY_MOVEMENTS = "COMMAND_JBUTTON_MY_MOVEMENTS";
	public static final String COMMAND_BUTTON_CONFIG_JFRAME = "COMMAND_BUTTON_CONFIG_JFRAME";
	public static final String COMMAND_JBUTTON_ARROW_BACK_QUESTIONS = "COMMAND_JBUTTON_ARROW_BACK_QUESTIONS";
	public static final String COMMAND_JBUTTON_ARROW_BACK_FORGOTP = "COMMAND_JBUTTON_ARROW_BACK_FORGOTP";
	public static final String COMMAND_JBUTTON_VERIFY_FOGOTP = "COMMAND_JBUTTON_VERIFY_FOGOTP";
	public static final String COMMAND_JBUTTON_QUESTION_FP = "COMMAND_JBUTTON_QUESTION_FP";
	public static final String COMMAND_JBUTTON_ARROW_BACK_CREDITS = "COMMAND_JBUTTON_ARROW_BACK_CREDITS";
	public static final String COMMAND_JBUTTON_DEPOSIT = "COMMAND_JBUTTON_DEPOSIT";
	public static final String COMMAND_JBUTTON_TRANSFERM = "COMMAND_JBUTTON_TRANSFERM";
	public static final String COMMAND_JBUTTON_NEXT_REGISTER = "COMMAND_JBUTTON_NEXT_REGISTER";
	public static final String COMMAND_JBUTTON_LOG_OUT = "COMMAND_JBUTTON_LOG_OUT";
	public static final String COMMAND_CONFIG_CORNER_JFRAME = "COMMAND_CONFIG_CORNER_JFRAME";
	public static final String COMMAND_JBUTTON_ARROW_BACK_BANKING_TRANSACTION = "COMMAND_JBUTTON_ARROW_BACK_BANKING_TRANSACTION";
	public static final String COMMAND_JBUTTON_PRINT = "COMMAND_JBUTTON_PRINT";
	public static final String COMMAND_REMOVE = "REMOVE_COMMAND";
	public static final String COMMAND_TRANSFER = "TRANSFER_COMMAND";
	public static final String COMMAND_DEPOSIT = "DEPOSIT_COMMAND";
	public static final String COMMAND_JBUTTON_SETTING = "COMMAND_JBUTTON_SETTING";
	public static final String COMMAND_ACCEPT_DEPOSIT = "COMMAND_ACCEPT_DEPOSIT";
	public static final String COMMAND_ACCEPT_WITHDRAWALS = "COMMAND_ACCEPT_WITHDRAWALS";
	public static final String COMMAND_JBUTTON_ARROW_BACK_WITHDRAWALS = "COMMAND_JBUTTON_ARROW_BACK_WITHDRAWALS";

	// PATHS
	public static final String PATH_DEPOSIT_MONEY_IMG = "src/res/money.png";
	public static final String PATH_WITHDRAWALS_IMG = "src/res/retirar.png";
	public static final String PATH_TRANSFER_IMG = "src/res/transferir.png";
	public static final String PATH_LOGOUT_IMG = "src/res/CerrarSesion.png";
	public static final String PATH_DEPOSIT_MONEY_GIF = "src/res/depositMoney.gif";
	public static final String PATH_WITHDRAWALS_GIF = "src/res/withdrawals.gif";
	public static final String PATH_TRANSFER_GIF = "src/res/transfer2.gif";
	public static final String PATH_LOGOUT_GIF = "src/res/logOut1.gif";
	public static final String PATH_PROPERTIES_EN = "src/res/properties/languajes/labels_en.properties";
	public static final String PATH_PROPERTIES_ES = "src/res/properties/languajes/labels_es.properties";
	public static final String PATH_IMAGE_ICONAPP = "src/res/iconApp.png";
	public static final String PATH_IMAGE_LOGO = "src/res/logo.png";
	public static final String PATH_CONFIG_ICON = "src/res/config.jpg";
	public static final String PATH_JBUTTON_LOGIN = "src/res/flecha.png";
	public static final String PATH_IMAGE_PHOTO_DEFAULT = "src/res/photoDefault.png";

	// JBUTTONS
	public static final String MESSAGE_JBUTTON_DEPOSIT = "MESSAGE_JBUTTON_DEPOSIT";
	public static final String MESSAGE_JBUTTON_ARROW_BACK = "\u25C4";
	public static final String MESSAGE_JBUTTON_REGISTER = "MESSAGE_JBUTTON_REGISTER";
	public static final String MESSAGE_JBUTTON_FORGOTPASS = "MESSAGE_JBUTTON_FORGOTPASS";
	public static final String MESSAGE_JBUTTON_CROSS_EXIT = "CROSS_EXIT";
	public static final String MESSAGE_JBUTTON_HELP = "MESSAGE_JBUTTON_HELP";
	public static final String MESSAGE_JBUTTON_MY_MOVEMENTS = "MESSAGE_JBUTTON_MY_MOVEMENTS";
	public static final String MESSAGE_JBUTTON_VERIFY_FP = "MESSAGE_JBUTTON_VERIFY_FP";
	public static final String MESSAGE_JBUTTON_QUESTION_FP = "MESSAGE_JBUTTON_QUESTION_FP";
	public static final String MESSAGE_JBUTTON_ANSWER_FP = "MESSAGE_JBUTTON_ANSWER_FP";
	public static final String MESSAGE_JBUTTON_WITHDRAWALS = "MESSAGE_JBUTTON_WITHDRAWALS";
	public static final String MESSAGE_JBUTTON_TRANSFERM = "MESSAGE_JBUTTON_TRANSFERM";
	public static final String MESSAGE_JBUTTON_NEXT_REGISTER = "MESSAGE_JBUTTON_NEXT_REGISTER";
	public static final String MESSAGE_JBUTTON_SEND_CREATE_ACCOUNT = "MESSAGE_JBUTTON_SEND_CREATE_ACCOUNT";
	public static final String COMMAND_JBUTTON_ARROW_BACK_CREDITS_JFRAME = "COMMAND_JBUTTON_ARROW_BACK_CREDITS_JFRAME";
	public static final String MESSAGE_JBUTTON_PRINT = "MESSAGE_JBUTTON_PRINT";
	public static final String MESSAGE_JBUTTON_ACCEPT = "MESSAGE_ACCEPT";

	// CHECKBOX
	public static final String MESSAGE_JCHECKBOX_LOGIN = "MESSAGE_JCHECKBOX_LOGIN";

	// COMBOBOX
	public static final String MESSAGE_JCOMBOBOX_ESPANISH = "ESPANISH_COMBOBOX";
	public static final String MESSAGE_JCOMBOBOX_ENGLISH = "ENGLISH_COMBOBOX";
	public static final String MESSAGE_JCOMBOBOX_CHANGE_THEME = "CHANGE_THEME_COMBOBOX";
	public static final String MESSAGE_JCOMBOBOX_THEME_DARK = "THEME_DARK_COMBOBOX";
	public static final String MESSAGE_JCOMBOBOX_THEME_LIGHT = "THEME_LIGHT_COMBOBOX";
	public static final String MESSAGE_JCOMBOBOX_SELECT = "MESSAGE_JCOMBOBOX_SELECT";
	public static final String MESSAGE_JCOMBOBOX_DATE = "MESSAGE_JCOMBOBOX_DATE";
	public static final String MESSAGE_JCOMBOBOX_TYPE = "MESSAGE_JCOMBOBOX_TYPE";

	// PLACEHOLDER
	public static final String MESSAGE_PLACEHOLDER_USER = "MESSAGE_PLACEHOLDER_USER";
	public static final String MESSAGE_PLACEHOLDER_PASS = "MESSAGE_PLACEHOLDER_PASS";
	public static final String MESSAGE_PLACEHOLDER_NAMES_REGISTER = "MESSAGE_PLACEHOLDER_NAMES_REGISTER";
	public static final String MESSAGE_PLACEHOLDER_LASTNAMES_REGISTER = "MESSAGE_PLACEHOLDER_LASTNAMES_REGISTER";
	public static final String MESSAGE_PLACEHOLDER_ID_REGISTER = "MESSAGE_PLACEHOLDER_ID_REGISTER";
	public static final String MESSAGE_PLACEHOLDER_USERNAME_REGISTER = "MESSAGE_PLACEHOLDER_USERNAME_REGISTER";
	public static final String MESSAGE_PLACEHOLDER_PASS_REGISTER = "MESSAGE_PLACEHOLDER_PASS_REGISTER";
	public static final String MESSAGE_PLACEHOLDER_CONFIRMPASS_REGISTER = "MESSAGE_PLACEHOLDER_CONFIRMPASS_REGISTER";
	public static final String MESSAGE_PLACEHOLDER_INITIALMONEY_REGISTER = "MESSAGE_PLACEHOLDER_INITIALMONEY_REGISTER";
	public static final String MESSAGE_PLACEHOLDER_PASSACCOUNT_REGISTER = "MESSAGE_PLACEHOLDER_PASSACCOUNT_REGISTER";
	public static final String MESSAGE_PLACEHOLDER_CONFIRMPASSACCOUNT_REGISTER = "MESSAGE_PLACEHOLDER_CONFIRMPASSACCOUNT_REGISTER";
	public static final String MESSAGE_PLACEHOLDER_BIRTH_DATE = "MESSAGE_PLACEHOLDER_BIRTH_DATE";
	public static final String MESSAGE_PLACEHOLDER_USER_TO_SEND = "MESSAGE_PLACEHOLDER_USER_TO_SEND";

	// QUESTIONS
	public static final String QUESTION_NAME_OLDER_FRIEND = "QUESTION_NAME_OLDER_FRIEND";
	public static final String QUESTION_FAVORITE_TEAM = "QUESTION_FAVORITE_TEAM";
	public static final String QUESTION_NAME_FIRST_PET = "QUESTION_NAME_FIRST_PET";
	public static final String QUESTION_NAME_FAVORITE_TEACHER = "QUESTION_NAME_FAVORITE_TEACHER";
	public static final String QUESTION_CITY_PARENTS = "QUESTION_CITY_PARENTS";
	public static final String QUESTION_NAME_STREET = "QUESTION_NAME_STREET";
	public static final String QUESTION_MODEL_CAR = "QUESTION_MODEL_CAR";
	public static final String QUESTION_NAME_CINE_STAR = "QUESTION_NAME_CINE_STAR";
	
	//JOPTIONPANE
	public static final String MESSAGE_JOPTIONPANE_USER_CREATE = "MESSAGE_JOPTIONPANE_USER_CREATE";
	public static final String MESSAGE_JOPTIONPANE_SOME_REGISTER_ERROR = "MESSAGE_JOPTIONPANE_SOME_REGISTER_ERROR";
	public static final String MESSAGE_JOPTIONPANE_ANSWERS_DONT_SIMILAR = "MESSAGE_JOPTIONPANE_ANSWERS_DONT_SIMILAR";
	public static final String MESSAGE_JOPTIONPANE_WANT_LOGOUT = "MESSAGE_JOPTIONPANE_WANT_LOGOUT";
	public static final String MESSAGE_JOPTIONPANE_INCORRECT_DATA = "MESSAGE_JLABEL_INCORRECT_DATA";
	public static final String MESSAGE_JOPTIONPANE_EMPTY_DATA = "MESSAGE_JLABEL_EMPTY_DATA";
	public static final String MESSAGE_JOPTIONPANE_INCORRECT_ANSWER = "MESSAGE_INCORRECT_ANSWER";
	public static final String MESSAGE_JOPTIONPANE_CANT_DELETE_ACC = "MESSAGE_JOPTIONPANE_CANT_DELETE_ACC";
	public static final String MESSAGE_JOPTIONPANE_DELETE_ACC = "MESSAGE_JOPTIONPANE_DELETE_ACC";
	public static final String MESSAGE_JOPTIONPANE__YOU_CAN_DELETE_ACC = "MESSAGE_JOPTIONPANE__YOU_CAN_DELETE_ACC";
	public static final String MESSAGE_JOPTIONPANE_INVALID_PASS = "MESSAGE_JOPTIONPANE_INVALID_PASS";
	public static final String MESSAGE_JOPTIONPANE_CAN_CHANGE_PASS = "MESSAGE_JOPTIONPANE_CAN_CHANGE_PASS";
	public static final String MESSAGE_JOPTIONPANE_PASS_LENGTH = "MESSAGE_JOPTIONPANE_PASS_LENGTH";
	public static final String MESSAGE_JOPTIONPANE_YOUR_NEW_PASS = "MESSAGE_JOPTIONPANE_YOUR_NEW_PASS";
	public static final String MESSAGE_JOPTIONPANE_PASS_ACTUAL = "MESSAGE_JOPTIONPANE_PASS_ACTUAL";
	public static final String MESSAGE_JOPTIONPANE_MONEY_DEPOSIT = "MESSAGE_JOPTIONPANE_MONEY_DEPOSIT";
	public static final String MESSAGE_JOPTIONPANE_NOT_FOUNDS = "MESSAGE_JOPTIONPANE_NOT_FOUNDS";
	public static final String MESSAGE_JOPTIONPANE_MONEY_WITHDRAWALS = "MESSAGE_JOPTIONPANE_MONEY_WITHDRAWALS";
	public static final String MESSAGE_JOPTIONPANE_USER_DONT_EXIST = "MESSAGE_JOPTIONPANE_USER_DONT_EXIST";
	public static final String MESSAGE_JOPTIONPANE_MONEY_TRANSFER = "MESSAGE_JOPTIONPANE_MONEY_TRANSFER";
	
	public static final String MESSAGE_TITLE_CONFIGURATION = "MESSAGE_TITLE_CONFIGURATION";
	public static final String JBUTTON_CHANGE_PASSWORD  = "CHANGE_PASSWORD";
	public static final String JBUTTON_DELETE_ACCOUNT = "DELETE_ACCOUNT";
	public static final String JBUTTON_BEHIND = "BEHIND";
	public static final String MESSAGE_TITLE_TRANSACTION= "MESSAGE_TITLE_TRANSACTION";
	public static final String MESSAGE_AMOUNT_OF_MONEY= "MESSAGE_AMOUNT_OF_MONEY";
	public static final String MESSAGE_SHIPPING_ACCOUNT= "MESSAGE_SHIPPING_ACCOUNT";
	public static final String MESSAGE_TITLE_RECHARGE= "MESSAGE_TITLE_RECHARGE";
	public static final String MESSAGE_TITLE_WITHDRAW= "MESSAGE_TITLE_WITHDRAW";
	public static final String MESSAGE_ENTER_BANK_PASSWORD= "MESSAGE_ENTER_BANK_PASSWORD";
	
	public static final String PATH_SETTING_OPTION_1 = "src/res/Configuration_1.jpeg";
	public static final String PATH_SETTING_OPTION_2 = "src/res/Configuration_2.jpeg";
	public static final String PATH_SETTING_OPTION_3 = "src/res/Configuration_3.jpeg";
	
	public static final int SIZE_WIDTH_BUTTON = 350;
	public static final int SIZE_HEIGHT_BUTTON = 50;
	public static final int SHADING = 50;
	
	// JLABELS
	public static final String MESSAGE_JLABEL_USER = "MESSAGE_JLABEL_USER";
	public static final String MESSAGE_JLABEL_PASS = "MESSAGE_JLABEL_PASS";
	public static final String MESSAGE_JLABEL_SELECT_LANGUAJE = "SELECT_LANGUAJE";
	public static final String MESSAGE_JLABEL_APP_DESCRIPTION_SPLASH = "APP_DESCRIPTION_SPLASH";
	public static final String MESSAGE_JLABEL_SLOGAN_APP = "SLOGAN_APP";
	public static final String MESSAGE_JLABEL_REGISTER_TITLE = "MESSAGE_JLABEL_REGISTER_TITLE";
	public static final String MESSAGE_JLABEL_WELCOME_AGAIN = "MESSAGE_JLABEL_WELCOME_AGAIN";
	public static final String MESSAGE_JLABEL_MY_ACCOUNT = "MESSAGE_JLABEL_MY_ACCOUNT";
	public static final String MESSAGE_JLABEL_MY_USERNAME = "MESSAGE_JLABEL_MY_USERNAME";
	public static final String MESSAGE_JLABEL_TYPE_ACCOUNT = "MESSAGE_JLABEL_TYPE_ACCOUNT";
	public static final String MESSAGE_JLABEL_LOGOUT = "MESSAGE_JLABEL_LOGOUT";
	public static final String MESSAGE_JLABEL_ACTUAL_MONEY = "MESSAGE_JLABEL_ACTUAL_MONEY";
	public static final String MESSAGE_JLABEL_MAIN_MENU = "MESSAGE_JLABEL_MAIN_MENU";
	public static final String MESSAGE_JLABEL_ABOUT_US = "MESSAGE_JLABEL_ABOUT_US";
	public static final String MESSAGE_JLABEL_LAST_CONNECTION = "MESSAGE_JLABEL_LAST_CONNECTION";
	public static final String MESSAGE_JLABEL_NAMES_REGISTER = "MESSAGE_JLABEL_NAMES_REGISTER";
	public static final String MESSAGE_JLABEL_LNAME_REGISTER = "MESSAGE_JLABEL_LNAME_REGISTER";
	public static final String MESSAGE_JLABEL_ID_REGISTER = "MESSAGE_JLABEL_ID_REGISTER";
	public static final String MESSAGE_JLABEL_DATE_REGISTER = "MESSAGE_JLABEL_DATE_REGISTER";
	public static final String MESSAGE_JLABEL_USERNAME_REGISTER = "MESSAGE_JLABEL_USERNAME_REGISTER";
	public static final String MESSAGE_JLABEL_PASS_REGISTER = "MESSAGE_JLABEL_PASS_REGISTER";
	public static final String MESSAGE_JLABEL_CONFIRMPASS_REGISTER = "MESSAGE_JLABEL_CONFIRMPASS_REGISTER";
	public static final String MESSAGE_JLABEL_TYPEACCOUNT_REGISTER = "MESSAGE_JLABEL_TYPEACCOUNT_REGISTER";
	public static final String MESSAGE_JLABEL_INITIALMONEY_REGISTER = "MESSAGE_JLABEL_INITIALMONEY_REGISTER";
	public static final String MESSAGE_JLABEL_PASSACCOUNT_REGISTER = "MESSAGE_JLABEL_PASSACCOUNT_REGISTER";
	public static final String MESSAGE_JLABEL_CANSWER = "MESSAGE_JLABEL_CANSWER";
	public static final String MESSAGE_JLABEL_MAYUS_NOTE = "MESSAGE_JLABEL_MAYUS_NOTE";
	public static final String MESSAGE_JLABEL_SELECT_QUESTION = "MESSAGE_JLABEL_SELECT_QUESTION";
	public static final String MESSAGE_JLABEL_WRITE_QUESTION = "MESSAGE_JLABEL_WRITE_QUESTION";
	public static final String MESSAGE_JLABEL_CONFIRM_ANSWER = "MESSAGE_JLABEL_CONFIRM_ANSWER";
	public static final String MESSAGE_JLABEL_TYPE_TRANSACTION = "MESSAGE_JLABEL_TYPE_TRANSACTION";
	public static final String MESSAGE_JLABEL_AMOUNT = "MESSAGE_JLABEL_AMOUNT";
	public static final String COMMAND_CHANGE_PASSWORD = "COMMAND_CHANGE_PASSWORD";
	public static final String COMMAND_DELETE_ACCOUNT = "COMMAND_DELETE_ACCOUNT";
	public static final String COMMAND_BEHIND = "COMMAND_BEHIND";
	public static final String COMMAND_JBUTTON_ARROW_BACK_DEPOSIT = "COMMAND_JBUTTON_ARROW_BACK_DEPOSIT";
	public static final String MESSAGE_JLABEL_WITHDRAWALS = "MESSAGE_JLABEL_WITHDRAWALS";
	public static final String MESSAGE_JLABEL_MONEY_TO_SEND = "MESSAGE_JLABEL_MONEY_TO_SEND";
	public static final String COMMAND_ACCEPT_TRANSFER = "COMMAND_ACCEPT_TRANSFER";
	public static final String COMMAND_JBUTTON_ARROW_BACK_TRANSFER = "COMMAND_JBUTTON_ARROW_BACK_TRANSFER";
	public static final String MESSAGE_DEPOSIT_MONEY = "MESSAGE_DEPOSIT_MONEY";
	
	public static final String SPANISH_ES = "Español";
	public static final String ENGLISH_EN = "English";
	public static final String THEMEDARK_EN = "Dark";
	public static final String THEMEDARK_ES = "Oscuro";
	public static final String THEMELIGTH_ES = "Claro";
	public static final String THEMELIGHT_EN = "Light";
	public static final String MESSAGE_DELETE = "MESSAGE_DELETE";
	public static final String MESSAGE_CONGRATULATIONS = "MESSAGE_CONGRATULATIONS";
	
	/**
	 * Patron singleton
	 * 
	 * @return
	 */
	public static Constants getInstance() {
		if (constants == null) {
			constants = new Constants(PATH_PROPERTIES_ES);
		}
		return constants;
	}

	/**
	 * Constructor de Constants
	 */
	private Constants(String pathName) {
		try {
			this.load(new FileReader(pathName));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que abre un nuevo archivo de idioma de propiedades
	 * 
	 * @param newPath
	 */
	public void changeLanguajeES() {
		try {
			this.load(new FileReader(PATH_PROPERTIES_ES));
			Constants.LANGUAJE_ACTUAL = "ES";
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Metodo que abre un nuevo archivo de idioma de propiedades
	 * 
	 * @param newPath
	 */
	public void changeLanguajeEN() {
		try {
			this.load(new FileReader(PATH_PROPERTIES_EN));
			Constants.LANGUAJE_ACTUAL = "EN";
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que retorna la constante de preguta de recuperacion
	 * 
	 * @param recoveryQuestion
	 * @return
	 */
	public static String getMessageRecoveryQuestion(int recoveryQuestion) {
		switch (recoveryQuestion) {
		case 0:
			return Constants.QUESTION_NAME_OLDER_FRIEND;
		case 1:
			return Constants.QUESTION_NAME_FIRST_PET;
		case 2:
			return Constants.QUESTION_NAME_FAVORITE_TEACHER;
		case 3:
			return Constants.QUESTION_CITY_PARENTS;
		case 4:
			return Constants.QUESTION_NAME_STREET;
		case 5: 
			return Constants.QUESTION_FAVORITE_TEAM;
		case 6:
			return Constants.QUESTION_MODEL_CAR;
		case 7:
			return Constants.QUESTION_NAME_CINE_STAR;
		default:
			return "";
		}
	}
}
