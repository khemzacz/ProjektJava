package maleOkienka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import komunikacja.RamkaKlienta;

public class ZnajomiWindow extends JFrame implements Runnable
{
	JPanel panel;
	JScrollPane listaZnajomych;
	JList list;
	JTextField poleNicka;
	JButton dodajZnajomego;
	ObjectOutputStream pisarz;
	
	public ZnajomiWindow(ObjectOutputStream pisarz)
	{
		super("Znajomi");
		this.pisarz=pisarz;
		//this.list = list;
	}
	
	public void run() 
	{
		setSize(300,700);
		panel = new JPanel();
		listaZnajomych = new JScrollPane();
		poleNicka = new JTextField();
		dodajZnajomego = new JButton();
		
		panel.setLayout(null);
		panel.add(listaZnajomych);
		listaZnajomych.setBounds(10,10,280,600);
		panel.add(poleNicka);
		poleNicka.setBounds(10,620,180,20);
		panel.add(dodajZnajomego);
		dodajZnajomego.setBounds(200,620,90,20);
		dodajZnajomego.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					pisarz.writeObject(new RamkaKlienta(16,poleNicka.getText(),""));
					pisarz.flush();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}			
			}
		});
		
		
		add(panel);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

}
