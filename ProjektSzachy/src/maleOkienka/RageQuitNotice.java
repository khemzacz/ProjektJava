package maleOkienka;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mainPackage.InternetChessGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.IOException;

import komunikacja.RamkaKlienta;


public class RageQuitNotice extends JFrame implements Runnable
{
	private JButton tak = new JButton("TAK");
	private JButton nie = new JButton("NIE");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private int width = 320;
	private int height = 130;
	private InternetChessGame graSieciowa;
	
	public RageQuitNotice(InternetChessGame graSieciowa)
	{
		super("notice");
		this.graSieciowa=graSieciowa;
	}
	
	public void run()
	{
		setSize(width,height);
		setLocationRelativeTo(null);
		label.setBounds(10,10,300,40);
		label.setText("<html><center>Jeśli wyjdziesz z gry zostanie to potraktowane<p> jako porażka, na pewno chcesz wyjść?</center></html>");
		tak.setBounds(width/2-85,height/2+40,75,20);
		tak.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try 
				{
					graSieciowa.getPisarz().writeObject(new RamkaKlienta(9,"",""));
					graSieciowa.getPisarz().flush();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			
				graSieciowa.dispose();
				dispose();
			}
			
		});
		nie.setBounds(width/2+10,height/2+40,75,20);
		nie.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ev)
			{
				dispose();	
			}
		});
		panel.add(label);
		panel.add(tak);
		panel.add(nie);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
}
