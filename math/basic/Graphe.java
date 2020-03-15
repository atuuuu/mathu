package math.basic;

import java.util.LinkedList;
import java.util.List;

public class Graphe
{
	private final List<Sommet> sommets;
	private final List<Arrete> arretes;
	private final MatAdjacence matrice;
	private boolean oriente;
	private String name;
	
	public Graphe()
	{
		this.sommets = new LinkedList<Sommet>();
		this.arretes = new LinkedList<Arrete>();
		this.oriente = false;
		this.matrice = null;
		this.name = null;
	}
	
	public Graphe(boolean oriente)
	{
		this.sommets = new LinkedList<Sommet>();
		this.arretes = new LinkedList<Arrete>();
		this.oriente = oriente;
		this.matrice = null;
		this.name = null;
	}
	
	public Graphe(int[][] mat, boolean oriente, String name)
	{
		
		this.sommets = new LinkedList<Sommet>();
		this.arretes = new LinkedList<Arrete>();
		this.matrice = new MatAdjacence(mat);
		this.oriente = oriente;
		this.createLists();
		this.name = name;
	}
	
	public Graphe(LinkedList<Sommet> sommets, LinkedList<Arrete> arretes, boolean oriente)
	{
		
		this.sommets = sommets;
		this.arretes = arretes;
		this.matrice = null;
		this.oriente = oriente;
	}
	
	private void createLists()
	{
		for(int i = 0; i < this.matrice.dim; i++)
		{
			Sommet temp = new Sommet();
			this.sommets.add(temp);
			
			for(int j = 0; j<i; j++)
			{
				if(this.matrice.matrice[i][j] == 1)
					this.arretes.add(new Arrete(this.sommets.get(i), this.sommets.get(j)));
			}
		}
	}
	
	public void addSommet(Sommet nouv)
	{
		sommets.add(nouv);
	}
	
	public void addArrete(Arrete nouv)
	{
		arretes.add(nouv);
	}
	
	public List<Sommet> getSommets()
	{
		return sommets;
	}
	
	public List<Arrete> getArretes()
	{
		return arretes;
	}
	
	public boolean isOriente()
	{
		return oriente;
	}
	
	public void setOriente(boolean oriente)
	{
		this.oriente = oriente;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
