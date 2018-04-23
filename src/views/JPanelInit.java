package views;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Person;
import models.Place;
import models.Product;

public class JPanelInit extends JPanel{

	private static final long serialVersionUID = 1L;
	private ArrayList<Person> personList;
	private ArrayList<Product> productList;
	//	private Person person;

	public JPanelInit() {
//		setBackground(Color.decode("#64B5F6"));
		setBackground(Color.DARK_GRAY);
		personList = new ArrayList<>();
		productList = new ArrayList<>();
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
		
		g.drawImage(new ImageIcon(getClass().getResource("/images/welcome.png")).getImage(), 1750,  80, 150, 150, this);
		g.drawImage(new ImageIcon(getClass().getResource("/images/welcome.png")).getImage(), 1750,  210, 150, 150, this);
		g.drawImage(new ImageIcon(getClass().getResource("/images/welcome.png")).getImage(), 1750,  350, 150, 150, this);
		g.drawImage(new ImageIcon(getClass().getResource("/images/welcome.png")).getImage(), 1750,  490, 150, 150, this);
		g.drawImage(new ImageIcon(getClass().getResource("/images/welcome.png")).getImage(), 1750,  630, 150, 150, this);
		g.drawImage(new ImageIcon(getClass().getResource("/images/welcome.png")).getImage(), 1750,  770, 150, 150, this);

		g.drawImage(new ImageIcon(getClass().getResource("/images/exit.png")).getImage(), 0,  400, 130, 130, this);
		
		for (Person person : personList) {
			//			g.drawLine(1900, 400, person.getPosX(), person.getPosY());
			if (person.getPlaceInit() == Place.PHARMACY) {
				g.drawImage(new ImageIcon(getClass().getResource("/images/personLeft.png")).getImage(), person.getPosX(),  person.getPosY(), 90, 90, this);
				g.drawImage(new ImageIcon(getClass().getResource("/images/pill.png")).getImage(), person.getPosX(),  person.getPosY(), 40, 40, this);
			}else if (person.getPlaceInit() == Place.NORMAL_QUERY) {
				g.drawImage(new ImageIcon(getClass().getResource("/images/personRight.png")).getImage(), person.getPosX(),  person.getPosY(), 90, 90, this);
				
			}else {
				g.drawImage(new ImageIcon(getClass().getResource("/images/personLeft.png")).getImage(), person.getPosX(),  person.getPosY(), 90, 90, this);
			}
			//		g.drawString(String.valueOf(person.getId()), person.getPosX(), person.getPosY());
		}
		for (Product product : productList) {
			g.drawImage(new ImageIcon(getClass().getResource("/images/pill.png")).getImage(), product.getPosX(),  product.getPosY(), 50, 50, this);
//			System.out.println(product.getIdProduct());
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
	
	public void setProduct(ArrayList<Product> products) {
		this.productList = products;
	}
}