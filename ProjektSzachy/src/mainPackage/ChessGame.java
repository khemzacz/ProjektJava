package mainPackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class ChessGame extends JFrame implements MouseListener, MouseMotionListener, Runnable, Serializable // implementacja interfejsów odpowiedzialnych za guziki myszy i ruch myszy i odpalanie na wątku
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3100221960058878700L;
	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel chessPiece;
	int xAdjustment;
	int yAdjustment;
	Pozycja pos, cel, poprzedniGraficzny;
	List <Pozycja> listaRuchow;
	JList list;

	private SzachyLogika gra;

	
	public void rysujPlansze()
	{
				 // nowy obiekt Typu SzachyLogika
		for (int i = 0;i<64 ;i++)
		{
			JPanel square = new JPanel(new BorderLayout());
			chessBoard.add( square);
			int row =(i/8)%2;
			if (row==0)
				square.setBackground(i%2== 0? Color.getHSBColor((51F/360F),.46F,0.77F) : Color.getHSBColor((76F/360F),1F,0.5F)); //
			else
				square.setBackground(i%2==0? Color.getHSBColor((76F/360F),1F,0.5F)  : Color.getHSBColor((51F/360F),.46F,0.77F));

		}
		
	}
	
	public void czyscBierki()
	{
		for (int i = 0 ; i<64 ; i++)
		{
			JPanel panel = (JPanel)chessBoard.getComponent(i);
			panel.remove(0);
		}
	}
	
	public void rysujBierki()
	{
		for (int i = 0 ; i<64 ; i++)
		{
			//System.out.println("Petla"); dziala
			if (gra.plansza[i/8][i%8].rowne('p'))
			{
				//System.out.println("True"); //  DZIAŁA
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/pionczarny.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('P'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/pionbialy.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('w'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/wiezaczarna.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('W'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/wiezabiala.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('s'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/skoczekczarny.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('S'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/skoczekbialy.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('g'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/goniecczarny.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('G'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/goniecbialy.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('k'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/krolczarny.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('K'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/krolbialy.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('h'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/hetmanczarny.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('H'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/hetmanbialy.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				continue;
			}
		}
	}
	
	public ChessGame()
	{
		super("Plansza");
		gra = new SzachyLogika();
		/*Dimension boardSize = new Dimension(512,512); // rozmiar szachownicy - to się poskaluje
		layeredPane= new JLayeredPane(); //
		getContentPane().add(layeredPane); //
		layeredPane.setPreferredSize(boardSize); // rozmiar layered pane
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);
		
		
		chessBoard = new JPanel();
		layeredPane.add(chessBoard,JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout(new GridLayout(8,8));
		chessBoard.setPreferredSize(boardSize);
		chessBoard.setBounds(0,0,boardSize.width, boardSize.height);*/
	}
	
	
	
	


	@Override
	public void run() 
	{
		JButton zapiszButton = new JButton("zapisz");
		JButton wczytajButton = new JButton("wczytaj");
		JButton wycofajOdczytButton = new JButton("wycofaj odczyt");
		wycofajOdczytButton.setMargin(new Insets(0, 0, 0, 0));
		wycofajOdczytButton.setEnabled(false);
		wycofajOdczytButton.setVisible(false);
		JButton okButton = new JButton("OK");
		okButton.setMargin(new Insets(0, 0, 0, 0));
		JButton ok1Button = new JButton("OK");
		ok1Button.setMargin(new Insets(0, 0, 0, 0));
		JTextField nazwaZapisuField= new JTextField();
		JLabel infoLabel = new JLabel();
		JPanel panel = new JPanel();
		JScrollPane wczytajScrollPane = new JScrollPane();
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE );
		
		panel.add(zapiszButton);
		panel.add(wczytajButton);
		panel.add(okButton);
		okButton.setVisible(false);
		okButton.setEnabled(false);
		panel.add(ok1Button);
		ok1Button.setVisible(false);
		ok1Button.setEnabled(false);
		panel.add(infoLabel);
		panel.add(wycofajOdczytButton);
		wycofajOdczytButton.setBounds(532,85,85,20);
		panel.add(nazwaZapisuField);
		panel.add(wczytajScrollPane);
		wczytajScrollPane.setBounds(532,115,285,300);
		wczytajScrollPane.setVisible(false);
		nazwaZapisuField.setBounds(637,25,130,20);
		nazwaZapisuField.setVisible(false);
		okButton.setBounds(777,25,50,20);
		ok1Button.setBounds(777,25,50,20);
		zapiszButton.setBounds(532,25,85,20);
		wczytajButton.setBounds(532,55,85,20);
		infoLabel.setBounds(532,0,350,20);
		
		panel.setLayout(null);
		
		
		zapiszButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				infoLabel.setText("Podaj nazwę zapisu, a następnie wciśnij OK");
				zapiszButton.setEnabled(false);
				okButton.setVisible(true);
				okButton.setEnabled(true);
				nazwaZapisuField.setVisible(true);
			}
			
		});
		wczytajButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				infoLabel.setText("Wybierz zapis z listy, a następnie kliknij OK");
				File currDir = new File("."); // tworzy plik w katalogu projektu
			    String path = currDir.getAbsolutePath(); // pobiera jego sciezke
			    path = path.substring(0, path.length()-1);// skraca sciezke o 1
				Filter poszukiwacz = new Filter();
				DefaultListModel<String> pliki;// = new ArrayList<File>();
				pliki = poszukiwacz.finder(path+"/saves/");
				wycofajOdczytButton.setEnabled(true);
				wycofajOdczytButton.setVisible(true);
				list = new JList(pliki);
				wczytajScrollPane.setViewportView(list);
				wczytajScrollPane.setVisible(true);
				ok1Button.setEnabled(true);
				ok1Button.setVisible(true);
				zapiszButton.setEnabled(false);
				wczytajButton.setEnabled(false);
				
			}
		});
		
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				DateFormat df = new SimpleDateFormat("dd_MM_yy HH;mm;ss");
				Date dateobj = new Date();		
				String tmp = df.format(dateobj);
			    File currDir = new File("."); // tworzy plik w katalogu projektu
			    String path = currDir.getAbsolutePath(); // pobiera jego sciezke
			    path = path.substring(0, path.length()-1);// skraca sciezke o 1
				File plik = new File(path+"/saves/"+tmp +" " +nazwaZapisuField.getText()+".txt");
				try
				{
					PrintWriter zapis = new PrintWriter(plik);
					for(int i = 0;i<8;i++)
					{
						for(int j =0;j<8;j++)
						{
							zapis.print(gra.plansza[i][j].get());
						}
						zapis.print("\n");
					}
					zapis.println(gra.tura);
					zapis.close();
				} 
				catch (FileNotFoundException e1)
				{
					e1.printStackTrace();
				}
				zapiszButton.setEnabled(true);
				infoLabel.setText("Zapisano pomyślnie!");
				okButton.setEnabled(false);
				okButton.setVisible(false);
				nazwaZapisuField.setVisible(false);
			}
			
		});
		
		ChessGame reference = this;
		
		ok1Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			    File currDir = new File("."); // tworzy plik w katalogu projektu
			    String path = currDir.getAbsolutePath(); // pobiera jego sciezke
			    path = path.substring(0, path.length()-1);// skraca sciezke o 1
				File plik = new File (path+"/saves/"+list.getSelectedValue());
				try 
				{
					Path sciezka = Paths.get(path+"/saves/"+list.getSelectedValue());
					Reader in = Files.newBufferedReader(sciezka);
					for (int i =0;i<8;i++)
					{
						for(int j=0;j<8;j++)
						{
							Character c = (char)in.read();
							//System.out.print(c); // dobrze czytał
							gra.plansza[i][j].set(c);
						}
						//System.out.println();
						in.skip(1);
					}
					gra.tura=Integer.parseInt(String.valueOf((char)in.read()));
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
				panel.remove(layeredPane); 
				
				Dimension boardSize = new Dimension(512,512);
				layeredPane= new JLayeredPane(); //
				panel.add(layeredPane); //
				panel.repaint();
				panel.revalidate();
				layeredPane.setPreferredSize(boardSize); // rozmiar layered pane
				layeredPane.addMouseListener(reference);
				layeredPane.addMouseMotionListener(reference);
				
				
				chessBoard = new JPanel();
				layeredPane.add(chessBoard,JLayeredPane.DEFAULT_LAYER);
				chessBoard.setLayout(new GridLayout(8,8));
				chessBoard.setPreferredSize(boardSize);
				layeredPane.setBounds(0,0,boardSize.width, boardSize.height);
				chessBoard.setBounds(0,0,boardSize.width, boardSize.height);
				
				rysujPlansze();
				rysujBierki();
				
				ok1Button.setEnabled(false);
				ok1Button.setVisible(false);
				wczytajButton.setEnabled(true);
				zapiszButton.setEnabled(true);		
				wczytajScrollPane.setVisible(false);
				wycofajOdczytButton.setEnabled(false);
				wycofajOdczytButton.setVisible(false);
			}
		});
		
		
		wycofajOdczytButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ok1Button.setEnabled(false);
				ok1Button.setVisible(false);
				wczytajButton.setEnabled(true);
				zapiszButton.setEnabled(true);		
				wczytajScrollPane.setVisible(false);
				wycofajOdczytButton.setEnabled(false);
				wycofajOdczytButton.setVisible(false);
			}
		});
		
		Dimension boardSize = new Dimension(512,512); // rozmiar szachownicy - to się poskaluje
		layeredPane= new JLayeredPane(); //
		panel.add(layeredPane); //
		layeredPane.setPreferredSize(boardSize); // rozmiar layered pane
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);
		
		
		chessBoard = new JPanel();
		layeredPane.add(chessBoard,JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout(new GridLayout(8,8));
		chessBoard.setPreferredSize(boardSize);
		layeredPane.setBounds(0,0,boardSize.width, boardSize.height);
		chessBoard.setBounds(0,0,boardSize.width, boardSize.height);
		
		
		//pack();
		setResizable(true);
		add(panel);
		setSize(850,550);
		setVisible(true);
		setLocationRelativeTo(null);
		
		rysujPlansze();
		rysujBierki();
	}

	public void mousePressed(MouseEvent e)
	{
		chessPiece=null;
		Component c = chessBoard.findComponentAt(e.getX(), e.getY()); //Pobiera komponent znajdujący się na danych współrzędnych
		
		if(c instanceof JPanel) // jeśli jest to JPanel;
			return; // to wyjdź z funkcji
		Point parentLocation =c.getParent().getLocation(); // zapisuhe położenie w parentLocation
		List <PojedynczyRuch> tmpMoves = new ArrayList<PojedynczyRuch>();

	  	
		
		xAdjustment = parentLocation.x -e.getX(); 
		yAdjustment = parentLocation.y -e.getY(); 
		//System.out.println(parentLocation.x); System.out.println(parentLocation.y);//
		int pom =0;
		pos = new Pozycja((e.getY()+pom)/64,(e.getX()+pom)/64);
		listaRuchow = gra.possibleMoves(pos,gra);
	  	
	  	if(gra.sprawdzSzachBialym(gra))
	  	{
	  		System.out.println("\nBialy krol w szachu!!!");
	  	}

	  	if (gra.plansza[pos.row][pos.column].isUpperCase() && gra.tura ==1)
	  	{
	  		tmpMoves.addAll(this.gra.sprawdzSDWMRB(this.gra));
	  		if (tmpMoves.size() == 0)
	  		{
	  			System.out.println("Bialy Zamatowany!");
	  		}
	  		System.out.println(listaRuchow.size());
	  		System.out.println(tmpMoves.size());
	  		listaRuchow = new ArrayList <Pozycja>(iloczynPozycji(pos,listaRuchow, tmpMoves)); 
	  	}
	  	
		tmpMoves = new ArrayList <PojedynczyRuch>();
	  	if(gra.sprawdzSzachCzarnym(gra))
	  	{
	  		System.out.println("\nCzarny krol w szachu!!!");
	  	}
	  	
	  	if (gra.plansza[pos.row][pos.column].isLowerCase() && gra.tura == 2)
	  	{
	  		tmpMoves.addAll(this.gra.sprawdzSDWMRC(this.gra));
	  		if (tmpMoves.size() == 0)
	  		{
	  			System.out.println("Czarny Zamatowany!");
	  		}
	  		System.out.println(listaRuchow.size());
	  		System.out.println(tmpMoves.size());
	  		listaRuchow = new ArrayList <Pozycja>(iloczynPozycji(pos,listaRuchow, tmpMoves)); 
	  	}
	  	
		//System.out.println("wiersz" + pos.row); System.out.println("kolumna" +pos.column);
		System.out.println(listaRuchow.size());
		podswietlPole(listaRuchow);
		chessPiece = (JLabel)c;
		chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		poprzedniGraficzny = new Pozycja( e.getY()+ yAdjustment, e.getX() + xAdjustment);
		chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
	}
	
	public void mouseDragged(MouseEvent me)
	{
		  if (chessPiece == null) return;
		 chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	}
	
	
	public void mouseReleased(MouseEvent e) 
	{
		  if(chessPiece == null) return;
		 
		  chessPiece.setVisible(false); //widocznosc JLabela
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		  Component pom = chessBoard.findComponentAt(poprzedniGraficzny.column, poprzedniGraficzny.row);

		  wylaczPodswietlenie();
		  cel = new Pozycja((e.getY())/64,(e.getX())/64);
		  Boolean flag = ruch(pos,cel);
		  if (!flag)
		  {
			  chessPiece.setLocation(poprzedniGraficzny.column,poprzedniGraficzny.row);
			  Container parent = (Container)pom;
			  parent.add(chessPiece);
			  chessPiece.setVisible(true);
			  return;
		  }
		  
		  if (c instanceof JLabel)
		  {
			  Container parent = c.getParent();
			  parent.remove(0);
			  parent.add( chessPiece );
		  }
		  else 
		  {
			  Container parent = (Container)c;
			  parent.add( chessPiece );
		  }
		  
		  
		  	if (gra.tura==2)
		  	{
		  		int tmp=gra.sprawdzAwansCzarnym();
		  		if(tmp!=8)
		  		{
		  			JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/hetmanczarny.png")); // Bierka jest JLabelem
					JPanel panel = (JPanel)chessBoard.getComponent(tmp); // przypisuje pod odniesienie panel, odpowiedni komponent
					panel.remove(0);
					panel.add(piece); // dodaje bierke do tego panelu
		  		}
		  			
		  	}
		  	if (gra.tura==1)
		  	{
		  		int tmp=gra.sprawdzAwansBialym();
		  		if (tmp!=8)
		  		{
		  			JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/hetmanbialy.png")); // Bierka jest JLabelem
					JPanel panel = (JPanel)chessBoard.getComponent(tmp); // przypisuje pod odniesienie panel, odpowiedni komponent
					panel.remove(0);
					panel.add(piece); // dodaje bierke do tego panelu
		  		}
		  	}
		  	
		  	//this.rysujBierki();
		  	zmianaTury();

		  	chessPiece.setVisible(true);

	}
	
	public void mouseClicked(MouseEvent e)
	{
		  
	}
	public void mouseMoved(MouseEvent e)
	{
	}
	public void mouseEntered(MouseEvent e)
	{
	  
	}
	public void mouseExited(MouseEvent e) 
	{
	  
	}
	 
	public void podswietlPole(List <Pozycja> ruchy)
	{
		if (ruchy.size() == 0)
			return;
		int k = ruchy.size();
		//System.out.println(k);
		for (int i =0;i<k;i++)
		{
			JPanel poleDoPomalowania = (JPanel)chessBoard.getComponentAt((ruchy.get(i).column+1)*64-32,(ruchy.get(i).row+1)*64-32);
			poleDoPomalowania.setBackground(Color.getHSBColor(61/360F, 1F, .81F));  
			
		}	 
	}
	
	public void wylaczPodswietlenie()
	{
		if (listaRuchow.size() == 0)
			return;
		int k = listaRuchow.size();
		int pom = 0;
		for (int i =0;i<k;i++)
		{
			JPanel poleDoPomalowania = (JPanel)chessBoard.getComponentAt((listaRuchow.get(i).column+1)*64-32,(listaRuchow.get(i).row+1)*64-32);
			pom = ((listaRuchow.get(i).row) + (listaRuchow.get(i).column));
			if (pom%2 ==0 )
			{
				//JPanel poleDoPomalowania = (JPanel)chessBoard.getComponentAt((ruchy.get(i).column+1)*64-32,(ruchy.get(i).row+1)*64-32);
				poleDoPomalowania.setBackground( Color.getHSBColor((51F/360F),.46F,0.77F)); 
			}
			else 	
				poleDoPomalowania.setBackground( Color.getHSBColor((76F/360F),1F,0.5F)); 
		}
		
	}
	
	public Boolean ruch(Pozycja pocz, Pozycja cel)
	{
		if (pocz.row == cel.row && pocz.column == cel.column)
			return false;
		for (int i =0;i<listaRuchow.size();i++)
		{
			if (cel.row == listaRuchow.get(i).row && cel.column == listaRuchow.get(i).column)
			{
				gra.plansza[cel.row][cel.column].set(gra.plansza[pos.row][pos.column].get());
				gra.plansza[pos.row][pos.column].set(' ');
				return true;
			}
			
		}
		return false;
		
	}
	public void zmianaTury()
	{
		if (this.gra.tura ==1)
			{
				this.gra.tura =2;
				return;
			}
		if (this.gra.tura == 2)
		{
			this.gra.tura =1;
			return;
		}
	}
	
	public List<Pozycja> iloczynPozycji(Pozycja pos,List<Pozycja> pierwsza, List <PojedynczyRuch> ruchy)
	{
		List <Pozycja> pMoves = new ArrayList <Pozycja>();

			for (int j =0;j<ruchy.size();j++) // kazdy mozliwy dozwolony ruch
			{

					if (pos.row == ruchy.get(j).getPocz().row && pos.column == ruchy.get(j).getPocz().column) // mozliwe przyczy buga: zle pozycje
						// jesli ruch nalezy do kliknietej bierki to:
					{

							pMoves.add(new Pozycja(ruchy.get(j).get())); // to dodaj 
						
					}				
			}
		return pMoves;
	}
	
}
