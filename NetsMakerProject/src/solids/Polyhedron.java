package solids;

import java.util.List;

import utils.SolidsException;


public class Polyhedron {
	private List<Point> listOfPoints;
	private List<Face> listOfFaces;
	private List<Edge> listOfEdges;
	
	public Polyhedron(List<Point> points,
					  List<Face> faces,
				  	  List<Edge> edges) {
		this.listOfPoints = points;
		this.listOfFaces = faces;
		this.listOfEdges = edges;
	}

	public void matchEdgesAndFaces() {
		for (Face f : listOfFaces) {
			for (Edge e : listOfEdges) {
				if (f.hasPoint(e.getPoints()[0]) && f.hasPoint(e.getPoints()[1]) ) {
					try {
						e.addFace(f);
						f.addEdge(e);
					} catch (SolidsException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	public void moveToCenter() {
		Point boxMin = new Point ();
		Point boxMax = new Point ();
		
		for (Point p : listOfPoints) {
			if (p.getX() < boxMin.getX()) {
				boxMin.setX(p.getX());
			}
			if (p.getY() < boxMin.getY()) {
				boxMin.setY(p.getY());
			}
			if (p.getZ() < boxMin.getZ()) {
				boxMin.setZ(p.getZ());
			}
			if (p.getX() > boxMax.getX()) {
				boxMax.setX(p.getX());
			}
			if (p.getY() > boxMax.getY()) {
				boxMax.setY(p.getY());
			}
			if (p.getZ() > boxMax.getZ()) {
				boxMax.setZ(p.getZ());
			}
		}
		
		Vector toCenter = new Vector ((boxMin.getX() + boxMax.getX())/-2.0,
									(boxMin.getY() + boxMax.getY())/-2.0,
									(boxMin.getY() + boxMax.getY())/-2.0);
		for (Point p: listOfPoints) {
			p.move(toCenter);
		}
	}

	public void checkConnections() {
		System.out.println("Writing amout od edges at every face:");
		for (Face f : listOfFaces) {
			System.out.print(""+f.getAmoutOfEdges());
		}
		System.out.println("\nWriting amout od faces at every edge:");
		for (Edge e : listOfEdges) {
			System.out.print(""+e.getAmoutOfFaces());
		}
	}

	public int getAmoutOfPoints() {
		return listOfPoints.size();
	}

	public void move(Vector vector) {
		for (Point p: listOfPoints) {
			p.move(vector);
		}
	}

	public List<Edge> getListOfEdges() {
		return listOfEdges;
	}
}
