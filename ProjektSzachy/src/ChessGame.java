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
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class ChessGame extends JFrame implements MouseListener, MouseMotionListener, Runnable // implementacja interfejsów odpowiedzialnych za guziki myszy i ruch myszy i odpalanie na wątku
{
	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel chessPiece;
	int xAdjustment;
	int yAdjustment;
	Pozycja pos, cel, poprzedniGraficzny;
	List <Pozycja> listaRuchow;

	private SzachyLogika gra;

	
	public void rysujPlansze()
	{
		gra = new SzachyLogika();		 // nowy obiekt Typu SzachyLogika
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

	}
	
	


	@Override
	public void run() 
	{
		
		  JFrame frame = new ChessGame();
		  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
		  frame.pack();
		  frame.setResizable(true);
		  frame.setLocationRelativeTo( null );
		  frame.setVisible(true);

		
	}

	public void mousePressed(MouseEvent e)
	{
		chessPiece=null;
		Component c = chessBoard.findComponentAt(e.getX(), e.getY()); //Pobiera komponent znajdujący się na danych współrzędnych
		
		if(c instanceof JPanel) // jeśli jest to JPanel;
			return; // to wyjdź z funkcji
		Point parentLocation =c.getParent().getLocation(); // zapisuhe położenie w parentLocation
		List <Pozycja> tmpMoves = new ArrayList<Pozycja>();

	  	
		
		xAdjustment = parentLocation.x -e.getX(); 
		yAdjustment = parentLocation.y -e.getY(); 
		//System.out.println(parentLocation.x); System.out.println(parentLocation.y);//
		int pom =0;
		pos = new Pozycja((e.getY()+pom)/64,(e.getX()+pom)/64);
		listaRuchow = gra.possibleMoves(pos,gra);
	  	
		if(gra.sprawdzSzachBialym(gra))
	  	{
	  		System.out.println("\nBialy krol w szachu!!!");
	  		
	  		tmpMoves.addAll(this.gra.sprawdzSDWMRB(this.gra));
	  		if (tmpMoves.size() == 0)
	  		{
	  			System.out.println("Bialy Zamatowany!");
	  		} 
	  		//listaRuchow = new ArrayList <Pozycja>(iloczynPozycji(listaRuchow, tmpMoves));
	  		
	  	}
		tmpMoves = new ArrayList <Pozycja>();
	  	if(gra.sprawdzSzachCzarnym(gra))
	  	{
	  		System.out.println("\nCzarny krol w szachu!!!");
	  		
	  		tmpMoves.addAll(this.gra.sprawdzSDWMRC(this.gra));
	  		if (tmpMoves.size() == 0)
	  		{
	  			System.out.println("Czarny Zamatowany!");
	  		}
	  		listaRuchow = new ArrayList <Pozycja>(iloczynPozycji(listaRuchow, tmpMoves)); 
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
	
	public List<Pozycja> iloczynPozycji(List<Pozycja> pierwsza, List <Pozycja> druga)
	{
		List <Pozycja> pMoves = new ArrayList <Pozycja>();
		for (int i =0;i<pierwsza.size();i++)
		{
			for (int j =0;j<druga.size();j++)
			{
				
				if (pierwsza.get(i).equals(druga.get(j)))
				{
					pMoves.add(druga.get(j));
				}
				
			}
		}
		return pMoves;
	}
	
}
