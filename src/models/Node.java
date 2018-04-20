package models;

public class Node {

	private Person person;
	private Node nextNode;
	
	public Node(Person person, Node nextNode) {
		this.person = person;
		this.nextNode = nextNode;
	}
	
	public Node(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return "Person ID:" + person + " NextNode:" + nextNode;
	}
}