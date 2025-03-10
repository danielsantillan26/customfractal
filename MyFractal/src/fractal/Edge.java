package fractal;

public class Edge {

	private int length;
	private int startingX;
	private int startingY;
	private int endingX;
	private int endingY;
	private int angle;
	
	
	public Edge(int length, int startingX, int startingY, int endingX, int endingY, int angle) {
		this.length = length;
		this.startingX = startingX;
		this.startingY = startingY;
		this.endingX = endingX;
		this.endingY = endingY;
		this.angle = angle;
	}


	public int getLength() {
		return length;
	}


	public int getStartingX() {
		return startingX;
	}


	public int getStartingY() {
		return startingY;
	}


	public int getEndingX() {
		return endingX;
	}


	public int getEndingY() {
		return endingY;
	}
	
	
	public int getAngle() {
		return angle;
	}

	
}
