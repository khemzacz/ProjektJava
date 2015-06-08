package maleOkienka;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mainPackage.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.IOException;
import java.io.ObjectOutputStream;

import komunikacja.*;

public class CzyNaPewnoChceszSieWylogowac extends JFrame implements Runnable
{
	private JButton tak = new JButton("TAK");
	private JButton nie = new JButton("NIE");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private int width = 320;
	private int height = 100;
	private ObjectOutputStream pisarz;
	private JButton connectButton;
	private MainMenu menu;
	
	public CzyNaPewnoChceszSieWylogowac(ObjectOutputStream pisarz, JButton connectButton, MainMenu menu)
	{
		super("notice");
		this.pisarz=pisarz;
		this.connectButton=connectButton;
		this.menu = menu;
		
	}
	
	@Override
	public void run()
	{
		setSize(width,height);
		setLocationRelativeTo(null);
		label.setBounds(10,10,300,20);
		label.setText("Jesteś pewien, że chcesz się wylogować?");
		tak.setBounds(width/2-85,height/2+40,75,20);
		tak.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					pisarz.writeObject(new RamkaKlienta(99,"",""));
					pisarz.flush();
					menu.disableStButton();
					//menu.diableZnajomiButton();
					menu.disableDodajZnajomegoButton();
					dispose();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
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
