package IHM;

import javax.swing.*;
import java.awt.*;

public class ErrorBox extends JFrame
{
	public ErrorBox(String e)
	{
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setSize(350, 100);
		
		JLabel msg = new JLabel();
		msg.setText(e);
		msg.setForeground(Color.RED);
		
		this.add(msg);
		this.setVisible(true);
		this.setEnabled(true);
	}
}
