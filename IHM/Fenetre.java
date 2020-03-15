package IHM;

import math.basic.Graphe;
import math.basic.Point2D;
import math.graphic.GraphicGraphe;
import math.graphic.matriceFields.MatriceAdjField;
import math.graphic.matriceFields.MatriceDimField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fenetre extends JFrame
{
	private final JFrame fenetre;
	private final Button boutNouv;
	private final Button swapGraph;
	private final MatriceDimField MF;
	private final JPanel graphList;
	private GridBagConstraints cGraphList;
	private GridBagConstraints cGrapheDisplay;
	private GridBagConstraints cSwapGraph;
	private GridBagConstraints cBoutNouv;
	private Container background;
	private GraphicGraphe grapheDisplay;
	
	
	public Fenetre(String name, int hauteur, int largeur)	//Mettre un GridBagLayout
	{
		this.background = new Container();
		this.background.setLayout(new GridBagLayout());
		this.background.setSize(hauteur, largeur);
		
		
		this.swapGraph = new Button("Liste des graphes", "Liste des graphes");
		this.swapGraph.setPreferredSize(new Dimension(150, 20));
		this.swapGraph.addActionListener(new swapGraphObserver(swapGraph));
		
		this.cSwapGraph = new GridBagConstraints();this.cSwapGraph.gridx = 1;
		this.cSwapGraph.gridy = 0;
		
		
		this.boutNouv = new Button("Nouveau", "Nouveau");
		this.boutNouv.setPreferredSize(new Dimension(150, 20));
		this.boutNouv.addActionListener(new boutonNouveauObserver(boutNouv));
		
		this.cBoutNouv = new GridBagConstraints();this.cBoutNouv.gridx = 0;
		this.cBoutNouv.gridy = 0;
		
		
		this.grapheDisplay = new GraphicGraphe
		(
				new Graphe(),	//empty graph to initiate the display
				new Point2D(background.getWidth()/3, background.getHeight()/2),	//point where the graph is displayed
				this.background.getWidth()/2,	//circular displayed graph width
				this.background.getWidth(),	//free graph width
				this.background.getHeight(),//free graph height
				this	//window updated after each change
		);
		
		this.cGrapheDisplay = new GridBagConstraints();
		this.cGrapheDisplay.gridx = 2;
		this.cGrapheDisplay.gridy = 1;
		this.cGrapheDisplay.weightx = 1;
		this.cGrapheDisplay.weighty = 1;
		
		
		this.graphList = new JPanel();
		this.graphList.setLayout(new BoxLayout(graphList, BoxLayout.PAGE_AXIS));
		this.graphList.add(Box.createVerticalGlue());
		this.graphList.setMaximumSize(new Dimension(200, 900));
		this.graphList.setBackground(Color.GRAY);
		this.graphList.setVisible(false);
		
		this.cGraphList = new GridBagConstraints();
		this.cGraphList.fill = GridBagConstraints.BOTH;
		this.cGraphList.gridx = 0;
		this.cGraphList.gridy = 1;
		this.cGraphList.gridheight = 2;
		this.cGraphList.gridwidth = 2;
		
		
		this.background.add(swapGraph, this.cSwapGraph);
		this.background.add(boutNouv, this.cBoutNouv);
		this.background.add(grapheDisplay, this.cGrapheDisplay);
		this.background.add(graphList, this.cGraphList);
		
		
		fenetre = new JFrame();
		fenetre.setTitle(name);
		fenetre.setSize(hauteur, largeur);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setContentPane(background);
		fenetre.setVisible(true);
		
		
		this.MF = new MatriceDimField(this);
		
		
		fenetre.repaint();
		fenetre.revalidate();
	}
	
	
	public void nouvMatAdj(int dim, String nom)
	{
		MatriceAdjField nouv = new MatriceAdjField(this, dim, nom);
	}
	
	
	public void addGraphToGraphList(Button graphButton, Graphe linkedGraphe)
	{
		Container con = new Container();
		con.setLayout(new FlowLayout());
		con.setPreferredSize(new Dimension(200, 30));
		
		con.add(graphButton);
		graphButton.addActionListener(new graphSwapper(linkedGraphe, this));
		
		Button supp = new Button("Supprimer", "Supprimer");
		supp.addActionListener(new graphSuppr(con, this));
		con.add(supp);
		
		this.graphList.add(con);
		fenetre.repaint();
		fenetre.revalidate();
	}
	
	
	public void displayNouvBar()
	{
		MF.start();
	}
	
	
	//Button observer classes
	class boutonNouveauObserver implements ActionListener
	{
		private int c = 0;
		public boutonNouveauObserver(@NotNull Button nouv)
		{
			nouv.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(c==0)
			{
				displayNouvBar();
			}
			c = (c+1)%2;
			fenetre.repaint();
			fenetre.revalidate();
		}
	}
	
	
	class swapGraphObserver implements ActionListener
	{
		private int c = 0;
		private boolean i = false;
		public swapGraphObserver(@NotNull Button nouv)
		{
			nouv.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(c==0)
			{
				i = !i;
				graphList.setVisible(i);
				graphList.setEnabled(i);
			}
			
			c = (c+1)%2;
			fenetre.repaint();
			fenetre.revalidate();
		}
	}
	
	
	class graphSwapper implements ActionListener
	{
		private final Graphe graphe;
		protected final Fenetre fen;
		
		public graphSwapper(Graphe linkedGraphe, Fenetre fen)
		{
			this.graphe = linkedGraphe;
			this.fen = fen;
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			grapheDisplay.setModele(graphe);
			grapheDisplay.setMinimumSize(new Dimension(background.getWidth(), background.getWidth()));
			System.out.println(background.getWidth());
			Container contentPane = new Container();
			contentPane.setLayout(new GridBagLayout());
			
			contentPane.add(grapheDisplay, cGrapheDisplay);
			contentPane.add(boutNouv, cBoutNouv);
			contentPane.add(swapGraph, cSwapGraph);
			contentPane.add(graphList, cGraphList);
			fenetre.setContentPane(contentPane);
			
			fenetre.repaint();
			fenetre.revalidate();
		}
	}
	
	
	class graphSuppr extends graphSwapper implements ActionListener
	{
		private Container con;
		
		public graphSuppr(Container con, Fenetre fen)
		{
			super(new Graphe(), fen);
			this.con = con;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			super.actionPerformed(e);
			graphList.remove(con);
			
			fenetre.repaint();
			fenetre.revalidate();
		}
	}
}
