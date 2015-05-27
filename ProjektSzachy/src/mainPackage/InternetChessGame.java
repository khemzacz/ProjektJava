package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import maleOkienka.RageQuitNotice;
import komunikacja.*;
import adapteryOkien.graSieciowaCloseAdapter;

public class InternetChessGame extends JFrame implements MouseListener, MouseMotionListener, Runnable, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7625420960573006748L;
	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel chessPiece;
	int xAdjustment;
	int yAdjustment;
	Pozycja pos, cel, poprzedniGraficzny;
	List <Pozycja> listaRuchow;
	
	String kolor;
	Boolean tura;
	
	private String gracz;
	private String oponent;

	private SzachyLogika gra;
	private ObjectOutputStream pisarz;
	
	public ObjectOutputStream getPisarz()
	{return pisarz;}
	
	public void rysujPlansze()
	{
		gra = new SzachyLogika();		 // nowy obiekt Typu SzachyLogika
		for (int i = 0;i<64 ;i++)
		{
			JPanel square = new JPanel(new BorderLayout());
			chessBoard.add( square); //dodaje pola w odpowiednim kolorze
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
			if (gra.plansza[i/8][i%8].rowne(' '))
			{
				JPanel panel = (JPanel)chessBoard.getComponent(i);
					panel.removeAll();
					panel.repaint();
			}
		}
	}
	
	
	public void odswiezBierki()
	{
		for (int i = 0 ; i<64 ; i++)
		{
			JPanel panel = (JPanel)chessBoard.getComponent(i);
			panel.repaint();
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
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('P'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/pionbialy.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('w'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/wiezaczarna.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('W'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/wiezabiala.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('s'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/skoczekczarny.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('S'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/skoczekbialy.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('g'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/goniecczarny.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('G'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/goniecbialy.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('k'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/krolczarny.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('K'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/krolbialy.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('h'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/hetmanczarny.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
			if (gra.plansza[i/8][i%8].rowne('H'))
			{
				JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/hetmanbialy.png")); // Bierka jest JLabelem
				JPanel panel = (JPanel)chessBoard.getComponent(i); // przypisuje pod odniesienie panel, odpowiedni komponent
				panel.add(piece); // dodaje bierke do tego panelu
				piece.setVisible(true);
				piece.repaint();
				continue;
			}
		}
	}
	
	public InternetChessGame(String gracz,String oponent, String kolor, Boolean tura, ObjectOutputStream pisarz)
	{
		super("partia przeciwko: "+oponent);
		this.kolor = kolor;
		this.tura=tura;
		this.pisarz=pisarz;
		this.gracz=gracz;
		this.oponent=oponent;

	}
	
	


	@Override
	public void run() 
	{  
		Dimension boardSize = new Dimension(512,512); // rozmiar szachownicy - to się poskaluje
		layeredPane= new JLayeredPane(); //
		getContentPane().add(layeredPane); //
		layeredPane.setPreferredSize(boardSize); // rozmiar layered pane
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);
		
		
		chessBoard = new JPanel();
		layeredPane.add(chessBoard,JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout(new GridLayout(8,8));
		chessBoard.setPreferredSize(boardSize);
		chessBoard.setBounds(0,0,boardSize.width, boardSize.height);
		

		rysujPlansze();
		rysujBierki();
		
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener( new graSieciowaCloseAdapter(this));
		
		pack();
		setResizable(true);
		setLocationRelativeTo( null );
		setVisible(true);	
	}

	public void mousePressed(MouseEvent e)
	{
		if(tura)
		{	
			int pom =0;
			pos = new Pozycja((e.getY()+pom)/64,(e.getX()+pom)/64);
			if(kolor.equals("Czarny") && gra.plansza[pos.row][pos.column].isUpperCase())
				return;
			if(kolor.equals("Bialy") && gra.plansza[pos.row][pos.column].isLowerCase())
				return;
			chessPiece=null;
			Component c = chessBoard.findComponentAt(e.getX(), e.getY()); //Pobiera komponent znajdujący się na danych współrzędnych
			
			if(c instanceof JPanel) // jeśli jest to JPanel;
				return; // to wyjdź z funkcji
			Point parentLocation =c.getParent().getLocation(); // zapisuhe położenie w parentLocation
			List <PojedynczyRuch> tmpMoves = new ArrayList<PojedynczyRuch>();
			xAdjustment = parentLocation.x -e.getX(); 
			yAdjustment = parentLocation.y -e.getY(); 
			//System.out.println(parentLocation.x); System.out.println(parentLocation.y);//

			//pos = new Pozycja((e.getY()+pom)/64,(e.getX()+pom)/64);
			listaRuchow = gra.possibleMoves(pos,gra);
		  	
		  	if(gra.sprawdzSzachBialym(gra))
		  	{
		  		System.out.println("\nCzarny krol w szachu!!!");
		  	}
	
		  	if (gra.plansza[pos.row][pos.column].isUpperCase())
		  	{
		  		tmpMoves.addAll(this.gra.sprawdzSDWMRB(this.gra));
		  		if (tmpMoves.size() == 0)
		  		{
		  			System.out.println("Czarny Zamatowany!");
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
		  	
		  	if (gra.plansza[pos.row][pos.column].isLowerCase())
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
	}
	
	public void mouseDragged(MouseEvent me)
	{
		if(tura)
		{	
			  if (chessPiece == null) return;
				if(kolor.equals("Czarny") && gra.plansza[pos.row][pos.column].isUpperCase())
					return;
				if(kolor.equals("Bialy") && gra.plansza[pos.row][pos.column].isLowerCase())
					return;
			 chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
		}
	}
	
	
	public void mouseReleased(MouseEvent e) 
	{
		if(tura)
		{	
			  if(chessPiece == null) return;
				if(kolor.equals("Czarny") && gra.plansza[pos.row][pos.column].isUpperCase())
					return;
				if(kolor.equals("Bialy") && gra.plansza[pos.row][pos.column].isLowerCase())
					return;
			  chessPiece.setVisible(false); //widocznosc JLabela
			  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
			  Component pom = chessBoard.findComponentAt(poprzedniGraficzny.column, poprzedniGraficzny.row);
	
			  wylaczPodswietlenie();
			  cel = new Pozycja((e.getY())/64,(e.getX())/64);
			  Boolean flag = ruch(pos,cel); // tu sie wykonal, albo nie ruch
			  if (!flag)
			  {
				  chessPiece.setLocation(poprzedniGraficzny.column,poprzedniGraficzny.row);
				  Container parent = (Container)pom;
				  parent.add(chessPiece);
				  chessPiece.setVisible(true);
				  return;
			  }
			  
			  if (c instanceof JLabel)// jesli bierka
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
	
			  	chessPiece.setVisible(true);
		}

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
				gra.plansza[cel.row][cel.column].set(gra.plansza[pocz.row][pocz.column].get());
				gra.plansza[pocz.row][pocz.column].set(' ');
				try 
				{
					pisarz.writeObject(new RamkaKlienta(8,gracz,oponent,pocz.row,pocz.column,cel.row,cel.column));
					pisarz.flush();
					zmianaTury();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
				// pakie ruchu do serwera
				return true;
			}
			
		}
		return false;
		
	}
	
	public void odbiorRuchu(Pozycja pocz, Pozycja cel)
	{
		gra.plansza[cel.row][cel.column].set(gra.plansza[pocz.row][pocz.column].get());
		gra.plansza[pocz.row][pocz.column].set(' '); // sam ruch na tablicy, trzeba grafike zupdatowac
		//System.out.println("Wykonalem ruch na tablicy");
		aktualizacjaGrafiki(pocz, cel);
		zmianaTury();//trzeba zmienic ture itd itp.
		//czyscBierki();
		//rysujBierki();

		
		//zmianaTury();//trzeba zmienic ture itd itp.
	}
	
	public void zmianaTury()
	{
		if (tura == false)
			{
				tura = true;
			}
		else
		{
			tura=false;
		}
	}
	
	public void aktualizacjaGrafiki(Pozycja pocz, Pozycja cel)
	{
		//czyscBierki();
		
		JPanel c = (JPanel) chessBoard.getComponent(pocz.row*8+pocz.column);
		JLabel chessPiece = (JLabel) c.getComponent(0);
		c.remove(0);
		c.repaint();
		c = (JPanel) chessBoard.getComponent(cel.row*8+cel.column);
		c.removeAll();
		c.add(chessPiece);
		c.repaint();
		
		//rysujBierki();
		//chessBoard.repaint();*/ //psuje sie 
		//rysujBierki();
		//odswiezBierki();
		
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
