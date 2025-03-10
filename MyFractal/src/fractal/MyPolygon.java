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


	public ArrayList<Edge> getEdges() {
		return edges;
	}
}
