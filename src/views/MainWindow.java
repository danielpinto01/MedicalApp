package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.Controller;

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

	public void init() {
		jPanelInit = new JPanelInit();
		add(jPanelInit, BorderLayout.CENTER);
	}

}