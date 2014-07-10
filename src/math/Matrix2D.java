package fractals.math;
/**
 * <code>Matrix2D</code> is a class which implements a 2x2 matrix in Java.
 *
 * @author      Abdul Fatir
 * @version		1.0
 * 
 */
public class Matrix2D
{
	/**
	* The 2D array which represents the 2x2 matrix.
	*/
	private double[][] matrix=new double[2][2];
	/**
	* Constructs a new <code>Matrix2D</code> with all elements 0.
	*/
	public Matrix2D()
	{
		matrix[0][0] = 0.0;
		matrix[0][1] = 0.0;
		matrix[1][0] = 0.0;
		matrix[1][1] = 0.0;
	}
	/**
	* Constructs a new <code>Matrix2D</code> with the passed elements.
	* @param a The [0,0] element of the matrix
	* @param b The [0,1] element of the matrix
	* @param c The [1,0] element of the matrix
	* @param d The [1,1] element of the matrix
	*/
	public Matrix2D(double a, double b, double c, double d)
	{
		matrix[0][0] = a;
		matrix[0][1] = b;
		matrix[1][0] = c;
		matrix[1][1] = d;
	}
	/**
	* Constructs a new <code>Matrix2D</code> using the passed array.
	* @param matrix The 2D array representing the matrix
	*/
	public Matrix2D(double[][] matrix)
	{
		this.matrix = matrix;
	}
	/**
	* Computes the determinant of the current matrix.
	* @return The determinant of the current matrix
	*/
	public double determinant()
	{
		return ((matrix[0][0]*matrix[1][1])-(matrix[0][1]*matrix[1][0]));
	}
}