package models;

import java.util.ArrayList;

public class Manager {
	
	private MyQueue myQueue;
	
	public Manager() {
		myQueue = new MyQueue();
	}
	
	public static Person createPerson(int id){
		return new Person(id);
	}
	
	public void addPersonToList(int id){
		myQueue.addLastNode(new Node(new Person(id)));
	}
	
	public void print() {
		myQueue.print();
	}
	
	public ArrayList<Node> getInfoList() {
		return myQueue.getInfoList();
	}
}