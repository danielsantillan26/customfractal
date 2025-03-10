package fractal;

import java.util.ArrayList;

/**
 * The MyPolygon class is a representation of a polygon. It is made of edges
 * with particular sizes. The polygon has a center for reference. The polygon
 * created in this class will help the program draw the planned fractal.
 * 
 * @author Daniel Santillan
 * @version 1.0
 */
public class MyPolygon {

	/** The number of edges */
	private int numEdges;
	/** The size of the polygon's edges */
	private int maxEdgeSize;
	/** The x coordinate of the polygon's center */
	private int centerX;
	/** The y coordinate of the polygon's center */
	private int centerY;
	/** 
	 * The apothem (for triangles, squares, and hexagons) or the circumradius
	 * (for pentagons) used to help draw the shape
	 */
	private int radius;
	/** The list of edges of the polygon */
	private ArrayList<Edge> edges;


	/**
	 * The MyPolygon constructor creates the shape's edges. Using the center (which is
	 * established by the size of the program's frame) and the shape's radius,
	 * the edges are defined by their starting and ending coordinates. This
	 * will be used to draw the shape and the fractal. Depending on the number
	 * of edges input, the constructor can make a triangle, square, pentagon,
	 * or hexagon.
	 * 
	 * @param numEdgesInput The number of edges
	 * @param maxEdgeSizeInput The size of the polygon's edges
	 * @param availableWidthInput The available width of the frame
	 * @param heightInput The height of the frame
	 */
	public MyPolygon(int numEdgesInput, int maxEdgeSizeInput, int availableWidthInput, int heightInput) {
		centerX = availableWidthInput/2;
		centerY = heightInput/2;
		maxEdgeSize = maxEdgeSizeInput;

		numEdges = numEdgesInput;
		edges = new ArrayList<Edge>();

		if (numEdges == 3) {
			radius = (int)(maxEdgeSize * Math.sqrt(3.0)/2);
			edges.add(new Edge(maxEdgeSize, centerX-(maxEdgeSize/2), centerY-radius,
					centerX+(maxEdgeSize/2), centerY-radius, 0));
			edges.add(new Edge(maxEdgeSize, centerX+(maxEdgeSize/2), centerY-radius, centerX,
					centerY + maxEdgeSize*(int)(Math.sqrt(3.0)/3), 120));
			edges.add(new Edge(maxEdgeSize, centerX, centerY + maxEdgeSize*(int)(Math.sqrt(3.0)/3),
					centerX-(maxEdgeSize/2), centerY-radius, 240));
		} else if (numEdges == 4) {
			radius = maxEdgeSizeInput/2;
			edges.add(new Edge(maxEdgeSize, centerX-radius, 
					centerY-radius, centerX+radius, centerY-radius, 0));
			edges.add(new Edge(maxEdgeSize, centerX+radius, 
					centerY-radius, centerX+radius, centerY+radius, 90));
			edges.add(new Edge(maxEdgeSize, centerX+radius, 
					centerY+radius, centerX-radius, centerY+radius, 180));
			edges.add(new Edge(maxEdgeSize, centerX-radius, 
					centerY+radius, centerX-radius, centerY-radius, 270));

		} else if (numEdges == 5) {
			radius = (int)(maxEdgeSize/(2*Math.sin(Math.toRadians(36))));
			edges.add(new Edge(maxEdgeSize, (int)(centerX + radius * Math.cos(Math.toRadians(18))),
					(int)(centerY + radius * Math.sin(Math.toRadians(18))),
					(int)(centerX + radius * Math.cos(Math.toRadians(90))), 
					(int)(centerY + radius * Math.sin(Math.toRadians(90))), 144));
			edges.add(new Edge(maxEdgeSize, (int)(centerX + radius * Math.cos(Math.toRadians(90))),
					(int)(centerY + radius * Math.sin(Math.toRadians(90))),
					(int)(centerX + radius * Math.cos(Math.toRadians(162))), 
					(int)(centerY + radius * Math.sin(Math.toRadians(162))), 216));
			edges.add(new Edge(maxEdgeSize, (int)(centerX + radius * Math.cos(Math.toRadians(162))),
					(int)(centerY + radius * Math.sin(Math.toRadians(162))),
					(int)(centerX + radius * Math.cos(Math.toRadians(234))), 
					(int)(centerY + radius * Math.sin(Math.toRadians(234))), 288));
			edges.add(new Edge(maxEdgeSize, (int)(centerX + radius * Math.cos(Math.toRadians(234))),
					(int)(centerY + radius * Math.sin(Math.toRadians(234))),
					(int)(centerX + radius * Math.cos(Math.toRadians(306))), 
					(int)(centerY + radius * Math.sin(Math.toRadians(306))), 0));
			edges.add(new Edge(maxEdgeSize, (int)(centerX + radius * Math.cos(Math.toRadians(306))),
					(int)(centerY + radius * Math.sin(Math.toRadians(306))),
					(int)(centerX + radius * Math.cos(Math.toRadians(18))), 
					(int)(centerY + radius * Math.sin(Math.toRadians(18))), 72));
		} else {
			radius = (int)((maxEdgeSize*Math.sqrt(3))/2);
			edges.add(new Edge(maxEdgeSize, centerX-(maxEdgeSize/2), centerY - radius,
					centerX+(maxEdgeSize/2), centerY-radius, 0));
			edges.add(new Edge(maxEdgeSize, centerX+(maxEdgeSize/2), centerY-radius,
					centerX+maxEdgeSize, centerY, 60));		
			edges.add(new Edge(maxEdgeSize, centerX+maxEdgeSize, centerY,
					centerX+(maxEdgeSize/2), centerY+radius, 120));
			edges.add(new Edge(maxEdgeSize, centerX+(maxEdgeSize/2), centerY+radius,
					centerX-(maxEdgeSize/2), centerY+radius, 180));
			edges.add(new Edge(maxEdgeSize, centerX-(maxEdgeSize/2), centerY+radius, 
					centerX - maxEdgeSize, centerY, 240));
			edges.add(new Edge(maxEdgeSize, centerX-maxEdgeSize, centerY,
					centerX-(maxEdgeSize/2), centerY - radius, 300));

		}

	}


	/**
	 * The getEdges method returns the edges list.
	 * 
	 * @return the edges list.
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}


	/**
	 * This is a simple toString that returns the field values for this class.
	 * 
	 * @return the field values for this class
	 */
	@Override
	public String toString() {
		return "MyPolygon [numEdges=" + numEdges + ", maxEdgeSize=" + maxEdgeSize + ", centerX=" + centerX
				+ ", centerY=" + centerY + ", radius=" + radius + ", edges=" + edges + "]";
	}
}
