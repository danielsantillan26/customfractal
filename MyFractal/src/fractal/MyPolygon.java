package fractal;

import java.util.ArrayList;

public class MyPolygon {

	private int numEdges;
	private int maxEdgeSize;
	private int centerX;
	private int centerY;
	private int radius;
	private ArrayList<Edge> edges;
	
	
	public MyPolygon(int numEdgesInput, int maxEdgeSizeInput, int availableWidthInput, int heightInput) {
		centerX = availableWidthInput/2;
		centerY = heightInput/2;
		maxEdgeSize = maxEdgeSizeInput;
		
		numEdges = numEdgesInput;
		edges = new ArrayList<Edge>();
		
		if (numEdges == 3) {
			radius = (int)(maxEdgeSize * Math.sqrt(3.0)/2);
			edges.add(new Edge(maxEdgeSize, centerX-(maxEdgeSize/2), centerY-radius,
					centerX+(maxEdgeSize/2), centerY-radius));
			edges.add(new Edge(maxEdgeSize, centerX+(maxEdgeSize/2), centerY-radius, centerX,
					centerY + maxEdgeSize*(int)(Math.sqrt(3.0)/3)));
			edges.add(new Edge(maxEdgeSize, centerX, centerY + maxEdgeSize*(int)(Math.sqrt(3.0)/3),
					centerX-(maxEdgeSize/2), centerY-radius));
		} else if (numEdges == 4) {
			radius = maxEdgeSizeInput/2;
			edges.add(new Edge(maxEdgeSize, centerX-radius, 
					centerY-radius, centerX+radius, centerY-radius));
			edges.add(new Edge(maxEdgeSize, centerX+radius, 
					centerY-radius, centerX+radius, centerY+radius));
			edges.add(new Edge(maxEdgeSize, centerX+radius, 
					centerY+radius, centerX-radius, centerY+radius));
			edges.add(new Edge(maxEdgeSize, centerX-radius, 
					centerY+radius, centerX-radius, centerY-radius));
			
		} else if (numEdges == 5) {
			radius = (int)(5/(2*Math.tan(Math.PI/5)));
		} else {
			radius = (int)((maxEdgeSize*Math.sqrt(3))/2);
			edges.add(new Edge(maxEdgeSize, centerX-(maxEdgeSize/2), centerY - radius,
					centerX+(maxEdgeSize/2), centerY-radius));
			edges.add(new Edge(maxEdgeSize, centerX+(maxEdgeSize/2), centerY-radius,
					centerX+maxEdgeSize, centerY));		
			edges.add(new Edge(maxEdgeSize, centerX+maxEdgeSize, centerY,
					centerX+(maxEdgeSize/2), centerY+radius));
			edges.add(new Edge(maxEdgeSize, centerX+(maxEdgeSize/2), centerY+radius,
					centerX-(maxEdgeSize/2), centerY+radius));
			edges.add(new Edge(maxEdgeSize, centerX-(maxEdgeSize/2), centerY+radius, 
					centerX - maxEdgeSize, centerY));
			edges.add(new Edge(maxEdgeSize, centerX-maxEdgeSize, centerY,
					centerX-(maxEdgeSize/2), centerY - radius));
			
		}
		
	}
	
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}
}
