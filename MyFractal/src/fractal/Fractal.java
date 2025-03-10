package fractal;

import java.util.ArrayList;

/**
 * The Fractal class establishes the coordinates for how to draw the fractal.
 * This depends on the minimum size of the fractal sides, leading to a recursive
 * use of the fractal drawingmethod.
 * 
 * @author Daniel Santillan
 * @version 1.0
 */
public class Fractal {

	/** The list of edges to draw the fractal on */
	private ArrayList<Edge> edgesToHandle;
	/** The minimum size of the fractal sides */
	private int minSize;
	
	/**
	 * The fractal constructor initializes the fields.
	 * 
	 * @param edgesInput the list of edges to handle
	 * @param minSizeInput the minimum size of the fractal sides
	 */
	public Fractal(ArrayList<Edge> edgesInput, int minSizeInput) {
		edgesToHandle = edgesInput;
		minSize = minSizeInput;
	}
	
	
	/**
	 * The drawFractal method uses the list of edges to handle and the minimum
	 * size to draw the fractal. Each fractal is built on a side of the base
	 * polygon. It is made of two squares that are 2/5 the length of the base 
	 * polygon side with an equilateral triangle in the middle. The top of the
	 * squares are added to a list of edges to draw the next recursion of the
	 * fractal on. The fractal is drawn using the location of the edges on the
	 * coordinate plane of the frame along with the angle of the edge.
	 * 
	 * @return the list of edges that comprise the fractal
	 */
	public ArrayList<Edge> drawFractal() {
		ArrayList<Edge> edgesDrawn = new ArrayList<Edge>();
		ArrayList<Edge> newEdgesToDraw = new ArrayList<Edge>();
		int length = edgesToHandle.get(0).getLength() * 2/5;
		
		for (Edge e : edgesToHandle) {
			int startingX = e.getStartingX();
			int startingY = e.getStartingY();
			edgesDrawn.add(new Edge(length, startingX, startingY,
					(int)(startingX + length*Math.sin(Math.toRadians(e.getAngle()))), 
					(int)(startingY - length*Math.cos(Math.toRadians(e.getAngle()))), e.getAngle()));
			
			startingX = (int)(startingX + length*Math.sin(Math.toRadians(e.getAngle())));
			startingY = (int)(startingY - length*Math.cos(Math.toRadians(e.getAngle())));
			Edge newEdgeOne = new Edge(length, startingX, startingY,
					(int)(startingX + length*Math.cos(Math.toRadians(e.getAngle()))), 
					(int)(startingY + length*Math.sin(Math.toRadians(e.getAngle()))), e.getAngle());
			edgesDrawn.add(newEdgeOne);
			newEdgesToDraw.add(newEdgeOne);
			
			startingX = (int)(startingX + length*Math.cos(Math.toRadians(e.getAngle())));
			startingY = (int)(startingY + length*Math.sin(Math.toRadians(e.getAngle())));
			edgesDrawn.add(new Edge(length, startingX, startingY,
					(int)(startingX - length*Math.sin(Math.toRadians(e.getAngle()))), 
					(int)(startingY + length*Math.cos(Math.toRadians(e.getAngle()))), e.getAngle()));
			
			startingX = (int)(startingX - length*Math.sin(Math.toRadians(e.getAngle())));
			startingY = (int)(startingY + length*Math.cos(Math.toRadians(e.getAngle())));
			edgesDrawn.add(new Edge(length, startingX, startingY,
					(int)(startingX + (length/2)*Math.sin(Math.toRadians(e.getAngle()+30))), 
					(int)(startingY - (length/2)*Math.cos(Math.toRadians(e.getAngle()+30))), e.getAngle()));
			
			startingX = (int)(startingX + (length/2)*Math.sin(Math.toRadians(e.getAngle()+30)));
			startingY = (int)(startingY - (length/2)*Math.cos(Math.toRadians(e.getAngle()+30)));
			edgesDrawn.add(new Edge(length, startingX, startingY,
					(int)(startingX + (length/2)*Math.sin(Math.toRadians(e.getAngle()+150))), 
					(int)(startingY - (length/2)*Math.cos(Math.toRadians(e.getAngle()+150))), e.getAngle()));
			
			startingX = (int)(startingX + (length/2)*Math.sin(Math.toRadians(e.getAngle()+150)));
			startingY = (int)(startingY - (length/2)*Math.cos(Math.toRadians(e.getAngle()+150)));
			edgesDrawn.add(new Edge(length, startingX, startingY,
					(int)(startingX + (length)*Math.sin(Math.toRadians(e.getAngle()))), 
					(int)(startingY - (length)*Math.cos(Math.toRadians(e.getAngle()))), e.getAngle()));
			
			startingX = (int)(startingX + (length)*Math.sin(Math.toRadians(e.getAngle())));
			startingY = (int)(startingY - (length)*Math.cos(Math.toRadians(e.getAngle())));
			Edge newEdgeTwo = new Edge(length, startingX, startingY,
					(int)(startingX + length*Math.cos(Math.toRadians(e.getAngle()))), 
					(int)(startingY + length*Math.sin(Math.toRadians(e.getAngle()))), e.getAngle());
			edgesDrawn.add(newEdgeTwo);
			newEdgesToDraw.add(newEdgeTwo);
			
			startingX = (int)(startingX + length*Math.cos(Math.toRadians(e.getAngle())));
			startingY = (int)(startingY + length*Math.sin(Math.toRadians(e.getAngle())));
			edgesDrawn.add(new Edge(length, startingX, startingY,
					(int)(startingX - length*Math.sin(Math.toRadians(e.getAngle()))), 
					(int)(startingY + length*Math.cos(Math.toRadians(e.getAngle()))), e.getAngle()));
			
		}
		
		if (length > minSize) {
			edgesToHandle = newEdgesToDraw;
			ArrayList<Edge> temp = drawFractal();
			for (int i = 0; i < temp.size(); i++) {
				edgesDrawn.add(i, temp.get(i));
			}
		}
		
		return edgesDrawn;
	}

	
	/**
	 * This is a simple toString that returns the field values for this class.
	 * 
	 * @return the field values for this class
	 */
	@Override
	public String toString() {
		return "Fractal [edgesToHandle=" + edgesToHandle + ", minSize=" + minSize + "]";
	}
	
}
