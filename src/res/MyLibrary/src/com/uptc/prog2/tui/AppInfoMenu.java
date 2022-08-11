package com.uptc.prog2.tui;

import java.util.List;

/**
 * Clase que maneja la informacion del menu principal
 * @author Cristian David Parada Martinez
 * @Date 21/02/2021
 *
 */
public class AppInfoMenu {
	
	protected String tittle;
	protected List<String> options;
	protected String requetsOption;
	
	public AppInfoMenu(String tittle, List<String> options, String requetsOption) {
		this.tittle = tittle;
		this.options = options;
		this.requetsOption = requetsOption;
	}
	
}
