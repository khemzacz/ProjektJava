package mainPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;


import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


import komunikacja.*;
import Listenery.*;
import maleOkienka.*;


public class MainMenu extends JFrame implements Runnable
{
	private String user;
	private int width=1000, height=600;
	
	private JPanel panel_menu= new JPanel();
	private JButton sp_button = new JButton("Local Game");
	private JButton mp_button = new JButton("Internet Game");
	//JButton st_button = new JButton("Statystyki");
	private JButton op_button = new JButton("Opcje");
	private JButton lo_button = new JButton("EXIT");
	private JLabel dane_usera = new JLabel("Witaj " +user);
	
	private JButton zalogujButton=new JButton("Zaloguj");
	private JButton rejestrujButton=new JButton("Rejestracja");
	private JTextField Login=new JTextField("",12);
	private JLabel LoginLabel= new JLabel("Login: ");
	private JPasswordField Pass=new JPasswordField("",12);
	private JLabel PassLabel= new JLabel("Hasło: ");
	private JButton zaprosDoGry = new JButton("Zaproś do gry");
	private String importedlogin = new String("");
	private JButton connectButton = new JButton("Connect");
	private JTextField adresTextField = new JTextField("127.0.0.1");	
	private JLabel adresLabel = new JLabel("Adres: ");
	private JTextArea messageBox = new JTextArea();
	private JButton wyslij = new JButton("Wyslij");
	private JTextField doWyslania = new JTextField();
	private JButton logoutButton = new JButton("Wyloguj");
	private JButton powrotDoMenuButton = new JButton("<html><center>Powrót do<br/>menu głównego<center/></html>");
	private ImageIcon zdjecieTla = new ImageIcon("pliki/tla/1.jpg");
	private JLabel tlo = new JLabel();
	
	private JScrollPane panelGraczy; 
	
	private boolean loginFlag=false;
	private RamkaKlienta ramka;
	
	private OdbiorcaKomunikatow reciever;//= new OdbiorcaKomunikatow();
	private Thread t;// = new Thread(reciever); 
	private PlayerListUpdater updater;// = new PlayerListUpdater();
	private Thread t1;// = new Thread(updater);
	private Boolean helpFlag=false;
	private Boolean JawnaProsbaPolaczenia=true;
	
	private ArrayList <String> ignorowani;
	
	private InternetChessGame rozgrywkaSieciowa;
	private Boolean inGame=false;
	
	ArrayList <CzatGraczy> watkiCzatow = new ArrayList<CzatGraczy>();
	
	JList list;
	
	String ip;
	String nadawca;
	int port=5000;
	
	
	ObjectInputStream czytelnik;
	ObjectOutputStream pisarz;
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
	
	public Boolean getLoginFlag()
	{
		return loginFlag;
	}
	
	public JScrollPane getPanelGraczy() {return panelGraczy;}
	
	public JPanel getPanel_Menu(){return panel_menu;}
	
	public JButton getZalogujButton(){return zalogujButton;}
	public JButton getRejestrujButton(){return rejestrujButton;}
	public JButton getSpButton(){return sp_button;}
	public JButton getMpButton(){return mp_button;}
	public JButton getOpButton(){return op_button;}
	public JButton getLoButton(){return lo_button;}
	public JButton getZaprosDoGryButton(){return zaprosDoGry;}
	public JButton getConnectButton(){return connectButton;}
	public JButton getLogOutButton(){return logoutButton;}
	public JButton getPowrotDoMenuButton(){return powrotDoMenuButton;}
	
	public JLabel getDane_Usera(){return dane_usera;}
	public JLabel getLoginLabel(){return LoginLabel;}
	public JLabel getPassLabel(){return PassLabel;}
	public JLabel getAdresLabel(){return adresLabel;}
	public JLabel getTlo(){return tlo;}
	
	public JTextField getLoginField(){return Login;}
	public JTextField getDoWyslania(){return doWyslania;}
	
	public JTextArea getMessageBox(){return messageBox;}
	
	public JPasswordField getPasswordField(){return Pass;}
	
	
	@Override
	public void run() {
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
				logoutButton.setBounds(10,10,85,20);
				powrotDoMenuButton.setBounds(10,height-90,140,40);
				//powrotDoMenuButton.setMargin(new Insets(5,5,35,115));
				zaprosDoGry.setBounds(width-175,535,155,20);
				
				panel_menu.add(adresTextField);
				panel_menu.add(adresLabel);
				panel_menu.add(connectButton);
				panel_menu.add(logoutButton);
				panel_menu.add(LoginLabel);
				panel_menu.add(Login);
				panel_menu.add(PassLabel);
				panel_menu.add(Pass);
				panel_menu.add(zalogujButton);
				panel_menu.add(rejestrujButton);
				panel_menu.add(messageBox);
				messageBox.setEditable(false);
				messageBox.setLineWrap(true);
				messageBox.setWrapStyleWord(true);
				panel_menu.add(zaprosDoGry);
				panel_menu.add(wyslij);
				panel_menu.add(doWyslania);
				panel_menu.add(powrotDoMenuButton);
				//panel_menu.add(panelGraczy);
				tlo.setIcon(zdjecieTla);
				tlo.setBounds(0,0,width,height);
				panel_menu.add(tlo);
				
				panel_menu.setVisible(true);
				zalogujButton.setEnabled(false);
				rejestrujButton.setEnabled(false);
				logoutButton.setEnabled(false);
				wyslij.setEnabled(false);
				zaprosDoGry.setEnabled(false);
				
			}
		});
		
		
		lo_button.addActionListener(new ExitButtonListener());
				
				
		connectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				Thread watekOdbiorcy = new Thread(new KomunikacjaSieciowa());
				watekOdbiorcy.start();
			
			}
		});
		
		powrotDoMenuButton.addActionListener(new PowrotDoMenuListener(this));
		
		wyslij.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				RamkaKlienta pakiet = new RamkaKlienta(4,user,doWyslania.getText());
				try 
				{
					pisarz.writeObject(pakiet);
					pisarz.flush();
					doWyslania.setText("");
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				
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
					
					ramka = new RamkaKlienta(1,user,new String(Pass.getPassword()));
					pisarz.writeObject(ramka);
					pisarz.flush();
					RamkaSerwera pakiet;
					try{
							pakiet = (RamkaSerwera) czytelnik.readObject();
							
							if( pakiet.getW1().equals("zalogowano"))
							{
								messageBox.append("\nZalogowano, witaj: "+user+"\n");
								zalogujButton.setEnabled(false);
								rejestrujButton.setEnabled(false);
								pisarz.writeObject(new RamkaKlienta(3,"",""));
								pisarz.flush();
								RamkaSerwera listaGraczy;
								listaGraczy = (RamkaSerwera) czytelnik.readObject();
								
								DefaultListModel<String>  listModel = new DefaultListModel<String>();
								for (int i =0 ;i<listaGraczy.getClientList().size();i++)
								{
									listModel.addElement(listaGraczy.getClientList().get(i));
								}
								
								
								list = new JList(listModel);
								list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
								list.setLayoutOrientation(JList.VERTICAL);
								list.setVisibleRowCount(-1);
								//list.addMouseListener(new ListMouseListener(user,pisarz,watkiCzatow));
								panelGraczy = new JScrollPane(list);
								panelGraczy.setBounds(width-175, 25,155,505);
								
								wyslij.setEnabled(true);

								
								panel_menu.add(panelGraczy);// dodaje scroll pane do menu
								for(ActionListener al : logoutButton.getActionListeners())
								logoutButton.removeActionListener(al);
								logoutButton.addActionListener(new WylogujButtonListener(pisarz));
								logoutButton.setEnabled(true);
								ignorowani = new ArrayList <String>();
								zaprosDoGry.setEnabled(true);
								
								loginFlag=true;
								reciever = new OdbiorcaKomunikatow();
								t = new Thread(reciever); 
								updater = new PlayerListUpdater();
								t1 = new Thread(updater);
								t.start(); // watek odbiorcy pakietow
								t1.start(); // watek aktualizatora listy graczy
							}
							else if (pakiet.getW1().equals("bledne_dane"))
							{
								messageBox.append ("\n Bledny login, lub haslo\n");
							}
							else if (pakiet.getW1().equals("zajete"))
							{
								messageBox.append ("\n Podany user jest juz na serwerze \n");
							}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
					//System.out.println("Nie udalo sie poslac");
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
					ramka = new RamkaKlienta(2,user,new String(Pass.getPassword()));
					pisarz.writeObject(ramka); // posyła
					pisarz.flush();
					RamkaSerwera pakiet = null;
					try
					{
						pakiet = (RamkaSerwera) czytelnik.readObject(); // czeka w nieskonczonosc
							if( pakiet.getW1().equals("zarejestrowano"))
							{
								messageBox.append("\n Zarejestrowano pomyślnie, mozesz sie zalogowac");
							}
							else if (pakiet.getW1().equals("zajete"))
							{
								messageBox.append ("\n nazwa uzytkownika jest juz zajeta");
							}
							else if(pakiet.getW1().equals("too_short"))
							{
								messageBox.append ("\n Login i hasło muszą składać się z więcej niż trzech liter");								
							}
							
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
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
		tlo.setIcon(zdjecieTla);
		tlo.setBounds(0,0,width,height);
		panel_menu.add(tlo);
		
		
		add(panel_menu);
		setVisible(true);
		
	}
	
	public String getLogin()
	{
		return importedlogin;
	}
	
	public void updatePlayerList(RamkaSerwera listaGraczy)
	{
		try
		{
			System.out.println("Aktualizuje liste graczy");
			DefaultListModel<String>  listModel = new DefaultListModel<String>();
			for (int i =0 ;i<listaGraczy.getClientList().size();i++)
			{
				listModel.addElement(listaGraczy.getClientList().get(i));
			}
			String tmp = (String) list.getSelectedValue();
			list = new JList(listModel);
			list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			list.setLayoutOrientation(JList.VERTICAL);
			list.setVisibleRowCount(-1);
			list.addMouseListener(new ListMouseListener(user,pisarz,watkiCzatow)); // DO POPRAWY LISTENER
			list.setSelectedValue(tmp, true);
			//if(!helpFlag)
			for(ActionListener al : zaprosDoGry.getActionListeners())
			zaprosDoGry.removeActionListener(al);
			zaprosDoGry.addActionListener(new ZaprosDoGryListener(list,pisarz,user));
			//helpFlag=true;
			//list.getSelectedIndex();
			panelGraczy.setViewportView(list);
			panelGraczy.repaint();

			//panel_menu.remove(panelGraczy);
			//panelGraczy = new JScrollPane(list);
			//panelGraczy.setBounds(width-175, 25,155,505);
			//panel_menu.add(panelGraczy);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void wiadomoscPrywatna(String nadawca, String odbiorca, String wiadomosc)
	{
		Boolean chatActive = false;
		for (int i = watkiCzatow.size()-1;i>=0;i--)
		{
			if (watkiCzatow.get(i).getRozmowca().equals(nadawca))
			{
				watkiCzatow.get(i).getMessageBox().append("\n"+nadawca+": "+wiadomosc);
				chatActive = true;
				break;
			}
		}
		if (chatActive == false)
		{
			CzatGraczy czat = new CzatGraczy(user,nadawca,pisarz);
			watkiCzatow.add(czat);
			czat.run();
			czat.getMessageBox().append("\n"+nadawca+": "+wiadomosc);
		}
	}
	
	public void obslugaZaproszenia(String zapraszajacy)
	{
		new ZaproszenieBox(zapraszajacy,user, ignorowani,pisarz, rozgrywkaSieciowa ).run();
	}
	
	public void logOut()
	{
		
		try 
		{
			gniazdo.close();
			//pisarz = null;
			//czytelnik=null;

		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		logoutButton.setEnabled(false);
		zaprosDoGry.setEnabled(false);
		wyslij.setEnabled(false);
		
		zalogujButton.setEnabled(false);
		rejestrujButton.setEnabled(false);
		loginFlag=false;
		list = new JList();
		panel_menu.remove(panelGraczy);
		panel_menu.repaint();
		panelGraczy.setViewportView(list);
		Login.setText("");
		Pass.setText("");
		//JawnaProsbaPolaczenia=false;

		messageBox.append("\nWylogowano - > Podłącz się ponownie do serwera\n");
		t.stop();
		t.destroy();
		t1.stop();
		t1.destroy();
	}
	
	public void powrotDoMenu()
	{
		
		
	}
	
	
	public void rozpocznijRozgrywke(String oponent)
	{
		rozgrywkaSieciowa = new InternetChessGame(oponent,"Czarny",false,pisarz);
		rozgrywkaSieciowa.run();
	}
	

	public class PlayerListUpdater implements Runnable
	{
		public void run() 
		{
			while (true)
			{
				try 
				{
					pisarz.writeObject(new RamkaKlienta(3,"",""));
					pisarz.flush();	
					//System.out.println("wyslalem");
					try {
						t1.sleep(2000);
						//Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				catch (IOException e1) 
				{
					t1.stop();
					t1.destroy();
					t.stop();
					t.destroy();
					e1.printStackTrace();
				}


			}
		}
		
		
	}
	
	public class KomunikacjaSieciowa implements Runnable
	{
	
		public void run() 
		{
			ip=adresTextField.getText();
			nadawca=Login.getText();
			InetSocketAddress adres = new InetSocketAddress(ip,port);
			try
			{
				gniazdo = new Socket();
				gniazdo.connect(adres,2000);

				pisarz = new ObjectOutputStream(gniazdo.getOutputStream()); 
				pisarz.flush();
				czytelnik = new ObjectInputStream(gniazdo.getInputStream());
				if(JawnaProsbaPolaczenia)
					messageBox.append("Obsluga sieci przygotowana\n");
				JawnaProsbaPolaczenia=true;
				zalogujButton.setEnabled(true);
				rejestrujButton.setEnabled(true);
			} 
			catch (IOException ex) {
				ex.printStackTrace();
				messageBox.append("Nie skonfigurowano sieci\n");
			}
		
		}
	}
	
	public class OdbiorcaKomunikatow implements Runnable {
		public void run() 
		{
			RamkaSerwera ramka;
			try
			{
				while(true)
				{
					if(loginFlag==true)
					{
						ramka = (RamkaSerwera) czytelnik.readObject();
						int typ = ramka.getRodzaj();
						switch(typ)
						{
							case 3:
								updatePlayerList(ramka);
								break;
							case 4:
								messageBox.append("\n"+ramka.getW1()+": "+ramka.getW2());
								break;
							case 5:
								wiadomoscPrywatna(ramka.getW1(),ramka.getW2(),ramka.getW3());
								break;
							case 6:
								obslugaZaproszenia(ramka.getW1());
								break;
							case 7:
								
								break;
							case 8: // Odpowiedź o akceptacji zaproszenia
								rozpocznijRozgrywke(ramka.getW1());
								break;
							case 9:
								
								break;
							case 10:
								
								break;
							case 99:
								logOut();
								break;
						}
					
					}		
				}
				
			}
			catch(Exception e)
			{
				t.stop();
				t.destroy();
				t1.stop();
				t1.destroy();
				e.printStackTrace();
			}
		}
		

	}
	
}
