package models;

public class Product {

	private int idProduct;
	private int posX;
	private int posY;
	private Place place;
	
	public Product(int idProduct, int posX, int posY, Place place) {
		this.idProduct = idProduct;
		this.posX = posX;
		this.posY = posY;
		this.place = place;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
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
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	
	@Override
	public String toString() {
		return "Id:" + idProduct + ", posX=" + posX + ", posY=" + posY + ", place=" + place;
	}
}