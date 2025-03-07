package fractal;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunMyFractal {
	
	private static final long serialVersionUID = 1L;
	

	public RunMyFractal() {
		createFrame();
	}
	
	
	private void createFrame() {
		JFrame frame = new JFrame("Daniel's Fractal");
		frame.setSize(1000, 900);
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("IMAGE_ICON.png"));
		frame.setIconImage(icon.getImage());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel drawingPanel = new JPanel();
		drawingPanel.setBackground(Color.BLACK);
		InformationPanel infoPanel = new InformationPanel();
		
		frame.add(drawingPanel, BorderLayout.CENTER);
		frame.add(infoPanel, BorderLayout.EAST);
		
		frame.setVisible(true);
	}
	
	
	public static void main(String[]args) {
		new RunMyFractal();
	}
	
}
