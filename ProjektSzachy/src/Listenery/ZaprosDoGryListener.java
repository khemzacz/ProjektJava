package Listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JList;

public class ZaprosDoGryListener implements ActionListener
{
	JList list;
	String cel;
	
	public ZaprosDoGryListener(JList list)
	{
		this.list = list;		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		cel = (String) list.getSelectedValue();
		System.out.println(cel);
	}

}
