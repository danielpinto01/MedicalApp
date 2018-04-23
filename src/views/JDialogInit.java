package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.Controller;
import controllers.Events;

public class JDialogInit  extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel pnlInformation;
	private JLabel lbInformation;
	private JTextField jTextFieldNumberPerson;
	private JButton btnInit;

	public JDialogInit(MainWindow mainWindow, Controller controller) {
		super(mainWindow, true);
		setTitle("Init");
		setLayout(new GridLayout(3, 1));
		setSize(300, 200);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.decode("#2979FF"));
		setLocationRelativeTo(mainWindow);
		
		init(controller);
	}
	
	public void init(Controller controller) {
		pnlInformation = new JPanel();
		pnlInformation.setBackground(Color.decode("#2979FF"));
		pnlInformation.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); 
		lbInformation = new JLabel("Enter a number of people");
		lbInformation.setBackground(Color.decode("#2979FF"));
		lbInformation.setForeground(Color.WHITE);
		lbInformation.setFont(new Font("Century Gothic", 0,16));
		pnlInformation.add(lbInformation);
		add(pnlInformation);
		jTextFieldNumberPerson =  new JTextField();
		jTextFieldNumberPerson.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		btnInit = new JButton("Init");
		btnInit.addActionListener(controller);
		btnInit.setActionCommand(Events.INIT.toString());
		btnInit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnInit.setBackground(Color.decode("#0D47A1"));
		btnInit.setForeground(Color.WHITE);
		btnInit.setFont(new Font("Century Gothic", 0,16));
		btnInit.setFocusable(false);
		btnInit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		add(jTextFieldNumberPerson);
		add(btnInit);
	}
	
	public int getTextNumberPerson() {
		return Integer.parseInt(jTextFieldNumberPerson.getText());
	}
}