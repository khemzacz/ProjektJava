package Listenery;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;

import mainPackage.*;
import maleOkienka.NieMozeszCzatowacSamZeSoba;







public class KontaktyListListener extends MouseAdapter
{
	JList list;
	ObjectOutputStream pisarz;
	ArrayList <CzatGraczy> watkiCzatow;
	String nadawca;
	
	public KontaktyListListener(String nadawca, ObjectOutputStream pisarz, ArrayList <CzatGraczy> watkiCzatow)
	{
		this.pisarz = pisarz;
		this.nadawca = nadawca;
		this.watkiCzatow = watkiCzatow;
	}
	
	
	public void mouseClicked(MouseEvent evt)
	{
		list = (JList)evt.getSource();
		if (evt.getClickCount() == 2)
		{
			if(nadawca.equals((String)list.getSelectedValue()))
			{
				new NieMozeszCzatowacSamZeSoba().run();
				return;
			}
			
	        int index = list.locationToIndex(evt.getPoint());
	        System.out.println("index: "+index); // wypisuje index bolka z tablicy bolków
			
	        String rozmowca = (String) list.getSelectedValue();
	        rozmowca = rozmowca.substring(0, rozmowca.lastIndexOf("-")-1);
	        CzatGraczy czat;
			czat = new CzatGraczy(nadawca,rozmowca,pisarz,watkiCzatow);
			for (CzatGraczy tmp : watkiCzatow)
			{
				if (tmp.getRozmowca().equals(rozmowca))
				{
					tmp.requestFocus();
					return;
				}
			}
			watkiCzatow.add(czat);
			czat.run(); // on sam to zakonczy po dispose
		}
		
	}


	
}
