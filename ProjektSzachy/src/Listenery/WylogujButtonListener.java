package Listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.IOException;
import java.io.ObjectOutputStream;

import maleOkienka.CzyNaPewnoChceszSieWylogowac;

public class WylogujButtonListener implements ActionListener
{
	private ObjectOutputStream pisarz;
	
	public WylogujButtonListener(ObjectOutputStream pisarz)
	{
		this.pisarz = pisarz;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		new CzyNaPewnoChceszSieWylogowac(pisarz).run();
		
		
	}

}
