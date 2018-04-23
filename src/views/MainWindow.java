package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable.PrintMode;

import controllers.Controller;
import controllers.Events;
import models.Node;
import models.Person;
import models.Product;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanelInit jPanelInit;
	private JPanel jPanelButtons;
	private JButton btnStop;
	private JButton btnReports;
	
	private JDialogInit jDialogInit;
	private JDialogReport jDialogReport;

	public MainWindow(Controller controller) {
		setBackground(Color.BLACK);
		setTitle("Medical App v1.0");
		setLayout(new BorderLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/images/iconApp.png")).getImage());
		
		jDialogInit = new JDialogInit(this, controller);
		jDialogReport = new JDialogReport(this, controller);
		
		init(controller);

		setVisible(true);
	}
	
	public void showDialogReports() {
		jDialogReport.setVisible(true);
	}
	
	public void ocultDialogReports() {
		jDialogReport.setVisible(false);
	}
	
	public void addToTable(Person person) {
		jDialogReport.addToTable(person);
	}
	
	public void showDialoginit() {
		jPanelInit.setVisible(false);
		jDialogInit.setVisible(true);
//		removeAll();
	}
	
	public void showPanelinit() {
		jPanelInit.setVisible(true);
	}
	
	public void ocultDialogInit() {
		jDialogInit.setVisible(false);
	}
	
	
	public int getHeightPanel() {
		return jPanelInit.getHeight();
	}
	
	public int getWidhtPanel() {
		return jPanelInit.getWidth();
	}

	public void init(Controller controller) {
		jPanelInit = new JPanelInit();
		add(jPanelInit, BorderLayout.CENTER);
		jPanelButtons = new JPanel();
		jPanelButtons.setLayout(new GridLayout(2, 1));
		btnStop = new JButton("Stop");
		btnReports = new JButton("Reports");
		btnReports.addActionListener(controller);
		btnReports.setActionCommand(Events.SHOW_DIALOG_REPORTS.toString());
		jPanelButtons.add(btnStop);
		jPanelButtons.add(btnReports);
		add(jPanelButtons, BorderLayout.EAST);
	}
	public void printTable() throws PrinterException {
		jDialogReport.printTable();
	}
	
	public void remove() {
		jPanelInit.remove();
	}
	
	public int getTextNumberPerson() {
		return jDialogInit.getTextNumberPerson();
	}
	
	public int getTexttime() {
		return jDialogInit.getTexttime();
	}
	
	public void addPerson(ArrayList<Person> persons) {
		jPanelInit.setPerson(persons);
		jPanelInit.repaint();
	}
	
	public void addProduct(ArrayList<Product> products) {
		jPanelInit.setProduct(products);
		jPanelInit.repaint();
	}
	
	public void clearList() {
		jDialogReport.clearList();
	}

}