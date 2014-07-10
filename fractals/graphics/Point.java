package fractals.graphics;
/**
 * <code>Point</code> is a class which implements a point in 2D plane in Java. 
 *
 * @author      Abdul Fatir
 * @version		1.0
 * 
 */
public class Point
{
	/**
	* The X co-ordinate of the <code>Point</code>.
	*/
	private double x;
	/**
	* The Y co-ordinate of the <code>Point</code>.
	*/
	private double y;
	/**
	* Constructs a new <code>Point</code> with X = 0.0 and Y = 0.0
	*/
	public Point()
	{
		x = 0.0;
		y = 0.0;
	}
	/**
	* Constructs a new <code>Point</code> object.
	* @param x The X co-ordinate
	* @param y The Y co-ordinate
	*/
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	/**
	* @return the X co-ordinate of the <code>Point</code>
	*/
	public double getX()
	{
		return this.x;
	}
	/**
	* @return the Y co-ordinate of the <code>Point</code>
	*/
	public double getY()
	{
		return this.y;
	}
	/**
	* Sets the X co-ordinate to the given argument.
	* @param x The X co-ordinate
	*/
	public void setX(double x)
	{
		this.x = x;
	}
	/**
	* Sets the Y co-ordinate to the given argument.
	* @param y The Y co-ordinate
	*/
	public void setY(double y)
	{
		this.y = y;
	}
	/**
	* Translates the point with the passed values.
	* @param dx The translatation in X.
	* @param dy The translatation in Y.
	*/
	public void translate(double dx, double dy)
	{
		x += dx;
		y += dy;
	}
}