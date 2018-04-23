package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JDialogAbout extends JDialog{

	private static final long serialVersionUID = 1L;
	private JLabel jLabelAbout;
	private JPanel jPanelAbout;

	public JDialogAbout(MainWindow mainWindow) {
		super(mainWindow, true);
		setLayout(new GridLayout(1, 1));
		setTitle("About");
		setSize(300, 80);
		setLocationRelativeTo(null);
		
		jLabelAbout = new JLabel("Daniel F Pinto C - 201614122 - v1.0");
		jLabelAbout.setBackground(Color.decode("#1976D2"));
		jLabelAbout.setForeground(Color.BLACK);
		jLabelAbout.setFont(new Font("Century Gothic", 0,16));
		jPanelAbout = new JPanel();
		jPanelAbout.setBackground(Color.decode("#1976D2"));
		jPanelAbout.add(jLabelAbout);
		add(jPanelAbout);
	}
}