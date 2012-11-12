package testingWindow;

import solids.Plane;
import solids.Vector;

public class Screen {
	private Vector x;
	private Vector y;
	private Plane plane;

	public Screen () {
		
	}
	
	public Screen (Plane p, Vector x, Vector y) {
		this.x = x;
		this.y = y;
		this.plane = p;
	}

	public Plane getPlane() {
		return plane;
	}

	public Vector getX() {
		return x;
	}

	public Vector getY() {
		return y;
	}
}