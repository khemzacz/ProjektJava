package Listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;

import mainPackage.MainMenu;
import maleOkienka.CzyNaPewnoChceszSieWylogowac;

public class WylogujButtonListener implements ActionListener
{
	private ObjectOutputStream pisarz;
	private JButton connectButton;
	private MainMenu menu;
	
	public WylogujButtonListener(ObjectOutputStream pisarz,JButton connectButton, MainMenu menu)
	{
		this.pisarz = pisarz;
		this.connectButton = connectButton;
		this.menu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		new CzyNaPewnoChceszSieWylogowac(pisarz,connectButton, menu).run();
		
		
	}

}
