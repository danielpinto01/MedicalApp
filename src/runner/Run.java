package runner;

import controllers.Controller;

public class Run {
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.addPersonToList(12);
		controller.addPersonToList(13);
		controller.addPersonToList(14);
		controller.addPersonToList(15);
//		controller.print();
		System.out.println(controller.getInfoList());
	}
}
