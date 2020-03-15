package math.basic;

public class Vecteur2D
{
	private Point2D origine;
	private Point2D arrive;
	private int i, j;
	
	//Builders
	public Vecteur2D()
	{
		this.origine = new Point2D();
		this.arrive = new Point2D();
		this.i = 0;
		this.j = 0;
	}
	
	public Vecteur2D(Point2D origine, Point2D arrive)
	{
		this.origine = origine;
		this.arrive = arrive;
		this.i = this.arrive.getX() - this.origine.getX();
		this.j = this.arrive.getY() - this.origine.getY();
	}
	
	public Vecteur2D(Point2D origine, int i, int j)
	{
		this.origine = origine;
		this.i = i;
		this.j = j;
		this.arrive = new Point2D();
		this.arrive.setX(this.origine.getX() + i);
		this.arrive.setY(this.origine.getY() + j);
	}
	
	public Vecteur2D(int i, int j, Point2D arrive)
	{
		this.arrive = arrive;
		this.i = i;
		this.j = j;
		this.origine = new Point2D();
		this.origine.setX(this.arrive.getX() - i);
		this.origine.setY(this.arrive.getY() - j);
	}
	
	
	//basic method
	@Override
	public Vecteur2D clone()
	{
		return new Vecteur2D(this.origine, this.arrive);
	}
	
	public boolean equals(Vecteur2D V)
	{
		return this == V || (this.origine == V.getOrigine() && this.arrive == V.getArrive());
	}
	
	@Override
	public String toString()
	{
		return "V(" + this.i + ", " + this.j + ")";
	}
	
	
	//getters
	public Point2D getOrigine()
	{
		return this.origine;
	}
	
	//setters
	public void setOrigine(Point2D origine)
	{
		this.origine = origine;
		this.i = (this.arrive.getX() - this.origine.getX());
		this.j = (this.arrive.getY() - this.origine.getY());
		
	}
	
	public Point2D getArrive()
	{
		return this.arrive;
	}
	
	public void setArrive(Point2D arrive)
	{
		this.arrive = arrive;
		this.i = (this.arrive.getX() - this.origine.getX());
		this.j = (this.arrive.getY() - this.origine.getY());
	}
	
	public int getI()
	{
		return this.i;
	}
	
	public int getJ()
	{
		return this.j;
	}
}
