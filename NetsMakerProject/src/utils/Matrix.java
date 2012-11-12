package utils;

public class Matrix {

	public static double determinant2(double[][] ds) {
		return ds[0][0]*ds[1][1]-ds[1][0]*ds[0][1];
	}

	public static double determinant3(double[][] ds) {
		double det = ds[0][0]*ds[1][1]*ds[2][2] + ds[0][1]*ds[1][2]*ds[2][0] + ds[0][2]*ds[1][0]*ds[2][1]
				- ds[0][2]*ds[1][1]*ds[2][0] - ds[1][2]*ds[2][1]*ds[0][0] - ds[2][2]*ds[0][1]*ds[1][0];
		return det;
	}

}
