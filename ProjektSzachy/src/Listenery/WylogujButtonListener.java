package Listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;

import maleOkienka.CzyNaPewnoChceszSieWylogowac;

public class WylogujButtonListener implements ActionListener
{
	private ObjectOutputStream pisarz;
	private JButton connectButton;
	
	public WylogujButtonListener(ObjectOutputStream pisarz,JButton connectButton)
	{
		this.pisarz = pisarz;
		this.connectButton = connectButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		new CzyNaPewnoChceszSieWylogowac(pisarz,connectButton).run();
		
		
	}

}
