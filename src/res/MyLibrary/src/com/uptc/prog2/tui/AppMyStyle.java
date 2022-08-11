package com.uptc.prog2.tui;

import java.awt.Color;

/** Clase que maneja el objeto AppMyStyle.java
 *
 * @author Cristian David Parada Martinez
 * @date 8/04/2021
 *
 */
public class AppMyStyle {
	
	private String typeFont;
	private int styleFont;
	private int sizeFont;
	private Color colorFont;
	
	/** Constructor de AppMyStyle
	 * @param typeFont
	 * @param styleFont
	 * @param sizeFont
	 * @param colorFont
	 */
	public AppMyStyle(String typeFont, int styleFont, int sizeFont, Color colorFont) {
		super();
		this.typeFont = typeFont;
		this.styleFont = styleFont;
		this.sizeFont = sizeFont;
		this.colorFont = colorFont;
	}

	/**
	 * @return the typeFont
	 */
	public String getTypeFont() {
		return typeFont;
	}

	/**
	 * @return the styleFont
	 */
	public int getStyleFont() {
		return styleFont;
	}

	/**
	 * @return the sizeFont
	 */
	public int getSizeFont() {
		return sizeFont;
	}

	/**
	 * @return the colorFont
	 */
	public Color getColorFont() {
		return colorFont;
	}
	
	
}
