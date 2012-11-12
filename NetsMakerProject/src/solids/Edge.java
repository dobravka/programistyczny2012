package solids;

import utils.SolidsException;

public class Edge {
	private Point point1;
	private Point point2;
	private Face face1;
	private Face face2;
	
	public Edge (Point p1, Point p2) {
		this.point1 = p1;
		this.point2 = p2;
	}
	
	public void setFaces (Face f1, Face f2) {
		face1 = f1;
		face2 = f2;
	}
	
	public void addFace (Face f1) throws SolidsException {
		if (face1 == null) {
			face1 = f1;
		} else if (face2 == null) {
			face2 = f1;
		} else {
			throw new SolidsException("This edge has already two faces");
		}	
	}

	public Point[] getPoints() {
		Point[] pp = {point1, point2};
		return pp;
	}

	public int getAmoutOfFaces() {
		if (face1 == null && face2 == null) {
			return 0;
		} else if(face1 != null && face2 != null) {
			return 2;
		} else {
			return 1;
		}
	}

	public Point getCenterPoint() {
		double x = (point1.getX()+point2.getX()) / 2.0;
		double y = (point1.getY()+point2.getY()) / 2.0;
		double z = (point1.getZ()+point2.getZ()) / 2.0;
		return new Point (x,y,z);
	}

	public String toString() {
		return "[("+point1.getX()+","+point1.getY()+","+point1.getZ()+") ; ("
				+point2.getX()+","+point2.getY()+","+point2.getZ()+")]";
	}

	public Edge copy() {
		Edge e = new Edge(point1, point2);
		e.setFaces(face1, face2);
		return e;
	}
	
	public Face getTheOtherFace(Face face) {
		if (face.equals(face1)) {
			return face2;
		} else if (face.equals(face2)) {
			return face1;
		} else {
			return null;
		}
	}

	private Point getTheOtherPoint(Point point) {
		if (point.equals(point1)) {
			return point2;
		} else if (point.equals(point2)) {
			return point1;
		} else {
			return null;
		}
	}
	
	private boolean hasPoint(Point point) {
		if (point.equals(point1) || point.equals(point2)) {
			return true;
		} else {
			return false;
		}
	}
}
