package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import models.Manager;
import models.Person;
import models.Place;
import views.MainWindow;

public class Controller implements ActionListener{

	private MainWindow mainWindow;
	private Manager manager;
	private Timer timer;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		manager = new Manager();
		showDialoginit();
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case INIT:
			mainWindow.ocultDialogInit();
			initApp();
			break;
		case STOP:
//			manager.stopSimulator();
//			timer.stop();
			break;
		default:
			break;
		}
	}
	
	
	public void initApp() {
		showPanelinit();
		addPersons(getNumberPerson(mainWindow.getTextNumberPerson()));
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
		int posX = 1200;
		for (int i = 0; i < numberPerson; i++) {
			Person person = new Person(i, posX, 400, Place.INIT);
			person.setPlaceFinal(manager.calculateService(person));
			manager.addPersonToList(person);
			posX += 80;
		}
	}


}
