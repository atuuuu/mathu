package IHM;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton
{
	final String name;
	
	public Button(String str, String name)
	{
		super(str);
		this.name = name;
		this.setBackground(Color.lightGray);
		this.setPreferredSize(new Dimension(100, 20));
	}
	
	@Override
	public String toString()
	{
		return "bouton : " + name;
	}
}
