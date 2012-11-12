package utils;


public class SimultaneousEquation {
	public static double[] solve2 (double a1, double b1, double c1, 
								  double a2, double b2, double c2) throws Exception{
		double[][] m0 = {{a1,b1},{a2,b2}};
		double[][] m1 = {{c1,b1},{c2,b2}};
		double[][] m2 = {{a1,c1},{a2,c2}};
		
		double W1 = Matrix.determinant2(m1);
		double W2 = Matrix.determinant2(m2);
		double W0 = Matrix.determinant2(m0);
		
		if (W0 == 0) {
			if (W1==0 && W2==0) {
				throw new SolidsException ("Equations inconsistent");
			} else {
				throw new SolidsException ("Equations have no solutions");
			}
		}
		
		double[] results = {W1/W0, W2/W0};
		return results;
	}
	public static double[] solve3 (double a1, double b1, double c1, double d1, 
			  					   double a2, double b2, double c2, double d2,
			  					   double a3, double b3, double c3, double d3) throws Exception{
		double[][] m0 = {{a1,b1,c1},{a2,b2,c2},{a3,b3,c3}};
		double[][] m1 = {{d1,b1,c1},{d2,b2,c2},{d3,b3,c3}};
		double[][] m2 = {{a1,d1,c1},{a2,d2,c2},{a3,d3,c3}};
		double[][] m3 = {{a1,b1,d1},{a2,b2,d2},{a3,b3,d3}};
		double W1 = Matrix.determinant3(m1);
		double W2 = Matrix.determinant3(m2);
		double W3 = Matrix.determinant3(m3);
		double W0 = Matrix.determinant3(m0);
		
		double[] results = {W1/W0, W2/W0, W3/W0};
		return results;
		}
}
