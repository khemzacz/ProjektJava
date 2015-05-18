package Listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JList;

import maleOkienka.NieMozeszZaprosicSamegoSiebie;
import komunikacja.*;

public class ZaprosDoGryListener implements ActionListener
{
	JList list;
	String cel;
	String zapraszajacy;
	ObjectOutputStream pisarz;
	
	public ZaprosDoGryListener(JList list, ObjectOutputStream pisarz, String zapraszajacy)
	{
		this.list = list;
		this.pisarz=pisarz;
		this.zapraszajacy = zapraszajacy;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		cel = (String) list.getSelectedValue();
		System.out.println("Próba zaproszenia: "+cel);
		if (cel .equals (zapraszajacy))
		{
			new NieMozeszZaprosicSamegoSiebie().run();
			return;
		}
		try {
			pisarz.writeObject(new RamkaKlienta(6,zapraszajacy,cel));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
