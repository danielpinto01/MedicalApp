package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.Controller;
import models.Person;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanelInit jPanelInit;

	public MainWindow(Controller controller) {
		setBackground(Color.BLACK);
		setTitle("Medical App v1.0");
		setLayout(new BorderLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/images/iconApp.png")).getImage());
		
		init();

		setVisible(true);
	}
	
	public int getHeightPanel() {
		return jPanelInit.getHeight();
	}
	
	public int getWidhtPanel() {
		return jPanelInit.getWidth();
	}

	public void init() {
		jPanelInit = new JPanelInit();
		add(jPanelInit, BorderLayout.CENTER);
	}
	
//	public void addPerson(Person person) {
//		jPanelInit.setPerson(person);
//		jPanelInit.repaint();
//	}
	
	public void addPerson(ArrayList<Person> persons) {
		jPanelInit.setPerson(persons);
		jPanelInit.repaint();
	}

}