package solids;

public class Line {
	private Point p;
	private Vector k;
	
	public Line (Point p, Vector k) {
		this.p = p;
		this.k = k;
	}
	
	public Line (Point pp, Point pk) {
		this.p = pp;
		this.k = new Vector (pk.getX()-pp.getX(), pk.getY()-pp.getY(), pk.getZ()-pp.getZ());
	}

	public Point getP() {
		return p;
	}

	public Vector getK() {
		return k;
	}
	
}
