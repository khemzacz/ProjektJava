package Listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import maleOkienka.CzyNaPewnoChceszWyjsc;

public class ExitButtonListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new CzyNaPewnoChceszWyjsc().run();		
	}

}
