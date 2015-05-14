package mainPackage;

import java.util.List;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class KlientCzatu implements Runnable
{
	String ip ="127.0.0.1";
	int port=5000;

	

	
	
	@Override
	public void run() 
	{
		try
		{

			
			System.out.println("Laczenie z hostem " +ip + " na porcie: " + port );
			Socket gniazdo = new Socket(ip,port);

			InputStreamReader strCzytelnik = new InputStreamReader(gniazdo.getInputStream());
			BufferedReader czytelnik = new BufferedReader(strCzytelnik);
			
			String message = czytelnik.readLine();
			System.out.println("Message of the Day: " + message);
			
			czytelnik.close();
		}
		catch (IOException ex)
		{
			//ex.printStackTrace();
			System.out.println("Nie udalo sie polaczyc  z hostem");
		}
		
	}
		
	
	
	
}
