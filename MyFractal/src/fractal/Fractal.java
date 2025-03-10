package fractal;

import java.util.ArrayList;

public class Fractal {

	private ArrayList<Edge> edgesToHandle;
	private ArrayList<Edge> edgesToDraw;
	private int minSize;
	private int maxSize;
	
	public Fractal(ArrayList<Edge> edgesInput, int minSizeInput) {
		edgesToHandle = edgesInput;
		edgesToDraw = new ArrayList<Edge>();
		minSize = minSizeInput;
		maxSize = edgesInput.get(0).getLength();
	}
	
	
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
	
}
