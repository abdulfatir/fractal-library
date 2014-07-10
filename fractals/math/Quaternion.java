package fractals.math;
public class Quaternion
{
	private double r,a,b,c;
	public Quaternion()
	{
		this.r = 0;
		this.a = 0;
		this.b = 0;
		this.c = 0;
	}
	public Quaternion(double r, double a, double b, double c)
	{
		this.r = r;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Quaternion conjugate()
	{
		return new Quaternion(this.r,-this.a,-this.b,-this.c);
	}
	public void add(Quaternion quaternion)
	{
		this.r = this.r + quaternion.r;
		this.a = this.a + quaternion.a;
		this.b = this.b + quaternion.b;
		this.c = this.c + quaternion.c;
	}
	public void multiply(Quaternion quaternion)
	{
		this.r = this.r*quaternion.r - this.a*quaternion.a - this.b*quaternion.b - this.c*quaternion.c;
		this.a = this.r*quaternion.a + this.a*quaternion.r + this.b*quaternion.c - this.c*quaternion.b; 
		this.b = this.r*quaternion.b + this.b*quaternion.r + this.c*quaternion.a - this.a*quaternion.c; 
		this.c = this.r*quaternion.c + this.c*quaternion.r + this.a*quaternion.b - this.b*quaternion.a; 
	}
	public double modulus()
	{
		return Math.sqrt(Math.pow(this.r,2) + Math.pow(this.a,2) + Math.pow(this.b,2) + Math.pow(this.c,2));
	}
	@Override
	public String toString()
	{
		return this.r+" + "+this.a+"i + "+this.b+"j + "+this.c+"k";
	}
}