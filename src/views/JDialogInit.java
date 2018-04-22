package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import controllers.Controller;
import controllers.Events;

public class JDialogInit  extends JDialog{

	private static final long serialVersionUID = 1L;
	private JTextField jTextFieldNumberPerson;
	private JTextField jTextFieldTime;
	private JButton btnInit;

	public JDialogInit(MainWindow mainWindow, Controller controller) {
		super(mainWindow, true);
		setTitle("Init");
		setLayout(new GridLayout(3, 1));
		setSize(500, 300);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(mainWindow);
		
		init(controller);
	}
	
	public void init(Controller controller) {
		jTextFieldNumberPerson =  new JTextField();
		jTextFieldNumberPerson.setBorder(BorderFactory.createTitledBorder("Numero"));
		jTextFieldTime = new JTextField();
		jTextFieldTime.setBorder(BorderFactory.createTitledBorder("Time [mili-segundos]"));
		btnInit = new JButton("init");
		btnInit.addActionListener(controller);
		btnInit.setActionCommand(Events.INIT.toString());
		add(jTextFieldNumberPerson);
		add(jTextFieldTime);
		add(btnInit);
	}
	
	public int getTextNumberPerson() {
		return Integer.parseInt(jTextFieldNumberPerson.getText());
	}
	
	public int getTexttime() {
		return Integer.parseInt(jTextFieldTime.getText());
	}
}