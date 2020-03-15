package math.basic;

public class Point2D
{
	private int x, y;
	
	//Builders
	public Point2D()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Point2D(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//basic method
	public Point2D clone()
	{
		return new Point2D(this.x, this.y);
	}
	
	public boolean equals(Point2D P)
	{
		return this == P || (this.x == P.getX() && this.y == P.getY());
	}
	
	public String toString()
	{
		return ("(" + this.x + ", " + this.y + ")");
	}
	
	//Setters
	public void setCoord(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//Getters
	public int getX()
	{
		return this.x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int[] getCoord()
	{
		int[] tab = new int[2];
		tab[0] = this.x;
		tab[1] = this.y;
		return tab;
	}
}
