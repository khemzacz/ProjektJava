package Listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.IOException;
import java.io.ObjectOutputStream;

import mainPackage.*;
import maleOkienka.*;

public class PowrotDoMenuListener implements ActionListener
{
	private MainMenu menu;
	
	public PowrotDoMenuListener(MainMenu menu)
	{
		this.menu = menu;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		if(!menu.getLoginFlag())
		new CzyNaPewnoPowrotDoMenu(menu).run();
		else if(menu.getLoginFlag())
		new NajpierwSieWyloguj().run();
	}

}
