package adapteryOkien;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import mainPackage.InternetChessGame;
import maleOkienka.RageQuitNotice;

public class graSieciowaCloseAdapter extends WindowAdapter
{
	private InternetChessGame graSieciowa;
	public graSieciowaCloseAdapter(InternetChessGame graSieciowa)
	{
		this.graSieciowa=graSieciowa;
	}
	
	public void windowClosing(WindowEvent evt)
	{
		new RageQuitNotice(graSieciowa).run();
	}
}
