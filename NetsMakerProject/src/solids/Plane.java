package solids;

import utils.SimultaneousEquation;

public class Plane {
	private double alfa;
	private double beta;
	private double gamma;
	private double delta;
	
	public Plane (Vector n, double d) {
		double nlen = n.length();
		this.alfa = n.getDx() / nlen;
		this.beta = n.getDy() / nlen;
		this.gamma = n.getDz() / nlen;
		this.delta = d / nlen;
	}
	
	public Plane(Vector k, Point point) {
		double klen = k.length();
		this.alfa = k.getDx() / klen;
		this.beta = k.getDy() / klen;
		this.gamma = k.getDz() / klen;
		double md = alfa*point.getX() + beta*point.getY() + gamma*point.getZ();
		this.delta = -md;
	}

	public Point intersectionWithLine (Line l) {
		double t = (-delta - alfa*l.getP().getX() - beta*l.getP().getY() - gamma*l.getP().getZ())
				/ (alfa*l.getK().getDx() + beta*l.getK().getDy() + gamma*l.getK().getDz());
		double x = l.getP().getX() + l.getK().getDx()*t;
		double y = l.getP().getY() + l.getK().getDy()*t;
		double z = l.getP().getZ() + l.getK().getDz()*t;
		return new Point(x,y,z);
	}

	public String toString () {
		return ""+alfa+"x+"+beta+"y+"+gamma+"z+"+delta+"=0";
	}
	
	public Line intersectionWithPlane(Plane plane) {
		return intersectionWithPlaneOnXzero (plane);
	}
	
	private Line intersectionWithPlaneOnXzero(Plane plane) {
		double x = 0.0;
		double[] res = null;
		try{
			 res = SimultaneousEquation.solve2(beta, gamma, -delta, 
								plane.getBeta(), plane.getGamma(), -plane.getDelta());
		} catch (Exception e) {
			return intersectionWithPlaneOnYzero(plane);
		}
		Point p = new Point(x, res[0], res[1]);
		Vector v = Vector.cross(this.getN(), plane.getN());
		return new Line(p,v);
	}

	private Line intersectionWithPlaneOnYzero(Plane plane) {
		double y = 0.0;
		double[] res = null;
		try{
			 res = SimultaneousEquation.solve2(alfa, gamma, -delta, 
								plane.getAlfa(), plane.getGamma(), -plane.getDelta());
		} catch (Exception e) {
			return intersectionWithPlaneOnZzero(plane);
		}
		Point p = new Point(res[0], y, res[1]);
		Vector v = Vector.cross(this.getN(), plane.getN());
		return new Line(p,v);
	}

	private Line intersectionWithPlaneOnZzero(Plane plane) {
		double z = 0.0;
		double[] res = null;
		try{
			 res = SimultaneousEquation.solve2(alfa, beta, -delta, 
								plane.getAlfa(), plane.getBeta(), -plane.getDelta());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Point p = new Point(res[0], res[1], z);
		Vector v = Vector.cross(this.getN(), plane.getN());
		return new Line(p,v);
	}
	
	private Vector getN() {
		return new Vector(this.alfa, this.beta, this.gamma);
	}

	public double getAlfa() {
		return alfa;
	}

	public double getBeta() {
		return beta;
	}

	public double getGamma() {
		return gamma;
	}

	public double getDelta() {
		return delta;
	}
}
