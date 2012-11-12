package solids;

import java.util.List;

public class Point {
	private double x;
	private double y;
	private double z;
	
	public Point() { }
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(double x, double y, double z) {
		this(x,y);
		this.z = z;
	}
	
	public void move(Vector vector) {
		this.x += vector.getDx();
		this.y += vector.getDy();
		this.z += vector.getDz();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public String toString () {
		return "(" + x + "," + y + ","+ z + ")";
	}
	
	public boolean equals (Object o) {
		if (o instanceof Point) {
			Point p = (Point) o;
			if (Math.abs(p.getX()-this.x)<1e-6 
					&& Math.abs(p.getY()-this.y)<1e-6
					&& Math.abs(p.getZ()-this.z)<1e-6) {
				return true;
			} 
		}
		return false;
	}
}
