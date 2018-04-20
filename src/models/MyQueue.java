package models;

public class MyQueue {

	private Node firstNode;

	public void addLastNode(Node node){
		Node actualNode = firstNode;
		if (actualNode != null) {
			while (actualNode.getNextNode() != null) {
				actualNode = actualNode.getNextNode();
			}
			actualNode.setNextNode(node);
		}else {
			firstNode = node;
		}
	}

	public Node removeFirstNode(){
		Node first = firstNode;
		firstNode = firstNode.getNextNode();
		first.setNextNode(null);
		return first;
	}
}