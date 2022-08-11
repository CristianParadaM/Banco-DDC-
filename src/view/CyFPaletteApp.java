package view;

import java.awt.Color;
import java.awt.Font;

/** Clase que maneja el objeto ColorPaletteApp.java
 *
 * @author Cristian David Parada Martinez
 * @date 8/05/2021
 *
 */
public class CyFPaletteApp {
	
		// FONTS
	public static final Font FONT_TITLE_JPANEL_LATERAL = new Font("Arial", Font.BOLD, 40);
		public static final Font FONT_TITLES = new Font("Arial", Font.BOLD, 50);
		public static final Font FONT_CONTENT_SUBTITLES = new Font("Arial", Font.BOLD, 25);
		public static final Font FONT_CONTENT = new Font("Arial", Font.PLAIN, 25);
		public static final Font FONT_BUTTONS = new Font("Arial", Font.PLAIN, 15);
		public static final Font FONT_JTEXTFIELD = new Font("Arial", Font.PLAIN, 20);
		public static final Font FONT_SLOGAN = new Font("Arial", Font.BOLD, 20);

		// COLORS
		private static final Color COLOR_BACKGROUND_DARK = new Color(0, 0, 0, 80);
		private static final Color COLOR_BACKGROUND_LIGHT = new Color(255, 255, 255, 80);
		private static final Color COLOR_BLACK = Color.BLACK;
		private static final Color COLOR_WHITE = new Color(240, 240, 240);
		public static final Color COLOR_TRANSPARENT = new Color(0,0,0,0);
		
		public static Color COLOR_BORDER = COLOR_WHITE;
		public static Color COLOR_BORDER_INVERT = COLOR_BLACK;
		public static Color COLOR_BACKGROUND_TEXTFIELD = COLOR_BLACK;
		public static Color COLOR_BACKGROUND = COLOR_BACKGROUND_DARK;
		public static Color COLOR_BACKGROUND_SECUNDARY = COLOR_BACKGROUND_LIGHT;
		public static Color COLOR_MAIN = COLOR_WHITE;
		public static Color COLOR_SECUNDARY = COLOR_BLACK;
		public static byte THEME_ORDINAL = 0;
		
		//PATH
		private static final String PATH_SHOW_PASS_DARK = "src/res/verPassOscuro.png";
		private static final String PATH_SHOW_PASS_LIGHT = "src/res/verPassClaro.png";
		private static final String PATH_BACKGROUND_JDIALOG_LIGHT = "src/res/backGroundLoginLigth.jpeg";
		private static final String PATH_BACKGROUND_JDIALOG_DARK = "src/res/backGroundLoginDark.jpeg";
		public static final String PATH_BACKGROUND_JFRAME_DARK = "src/res/backGroundFDark.jpeg";
		public static final String PATH_BACKGROUND_JFRAME_LIGHT = "src/res/backGroundFLigth.jpeg";
		
		public static String PATH_SHOW_PASS = PATH_SHOW_PASS_DARK;
		public static String PATH_BACKGROUND = PATH_BACKGROUND_JDIALOG_DARK;
		
		/**
		 * Metodo que cambia el tema a oscuro
		 */
		public static void changeThemeDark(){
			CyFPaletteApp.COLOR_BACKGROUND_TEXTFIELD = COLOR_BLACK;
			CyFPaletteApp.COLOR_BACKGROUND = COLOR_BACKGROUND_DARK;
			CyFPaletteApp.COLOR_MAIN = COLOR_WHITE;
			CyFPaletteApp.COLOR_BACKGROUND_SECUNDARY = COLOR_BACKGROUND_LIGHT;
			CyFPaletteApp.COLOR_BORDER = COLOR_WHITE;
			CyFPaletteApp.PATH_SHOW_PASS = PATH_SHOW_PASS_DARK;
			CyFPaletteApp.PATH_BACKGROUND = PATH_BACKGROUND_JDIALOG_DARK;
			CyFPaletteApp.COLOR_BORDER_INVERT = COLOR_BLACK;
			CyFPaletteApp.THEME_ORDINAL = 0;
		}
		
		/**
		 * Metodo que cambia el tema a claro
		 */
		public static void changeThemeLight(){
			CyFPaletteApp.COLOR_BORDER = COLOR_BLACK;
			CyFPaletteApp.COLOR_BACKGROUND_TEXTFIELD = COLOR_WHITE;
			CyFPaletteApp.COLOR_BACKGROUND = COLOR_BACKGROUND_LIGHT;
			CyFPaletteApp.COLOR_MAIN = COLOR_BLACK;
			CyFPaletteApp.COLOR_BACKGROUND_SECUNDARY = COLOR_BACKGROUND_DARK;
			CyFPaletteApp.PATH_SHOW_PASS = PATH_SHOW_PASS_LIGHT;
			CyFPaletteApp.PATH_BACKGROUND = PATH_BACKGROUND_JDIALOG_LIGHT;
			CyFPaletteApp.COLOR_BORDER_INVERT = COLOR_WHITE;
			CyFPaletteApp.THEME_ORDINAL = 1;
		}
		
}
