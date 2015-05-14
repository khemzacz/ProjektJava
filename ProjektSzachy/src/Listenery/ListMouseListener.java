package Listenery;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectOutputStream;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;

import mainPackage.*;







public class ListMouseListener extends MouseAdapter
{
	JList list;
	ObjectOutputStream pisarz;
	
	public ListMouseListener( ObjectOutputStream pisarz)
	{
		this.pisarz = pisarz;
		
		
	}
	
	
	public void mouseClicked(MouseEvent evt)
	{
		list = (JList)evt.getSource();
		if (evt.getClickCount() == 2)
		{
			new CzatGraczy("tester");
			
		}
		
	}


	
}
