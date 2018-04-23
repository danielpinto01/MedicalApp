package models;

public class MyStack {

	private Node headNode;

	public void addNode(Node node){
		node.setNextNode(headNode);
		headNode = node;
	}
	
	public Node deleteNode(){
		Node actualNode = headNode;
		if(headNode != null){
			headNode = headNode.getNextNode();
		}
		actualNode.setNextNode(null);
		return actualNode;
	}
	
	public void deleteAll(){
		while(headNode != null){
			headNode = headNode.getNextNode();
		}
		headNode = null;
	}
}