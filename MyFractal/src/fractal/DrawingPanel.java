package fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

/**
 * The DrawingPanel class creates the drawing panel for the program. This is
 * where the fractal and other base shapes are drawn.
 * 
 * @author Daniel Santillan
 * @version 1.0
 */
public class DrawingPanel extends JPanel {

	/** Version */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * This is a simple constructor that does nothing.
	 */
	public DrawingPanel() {	
	}
	
	
	/**
	 * The paintComponent method creates the black screen for the drawing panel.
	 * 
	 * @param g the graphics object
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	
	/**
	 * The paintShape method draws a shape based on the edges and the timer
	 * pause, which sleeps the thread for a set amount of time between edges.
	 * 
	 * @param g the graphics object
	 * @param edges the edges to draw
	 * @param timerPause the timer pause
	 */
	public void paintShape(Graphics g, ArrayList<Edge> edges, int timerPause) {
		for (Edge edge : edges) {
			int colorChoice = (int)(Math.random()*11);
			switch (colorChoice) {
				case 0:
					g.setColor(Color.RED);
					break;
				case 1:
					g.setColor(Color.ORANGE);
					break;
				case 2:
					g.setColor(Color.YELLOW);
					break;
				case 3:
					g.setColor(Color.GREEN);
					break;
				case 4:
					g.setColor(Color.BLUE);
					break;
				case 5:
					g.setColor(Color.CYAN);
					break;
				case 6:
					g.setColor(Color.MAGENTA);
					break;
				case 7:
					g.setColor(Color.PINK);
					break;
				case 8:
					g.setColor(Color.WHITE);
					break;
				case 9:
					g.setColor(Color.LIGHT_GRAY);
					break;
				case 10:
					g.setColor(Color.GRAY);
					break;
			}
			g.drawLine(edge.getStartingX(), edge.getStartingY(), edge.getEndingX(), edge.getEndingY());
			try {
				Thread.sleep(timerPause);
			} catch (Exception e) {
				
			}
		}
	}
	
	
	/**
	 * The paintFractalShape draws the list of edges in reverse order to have
	 * the fractal build from the base level up. Once the list is reversed,
	 * the paintShape method is called.
	 * 
	 * @param g the graphics object
	 * @param edges the list of fractal edges
	 * @param timerPause the timer pause
	 */
	public void paintFractalShape(Graphics g, ArrayList<Edge> edges, int timerPause) {
		Collections.reverse(edges);
		paintShape(g, edges, timerPause);
	}
	
	
	/**
	 * The clear method cleans up the drawing panel and clears it of any edges.
	 * 
	 * @param g the graphics object
	 */
	public void clear(Graphics g) {
		this.paintComponent(g);
	}


	/**
	 * This is a simple toString.
	 * 
	 * @return a simple string message
	 */
	@Override
	public String toString() {
		return "DrawingPanel []";
	}
	
}
