/**
 * 
 */
package view.viewRegister;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import com.toedter.calendar.JDateChooser;

import controller.ControllerApp;
import model.TextPrompt;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 13/05/2021
 */
public class JPanelRegister extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JComboBox<String> comboBox;

	public JPanelRegister() {
		super();
		this.gbc = new GridBagConstraints();
		this.comboBox = new JComboBox<>();
		init();
	}

	private void init() {
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());

		gbc.weightx = 1;
		gbc.fill = 1;
		gbc.insets = new Insets(0, 30, 0, 30);
		addOptionLabel(0, 0, 40, Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_NAMES_REGISTER));
		addJTextField(0, 1, 30, 50, Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_NAMES_REGISTER),
				Constants.MAX_LENGTH_NAMES);

		addOptionLabel(0, 2, 40, Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_LNAME_REGISTER));
		addJTextField(0, 3, 30, 50,
				Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_LASTNAMES_REGISTER),
				Constants.MAX_LENGTH_NAMES);

		addOptionLabel(0, 4, 40, Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_ID_REGISTER));
		addNumberField(0, 5, 30, 50, 0, Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_ID_REGISTER));

		addOptionLabel(0, 6, 40, Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_DATE_REGISTER));
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.insets = new Insets(0, 30, 0, 50);

		JTextField jTextFieldDate = new JTextField();
		jTextFieldDate.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		jTextFieldDate.setForeground(CyFPaletteApp.COLOR_MAIN);
		jTextFieldDate.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
		jTextFieldDate.setLayout(new BorderLayout());
		jTextFieldDate.setOpaque(false);
		jTextFieldDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() != (char) 8) {
					e.consume();
				}
			}
		});
		TextPrompt textPrompt = new TextPrompt(
				Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_BIRTH_DATE), jTextFieldDate);
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);
		JDateChooser calendar = new JDateChooser();
		calendar.setPreferredSize(new Dimension(24, 20));
		calendar.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
		calendar.getCalendarButton().setBackground(CyFPaletteApp.COLOR_BACKGROUND);
		calendar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		if (Constants.LANGUAJE_ACTUAL.equals("EN")) {
			calendar.setLocale(Locale.US);
		} else {
			calendar.setLocale(new Locale("es"));
		}

		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (calendar.getDate() != null) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					jTextFieldDate.setText(simpleDateFormat.format(calendar.getDate()).toUpperCase());
				}
			}
		});
		jTextFieldDate.add(calendar, BorderLayout.EAST);
		this.add(jTextFieldDate, gbc);

		addOptionLabel(0, 8, 40, Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_USERNAME_REGISTER));
		addJTextField(0, 9, 30, 50,
				Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_USERNAME_REGISTER),
				Constants.MAX_LENGTH_USERNAME);

		addOptionLabel(0, 10, 40, Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_PASS_REGISTER));
		addJPasswordField(0, 11, 30, 50, 0,
				Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_PASS_REGISTER), 10);

		addOptionLabel(1, 0, 10, Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_CONFIRMPASS_REGISTER));
		addJPasswordField(1, 1, 0, 30, 0, Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_PASS), 10);

		addOptionLabel(1, 2, 10, Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_TYPEACCOUNT_REGISTER));
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 0, 30);

		comboBox.setPreferredSize(new Dimension(60, 20));
		comboBox.setOpaque(false);
		comboBox.setRenderer(new BasicComboBoxRenderer() {

			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				JComponent result = (JComponent) super.getListCellRendererComponent(list, value, index, isSelected,
						cellHasFocus);
				result.setOpaque(false);
				return result;
			}

			@Override
			public void setBorder(Border border) {
				super.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
			}

			@Override
			public void setForeground(Color fg) {
				super.setForeground(CyFPaletteApp.COLOR_MAIN);
			}

			@Override
			public void setFont(Font font) {
				super.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
			}

		});
		comboBox.setBackground(CyFPaletteApp.COLOR_BORDER_INVERT);
		comboBox.addItem(Constants.getInstance().getProperty(Constants.SAVINGS_ACCOUNT));
		comboBox.addItem(Constants.getInstance().getProperty(Constants.CURRENT_ACCOUNT));
		this.add(comboBox, gbc);

		addOptionLabel(1, 4, 10, Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_INITIALMONEY_REGISTER));
		addMoneyField(1, 5, 0, 30, 0,
				Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_INITIALMONEY_REGISTER));

		addOptionLabel(1, 6, 10, Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_PASSACCOUNT_REGISTER));
		addJPasswordField(1, 7, 0, 30, 0,
				Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_PASSACCOUNT_REGISTER),
				Constants.MAX_LENGTH_PASSWORD_ACCOUNT);

		addOptionLabel(1, 8, 10, Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_CONFIRMPASS_REGISTER));
		addJPasswordField(1, 9, 0, 30, 0,
				Constants.getInstance().getProperty(Constants.MESSAGE_PLACEHOLDER_CONFIRMPASSACCOUNT_REGISTER),
				Constants.MAX_LENGTH_PASSWORD_ACCOUNT);

		addOptionLabel(1, 10, 10, "");
		gbc.gridx = 1;
		gbc.gridy = 11;
		gbc.insets = new Insets(0, 100, 0, 130);
		JButtonsDDC button = new JButtonsDDC(
				Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_NEXT_REGISTER),
				ControllerApp.getInstance(), Constants.COMMAND_JBUTTON_NEXT_REGISTER, 60, 20, CyFPaletteApp.COLOR_MAIN,
				CyFPaletteApp.COLOR_BACKGROUND, false);
		button.setFont(CyFPaletteApp.FONT_BUTTONS);
		button.setOpaque(false);
		this.add(button, gbc);

		gbc.gridy = 12;
		gbc.gridx = 0;
		gbc.insets = new Insets(30, 0, 0, 0);
		gbc.gridwidth = 2;
		JLabel jLabel = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_MAYUS_NOTE),
				JLabel.CENTER);
		jLabel.setFont(CyFPaletteApp.FONT_BUTTONS);
		jLabel.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabel, gbc);
		this.add(Box.createRigidArea(new Dimension(0, 50)), gbc);
	}

	private void addNumberField(int x, int y, int insetsLeft, int insetsRigth, int insetsTop, String placeHolder) {
		gbc.insets = new Insets(insetsTop, insetsLeft, 0, insetsRigth);
		gbc.gridx = x;
		gbc.gridy = y;
		JTextField jTextField = new JTextField();
		jTextField.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		jTextField.setForeground(CyFPaletteApp.COLOR_MAIN);
		jTextField.setPreferredSize(new Dimension(0, 25));
		jTextField.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
		jTextField.setOpaque(false);
		TextPrompt textPrompt = new TextPrompt(placeHolder, jTextField);
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);
		jTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if ((int) e.getKeyChar() < 48 || (int) e.getKeyChar() > 57) {
					e.consume();
				}
				if (jTextField.getText().length() == Constants.MAX_LENGTH_NUMBER_DOCUMENT) {
					e.consume();
				}
			}
		});
		this.add(jTextField, gbc);
	}

	private void addMoneyField(int x, int y, int insetsLeft, int insetsRigth, int insetsTop, String placeHolder) {
		gbc.insets = new Insets(insetsTop, insetsLeft, 0, insetsRigth);
		gbc.gridx = x;
		gbc.gridy = y;
		JTextField jTextField = new JTextField();
		jTextField.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		jTextField.setForeground(CyFPaletteApp.COLOR_MAIN);
		jTextField.setPreferredSize(new Dimension(0, 25));
		jTextField.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
		jTextField.setOpaque(false);
		TextPrompt textPrompt = new TextPrompt(placeHolder, jTextField);
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);
		jTextField.setText("$ ");
		jTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if ((int) e.getKeyChar() < 48 || (int) e.getKeyChar() > 57) {
					e.consume();
				}
				if (jTextField.getText().length() <= 2) {
					jTextField.setText("$ ");
				}
				if (jTextField.getText().length() == Constants.MAX_LENGTH_MONEY) {
					e.consume();
				}
			}
		});
		this.add(jTextField, gbc);
	}

	private void addOptionLabel(int x, int y, int insetLeft, String text) {
		gbc.insets = new Insets(20, insetLeft, 0, 0);
		gbc.gridx = x;
		gbc.gridy = y;

		JLabel label = new JLabel(text);
		label.setOpaque(false);
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setFont(CyFPaletteApp.FONT_CONTENT);
		label.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(label, gbc);
	}

	public void addJTextField(int x, int y, int insetLeft, int insetRigth, String placeHolder, int lenght) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(0, insetLeft, 0, insetRigth);
		JTextField jTextField = new JTextField();
		jTextField.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
		jTextField.setOpaque(false);
		jTextField.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		jTextField.setForeground(CyFPaletteApp.COLOR_MAIN);
		jTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (jTextField.getText().length() == Constants.MAX_LENGTH_NAMES) {
					e.consume();
				}
				if (jTextField.getText().length() == lenght) {
					e.consume();
				}
			}
		});

		TextPrompt textPrompt = new TextPrompt(placeHolder, jTextField);
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);

		this.add(jTextField, gbc);
	}

	public void addJPasswordField(int x, int y, int insetLeft, int insetRigth, int insetTop, String placeHolder,
			int lengthPass) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(insetTop, insetLeft, 0, insetRigth);
		JPasswordField jPasswordField = new JPasswordField();
		jPasswordField.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		jPasswordField.setForeground(CyFPaletteApp.COLOR_BORDER);
		jPasswordField.setOpaque(false);
		jPasswordField.setBorder(BorderFactory.createLineBorder(CyFPaletteApp.COLOR_BORDER));
		jPasswordField.setPreferredSize(new Dimension(0, 25));
		jPasswordField.setLayout(new BorderLayout());
		jPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == ' ') {
					e.consume();
				}
				if (String.valueOf(jPasswordField.getPassword()).length() == lengthPass) {
					e.consume();
				}
			}
		});
		TextPrompt textPrompt = new TextPrompt(placeHolder, jPasswordField);
		jPasswordField.add(new JButtonsDDC(new ImageIcon(CyFPaletteApp.PATH_SHOW_PASS), new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jPasswordField.getEchoChar() == '•') {
					jPasswordField.setEchoChar((char) 0);
				} else {
					jPasswordField.setEchoChar('•');
				}
			}

		}, "", 50, 20, Color.WHITE, CyFPaletteApp.COLOR_TRANSPARENT, true), BorderLayout.EAST);
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);
		this.add(jPasswordField, gbc);
	}

	public void setIncorrectNameRegister() {
		((JTextField) this.getComponent(1)).setBorder(new LineBorder(Color.RED));
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectLastNameRegister() {
		((JTextField) this.getComponent(3)).setBorder(new LineBorder(Color.RED));
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectDocumentNumberRegister() {
		((JTextField) this.getComponent(5)).setBorder(new LineBorder(Color.RED));
	}
	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectDateOfBirthRegister() {
		((JTextField) this.getComponent(7)).setBorder(new LineBorder(Color.RED));
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectUserNameRegister() {
		((JTextField) this.getComponent(9)).setBorder(new LineBorder(Color.RED));
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectPasswordRegister() {
		((JPasswordField) this.getComponent(11)).setBorder(new LineBorder(Color.RED));
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectConfirmPasswordRegister() {
		((JPasswordField) this.getComponent(13)).setBorder(new LineBorder(Color.RED));
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectInitialAmountRegister() {
		((JTextField) this.getComponent(17)).setBorder(new LineBorder(Color.RED));
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectPasswordAccountRegister() {
		((JPasswordField) this.getComponent(19)).setBorder(new LineBorder(Color.RED));
	}

	/**
	 * Metodo que pone incorrcto el jtextfield
	 */
	public void setIncorrectConfirmPasswordAccountRegister() {
		((JPasswordField) this.getComponent(21)).setBorder(new LineBorder(Color.RED));
	}

	// ---

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectNameRegister() {
		((JTextField) this.getComponent(1)).setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectLastNameRegister() {
		((JTextField) this.getComponent(3)).setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectDocumentNumberRegister() {
		((JTextField) this.getComponent(5)).setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectDateOfBirthRegister() {
		((JTextField) this.getComponent(7)).setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectUserNameRegister() {
		((JTextField) this.getComponent(9)).setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectPasswordRegister() {
		((JPasswordField) this.getComponent(11)).setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectConfirmPasswordRegister() {
		((JPasswordField) this.getComponent(13)).setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectInitialAmountRegister() {
		((JTextField) this.getComponent(17)).setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectPasswordAccountRegister() {
		((JPasswordField) this.getComponent(19)).setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
	}

	/**
	 * Metodo que pone corrcto el jtextfield
	 */
	public void setCorrectConfirmPasswordAccountRegister() {
		((JPasswordField) this.getComponent(21)).setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
	}

	/**
	 * Metodo que obtiene el nombre de registro
	 * 
	 * @return nombre de usuario
	 */
	public String getNameRegister() {
		return ((JTextField) this.getComponent(1)).getText();
	}

	/**
	 * Metodo que obtiene el apellido de registro
	 * 
	 * @return apellido de usuario
	 */
	public String getLastNameRegister() {
		return ((JTextField) this.getComponent(3)).getText();
	}

	/**
	 * Metodo que obtiene el numero de documento de registro
	 * 
	 * @return numero de documento de usuario
	 */
	public String getDocumentNumberRegister() {
		return ((JTextField) this.getComponent(5)).getText();
	}

	/**
	 * Metodo que obtiene la fecha de nacimiento de registro
	 * 
	 * @return fecha de nacimiento de usuario
	 */
	public String getDateOfBirthRegister() {
		return ((JTextField) this.getComponent(7)).getText();
	}

	/**
	 * Metodo que obtiene el username de registro
	 * 
	 * @return username de usuario
	 */
	public String getUserNameRegister() {
		return ((JTextField) this.getComponent(9)).getText();
	}

	/**
	 * Metodo que obtiene la contraseña de registro
	 * 
	 * @return contraseña de usuario
	 */
	public String getPasswordRegister() {
		return String.valueOf(((JPasswordField) this.getComponent(11)).getPassword());
	}

	/**
	 * Metodo que obtiene la confirmacion de contraseña de registro
	 * 
	 * @return confirmacion contraseña de usuario
	 */
	public String getConfirmPasswordRegister() {
		return String.valueOf(((JPasswordField) this.getComponent(13)).getPassword());
	}

	/**
	 * Metodo que obtiene el tipo de cuenta de registro
	 * 
	 * @return tipo de cuenta de usuario
	 */
	public String getTypeAccountRegister() {
		return (String) comboBox.getSelectedItem();
	}

	/**
	 * Metodo que obtiene el monto inicial de registro
	 * 
	 * @return monto inicial de usuario
	 */
	public String getInitialAmountRegister() {
		return ((JTextField) this.getComponent(17)).getText().substring(2,
				((JTextField) this.getComponent(17)).getText().length());
	}

	/**
	 * Metodo que obtiene la contraseña de la cuenta de registro
	 * 
	 * @return contraseña de la cuenta de usuario
	 */
	public String getPasswordAccountRegister() {
		return String.valueOf(((JPasswordField) this.getComponent(19)).getPassword());
	}

	/**
	 * Metodo que obtiene la contraseña de la cuenta de registro
	 * 
	 * @return contraseña de la cuenta de usuario
	 */
	public String getConfirmPasswordAccountRegister() {
		return String.valueOf(((JPasswordField) this.getComponent(21)).getPassword());
	}

}
