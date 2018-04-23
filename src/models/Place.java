package models;

import javax.swing.ImageIcon;

public enum Place {
	
	QUERY(1400, 50, "Consulta", "/images/consulta.png"), 
	QUOTE(1400, 600, "Cita","/images/quote.png"), 
	EMERGENCY_QUERY(1000, 300, "Emergencia", "/images/emergency.png"), 
	NORMAL_QUERY(500, 100, "General", "/images/general.png"), 
	PHARMACY(800, 800, "Farmacia", "/images/farmacia.png"), 
	BILLING(300, 500, "facturacion", "/images/facturacion.png"), 
	INIT(1800, 400, "Entrada", "/images/init.png"),
	EXIT(-100, 400, "Salida", "/images/exit.png");
	
//	QUERY(1000, 50, "Consulta", "/images/consulta.png"), 
//	QUOTE(50, 800, "Cita","/images/quote.png"), 
//	EMERGENCY_QUERY(300, 50, "Emergencia", "/images/emergency.png"), 
//	NORMAL_QUERY(500, 50, "General", "/images/general.png"), 
//	PHARMACY(400, 400, "Farmacia", "/images/farmacia.png"), 
//	BILLING(900, 600, "facturacion", "/images/facturacion.png"), 
//	INIT(1400, 300, "Entrada", "/images/init.png"),
//	EXIT(1400, 600, "Salida", "/images/exit.png");
	
	
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