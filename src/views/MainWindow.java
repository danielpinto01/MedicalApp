package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.print.PrinterException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.Controller;
import controllers.Events;
import models.Person;
import models.Product;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanelInit jPanelInit;
	private JPanel jPanelButtons;
	private JButton btnStop;
	private JButton btnReports;
	private JButton btnAbout;
	
	private JDialogInit jDialogInit;
	private JDialogReport jDialogReport;
	private JDialogAbout jDialogAbout; 

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
		jDialogAbout = new JDialogAbout(this);
		
		init(controller);

		setVisible(true);
	}
	
	public void showDialogAbout() {
		jDialogAbout.setVisible(true);
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
		jPanelButtons.setLayout(new GridLayout(3, 1));
		
		btnStop = new JButton("Exit");
		btnStop.addActionListener(controller);
		btnStop.setActionCommand(Events.EXIT.toString());
		btnStop.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		btnStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnStop.setBackground(Color.decode("#64B5F6"));
		btnStop.setForeground(Color.WHITE);
		btnStop.setFont(new Font("Century Gothic", 0,16));
		btnStop.setFocusable(false);
		
		btnReports = new JButton("Reports");
		btnReports.addActionListener(controller);
		btnReports.setActionCommand(Events.SHOW_DIALOG_REPORTS.toString());
		btnReports.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		btnReports.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnReports.setBackground(Color.decode("#1976D2"));
		btnReports.setForeground(Color.WHITE);
		btnReports.setFont(new Font("Century Gothic", 0,16));
		btnReports.setFocusable(false);
		
		btnAbout = new JButton("About");
		btnAbout.addActionListener(controller);
		btnAbout.setActionCommand(Events.SHOW_DIALOG_ABOUT.toString());
		btnAbout.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		btnAbout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAbout.setBackground(Color.decode("#2962FF"));
		btnAbout.setForeground(Color.WHITE);
		btnAbout.setFont(new Font("Century Gothic", 0,16));
		btnAbout.setFocusable(false);
		
		jPanelButtons.add(btnAbout);
		jPanelButtons.add(btnReports);
		jPanelButtons.add(btnStop);
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