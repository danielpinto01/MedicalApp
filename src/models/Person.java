package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Person {

	private int id;

	private int posX;
	private int posY;
	private Place placeInit;
	private Place placeFinal;

	private boolean proxService;
	private Timer timer;

	public Person(int id, int posX, int posY, Place placeInit) {
		this.id = id;
		this.posX = posX;
		this.posY = posY;
		this.placeInit = placeInit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Place getPlaceInit() {
		return placeInit;
	}

	public void setPlaceInit(Place placeInit) {
		this.placeInit = placeInit;
	}

	public Place getPlaceFinal() {
		return placeFinal;
	}

	public void setPlaceFinal(Place placeFinal) {
		this.placeFinal = placeFinal;
	}

	public void movePerson() {
		if (placeInit != null && placeFinal != null) {
			if (posX < placeFinal.getPosX()) {
				posX += 5;
			}if (posX > placeFinal.getPosX()) {
				posX -= 5;
			}if (posY < placeFinal.getPosY()) {
				posY += 5;
			}if (posY > placeFinal.getPosY()) {
				posY -= 5;
			}
		}
		//		System.out.println("id" + id + " " + posX + "-" + posY);
	}

	public void initTimer() {
		//Tiempo que dura la persona en moverse de un servicio a otro
		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent t) {
				movePerson();
				if (validateFinalPosition() ) {
					setProxService(true);
				}				
			}
		});
		timer.start();
	}

	public void setProxService(boolean proxService) {
		this.proxService = proxService;
	}

	public boolean isProxService() {
		return proxService;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", posX=" + posX + ", posY=" + posY + ", placeInit=" + placeInit + ", placeFinal=" + placeFinal + "]";
	}

	public boolean validateFinalPosition() {
		if (placeInit != null && placeFinal != null) {
			if (getPosX() == placeFinal.getPosX() && getPosY() == placeFinal.getPosY()) {
				return true;
			}
		}
		return false;
	}
}