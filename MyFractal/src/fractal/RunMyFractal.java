package fractal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RunMyFractal {
	
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private int availableWidth;
	

	public RunMyFractal() {
		createFrame(1000, 900);
	}
	
	
	private void createFrame(int givenWidth, int givenHeight) {
		width = givenWidth;
		height = givenHeight;
		availableWidth = givenWidth - 300;
		
		JFrame frame = new JFrame("Daniel's Fractal");
		frame.setSize(width, height);
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("IMAGE_ICON.png"));
		frame.setIconImage(icon.getImage());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel drawingPanel = new JPanel();
		drawingPanel.setBackground(Color.BLACK);
		
		JButton drawButton = new JButton("Draw!");
		JButton clearButton = new JButton("Clear");
		InformationPanel infoPanel = new InformationPanel(drawButton, clearButton);
		
		drawButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int numSides = infoPanel.getNumSides();
				int minEdgeSize = infoPanel.getMinEdgeSize();
				int maxEdgeSize = infoPanel.getMaxEdgeSize();
				int timerPause = infoPanel.getTimerPause();
				boolean isShapeDrawn = infoPanel.isShapeDrawn();
				boolean isFractalDrawn = infoPanel.isFractalDrawn();
				
				if (numSides <= 2 || numSides > 6) {
					JOptionPane.showMessageDialog(null, "Number of sides must be between 3 and 6.",
							"Failed to Run", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (minEdgeSize < 2) {
					JOptionPane.showMessageDialog(null, "Minimum edge side is too small... we cannot cause stack overflow, ya know.",
							"Failed to Run", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (minEdgeSize > maxEdgeSize) {
					JOptionPane.showMessageDialog(null, "Minimum edge size is larger than maximum edge size.",
							"Failed to Run", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (maxEdgeSize > 500) {
					JOptionPane.showMessageDialog(null, "Maximum edge side is too large ... your device may not show the entire shape.",
							"Failed to Run", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				width = 1000 + 3*(maxEdgeSize-200);
				height = 900 + 2*(maxEdgeSize-200);
				availableWidth = 700 + 3*(maxEdgeSize-200);
				frame.setSize(width, height);
				
			}
			
		});
		
		frame.add(drawingPanel, BorderLayout.CENTER);
		frame.add(infoPanel, BorderLayout.EAST);
		
		frame.setVisible(true);
	}
	
	
	public static void main(String[]args) {
		new RunMyFractal();
	}
	
}
