package math.graphic;

import IHM.Fenetre;
import math.basic.Graphe;
import math.basic.Point2D;

import javax.swing.*;
import java.awt.*;

public class GraphicGraphe extends JPanel
{
	private Fenetre fen;
	private Point2D circleCenter;
	private Graphe modele;
	private int sommetRadius;
	private final int mainCircleRadius;
	
	//Constructeurs
	
	public GraphicGraphe(Graphe graph, Point2D circleCenter, int graphSize, int width, int height, Fenetre fenetre)
	{
		this.fen = fenetre;
		this.setPreferredSize(new Dimension(width, height));
		this.circleCenter = circleCenter;
		this.modele = graph;
		this.sommetRadius = 20;
		this.mainCircleRadius = graphSize-20;
	}
	
	public void setModele(Graphe modele)
	{
		this.modele = modele;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawString("GRAPHE : " + modele.getName(), 160, 50);
		
		//Responsive drawings
		Graphics2D g2d = (Graphics2D) g;
		g2d.scale((double)this.getWidth()/1920, (double)this.getHeight()/1000);
		
		int x;    //Coordonnée x du Sommet
		int y;    //Coordonnée y du Sommet
		String label;
		
		for(int i = 0; i < modele.getSommets().size(); i++)
		{		//Point coordinate determination
			x = (int) (this.circleCenter.getX() + this.mainCircleRadius/2 * Math.cos(i));	//Calcul de x
			y = (int) (this.circleCenter.getY() + this.mainCircleRadius/2 * Math.sin(i));	//Calcul de y
			//Point names/index display
			label = (modele.getSommets().get(i).getNom());
			if(label==null) label = Integer.toString(i);
			
			//Point display
			g.fillOval(x, y, this.sommetRadius, this.sommetRadius);    //dessine le sommet aux coordonnées calculées précedemment
			g.drawString(label, x-5, y-5);
			//Point coordinate storing
			modele.getSommets().get(i).setX(x + 10);    //Enregistre les coordonnées du sommet
			modele.getSommets().get(i).setY(y + 10);    //Enregistre les coordonnées du sommet
		}
		
		//Lines drawing
		for(int i = 0; i < modele.getArretes().size(); i++)    //Dessine les arrètes enregistrées dans la liste du graphe passé en paramètre
		{
			//affiche un ligne allant de l'origine de l'arrète : origine(x, y) à l'arrivée de l'arrète : arrive(x, y)
			g.drawLine(modele.getArretes().get(i).getOrigine().getX(), modele.getArretes().get(i).getOrigine().getY(), modele.getArretes().get(i).getArrive().getX(), modele.getArretes().get(i).getArrive().getY());
		}
		
		fen.repaint();
		fen.revalidate();
	}
}
