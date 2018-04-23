package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimeZone;

import javax.swing.Timer;

public class Manager {

	private MyQueue myQueue;
	private MyTree myTree;

	private Timer timer;
	private ArrayList<Person> personList;
	private Person person;
	
	private MyStack myStack;
	private ArrayList<Product> productList;

	public Manager() {
		myQueue = new MyQueue();
		personList = new ArrayList<>();
		myStack = new MyStack();
		productList = new ArrayList<>();
		initTree();
	}


	public void initTree() {
		NodePlace init = new NodePlace(Place.INIT);
		NodePlace query = new NodePlace(Place.QUERY);
		NodePlace quote = new NodePlace(Place.QUOTE);
		NodePlace emergency = new NodePlace(Place.EMERGENCY_QUERY);
		NodePlace normal = new NodePlace(Place.NORMAL_QUERY);
		NodePlace pharmacy = new NodePlace(Place.PHARMACY);
		NodePlace billing = new NodePlace(Place.BILLING);
		NodePlace pharmacyTwo = new NodePlace(Place.PHARMACY);
		NodePlace billingTwo = new NodePlace(Place.BILLING);
		NodePlace billingTree = new NodePlace(Place.BILLING);
		NodePlace exit = new NodePlace(Place.EXIT);
		myTree = new MyTree(init);
		myTree.addNode(init, query);
		myTree.addNode(init, quote);
		myTree.addNode(query, emergency);
		myTree.addNode(query, normal);
		myTree.addNode(emergency, pharmacy);
		myTree.addNode(normal, pharmacyTwo);
		myTree.addNode(pharmacy, billing);
		myTree.addNode(pharmacyTwo, billingTwo);
		myTree.addNode(quote, billingTree);
		myTree.addNode(billing, exit);
		myTree.print();
	}

	public ArrayList<Person> getList() {
		Node node = myQueue.getRootNode();
		ArrayList<Person> persons = new ArrayList<>();
		while (node != null) {
			persons.add(node.getPerson());
			node = node.getNextNode();
		}
		return persons;
	}

	public void initSimulator() {
		Node node = myQueue.getRootNode();
		while (node != null) {
			node.getPerson().initTimer();
			node = node.getNextNode();
		}
		timer = new Timer(100, new ActionListener() {
			//			timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent t) {
				Node node = myQueue.getRootNode();
				while (node != null) {
//					System.out.println(node.getPerson().getId() + "   --------> ");
					Person person = node.getPerson();
					if (person.isProxService()) {
						person.setPlaceInit(person.getPlaceFinal());
						person.setPlaceFinal(calculateService(person));
						person.setProxService(false);
						timer.setDelay(new Random().nextInt(10000));
					}
					if (person.getPlaceFinal() == null) {
						person.setEnd(System.currentTimeMillis());
//						DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
//						df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
//						System.out.println(df.format(new Date((long)person.getEnd())));
						personList.add(person);
						myQueue.delete(node);
					}
					node = node.getNextNode();
				}
			}
		});
		timer.start();
	}

	public void getTime() {
		for (Person person : personList) {
			DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
			df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
			System.out.println(df.format(new Date((long)person.getEnd())));
//			System.out.println("id " + person.getId() + " ti " + (person.getEnd() - person.getInit()));
		}
	}
	
	
	public Place calculateService(Person person) {
		NodePlace auxNode = myTree.searchNode(person.getPlaceInit());
		if (auxNode.getNodes().size() > 0) {
			int child = auxNode.getNodes().size();
//			System.out.println(child);
			Random random = new Random();
			int position = random.nextInt(child);
			return auxNode.getNodes().get(position).getPlace();
		}
		return null;
	}

	public void stopTimerPerson() {
		myQueue.getRootNode().getPerson().stopTimerPerson();
	}

	public void stopTimerManager() {
		timer.stop();
	}

	public MyTree getMyTree() {
		return myTree;
	}

	public void addPersonToList(Person person){
		myQueue.addLastNode(new Node(person));
	}

	public void print() {
		myQueue.print();
	}

	public ArrayList<Node> getInfoList() {
		return myQueue.getInfoList();
	}
	
	
	public void addpersonToListTable(Person person) {
		personList.add(person);
	}

	public ArrayList<Person> getPersonListToTable() {
		return personList;
	}


	public void setPersonListToTable(ArrayList<Person> personList) {
		this.personList = personList;
	}


	public MyQueue getMyQueue() {
		return myQueue;
	}
	
	public MyStack getMyStack() {
		return myStack;
	}

	public void setMyStack(MyStack myStack) {
		this.myStack = myStack;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}


	public void addProductToStack(Product product) {
		myStack.addFirst(new NodeProduct(product));
	}
}