package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.Controller;
import controllers.Events;
import models.Person;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanelInit jPanelInit;
	private JPanel jPanelButtons;
	private JButton btnStop;
	private JButton btnReports;
	
	private JDialogInit jDialogInit;

	public MainWindow(Controller controller) {
		setBackground(Color.BLACK);
		setTitle("Medical App v1.0");
		setLayout(new BorderLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/images/iconApp.png")).getImage());
		
		jDialogInit = new JDialogInit(this, controller);
		
		init(controller);

		setVisible(true);
	}
	
	public void showDialoginit() {
		jPanelInit.setVisible(false);
		jDialogInit.setVisible(true);
//		removeAll();
	}
	
	public void showPanelinit() {
		jPanelInit.setVisible(true);
	}
	
	public void ocultDialogInit() {
		jDialogInit.setVisible(false);
	}
	
	
	public int getHeightPanel() {
		return jPanelInit.getHeight();
	}
	
	public int getWidhtPanel() {
		return jPanelInit.getWidth();
	}

	public void init(Controller controller) {
		jPanelInit = new JPanelInit();
		add(jPanelInit, BorderLayout.CENTER);
		jPanelButtons = new JPanel();
		jPanelButtons.setLayout(new GridLayout(2, 1));
		btnStop = new JButton("Stop");
		btnStop.addActionListener(controller);
		btnStop.setActionCommand(Events.STOP.toString());
		btnReports = new JButton("Reports");
		jPanelButtons.add(btnStop);
		jPanelButtons.add(btnReports);
		add(jPanelButtons, BorderLayout.EAST);
	}
	
//	public void addPerson(Person person) {
//		jPanelInit.setPerson(person);
//		jPanelInit.repaint();
//	}
	
	public void remove() {
		jPanelInit.remove();
	}
	
	public int getTextNumberPerson() {
		return jDialogInit.getTextNumberPerson();
	}
	
	public int getTexttime() {
		return jDialogInit.getTexttime();
	}
	
	public void addPerson(ArrayList<Person> persons) {
		jPanelInit.setPerson(persons);
		jPanelInit.repaint();
	}

}