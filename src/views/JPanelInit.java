package views;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Person;
import models.Place;

public class JPanelInit extends JPanel{

	private static final long serialVersionUID = 1L;
	private ArrayList<Person> personList;
	//	private Person person;

	public JPanelInit() {
		setBackground(Color.PINK);
		personList = new ArrayList<>();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		removeAll();
		g.drawImage(Place.QUERY.getImage().getImage(), Place.QUERY.getPosX(), Place.QUERY.getPosY(), 150, 150, this);
		g.drawImage(Place.QUOTE.getImage().getImage(), Place.QUOTE.getPosX(), Place.QUOTE.getPosY(), 150, 150, this);
		g.drawImage(Place.EMERGENCY_QUERY.getImage().getImage(), Place.EMERGENCY_QUERY.getPosX(), Place.EMERGENCY_QUERY.getPosY(), 150, 150, this);
		g.drawImage(Place.NORMAL_QUERY.getImage().getImage(), Place.NORMAL_QUERY.getPosX(), Place.NORMAL_QUERY.getPosY(), 150, 150, this);
		g.drawImage(Place.PHARMACY.getImage().getImage(), Place.PHARMACY.getPosX(), Place.PHARMACY.getPosY(), 150, 150, this);
		g.drawImage(Place.BILLING.getImage().getImage(), Place.BILLING.getPosX(), Place.BILLING.getPosY(), 150, 150, this);
		g.drawImage(Place.INIT.getImage().getImage(), Place.INIT.getPosX(), Place.INIT.getPosY(), 150, 150, this);
		g.drawImage(Place.EXIT.getImage().getImage(), Place.EXIT.getPosX(), Place.EXIT.getPosY(), 150, 150, this);

		for (Person person : personList) {
//			g.drawLine(1900, 400, person.getPosX(), person.getPosY());
			if (person.getPlaceInit() == Place.PHARMACY) {
				g.drawImage(new ImageIcon(getClass().getResource("/images/pill.png")).getImage(), person.getPosX(),  person.getPosY(), 60, 60, this);
			}else {
				g.drawImage(new ImageIcon(getClass().getResource("/images/cam.gif")).getImage(), person.getPosX(),  person.getPosY(), 60, 60, this);
			}
//			g.drawString(String.valueOf(person.getId()), person.getPosX(), person.getPosY());

		}
	}


public void remove() {
	revalidate();
	repaint();
	removeAll();
}

public void setPerson(ArrayList<Person> persons) {
	this.personList = persons;
}
}