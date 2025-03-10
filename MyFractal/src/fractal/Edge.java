package fractal;

/**
 * The Edge class creates edges for the polygon and fractal to be used in the
 * program. It gives valuable information used to draw the fractal.
 * 
 * @author Daniel Santillan
 * @version 1.0
 */
public class Edge {

	/** The length of the edge */
	private int length;
	/** The x-coordinate of the starting point */
	private int startingX;
	/** The y-coordinate of the ending point */
	private int startingY;
	/** The x-coordinate of the starting point */
	private int endingX;
	/** The y-coordinate of the ending point */
	private int endingY;
	/** The angle of the line in degrees (0 means horizontal) */
	private int angle;
	
	
	/**
	 * The Edge constructor initializes the fields and assigns them a value.
	 * 
	 * @param length The length of the edge
	 * @param startingX The x-coordinate of the starting point
	 * @param startingY The y-coordinate of the starting point
	 * @param endingX The x-coordinate of the ending point
	 * @param endingY The y-coordinate of the ending point
	 * @param angle The angle of the line in degrees
	 */
	public Edge(int length, int startingX, int startingY, int endingX, int endingY, int angle) {
		this.length = length;
		this.startingX = startingX;
		this.startingY = startingY;
		this.endingX = endingX;
		this.endingY = endingY;
		this.angle = angle;
	}

	
	/**
	 * Returns the length of the edge.
	 * 
	 * @return The length of the edge
	 */
	public int getLength() {
		return length;
	}
	

	/**
	 * Returns the x-coordinate of the starting point.
	 * 
	 * @return The x-coordinate of the starting point
	 */
	public int getStartingX() {
		return startingX;
	}


	/**
	 * Returns the y-coordinate of the starting point.
	 * 
	 * @return The y-coordinate of the starting point
	 */
	public int getStartingY() {
		return startingY;
	}

	
	/**
	 * Returns the x-coordinate of the ending point.
	 * 
	 * @return The x-coordinate of the ending point
	 */
	public int getEndingX() {
		return endingX;
	}


	/**
	 * Returns the y-coordinate of the ending point.
	 * 
	 * @return The y-coordinate of the ending point
	 */
	public int getEndingY() {
		return endingY;
	}
	
	
	/**
	 * Returns the angle of the edge.
	 * 
	 * @return the angle of the edge in degrees
	 */
	public int getAngle() {
		return angle;
	}


	/**
	 * This is a simple toString that returns the field values for this class.
	 * 
	 * @return the field values for this class
	 */
	@Override
	public String toString() {
		return "Edge [length=" + length + ", startingX=" + startingX + ", startingY=" + startingY + ", endingX="
				+ endingX + ", endingY=" + endingY + ", angle=" + angle + "]";
	}
}
