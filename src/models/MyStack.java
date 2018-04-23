package models;

public class MyStack {

	private NodeProduct headNode;

	public void addFirst(NodeProduct node) {
		NodeProduct actual = headNode;
		if (actual != null) {
			node.setNextNode(headNode);
			headNode = node;
		} else {
			headNode = node;
		}
	}
	
	public NodeProduct getFirst() {
		NodeProduct first = headNode;
		headNode = headNode.getNextNode();
		first.setNextNode(null);
		return first;
	}
	
	public void print() {
		NodeProduct actual = headNode;
		while (actual != null) {
			System.out.println(actual.getProduct());
			actual = actual.getNextNode();
		}
	}
	
	public NodeProduct getHead() {
		return headNode;
	}
}