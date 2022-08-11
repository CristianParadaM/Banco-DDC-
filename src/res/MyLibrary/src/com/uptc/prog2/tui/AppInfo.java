package com.uptc.prog2.tui;

/**
 * Clase que contiene la informacion de la aplicacion
 * @author Cristian David Parada Martinez
 * @Date 17/02/2021
 *
 */
public class AppInfo {
	protected String appMainMenu;
	protected String appName;
	protected String appVersion;
	protected String appYear;
	protected String appAuthor;
	protected String appEnterprise;
	protected String appDescription;
	
	/**
	 * Constructor de AppInfo
	 * @param appName
	 * @param appVersion
	 * @param appYear
	 * @param appAuthor
	 */
	public AppInfo(String appMainMenu, String appName, String appVersion, String appYear, String appAuthor, String appEnterprise, String appDescription) {
		this.appMainMenu = appMainMenu;
		this.appName = appName;
		this.appVersion = appVersion;
		this.appYear = appYear;
		this.appAuthor = appAuthor;
		this.appEnterprise = appEnterprise;
		this.appDescription = appDescription;
	}

	/**
	 * @return the appMainMenu
	 */
	public String getAppMainMenu() {
		return appMainMenu;
	}

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @return the appVersion
	 */
	public String getAppVersion() {
		return appVersion;
	}

	/**
	 * @return the appYear
	 */
	public String getAppYear() {
		return appYear;
	}

	/**
	 * @return the appAuthor
	 */
	public String getAppAuthor() {
		return appAuthor;
	}

	/**
	 * @return the appEnterprise
	 */
	public String getAppEnterprise() {
		return appEnterprise;
	}

	/**
	 * @return the appDescription
	 */
	public String getAppDescription() {
		return appDescription;
	}
	
	
	
}
