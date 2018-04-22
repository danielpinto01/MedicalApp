package models;

import java.util.ArrayList;

public class MyQueue {

	private Node rootNode;

	public void addLastNode(Node node){
		Node actualNode = rootNode;
		if (actualNode != null) {
			while (actualNode.getNextNode() != null) {
				actualNode = actualNode.getNextNode();
			}
			actualNode.setNextNode(node);
		}else {
			rootNode = node;
		}
	}
	

	public Node removeFirstNode(){
		Node first = rootNode;
		rootNode = rootNode.getNextNode();
		first.setNextNode(null);
		return first;
	}
	
	public void print() {
		Node actualNode = rootNode;
		int count = 0;
		while (actualNode != null) {
			System.out.println(count++ + " - "+ actualNode.getPerson());
			actualNode = actualNode.getNextNode();
		}
	}
	
	public ArrayList<Node> getInfoList() {
		ArrayList<Node> list = new ArrayList<>();
		Node actualNode = rootNode;
		while (actualNode != null) {
			list.add(actualNode);
			actualNode = actualNode.getNextNode();
		}
		return list;
	}
	
	
	public int size() {
		int size = 0;
		Node actualNode = rootNode;
		while (actualNode != null) {
			size++;
			actualNode = actualNode.getNextNode();
		}
		return size;
	}

	public Node getRootNode() {
		return rootNode;
	}


	public void delete(Node node) {
		Node actualNode = rootNode;
		if (node == actualNode) {
			rootNode = actualNode.getNextNode();
		}else {
			
			while (actualNode != null) {
				if (node == actualNode.getNextNode()) {
					actualNode.setNextNode(node.getNextNode());
				}
				actualNode = actualNode.getNextNode();
			}
		}
	}	
}