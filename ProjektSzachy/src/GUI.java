import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame 
{
	private JPanel p1 = new JPanel();
	private JButton connectButton = new JButton("Connect");
	private JButton rejestracjaButton = new JButton("rejestruj");
	private JButton wyslij = new JButton("Wyslij");
	private JTextField doWyslania = new JTextField();
	private JTextField loginTextField = new JTextField();
	private JTextField hasloTextField = new JTextField();
	private JTextField adresTextField = new JTextField("127.0.0.1");
	private JTextArea odebraneWiadomosci = new JTextArea();
	private JLabel loginLabel = new JLabel("Login: ");
	private JLabel hasloLabel = new JLabel("Haslo: ");
	private JLabel adresLabel = new JLabel("Adres: ");
	private String importedLogin = new String("");



	private boolean loginFlag=true;
	
	String ip;
	String nadawca;
	int port=5000;
	
	BufferedReader czytelnik;
	PrintWriter pisarz;
	Socket gniazdo;
	
	
	GUI(String tekst)
	{super(tekst);}
	
	public void guiStart()
	{
		setSize(250,500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p1.setLayout(null);
		
		/*communicationConfig();
		Thread watekOdbiorcy = new Thread(new OdbiorcaKomunikatow());
		watekOdbiorcy.start();*/
		
		wyslij.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				if (!loginFlag)
					return;
				try {
				//importedLogin = loginTextField.getText();
				//System.out.println("Pobrany Login: " +importedLogin);
				pisarz.println((nadawca+": "+doWyslania.getText()));
				pisarz.flush();
				//odebraneWiadomosci.append("\n PrzeslanoLogin");
				}
				catch (Exception ex)
				{
					//ex.printStackTrace();
					System.out.println("Nie udalo sie poslac");
				}
				doWyslania.setText("");// czyści pole tekstowe na login
				doWyslania.requestFocus();
				
			}
		});
		
		connectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				communicationConfig();
				Thread watekOdbiorcy = new Thread(new OdbiorcaKomunikatow());
				watekOdbiorcy.start();
			
			}
		});

		adresLabel.setBounds(5,15,60,20);
		adresTextField.setBounds(50,15, 180,20);
		connectButton.setBounds(25+5,80,85,20);
		rejestracjaButton.setBounds(90+25,80,100,20);
		loginLabel.setBounds(5+25,40,60,20);
		//hasloLabel.setBounds(5+25,60,60,20);
		loginTextField.setBounds(65+25,40,126,20);
		//hasloTextField.setBounds(65+25,60,126,20);
		odebraneWiadomosci.setBounds(5+25,100,185,200);
		doWyslania.setBounds(5+25,305,185,40);
		wyslij.setBounds(5+25,347,80,20);

		
		
		p1.add(adresLabel);
		p1.add(adresTextField);
		p1.add(loginLabel);
		p1.add(hasloLabel);
		p1.add(loginTextField);
		p1.add(hasloTextField);
		//p1.add(rejestracjaButton);
		p1.add(connectButton);
		p1.add(odebraneWiadomosci);
		p1.add(doWyslania);
		p1.add(wyslij);
		add(p1);

		setVisible(true);
		

	}
	
	public String getLogin()
	{
		return importedLogin;
	}
	
	public void communicationConfig()
	{
		ip=adresTextField.getText();
		nadawca=loginTextField.getText();
		try
		{
			gniazdo = new Socket(ip,port);
			InputStreamReader czytelnikStrm = new InputStreamReader(gniazdo.getInputStream());
			czytelnik = new BufferedReader(czytelnikStrm);
			pisarz = new PrintWriter(gniazdo.getOutputStream());
			odebraneWiadomosci.append("Obsluga sieci przygotowana");
		} 
		catch (IOException ex) {
			// TODO Auto-generated catch block
			//ex.printStackTrace();
			loginFlag=false;
			System.out.println("Nie skonfigurowano sieci");
		}
	}
	
	public class OdbiorcaKomunikatow implements Runnable {
		public void run() {
			String wiadom;
			try {
				while ((wiadom = czytelnik.readLine()) !=null)
				{
					System.out.println("Odczyntano: "+ wiadom);
					//odebraneWiadomosci.append(wiadom + "\n");
					odebraneWiadomosci.append("\n"+ wiadom);
				}
				
			}
			catch (Exception ex)
			{
				//ex.printStackTrace();
				System.out.println("Blad tutaj");
			}
		}

	}
	
}
