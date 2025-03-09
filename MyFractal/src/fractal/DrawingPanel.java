package fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public DrawingPanel() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	
	public void paintBaseShape(Graphics g, ArrayList<Edge> edges, int timerPause) {
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
	
	
	public void clear(Graphics g) {
		this.paintComponent(g);
	}
	
}
