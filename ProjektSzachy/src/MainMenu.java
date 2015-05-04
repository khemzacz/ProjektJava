import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class MainMenu extends JFrame implements Runnable
{
	private String user;
	private int width=800, height=600;
	
	private JPanel panel_menu= new JPanel();
	private JButton sp_button = new JButton("Local Game");
	private JButton mp_button = new JButton("Internet Game");
	//JButton st_button = new JButton("Statystyki");
	private JButton op_button = new JButton("Opcje");
	private JButton lo_button = new JButton("Log Out");
	private JLabel dane_usera = new JLabel("Witaj " +user);
	
	private JButton zalogujButton=new JButton("Zaloguj");
	private JButton rejestrujButton=new JButton("Rejestracja");
	private JTextField Login=new JTextField("",12);
	private JLabel LoginLabel= new JLabel("Login: ");
	private JPasswordField Pass=new JPasswordField("",12);
	private JLabel PassLabel= new JLabel("Hasło: ");
	
	private String importedlogin = new String("");
	private JButton connectButton = new JButton("Connect");
	private JTextField adresTextField = new JTextField("127.0.0.1");	
	private JLabel adresLabel = new JLabel("Adres: ");
	private JTextArea messageBox = new JTextArea();
	private JButton wyslij = new JButton("Wyslij");
	private JTextField doWyslania = new JTextField();
	
	private boolean loginFlag=true;
	
	String ip;
	String nadawca;
	int port=5000;
	
	BufferedReader czytelnik;
	PrintWriter pisarz;
	Socket gniazdo;
	
	MainMenu(String user)
	{
		super("MainMenu"); // nazwa okna
		this.user=user;	
	}
	
	MainMenu()
	{
		super("Menu Główne");
	}
	
	@Override
	public void run() {
	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(width,height);
		
		sp_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new ChessGame().run();
			}
		});
		
		mp_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			/*{
				new GUI("Klient").guiStart();
				// TU bede odpalał
			}*/
			
			{
				panel_menu.setVisible(false);
				panel_menu.removeAll();
				
				adresTextField.setBounds(width/2-50,height/2-190,151,20);
				adresLabel.setBounds(width/2-100,height/2-190,44,20);
				connectButton.setBounds(width/2-50,height/2-170,150,20);
				
				LoginLabel.setBounds(width/2-100, height/2 -150, 44, 20);
				Login.setBounds(width/2-50,height/2 -150,151,20);
				
				PassLabel.setBounds(width/2-100,height/2 -130,44,20);
				Pass.setBounds(width/2-50,height/2 -130,151,20);
				
				zalogujButton.setBounds(width/2-100,height/2 -110,90,20);
				rejestrujButton.setBounds(width/2-10,height/2 -110,110,20);
				messageBox.setBounds(width/2-250,height/2-90,500,300);
				wyslij.setBounds(width/2-250,height/2+210,70,20);
				doWyslania.setBounds(width/2-180,height/2+210,431,20);
				
				panel_menu.add(adresTextField);
				panel_menu.add(adresLabel);
				panel_menu.add(connectButton);
				
				panel_menu.add(LoginLabel);
				panel_menu.add(Login);
				panel_menu.add(PassLabel);
				panel_menu.add(Pass);
				panel_menu.add(zalogujButton);
				panel_menu.add(rejestrujButton);
				panel_menu.add(messageBox);
				panel_menu.add(wyslij);
				panel_menu.add(doWyslania);
				
				panel_menu.setVisible(true);
				zalogujButton.setEnabled(false);
				rejestrujButton.setEnabled(false);
				wyslij.setEnabled(false);
				
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
				doWyslania.setText("");// czyÅ›ci pole tekstowe na login
				doWyslania.requestFocus();
				
			}
		});
		
		zalogujButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				try 
				{
					user = Login.getText();
					System.out.println("Pobrany Login: " +user);
					pisarz.println("loginAttempt");
					pisarz.println(user);
					pisarz.println(Pass.getPassword());
					pisarz.flush();
					String wiadom;
					try{
						while ((wiadom = czytelnik.readLine()) !=null)
							if( wiadom.equals("zalogowano"))
							{
								messageBox.append("\n Zalogowano, witaj: "+user+"\n");
							}
							else if (wiadom.equals("bledne_dane"))
							{
								messageBox.append ("\n Bledny login, lub haslo\n");
							}
					}
					catch(Exception ex)
					{
					
					}
				}
				catch (Exception ex)
				{
					//ex.printStackTrace();
					System.out.println("Nie udalo sie poslac");
				}

				
			}
		});
		
		rejestrujButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				try 
				{
					user = Login.getText();
					System.out.println("Pobrany Login: " +user);
					pisarz.println("registerAttempt");
					pisarz.println(user);
					pisarz.println(Pass.getPassword());
					pisarz.flush();
					String wiadom;
					try{
						while ((wiadom = czytelnik.readLine()) !=null)
							if( wiadom.equals("zarejestrowano"))
							{
								messageBox.append("\n Zarejestrowano pomyślnie, mozesz sie zalogowac");
							}
							else if (wiadom.equals("zajete"))
							{
								messageBox.append ("\n nazwa uzytkownika jest juz zajeta");
							}
					}
					catch(Exception ex)
					{
					
					}
				}
				catch (Exception ex)
				{
					//ex.printStackTrace();
					System.out.println("Nie udalo sie poslac");
				}

				
			}
		});
		
		setResizable(false);
		
		panel_menu.setLayout(null);
		
		//dane_usera.setBounds(width-40-8*user.length(),0,40+8*user.length(),20);
		sp_button.setBounds(width/2-80,height/2-120,160,40);
		mp_button.setBounds(width/2-80,height/2-80,160,40);
		op_button.setBounds(width/2-80,height/2-40,160,40);
		lo_button.setBounds(width/2-80,height/2-0,160,40);
		
		panel_menu.add(sp_button);
		panel_menu.add(mp_button);
		panel_menu.add(op_button);
		panel_menu.add(lo_button);
		//panel_menu.add(dane_usera);
		add(panel_menu);
		setVisible(true);
		
	}
	
	public String getLogin()
	{
		return importedlogin;
	}
	
	public void communicationConfig()
	{
		ip=adresTextField.getText();
		nadawca=Login.getText();
		try
		{
			gniazdo = new Socket(ip,port);
			InputStreamReader czytelnikStrm = new InputStreamReader(gniazdo.getInputStream());
			czytelnik = new BufferedReader(czytelnikStrm);
			pisarz = new PrintWriter(gniazdo.getOutputStream());
			messageBox.append("Obsluga sieci przygotowana\n");
			zalogujButton.setEnabled(true);
			rejestrujButton.setEnabled(true);
		} 
		catch (IOException ex) {
			// TODO Auto-generated catch block
			//ex.printStackTrace();
			loginFlag=false;
			messageBox.append("Nie skonfigurowano sieci");
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
					messageBox.append("\n"+ wiadom);
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
