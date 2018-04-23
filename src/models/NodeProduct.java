package models;

public class NodeProduct {

	private Product product;
	private NodeProduct nextNode;

	public NodeProduct(Product product, NodeProduct nextNode) {
		this.product = product;
		this.nextNode = nextNode;
	}
	
	public NodeProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public NodeProduct getNextNode() {
		return nextNode;
	}
	public void setNextNode(NodeProduct nextNode) {
		this.nextNode = nextNode;
	}
	
	@Override
	public String toString() {
		return "P:" + product;
	}
}