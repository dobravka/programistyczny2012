package testingWindow;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import solids.Edge;
import solids.Line;
import solids.Plane;
import solids.Point;
import solids.Polyhedron;
import solids.Vector;
import utils.PolyhedronCreator;
import utils.SimultaneousEquation;

class MyWindowAdapter extends WindowAdapter { 
    public void windowClosing (WindowEvent e) {
        System.exit(0); 
    }
}

@SuppressWarnings("serial")
class MyFrame extends Frame {
    MyFrame(TestClass k,int a, int b) {
        super();
        setBounds(0,0,a,b);
        add(k);
        addWindowListener(new MyWindowAdapter());
        setResizable(false);
        setVisible(true); 
    }
}

@SuppressWarnings("serial")
public class TestClass extends Applet implements ActionListener, ComponentListener {
	static MyFrame frame;
    static Polyhedron polyhedron;
    static Screen screen;
    POV observer;
    public static int windowWidth = 1600;
    public static int windowHeight = 900;
    public static int pixelsForOneUnit;	
    Graphics g;
    double angle = 0.5;
        
    public TestClass() { 
        super(); 
        Point pObs = new Point(-1,5,-5);
        observer = new POV (pObs,angle);
        
        Plane screenPlane = new Plane (observer.getV(),0);
        Plane XOZ =  new Plane (new Vector(0,1,0),0);
        Line screenPlaneOnXOZ = screenPlane.intersectionWithPlane(XOZ);
		Vector xb = screenPlaneOnXOZ.getK();
		Vector yb = Vector.cross(xb, observer.getV());
		yb = yb.scaleToUnitLength();
		xb = xb.scaleToUnitLength();
		screen = new Screen (screenPlane, xb,yb);
        
		frame = new MyFrame(this,windowWidth,windowHeight);
        requestFocus(); 
		addComponentListener(this);
        setVisible(true); 
    }
        
    public static void main(String args[]) throws InterruptedException {
        double a = 0.5;
        polyhedron = PolyhedronCreator.createDedecahedron(a);
		TestClass tc = new TestClass();
		
    }

    public void paint(Graphics g) {
    	this.g = g;
    	for (Edge e : polyhedron.getListOfEdges()) {
    		drawEdge(e);
    	}
    }

	public void drawEdge(Edge e) {
		Point p1 = e.getPoints()[0];
		Point p2 = e.getPoints()[1];
		Point2D.Double p11 = calculateScreenPosition(p1.getX(), p1.getY(), p1.getZ());
		Point2D.Double p22 = calculateScreenPosition(p2.getX(), p2.getY(), p2.getZ());
		
		g.drawLine((int) p11.x, (int) p11.y, (int) p22.x, (int) p22.y);
	}


	public Point2D.Double calculateScreenPosition (double xp, double yp, double zp) {
		double pixelsForOneUnit = (double)windowWidth / (Math.tan(observer.getAngle())*observer.getV().length());
		
		Point p = screen.getPlane().intersectionWithLine(new Line(observer.getP(),new Point(xp,yp,zp)));
		Point p2 = new Point(0,0,0);
		
		Vector v = new Vector(p2,p);
		double[] r = null;
		
		try {
			r = SimultaneousEquation.solve3(
				screen.getX().getDx(), screen.getY().getDx(), observer.getP().getX(), v.getDx(), 
				screen.getX().getDy(), screen.getY().getDy(), observer.getP().getY(), v.getDy(), 
				screen.getX().getDz(), screen.getY().getDz(), observer.getP().getZ(), v.getDz());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Info.info("["+r[0]+" , "+r[1]+" , "+r[2]+"]");
		double posX = r[0]*pixelsForOneUnit;
		double posY = r[1]*pixelsForOneUnit;
		return new Point2D.Double(windowWidth/2.0+posX, windowHeight/2.0-posY);
	}
	
    public void actionPerformed (ActionEvent e) {
        //String r=e.getActionCommand();
        requestFocus(); 
    }
    
    public void componentShown(ComponentEvent e) {}
    public void keyPressed (KeyEvent e) {}
    public void keyReleased (KeyEvent e) {}
    public void componentHidden(ComponentEvent e) {}
    public void componentMoved(ComponentEvent e) {}
    public void componentResized(ComponentEvent arg0) {}
    
    
}
