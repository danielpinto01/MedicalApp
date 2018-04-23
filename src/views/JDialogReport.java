package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JDialog;

import controllers.Controller;

public class JDialogReport extends JDialog{
	
	private static final long serialVersionUID = 1L;
	
	public JDialogReport(MainWindow mainWindow, Controller controller) {
		super(mainWindow, true);
		setTitle("Reports");
		setLayout(new GridLayout(3, 1));
		setSize(500, 300);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(mainWindow);
	}
	
	public void init() {
		
	}
}