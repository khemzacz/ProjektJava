package Listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JList;

import komunikacja.*;

public class ZaprosDoGryListener implements ActionListener
{
	JList list;
	String cel;
	ObjectOutputStream pisarz;
	
	public ZaprosDoGryListener(JList list, ObjectOutputStream pisarz)
	{
		this.list = list;
		this.pisarz=pisarz;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		cel = (String) list.getSelectedValue();
		System.out.println("Próba zaproszenia: "+cel);
		try {
			pisarz.writeObject(new RamkaKlienta(6,cel,""));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
