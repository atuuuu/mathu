package math.graphic.matriceFields;

import IHM.Fenetre;
import IHM.Button;
import math.basic.Graphe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class MatriceAdjField extends JDialog
{
	private final JFormattedTextField[][] jtf;
	private final Fenetre fen;
	private final int dim;
	private int[][] matAdjacence;
	private final String nom;
	
	public MatriceAdjField(Fenetre fen, int dim, String nom)
	{
		super(fen, "Renseignez la matrice d'adjacence", false);
		this.nom = nom;
		this.jtf = new JFormattedTextField[dim][dim];
		this.dim = dim;
		this.fen = fen;
		JLabel label = new JLabel("Renseignez la matrice d'adjacence :");
		Button Ok = new Button("Valider", "Valider");
		JPanel top = new JPanel();
		Button allToOne = new Button("Tout mettre à 1", "Tout mettre à 1");
		
		Font police = new Font("Arial", Font.BOLD, 14);
		
		this.setSize(Math.min(dim * 105, 1900), Math.min(dim*105+30, 1000));
		this.setContentPane(top);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setEnabled(true);
		
		Ok.addActionListener(new MatriceAdjField.BoutonListener());
		allToOne.addActionListener(new BoutonAllToOneListener());
		
		top.setLayout(new GridLayout(dim+1, dim));
		
		top.setSize(dim*100, dim*100+30);
	
		for(int i = 0; i<this.dim; i++)
		{
			for(int j = 0; j<this.dim; j++)
			{
				this.matAdjacence = new int[dim][dim];
				this.jtf[i][j] = new JFormattedTextField(NumberFormat.getIntegerInstance());
				this.jtf[i][j].setFont(police);
				this.jtf[i][j].setPreferredSize(new Dimension(150, 30));
				this.jtf[i][j].setForeground(Color.BLACK);
				this.jtf[i][j].addActionListener(new BoutonListener());
				top.add(this.jtf[i][j]);
			}
		}

		top.add(label);
		top.add(Ok);
		top.add(allToOne);
	}
	
	
	class BoutonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) throws NumberFormatException
		{
			for(int i = 0; i<dim; i++)
			{
				for(int j = 0; j<dim; j++)
				{
					try
					{
						matAdjacence[i][j] = Integer.parseInt(jtf[i][j].getText());
						jtf[i][j].setVisible(false);
						jtf[i][j].setEnabled(false);
					} catch(NumberFormatException ex)
					{
						matAdjacence[i][j]= 0;
					}
				}
			}
			
			Graphe nouv = new Graphe(matAdjacence, false, nom);
			setEnabled(false);
			setVisible(false);
			fen.addGraphToGraphList(new Button(nouv.getName(), nouv.getName()), nouv);
			fen.repaint();
			fen.revalidate();
		}
	}
	
	class BoutonAllToOneListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) throws NumberFormatException
		{
			for(int i = 0; i<dim; i++)
			{
				for(int j = 0; j < dim; j++)
				{
					jtf[i][j].setValue(1);
				}
			}
		}
	}
}
