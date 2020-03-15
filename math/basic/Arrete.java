package math.basic;

public class Arrete
{
	private Sommet origine;
	private Sommet arrive;
	
	public Arrete()
	{
		this.origine = null;
		this.arrive = null;
	}
	
	public Arrete(Sommet origine, Sommet arrive)
	{
		this.origine = origine;
		this.arrive = arrive;
	}
	
	//Basic method
	public String toString()
	{
		return ("Arrète reliant " + origine + " à " + arrive);
	}
	
	public Arrete clone()
	{
		return new Arrete(this.origine, this.arrive);
	}
	
	public boolean equals(Arrete A)
	{
		return (this == A || (this.origine == A.getOrigine() && this.arrive == A.getArrive()));
	}
	
	public Sommet getOrigine()
	{
		return this.origine;
	}
	
	public void setOrigine(Sommet origine)
	{
		this.origine = origine;
	}
	
	public Sommet getArrive()
	{
		return this.arrive;
	}
	
	public void setArrive(Sommet arrive)
	{
		this.arrive = arrive;
	}
}
