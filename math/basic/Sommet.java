package math.basic;

public class Sommet extends Point2D
{
	private int degre;
	private String nom;
	
	//Builders
	public Sommet()
	{
		super();
		this.degre = 0;
	}
	
	public Sommet(int degre, String nom)
	{
		super();
		this.degre = degre;
		this.nom = nom;
	}
	
	
	//basic methods
	public Sommet clone()
	{
		return new Sommet(this.degre, this.nom);
	}
	
	public boolean equals(Sommet S)
	{
		return this == S || (this.degre == S.getDegre() && this.nom == S.getNom());
	}
	
	public String toString()
	{
		return "Sommet de " + this.degre + " degré(s) nommé " + this.getNom();
	}
	
	public int getDegre()
	{
		return this.degre;
	}
	
	public void setDegre(int degre)
	{
		this.degre = degre;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
}
