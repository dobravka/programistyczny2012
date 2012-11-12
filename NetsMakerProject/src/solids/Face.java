package solids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Face {
	private List<Point> listOfPoints;
	private List<Edge> listOfEdges;
	
	public Face(Point... points) {
		listOfPoints = Arrays.asList(points);
		listOfEdges = new ArrayList<Edge>();
		for (int i=1; i<points.length; i++) {
			listOfEdges.add(new Edge(listOfPoints.get(i-1),listOfPoints.get(i)));
		}
		listOfEdges.add(new Edge(listOfPoints.get(points.length-1),listOfPoints.get(0)));
	}

	public int getAmoutOfEdges() {
		return listOfEdges.size();
	}
	
	public boolean hasPoint(Point point) {
		return listOfPoints.contains(point);
	}
	
	public void addEdge(Edge e) {
		listOfEdges.add(e);
	}
}
