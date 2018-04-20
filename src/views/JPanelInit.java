package views;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelInit extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public JPanelInit() {
//		setBackground(Color.DARK_GRAY);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(new ImageIcon(getClass().getResource("/images/quote.png")).getImage(), 100, 100, 300, 300, this);
	}
}