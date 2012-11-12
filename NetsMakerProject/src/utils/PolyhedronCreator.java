package utils;

import java.util.ArrayList;
import java.util.List;

import solids.Edge;
import solids.Face;
import solids.Point;
import solids.Polyhedron;

public class PolyhedronCreator {

	public static Polyhedron createTetrahedron(double a) {
		List<Point> ptns = new ArrayList<Point>();
		List<Face> fcs = new ArrayList<Face>();
		List<Edge> edgs = new ArrayList<Edge>();
		
		ptns.add(new Point(-a, 0.0, -a/Math.sqrt(2.0)));	//0
		ptns.add(new Point(a, 0.0, -a/Math.sqrt(2.0)));		//1
		ptns.add(new Point(0.0, -a, a/Math.sqrt(2.0)));		//2
		ptns.add(new Point(0.0, a, a/Math.sqrt(2.0)));		//3
		
		edgs.add(new Edge(ptns.get(0), ptns.get(1)));
		edgs.add(new Edge(ptns.get(0), ptns.get(2)));
		edgs.add(new Edge(ptns.get(0), ptns.get(3)));
		edgs.add(new Edge(ptns.get(1), ptns.get(2)));
		edgs.add(new Edge(ptns.get(1), ptns.get(3)));
		edgs.add(new Edge(ptns.get(2), ptns.get(3)));
		
		fcs.add(new Face(ptns.get(0), ptns.get(1), ptns.get(2)));
		fcs.add(new Face(ptns.get(1), ptns.get(2), ptns.get(3)));
		fcs.add(new Face(ptns.get(2), ptns.get(3), ptns.get(0)));
		fcs.add(new Face(ptns.get(3), ptns.get(0), ptns.get(1)));
		
		Polyhedron polyhedron = new Polyhedron(ptns, fcs, edgs);
		polyhedron.matchEdgesAndFaces();
		polyhedron.checkConnections();
		return polyhedron;
	}

	public static Polyhedron createHexahedron(double a) {
		List<Point> ptns = new ArrayList<Point>();
		List<Face> fcs = new ArrayList<Face>();
		List<Edge> edgs = new ArrayList<Edge>();
		
		ptns.add(new Point(0.0, 0.0, 0.0)); //0
		ptns.add(new Point(0.0, 0.0, a)); 	//1
		ptns.add(new Point(0.0, a, 0.0)); 	//2
		ptns.add(new Point(0.0, a, a)); 	//3
		ptns.add(new Point(a, 0.0, 0.0)); 	//4
		ptns.add(new Point(a, 0.0, a)); 	//5
		ptns.add(new Point(a, a, 0.0)); 	//6
		ptns.add(new Point(a, a, a)); 		//7
		
		edgs.add(new Edge(ptns.get(0), ptns.get(1)));
		edgs.add(new Edge(ptns.get(0), ptns.get(2)));
		edgs.add(new Edge(ptns.get(0), ptns.get(4)));
		edgs.add(new Edge(ptns.get(1), ptns.get(3)));
		edgs.add(new Edge(ptns.get(1), ptns.get(5)));
		edgs.add(new Edge(ptns.get(2), ptns.get(3)));
		edgs.add(new Edge(ptns.get(2), ptns.get(6)));
		edgs.add(new Edge(ptns.get(3), ptns.get(7)));
		edgs.add(new Edge(ptns.get(4), ptns.get(5)));
		edgs.add(new Edge(ptns.get(4), ptns.get(6)));
		edgs.add(new Edge(ptns.get(5), ptns.get(7)));
		edgs.add(new Edge(ptns.get(6), ptns.get(7)));
		
		fcs.add(new Face(ptns.get(0), ptns.get(1), ptns.get(2), ptns.get(3)));
		fcs.add(new Face(ptns.get(4), ptns.get(5), ptns.get(6), ptns.get(7)));
		fcs.add(new Face(ptns.get(0), ptns.get(1), ptns.get(4), ptns.get(5)));
		fcs.add(new Face(ptns.get(2), ptns.get(3), ptns.get(6), ptns.get(7)));
		fcs.add(new Face(ptns.get(0), ptns.get(2), ptns.get(4), ptns.get(6)));
		fcs.add(new Face(ptns.get(1), ptns.get(3), ptns.get(5), ptns.get(7)));
		
		Polyhedron polyhedron = new Polyhedron(ptns, fcs, edgs);
		polyhedron.matchEdgesAndFaces();
		polyhedron.checkConnections();
		return polyhedron;
	}
	
	public static Polyhedron createOctahedron(double a) {
		List<Point> ptns = new ArrayList<Point>();
		List<Face> fcs = new ArrayList<Face>();
		List<Edge> edgs = new ArrayList<Edge>();
		
		ptns.add(new Point(a, 0.0, 0.0)); //0
		ptns.add(new Point(-a, 0.0, 0.0)); //1
		ptns.add(new Point(0.0, a, 0.0)); //2
		ptns.add(new Point(0.0, -a, 0.0)); //3
		ptns.add(new Point(0.0, 0.0, a)); //4
		ptns.add(new Point(0.0, 0.0, -a)); //5
		
		edgs.add(new Edge(ptns.get(0), ptns.get(2)));
		edgs.add(new Edge(ptns.get(0), ptns.get(3)));
		edgs.add(new Edge(ptns.get(0), ptns.get(4)));
		edgs.add(new Edge(ptns.get(0), ptns.get(5)));
		edgs.add(new Edge(ptns.get(1), ptns.get(2)));
		edgs.add(new Edge(ptns.get(1), ptns.get(3)));
		edgs.add(new Edge(ptns.get(1), ptns.get(4)));
		edgs.add(new Edge(ptns.get(1), ptns.get(5)));
		edgs.add(new Edge(ptns.get(2), ptns.get(4)));
		edgs.add(new Edge(ptns.get(2), ptns.get(5)));
		edgs.add(new Edge(ptns.get(3), ptns.get(4)));
		edgs.add(new Edge(ptns.get(3), ptns.get(5)));
		
		fcs.add(new Face(ptns.get(0), ptns.get(3), ptns.get(5)));
		fcs.add(new Face(ptns.get(0), ptns.get(2), ptns.get(5)));
		fcs.add(new Face(ptns.get(1), ptns.get(2), ptns.get(5)));
		fcs.add(new Face(ptns.get(1), ptns.get(3), ptns.get(5)));
		fcs.add(new Face(ptns.get(0), ptns.get(3), ptns.get(4)));
		fcs.add(new Face(ptns.get(0), ptns.get(2), ptns.get(4)));
		fcs.add(new Face(ptns.get(1), ptns.get(2), ptns.get(4)));
		fcs.add(new Face(ptns.get(1), ptns.get(3), ptns.get(4)));
		
		Polyhedron polyhedron = new Polyhedron(ptns, fcs, edgs);
		polyhedron.matchEdgesAndFaces();
		polyhedron.checkConnections();
		return polyhedron;
	}
	
	public static Polyhedron createDedecahedron(double a) {
		List<Point> ptns = new ArrayList<Point>();
		List<Face> fcs = new ArrayList<Face>();
		List<Edge> edgs = new ArrayList<Edge>();
		
		double g = (1.0 + Math.sqrt(5.0)) / 2.0; //golden ratio
		
		ptns.add(new Point(a*g/2.0, a*g/2.0, a*g/2.0)); 	//0
		ptns.add(new Point(a*g/2.0, a*g/2.0, -a*g/2.0)); 	//1
		ptns.add(new Point(a*g/2.0, -a*g/2.0, a*g/2.0)); 	//2
		ptns.add(new Point(a*g/2.0, -a*g/2.0, -a*g/2.0)); 	//3
		ptns.add(new Point(-a*g/2.0, a*g/2.0, a*g/2.0)); 	//4
		ptns.add(new Point(-a*g/2.0, a*g/2.0, -a*g/2.0)); 	//5
		ptns.add(new Point(-a*g/2.0, -a*g/2.0, a*g/2.0)); 	//6
		ptns.add(new Point(-a*g/2.0, -a*g/2.0, -a*g/2.0)); 	//7
		
		ptns.add(new Point(0.0, a/2.0, a*g*g/2.0)); 		//8
		ptns.add(new Point(0.0, a/2.0, -a*g*g/2.0)); 		//9
		ptns.add(new Point(0.0, -a/2.0, a*g*g/2.0)); 		//10
		ptns.add(new Point(0.0, -a/2.0, -a*g*g/2.0)); 		//11
		
		ptns.add(new Point(a/2.0, a*g*g/2.0, 0.0)); 		//12
		ptns.add(new Point(a/2.0, -a*g*g/2.0, 0.0)); 		//13
		ptns.add(new Point(-a/2.0, a*g*g/2.0, 0.0)); 		//14
		ptns.add(new Point(-a/2.0, -a*g*g/2.0, 0.0)); 		//15
		
		ptns.add(new Point(a*g*g/2.0, 0.0, a/2.0)); 		//16
		ptns.add(new Point(a*g*g/2.0, 0.0, -a/2.0)); 		//17
		ptns.add(new Point(-a*g*g/2.0, 0.0, a/2.0)); 		//18
		ptns.add(new Point(-a*g*g/2.0, 0.0, -a/2.0)); 		//19
		
		edgs.add(new Edge(ptns.get(0), ptns.get(16)));
		edgs.add(new Edge(ptns.get(0), ptns.get(12)));
		edgs.add(new Edge(ptns.get(0), ptns.get(8)));
		edgs.add(new Edge(ptns.get(1), ptns.get(17)));
		edgs.add(new Edge(ptns.get(1), ptns.get(9)));
		edgs.add(new Edge(ptns.get(1), ptns.get(12)));
		edgs.add(new Edge(ptns.get(2), ptns.get(16)));
		edgs.add(new Edge(ptns.get(2), ptns.get(13)));
		edgs.add(new Edge(ptns.get(2), ptns.get(10)));
		edgs.add(new Edge(ptns.get(3), ptns.get(11)));
		edgs.add(new Edge(ptns.get(3), ptns.get(13)));
		edgs.add(new Edge(ptns.get(3), ptns.get(17)));
		edgs.add(new Edge(ptns.get(4), ptns.get(8)));
		edgs.add(new Edge(ptns.get(4), ptns.get(14)));
		edgs.add(new Edge(ptns.get(4), ptns.get(18)));
		edgs.add(new Edge(ptns.get(5), ptns.get(9)));
		edgs.add(new Edge(ptns.get(5), ptns.get(14)));
		edgs.add(new Edge(ptns.get(5), ptns.get(19)));
		edgs.add(new Edge(ptns.get(6), ptns.get(15)));
		edgs.add(new Edge(ptns.get(6), ptns.get(10)));
		edgs.add(new Edge(ptns.get(6), ptns.get(18)));
		edgs.add(new Edge(ptns.get(7), ptns.get(11)));
		edgs.add(new Edge(ptns.get(7), ptns.get(15)));
		edgs.add(new Edge(ptns.get(7), ptns.get(19)));
		
		edgs.add(new Edge(ptns.get(8), ptns.get(10)));
		edgs.add(new Edge(ptns.get(9), ptns.get(11)));
		edgs.add(new Edge(ptns.get(12), ptns.get(14)));
		edgs.add(new Edge(ptns.get(13), ptns.get(15)));
		edgs.add(new Edge(ptns.get(18), ptns.get(19)));
		edgs.add(new Edge(ptns.get(16), ptns.get(17)));
		
		fcs.add(new Face(ptns.get(0), ptns.get(4), ptns.get(8), ptns.get(12), ptns.get(14)));
		fcs.add(new Face(ptns.get(0), ptns.get(1), ptns.get(12), ptns.get(16), ptns.get(17)));
		fcs.add(new Face(ptns.get(0), ptns.get(2), ptns.get(8), ptns.get(10), ptns.get(16)));
		fcs.add(new Face(ptns.get(1), ptns.get(3), ptns.get(9), ptns.get(11), ptns.get(17)));
		fcs.add(new Face(ptns.get(1), ptns.get(5), ptns.get(9), ptns.get(12), ptns.get(14)));
		fcs.add(new Face(ptns.get(3), ptns.get(7), ptns.get(11), ptns.get(13), ptns.get(15)));
		fcs.add(new Face(ptns.get(2), ptns.get(3), ptns.get(13), ptns.get(16), ptns.get(17)));
		fcs.add(new Face(ptns.get(6), ptns.get(7), ptns.get(15), ptns.get(18), ptns.get(19)));
		fcs.add(new Face(ptns.get(5), ptns.get(7), ptns.get(9), ptns.get(11), ptns.get(19)));
		fcs.add(new Face(ptns.get(4), ptns.get(6), ptns.get(8), ptns.get(10), ptns.get(18)));
		fcs.add(new Face(ptns.get(4), ptns.get(5), ptns.get(14), ptns.get(18), ptns.get(19)));
		fcs.add(new Face(ptns.get(2), ptns.get(6), ptns.get(10), ptns.get(13), ptns.get(15)));
		
		Polyhedron polyhedron = new Polyhedron(ptns, fcs, edgs);
		polyhedron.matchEdgesAndFaces();
		polyhedron.checkConnections();
		return polyhedron;
	}
	
	public static Polyhedron createIcosahedron(double a) {
		List<Point> ptns = new ArrayList<Point>();
		List<Face> fcs = new ArrayList<Face>();
		List<Edge> edgs = new ArrayList<Edge>();
		
		double g = (1.0 + Math.sqrt(5.0)) / 2.0; //golden ratio
		
		ptns.add(new Point(0.0, 0.5*a, 0.5*g*a)); 		//0
		ptns.add(new Point(0.0, 0.5*a, -0.5*g*a)); 		//1
		ptns.add(new Point(0.0, -0.5*a, 0.5*g*a)); 		//2
		ptns.add(new Point(0.0, -0.5*a, -0.5*g*a)); 	//3
		
		ptns.add(new Point(0.5*a, 0.5*g*a, 0.0)); 		//4
		ptns.add(new Point(0.5*a, -0.5*g*a, 0.0)); 		//5
		ptns.add(new Point(-0.5*a, 0.5*g*a, 0.0)); 		//6
		ptns.add(new Point(-0.5*a, -0.5*g*a, 0.0)); 	//7
		
		ptns.add(new Point(0.5*g*a, 0.0, 0.5*a)); 		//8
		ptns.add(new Point(0.5*g*a, 0.0, -0.5*a)); 		//9
		ptns.add(new Point(-0.5*g*a, 0.0, 0.5*a)); 		//10
		ptns.add(new Point(-0.5*g*a, 0.0, -0.5*a)); 	//11
		
		edgs.add(new Edge(ptns.get(0), ptns.get(2)));
		edgs.add(new Edge(ptns.get(1), ptns.get(3)));
		edgs.add(new Edge(ptns.get(4), ptns.get(6)));
		edgs.add(new Edge(ptns.get(5), ptns.get(7)));
		edgs.add(new Edge(ptns.get(8), ptns.get(9)));
		edgs.add(new Edge(ptns.get(10), ptns.get(11)));
		edgs.add(new Edge(ptns.get(2), ptns.get(5)));
		edgs.add(new Edge(ptns.get(2), ptns.get(7)));
		edgs.add(new Edge(ptns.get(3), ptns.get(5)));
		edgs.add(new Edge(ptns.get(3), ptns.get(7)));
		edgs.add(new Edge(ptns.get(0), ptns.get(10)));
		edgs.add(new Edge(ptns.get(2), ptns.get(10)));
		edgs.add(new Edge(ptns.get(7), ptns.get(10)));
		edgs.add(new Edge(ptns.get(7), ptns.get(11)));
		edgs.add(new Edge(ptns.get(3), ptns.get(11)));
		edgs.add(new Edge(ptns.get(1), ptns.get(11)));
		edgs.add(new Edge(ptns.get(6), ptns.get(10)));
		edgs.add(new Edge(ptns.get(6), ptns.get(11)));
		edgs.add(new Edge(ptns.get(0), ptns.get(6)));
		edgs.add(new Edge(ptns.get(0), ptns.get(4)));
		edgs.add(new Edge(ptns.get(1), ptns.get(6)));
		edgs.add(new Edge(ptns.get(1), ptns.get(4)));
		edgs.add(new Edge(ptns.get(2), ptns.get(8)));
		edgs.add(new Edge(ptns.get(8), ptns.get(5)));
		edgs.add(new Edge(ptns.get(5), ptns.get(9)));
		edgs.add(new Edge(ptns.get(9), ptns.get(3)));
		edgs.add(new Edge(ptns.get(0), ptns.get(8)));
		edgs.add(new Edge(ptns.get(8), ptns.get(4)));
		edgs.add(new Edge(ptns.get(1), ptns.get(9)));
		edgs.add(new Edge(ptns.get(9), ptns.get(4)));
		
		fcs.add(new Face(ptns.get(0), ptns.get(2), ptns.get(8)));
		fcs.add(new Face(ptns.get(0), ptns.get(4), ptns.get(8)));
		fcs.add(new Face(ptns.get(4), ptns.get(8), ptns.get(9)));
		fcs.add(new Face(ptns.get(1), ptns.get(4), ptns.get(9)));
		fcs.add(new Face(ptns.get(1), ptns.get(3), ptns.get(9)));
		fcs.add(new Face(ptns.get(1), ptns.get(3), ptns.get(11)));
		fcs.add(new Face(ptns.get(3), ptns.get(7), ptns.get(11)));
		fcs.add(new Face(ptns.get(7), ptns.get(10), ptns.get(11)));
		fcs.add(new Face(ptns.get(2), ptns.get(7), ptns.get(10)));
		fcs.add(new Face(ptns.get(0), ptns.get(2), ptns.get(10)));
		
		fcs.add(new Face(ptns.get(5), ptns.get(2), ptns.get(8)));
		fcs.add(new Face(ptns.get(5), ptns.get(8), ptns.get(9)));
		fcs.add(new Face(ptns.get(5), ptns.get(9), ptns.get(3)));
		fcs.add(new Face(ptns.get(5), ptns.get(3), ptns.get(7)));
		fcs.add(new Face(ptns.get(5), ptns.get(7), ptns.get(2)));
		
		fcs.add(new Face(ptns.get(6), ptns.get(1), ptns.get(4)));
		fcs.add(new Face(ptns.get(6), ptns.get(4), ptns.get(0)));
		fcs.add(new Face(ptns.get(6), ptns.get(0), ptns.get(10)));
		fcs.add(new Face(ptns.get(6), ptns.get(10), ptns.get(11)));
		fcs.add(new Face(ptns.get(6), ptns.get(11), ptns.get(1)));
		
		Polyhedron polyhedron = new Polyhedron(ptns, fcs, edgs);
		polyhedron.matchEdgesAndFaces();
		polyhedron.checkConnections();
		return polyhedron;
	}

	public static Polyhedron createRailway(double a) {
		List<Point> ptns = new ArrayList<Point>();
		List<Face> fcs = new ArrayList<Face>();
		List<Edge> edgs = new ArrayList<Edge>();
		
		for(int i=0; i<1000; i++) {
			edgs.add(new Edge(new Point(0,0,10-i), new Point(0,3,10-i)));
		}
		
		Polyhedron polyhedron = new Polyhedron(ptns, fcs, edgs);
		
		return polyhedron;
		
	}

}
