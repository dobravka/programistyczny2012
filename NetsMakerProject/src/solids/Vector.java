package solids;

public class Vector {
	private double dx;
	private double dy;
	private double dz;
	private double length;
	
	public Vector (double dx, double dy, double dz) {
		this.dx = dx;
		this.dy = dy;
		this.dz = dz;
		this.length = vectorLength(dx, dy, dz);
	}
	
	public Vector (Point pp, Point pe) {
		this.dx = pe.getX() - pp.getX();
		this.dy = pe.getY() - pp.getY();
		this.dz = pe.getZ() - pp.getZ();
		this.length = vectorLength(dx, dy, dz);
	}
	
	public static double vectorLength(double dx, double dy, double dz) {
		return Math.sqrt(dx*dx + dy*dy + dz*dz);
	}
	
	public static Vector cross(Vector m, Vector n) {
		double x = m.dy*n.getDz()-m.dz*n.getDy();
		double y = m.dz*n.getDx()-m.dx*n.getDz();
		double z = m.dx*n.getDy()-m.dy*n.getDx();
		if(x==0 && y==0 && z==0) {
			return null;
		}
		return new Vector(x,y,z);
	}
	
	public Vector scale(double scale) {
		return new Vector(this.dx*scale, this.dy*scale, this.dz*scale);
	}
	
	public Vector scaleToUnitLength() {
		return this.scale(1.0/this.length());
	}
	
	public String toString () {
		return "[" + dx + "," + dy + ","+ dz + "]";
	}
	
	public double length() {
		return length;
	}
	
	public double getDx() {
		return dx;
	}

	public double getDy() {
		return dy;
	}

	public double getDz() {
		return dz;
	}
}
