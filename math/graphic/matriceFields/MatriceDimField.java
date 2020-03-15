package math.graphic.matriceFields;

import IHM.ErrorBox;
import IHM.Fenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class MatriceDimField extends JDialog
{
	private final JTextField jtfName;
	private final JFormattedTextField jtf;
	private final Fenetre fen;
	private final MatriceDimField ceci = this;
	
	public MatriceDimField(Fenetre fen)
	{
		super(fen, "Nouvelle matrice", true);
		this.fen = fen;
		JLabel label = new JLabel("Dimension :");
		JLabel name = new JLabel("Nom :");
		IHM.Button Ok = new IHM.Button("Ok", "ok");
		this.jtf = new JFormattedTextField(NumberFormat.getIntegerInstance());
		this.jtfName = new JTextField();
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(3, 2));
		IHM.Button cancel = new IHM.Button("Annuler", "Annuler");
		cancel.addActionListener(new cancelListener());
		
		this.setTitle("Nouvelle matrice d'adjacence");
		this.setSize(300, 120);
		this.setContentPane(top);
		this.setLocationRelativeTo(null);
		
		Font police = new Font("Arial", Font.BOLD, 14);
		
		Ok.addActionListener(new BoutonListener());
		
		jtf.setFont(police);
		jtf.setPreferredSize(new Dimension(150, 30));
		jtf.setForeground(Color.BLACK);
		
		jtfName.setFont(police);
		jtfName.setPreferredSize(new Dimension(150, 30));
		jtfName.setForeground(Color.BLACK);
		
		top.add(label);
		top.add(jtf);
		top.add(name);
		top.add(jtfName);
		top.add(Ok);
		top.add(cancel);
	}
	
	public void start()
	{
		this.setEnabled(true);
		this.setVisible(true);
		this.jtf.setValue(null);
		this.jtfName.setText("");
		this.jtf.requestFocus();
	}
	
	public void stop()
	{
		this.setEnabled(false);
		this.setVisible(false);
	}
	
	class BoutonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) throws NumberFormatException
		{
			int dim = 0;
			String nom = null;
			JOptionPane er;
			boolean goNext = true;
			
			try
			{
				dim = Integer.parseInt(jtf.getText());
				nom = jtfName.getText();
			} catch(NumberFormatException ex)
			{
				goNext = false;
			}
			finally
			{
				if(nom != null && (dim<=0 || nom.equals("")))
				{
					er = new JOptionPane();
					er.showMessageDialog(null, "Merci d'entrer un entier positif supérieur à 0 et un nom", "Erreur", JOptionPane.ERROR_MESSAGE);
					goNext = false;
				}
			}
			
			if(goNext)
			{
				setEnabled(false);
				setVisible(false);
				MatriceAdjField nouvMat = new MatriceAdjField(fen, dim, nom);
			}
		}
	}
	
	class cancelListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			stop();
		}
	}
}
