package fractals.math;
import fractals.graphics.Point;
/**
 * <code>AffineTransformation</code> is a class which implements affine transformation in Java.
 *
 * @author      Abdul Fatir
 * @version		1.0
 * 
 */
public class AffineTransformation
{
	/**
	* The transformation matrix i.e. a,b,c,d
	*/
	private double[][] transformation=new double[2][2];
	/**
	* The translation matrix i.e. e,f
	*/
	private double[][] translation=new double[2][1];
	/**
	* Constructs an <code>AffineTransformation</code> with all elements 0.
	*/
	public AffineTransformation()
	{
		transformation[0][0] = 0.0;
		transformation[0][1] = 0.0;
		transformation[1][0] = 0.0;
		transformation[1][1] = 0.0;
		translation[0][0] = 0.0;
		translation[1][0] = 0.0;
	}
	/**
	* Constructs an <code>AffineTransformation</code> with given transformation matrix and translation matrix 0.
	* @param transformation the transformation matrix i.e. a,b,c,d
	*/
	public AffineTransformation(double[][] transformation)
	{
		this.transformation = transformation;
		translation[0][0] = 0.0;
		translation[1][0] = 0.0;
	}
	/**
	* Constructs an <code>AffineTransformation</code> with given transformation matrix and translation matrix.
	* @param transformation the transformation matrix i.e. a,b,c,d
	* @param translation the translation matrix i.e. e,f
	*/
	public AffineTransformation(double[][] transformation, double[][] translation)
	{
		this.transformation = transformation;
		this.translation = translation;
	}
	/**
	* Constructs an <code>AffineTransformation</code> with given a,b,c,d,e,f.
	* @param a the [0,0] element of the transformation matrix
	* @param b the [0,1] element of the transformation matrix
	* @param c the [1,0] element of the transformation matrix
	* @param d the [1,1] element of the transformation matrix
	* @param e the [0,0] element of the translation matrix
	* @param f the [1,0] element of the translation matrix
	*/
	public AffineTransformation(double a,double b,double c,double d,double e,double f)
	{
		transformation[0][0] = a;
		transformation[0][1] = b;
		transformation[1][0] = c;
		transformation[1][1] = d;
		translation[0][0] = e;
		translation[1][0] = f;
	}
	/**
	* Transforms the passed point with the current <code>AffineTransformation</code>
	* @return The transformed point
	*/
	public Point transform(Point point)
	{
		double x = point.getX();
		double y = point.getY();
		double u = 0.0;
		double v = 0.0;
		u = transformation[0][0]*x + transformation[0][1]*y;
		v = transformation[1][0]*x + transformation[1][1]*y;
		u = u + translation[0][0];
		v = v + translation[1][0];
		return new Point(u,v);
	}
	/**
	* @return a <code>Matrix2D</code> object of the transformation matrix.
	*/
	public Matrix2D getMatrix2D()
	{
		return new Matrix2D(transformation[0][0],transformation[0][1],transformation[1][0],transformation[1][1]);
	}
	/**
	* @param transformations The AffineTransformations used.
	* @return An array containing the probabilities to be used for each affine transformation
	*/
	public static double[] getProbabilities(AffineTransformation... transformations)
	{
		double sum_of_determinants = 0;
		double probabilities[] = new double[transformations.length];
		for(AffineTransformation affine : transformations)
		{
			sum_of_determinants+= Math.abs(affine.getMatrix2D().determinant());
		}
		int i = 0;
		for(AffineTransformation affine : transformations)
		{
			probabilities[i] = Math.abs(affine.getMatrix2D().determinant())/sum_of_determinants;
			i++;
		}
		return probabilities;
	}
}