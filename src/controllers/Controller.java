package controllers;

import java.util.ArrayList;

import models.Manager;
import models.Node;
import views.MainWindow;

public class Controller {
	
	@SuppressWarnings("unused")
	private MainWindow mainWindow;
	private Manager manager;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		manager = new Manager();
	}
	
	public void addPersonToList(int id){
		manager.addPersonToList(id);
	}
	
	public void print() {
		manager.print();
	}
	
	public ArrayList<Node> getInfoList() {
		return manager.getInfoList();
	}
}
