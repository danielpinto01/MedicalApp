package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import models.Manager;
import models.Person;
import models.Place;
import models.Product;
import sun.security.krb5.internal.ktab.KeyTabConstants;
import views.MainWindow;

public class Controller implements ActionListener, KeyListener{

	private MainWindow mainWindow;
	private Manager manager;
	private Timer timer;
	private Person person;
	private Product product;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		manager = new Manager();
		showDialoginit();
		showPanelinit();
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case INIT:
			mainWindow.ocultDialogInit();
			initApp();
			mainWindow.addProduct(manager.getProductList());
			break;
		case SHOW_DIALOG_REPORTS:
			addPerson();
			mainWindow.showDialogReports();
			showDialoginit();
			showPanelinit();
			break;
		case PRINT_TABLE:
			printTable();
			break;
		default:
			break;
		}
	}
	
	public void addProduct(int numberProduct) {
		int posX = 10;
		for (int i = 0; i < numberProduct; i++) {
			product = new Product(i, posX, 10, Place.PHARMACY);
			manager.addProductToStack(product);
//			System.out.println(product.getIdProduct());
			posX += 20;
		}
	}
	
	public void initApp() {
		addPersons(getNumberPerson(mainWindow.getTextNumberPerson()));
		addProduct(getNumberPerson(mainWindow.getTextNumberPerson()));
		manager.initSimulator();
	
		//Tiempo de lugar a lugar
		timer = new Timer(new Random().nextInt(100), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent t) {
				mainWindow.addPerson(manager.getList());
			}
		});
		timer.start();
	}

	public void starTimerC() {
		timer.start();
	}

	public int getNumberPerson(int numberPerson) {
		return numberPerson;
	}
	
	public int getTime(int time) {
		return time;
	}
	
	public void showDialoginit() {
		mainWindow.showDialoginit();
	}

	public void showPanelinit() {
		mainWindow.showPanelinit();
	}

	public void addPersons(int numberPerson) {
		int posX = 1900;
		for (int i = 0; i < numberPerson; i++) {
			person = new Person(i, posX, 400, Place.INIT);
			person.setPlaceFinal(manager.calculateService(person));
			manager.addPersonToList(person);
			posX += 50;
		}
	}
	
	public void sendPersonToList() {
		ArrayList<Person> personList = manager.getPersonListToTable();
		for (Person person : personList) {
			mainWindow.addToTable(person);
//			System.out.println(person);
		}
//		System.out.println(personList);
	}
	
	public void clearList() {
		mainWindow.clearList();
	}
	
	public void addPerson() {
		manager.addpersonToListTable(person);
		clearList();
		sendPersonToList();
	}
	
	public void printTable() {
		try {
			mainWindow.printTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(mainWindow, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}