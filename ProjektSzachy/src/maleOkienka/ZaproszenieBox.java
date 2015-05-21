package maleOkienka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import komunikacja.*;
import mainPackage.*;

public class ZaproszenieBox extends JFrame implements Runnable // to jes wywoływane przez odbiorcę komunikatów po odpowiednim pakiecie z serwera
{
	private JButton akceptuj = new JButton("Akceptuj");
	private JButton odrzuc = new JButton("Odrzuc");
	private JButton ignoruj = new JButton("ignoruj");
	private JPanel panel = new JPanel();
	private int width = 320;
	private int height = 80;
	
	private ArrayList<String> ignorowani;
	private String zapraszajacy;
	private String user;
	private ObjectOutputStream pisarz;
	private InternetChessGame rozgrywkaSieciowa;
	
	public ZaproszenieBox(String zapraszajacy, String user, ArrayList<String> ignorowani, ObjectOutputStream pisarz, InternetChessGame rozgrywkaSieciowa)
	{
		super("Zaproszenie do gry od: "+zapraszajacy);
		this.zapraszajacy=zapraszajacy;
		this.ignorowani=ignorowani;
		this.pisarz=pisarz;
		this.user=user;
		this.rozgrywkaSieciowa=rozgrywkaSieciowa;
	}
	
	
	public void run()
	{
		setSize(width,height);
		akceptuj.setBounds(10,height/2,90,20);
		odrzuc.setBounds(110,height/2,90,20);
		ignoruj.setBounds(210,height/2,90,20);
		
		akceptuj.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					pisarz.writeObject(new RamkaKlienta(7,user,zapraszajacy)); // akceptacja zapro
					pisarz.flush();
					
					rozgrywkaSieciowa=new InternetChessGame(zapraszajacy,"Bialy",true,pisarz);
					rozgrywkaSieciowa.run();
					
					// DO ZROBIENA utworzenie kontrolki z grą
					dispose();
				}
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				
			}
		});
		
		odrzuc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//DO ZROBIENIA -> Posłanie noobowi info, że został odrzucony;
				dispose();
			}
		});
		
		ignoruj.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ignorowani.add(zapraszajacy);
				// DO ZROBIENIA -> Posłanie noobowi info, że dostał ignora;
				dispose();
				
			}
		});
		
		panel.add(akceptuj);
		panel.add(odrzuc);
		panel.add(ignoruj);
		add(panel);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
	}

}
