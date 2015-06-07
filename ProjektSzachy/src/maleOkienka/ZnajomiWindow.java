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
	JButton kasujZnajomego;
	ObjectOutputStream pisarz;
	
	public ZnajomiWindow(ObjectOutputStream pisarz)
	{
		super("Znajomi");
		this.pisarz=pisarz;
		//this.list = list;
	}
	
	public void run() 
	{
		setSize(310,100);
		panel = new JPanel();
		listaZnajomych = new JScrollPane();
		poleNicka = new JTextField();
		dodajZnajomego = new JButton("Dodaj Kontakt");
		kasujZnajomego = new JButton("Kasuj Kontakt");
		
		panel.setLayout(null);
		panel.add(poleNicka);
		poleNicka.setBounds(10,10,275,20);
		dodajZnajomego.setBounds(10,30,135,20);
		kasujZnajomego.setBounds (150,30,135,20);
		panel.add(kasujZnajomego);
		panel.add(dodajZnajomego);
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
		
		kasujZnajomego.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					pisarz.writeObject(new RamkaKlienta(18,poleNicka.getText(),""));
					pisarz.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		
		add(panel);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

}
