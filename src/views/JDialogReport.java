package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;

import controllers.Controller;
import controllers.Events;
import models.Person;

public class JDialogReport extends JDialog{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel defaultTableModel;
	private JTable userTable;
	private JButton btnPrint;

	public JDialogReport(MainWindow mainWindow, Controller controller) {
		super(mainWindow, true);
		setLayout(new GridBagLayout());
		setTitle("Reports");
		setSize(500, 600);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(mainWindow);
		
		init(controller);
	}

	public void init(Controller controller) {
		GridBagConstraints c = new GridBagConstraints(); 
		c.fill = GridBagConstraints.BOTH;

		c.weightx = 1;
		c.gridheight =  1;
		for (int i = 0; i < 2; i++) {
			c.gridx = i;
		}

		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(new Object[]{"ID" , "TIME OF ENTRY", "DEPARTURE TIME", "TRAVEL TIME"});
		userTable = new JTable(defaultTableModel);

		c.gridy = 0;
		c.weighty = 0.8;
		c.gridx = 0;
		c.gridwidth = 1;
		JScrollPane rolloDeTabla = new JScrollPane(userTable);
		add(rolloDeTabla, c);

		c.gridy = 1;
		c.weighty = 0.2;
		c.gridx = 0;
		c.gridwidth = 1;
		btnPrint= new JButton("Print");
		btnPrint.setBackground(Color.decode("#1976D2"));
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Arial", 0, 16));
		btnPrint.addActionListener(controller);
		btnPrint.setActionCommand(Events.PRINT_TABLE.toString());
		add(btnPrint, c);
	}
	
	public void addToTable(Person person) {
		defaultTableModel.addRow(person.toArray());
	}
	
	public void clearList() {
		defaultTableModel.setRowCount(0);
	}
	
	public void printTable() throws PrinterException {
		MessageFormat north = new MessageFormat("PERSON LIST");
		MessageFormat south = new MessageFormat("By Daniel Pinto :v");
		userTable.print(PrintMode.NORMAL, north, south);
	}
}