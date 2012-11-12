package testingWindow;

import solids.Point;
import solids.Vector;

public class POV {
	private Point p;
	private Vector v;
	private double angle;
	
	public POV (Point p, double angle) {
		this.p = p;
		this.v = new Vector (-p.getX(), -p.getY(), -p.getZ());
		this.angle = angle;
	}
	
	public double getAngle() {
		return angle;
	}

	public double getDistanceToScreen() {
		return v.length();
	}

	public Point getP() {
		return p;
	}

	public Vector getV() {
		return v;
	}
}
