package test;

import models.MyStack;
import models.NodeProduct;
import models.Place;
import models.Product;

public class Test {

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.addFirst(new NodeProduct(new Product(0, 200, 200, Place.PHARMACY)));
		myStack.addFirst(new NodeProduct(new Product(1, 200, 200, Place.PHARMACY)));
		myStack.addFirst(new NodeProduct(new Product(2, 200, 200, Place.PHARMACY)));
		myStack.getFirst();
		myStack.print();
	}
}