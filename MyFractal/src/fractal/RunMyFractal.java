package fractal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;


/**
 * The RunMyFractal class runs the program that draws my custom fractal. This
 * includes code that reads in values from the information panel to draw the
 * fractal along with a swing worker to run the recursive drawing in a separate
 * thread.
 * 
 * @author Daniel Santillan
 * @version 1.0
 */
public class RunMyFractal {
	
	/** The width of the frame */
	private int width;
	/** The height of the frame */
	private int height;
	/** 
	 * The available width to use for drawing the fractal - this is the width
	 * minus several hundred pixels to account for the information panel on
	 * the right side.
	 */
	private int availableWidth;
	

	/**
	 * The runMyFractal constructor calls a method that creates the frame for
	 * the program. This is called at the start of the program.
	 */
	public RunMyFractal() {
		createFrame(1000, 900);
	}
	
	
	/**
	 * The createFrame method builds the frame for the program. It assigns
	 * initial attributes to the frame, such as the icon, close operation, etc.
	 * It also creates buttons and adds action listeners to them to be added
	 * into the information panel. Lastly, the information and drawing panels
	 * are appended to the frame, which is set visible.
	 * 
	 * @param givenWidth the given width
	 * @param givenHeight the given height
	 */
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
		
		DrawingPanel drawingPanel = new DrawingPanel();
		
		JButton drawButton = new JButton("Draw!");
		JButton clearButton = new JButton("Clear");
		InformationPanel infoPanel = new InformationPanel(drawButton, clearButton);
		
		drawButton.addActionListener(new ActionListener() {

			/**
			 * The action listener for the "draw" button begins work to draw
			 * the fractal. It makes sure that input values from the information
			 * panel are within limits, otherwise executing a JOptionPane message
			 * dialog. If all values are good, a polygon is created with the
			 * given side count and max edge size. Additionally, a fractal
			 * is made using the polygon. If the user checks off the boxes to
			 * draw the shape and the fractal, both the shape and the fractal
			 * will be drawn.
			 * 
			 * @param e the ActionEvent triggering the method
			 */
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
				} else if (timerPause > 2000) {
					JOptionPane.showMessageDialog(null, "lol i get you want to wait but i don't want to destroy your pc.",
							"Failed to Run", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				width = 1000 + 3*(maxEdgeSize-200);
				height = 900 + (maxEdgeSize-200);
				availableWidth = 700 + 3*(maxEdgeSize-200);
				frame.setSize(width, height);
				
				MyPolygon polygon = new MyPolygon(numSides, maxEdgeSize, availableWidth, height);
				Fractal fractal = new Fractal(polygon.getEdges(), minEdgeSize);
				
				drawingPanel.clear(drawingPanel.getGraphics());
				if (isShapeDrawn) {
					drawingPanel.paintShape(drawingPanel.getGraphics(), polygon.getEdges(), timerPause);
				}
				
				if (isFractalDrawn) {
					createSwingWorker(drawingPanel, fractal, timerPause, drawButton);
				}

			}
			
		});
		
		clearButton.addActionListener(new ActionListener() {

			/**
			 * The action listener for the "clear" button acts as an eraser
			 * that removes any previous fractal from the screen.
			 * 
			 * @param e the ActionEvent triggering the method
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.clear(drawingPanel.getGraphics());
			}
			
		});
		
		frame.add(drawingPanel, BorderLayout.CENTER);
		frame.add(infoPanel, BorderLayout.EAST);
		
		frame.setVisible(true);
	}
	
	
	/**
	 * The createSwingWorker method creates a swing worker to run the drawing
	 * of the fractal in a background thread, thus allowing users to work with
	 * the information panel while the fractal process is running. While the
	 * process runs, the "draw" button cannot be pressed.
	 * 
	 * @param drawingPanel the DrawingPanel to be used
	 * @param fractal the fractal to be drawn
	 * @param timerPause the pause between lines drawn on the fractal
	 * @param button the JButton that triggers the fractal to be drawn
	 */
	public void createSwingWorker(DrawingPanel drawingPanel, Fractal fractal, int timerPause, JButton button) {
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

			/**
			 * The doInBackground method contains the method to draw the
			 * fractal, which is done in this background thread. 
			 * 
			 * @throws Exception simple exception
			 */
			@Override
			protected Void doInBackground() throws Exception {
				drawingPanel.paintFractalShape(drawingPanel.getGraphics(), fractal.drawFractal(), timerPause);
				return null;
			}

			/**
			 * The done method allows the draw button to be pressed again.
			 */
			@Override
			protected void done() {
				button.setEnabled(true);
			}
		};
		
		button.setEnabled(false);
		worker.execute();
	}
	
	
	/**
	 * The main method calls the RunMyFractal constructor, which creates
	 * the frame for the program.
	 * 
	 * @param args The main method arguments
	 */
	public static void main(String[]args) {
		new RunMyFractal();
	}


	/**
	 * This is a simple toString that returns the field values for this class.
	 * 
	 * @return the field values for this class
	 */
	@Override
	public String toString() {
		return "RunMyFractal [width=" + width + ", height=" + height + ", availableWidth=" + availableWidth + "]";
	}
	
}
