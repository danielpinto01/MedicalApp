package models;

import javax.swing.ImageIcon;

public enum Place {
	
	QUERY(1000, 50, "Consulta", "/images/consulta.png"), 
	QUOTE(50, 800, "Cita","/images/quote.png"), 
	EMERGENCY_QUERY(300, 50, "Emergencia", "/images/emergency.png"), 
	NORMAL_QUERY(500, 50, "General", "/images/general.png"), 
	PHARMACY(400, 400, "Farmacia", "/images/farmacia.png"), 
	BILLING(900, 600, "facturacion", "/images/facturacion.png"), 
	INIT(1400, 400, "facturacion", "/images/init.png");
	
	private int posX, posY;
	private String name;
	private String image;

	private Place(int posX, int posY, String name, String image) {
		this.posX = posX;
		this.posY = posY;
		this.name = name;
		this.image = image;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public String getName() {
		return name;
	}

	public ImageIcon getImage() {
		return new ImageIcon(getClass().getResource(image));
	}
}