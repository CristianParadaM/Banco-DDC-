package view.viewRegister;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.ControllerApp;
import model.TextPrompt;
import view.Constants;
import view.CyFPaletteApp;
import view.JButtonsDDC;
import view.viewJFrameMain.JFrameMainWindow;

/**
 * Clase que maneja el objeto jPanelQuestion.java
 *
 * @author Cristian David Parada Martinez
 * @date 16/05/2021
 *
 */
public class jPanelQuestion extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JLabel jLabelSelectOption;
	private ButtonGroup buttonGroup;
	private JLabel jLabelAnswer;
	private JLabel jLabelCAnswer;
	private JTextField jTextFieldAnswer;
	private JTextField jTextFieldCAnswer;
	private JButtonsDDC buttonSend;

	/**
	 * Constructor de jPanelQuestion
	 */
	public jPanelQuestion() {
		super();
		this.gbc = new GridBagConstraints();
		this.jLabelSelectOption = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_SELECT_QUESTION), JLabel.LEFT);
		this.buttonGroup= new ButtonGroup();
		this.jLabelAnswer = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_WRITE_QUESTION), JLabel.CENTER);
		this.jLabelCAnswer = new JLabel(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_CONFIRM_ANSWER), JLabel.CENTER);
		this.jTextFieldAnswer = new JTextField();
		this.jTextFieldCAnswer = new JTextField();
		this.buttonSend = new JButtonsDDC(Constants.getInstance().getProperty(Constants.MESSAGE_JBUTTON_SEND_CREATE_ACCOUNT), ControllerApp.getInstance(), Constants.COMMAND_JBUTTON_SEND_CREATE_ACCOUNT, 0,
				20, CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false);
		init();
	}

	/**
	 * Metodo que
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		gbc.weightx = 1;
		gbc.fill = 1;
		gbc.insets = new Insets(0, 30, 20, 30);
		gbc.gridwidth = 2;

		this.jLabelSelectOption.setFont(CyFPaletteApp.FONT_CONTENT_SUBTITLES);
		this.jLabelSelectOption.setForeground(CyFPaletteApp.COLOR_MAIN);
		this.add(jLabelSelectOption, gbc);

		gbc.gridwidth = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.insets.bottom=5;
		
		JRadioButton question1 = new JRadioButton(
				"<html>" + Constants.getInstance().getProperty(Constants.QUESTION_NAME_OLDER_FRIEND) + "</html>");
		question1.setFocusPainted(false);
		question1.setOpaque(false);
		question1.setFont(CyFPaletteApp.FONT_CONTENT);
		question1.setForeground(CyFPaletteApp.COLOR_MAIN);
		question1.setActionCommand("0");
		JRadioButton question2 = new JRadioButton("<html>" + Constants.getInstance().getProperty(Constants.QUESTION_NAME_FIRST_PET) + "</html>");
		question2.setFocusPainted(false);
		question2.setOpaque(false);
		question2.setFont(CyFPaletteApp.FONT_CONTENT);
		question2.setForeground(CyFPaletteApp.COLOR_MAIN);
		question2.setActionCommand("1");
		JRadioButton question3 = new JRadioButton("<html>" + Constants.getInstance().getProperty(Constants.QUESTION_NAME_FAVORITE_TEACHER) + "</html>");
		question3.setFocusPainted(false);
		question3.setOpaque(false);
		question3.setFont(CyFPaletteApp.FONT_CONTENT);
		question3.setForeground(CyFPaletteApp.COLOR_MAIN);
		question3.setActionCommand("2");
		JRadioButton question4 = new JRadioButton("<html>" + Constants.getInstance().getProperty(Constants.QUESTION_CITY_PARENTS) + "</html>");
		question4.setFocusPainted(false);
		question4.setOpaque(false);
		question4.setFont(CyFPaletteApp.FONT_CONTENT);
		question4.setForeground(CyFPaletteApp.COLOR_MAIN);
		question4.setActionCommand("3");
		JRadioButton question5 = new JRadioButton(
				"<html>" + Constants.getInstance().getProperty(Constants.QUESTION_NAME_STREET) + "</html>");
		question5.setFocusPainted(false);
		question5.setOpaque(false);
		question5.setFont(CyFPaletteApp.FONT_CONTENT);
		question5.setForeground(CyFPaletteApp.COLOR_MAIN);
		question5.setActionCommand("4");
		JRadioButton question6 = new JRadioButton("<html>" + Constants.getInstance().getProperty(Constants.QUESTION_FAVORITE_TEAM) + "</html>");
		question6.setFocusPainted(false);
		question6.setOpaque(false);
		question6.setFont(CyFPaletteApp.FONT_CONTENT);
		question6.setForeground(CyFPaletteApp.COLOR_MAIN);
		question6.setActionCommand("5");
		JRadioButton question7 = new JRadioButton("<html>" + Constants.getInstance().getProperty(Constants.QUESTION_MODEL_CAR) + "</html>");
		question7.setFocusPainted(false);
		question7.setOpaque(false);
		question7.setFont(CyFPaletteApp.FONT_CONTENT);
		question7.setForeground(CyFPaletteApp.COLOR_MAIN);
		question7.setActionCommand("6");
		JRadioButton question8 = new JRadioButton("<html>" + Constants.getInstance().getProperty(Constants.QUESTION_NAME_CINE_STAR) + "</html>");
		question8.setFocusPainted(false);
		question8.setOpaque(false);
		question8.setFont(CyFPaletteApp.FONT_CONTENT);
		question8.setForeground(CyFPaletteApp.COLOR_MAIN);
		question8.setActionCommand("7");
		
		buttonGroup.add(question1);
		buttonGroup.add(question2);
		buttonGroup.add(question3);
		buttonGroup.add(question4);
		buttonGroup.add(question5);
		buttonGroup.add(question6);
		buttonGroup.add(question7);
		buttonGroup.add(question8);
		question1.addActionListener(this);
		question2.addActionListener(this);
		question3.addActionListener(this);
		question4.addActionListener(this);
		question5.addActionListener(this);
		question6.addActionListener(this);
		question7.addActionListener(this);
		question8.addActionListener(this);
		
		this.add(question1, gbc);
		gbc.gridy = 2;
		this.add(question2, gbc);
		gbc.gridy = 3;
		this.add(question3, gbc);
		gbc.gridy = 4;
		this.add(question4, gbc);
		gbc.gridy = 1; gbc.gridx=1;
		this.add(question5, gbc);
		gbc.gridy = 2;
		this.add(question6, gbc);
		gbc.gridy = 3;
		this.add(question7, gbc);
		gbc.gridy = 4;
		this.add(question8, gbc);
		
		gbc.gridx=0; gbc.gridy=5; gbc.insets.bottom=0; gbc.insets.top = 30;
		jLabelAnswer.setFont(CyFPaletteApp.FONT_CONTENT_SUBTITLES);
		jLabelAnswer.setForeground(CyFPaletteApp.COLOR_MAIN);
		jLabelAnswer.setEnabled(false);
		this.add(jLabelAnswer, gbc);
		
		gbc.gridx=1;
		jLabelCAnswer.setFont(CyFPaletteApp.FONT_CONTENT_SUBTITLES);
		jLabelCAnswer.setForeground(CyFPaletteApp.COLOR_MAIN);
		jLabelCAnswer.setEnabled(false);
		this.add(jLabelCAnswer, gbc);
		
		gbc.gridx=0; gbc.gridy=6; gbc.insets.bottom = 30; gbc.insets.top =0;
		jTextFieldAnswer.setOpaque(false);
		jTextFieldAnswer.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
		jTextFieldAnswer.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		jTextFieldAnswer.setForeground(CyFPaletteApp.COLOR_MAIN);
		jTextFieldAnswer.setEnabled(false);
		{
		TextPrompt placeHolder = new TextPrompt(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_CANSWER), jTextFieldAnswer);
		placeHolder.changeAlpha(0.35f);
		placeHolder.changeStyle(Font.ITALIC);
		this.add(jTextFieldAnswer, gbc);
		}
		gbc.gridx=1;
		jTextFieldCAnswer.setOpaque(false);
		jTextFieldCAnswer.setBorder(new LineBorder(CyFPaletteApp.COLOR_BORDER));
		jTextFieldCAnswer.setFont(CyFPaletteApp.FONT_JTEXTFIELD);
		jTextFieldCAnswer.setForeground(CyFPaletteApp.COLOR_MAIN);
		jTextFieldCAnswer.setEnabled(false);
		{
		TextPrompt placeHolder = new TextPrompt(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_CANSWER), jTextFieldCAnswer);
		placeHolder.changeAlpha(0.35f);
		placeHolder.changeStyle(Font.ITALIC);
		this.add(jTextFieldCAnswer, gbc);
		}
		gbc.gridx=0; gbc.gridy=7; gbc.insets.left = 100; gbc.insets.right = 100;
		this.add(new JButtonsDDC(Constants.MESSAGE_JBUTTON_ARROW_BACK, JFrameMainWindow.getInstance(), Constants.COMMAND_JBUTTON_ARROW_BACK_QUESTIONS, 0,
				20, CyFPaletteApp.COLOR_MAIN, CyFPaletteApp.COLOR_BACKGROUND, false), gbc);
		
		gbc.gridx=1;
		buttonSend.setEnabled(false);
		this.add(buttonSend, gbc);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.jLabelAnswer.setEnabled(true);
		this.jLabelCAnswer.setEnabled(true);
		this.jTextFieldAnswer.setEnabled(true);
		this.jTextFieldCAnswer.setEnabled(true);
		this.buttonSend.setEnabled(true);
	}
	
	/**
	 * Metodo que obtiene la pregunta seleccionada
	 * @return pregunta seleccionada
	 */
	public int getQuestionSelected() {
		return Integer.parseInt(buttonGroup.getSelection().getActionCommand());
	}
	/**
	 * Metodo que obtiene la respuesta
	 * @return respuesta seleccionada
	 */
	public String getAnswer() {
		return jTextFieldAnswer.getText();
	}
	/**
	 * Metodo que obtiene la confirmacion de respuesta
	 * @return respuesta seleccionada
	 */
	public String getConfirmationAnswer() {
		return jTextFieldCAnswer.getText();
	}
	
	

}
