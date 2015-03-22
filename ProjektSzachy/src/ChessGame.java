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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class ChessGame extends JFrame implements MouseListener, MouseMotionListener, Runnable
{
	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel chessPiece;
	int xAdjustment;
	int yAdjustment;
	
	public ChessGame()
	{
		Dimension boardSize = new Dimension(600,600);
		layeredPane= new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);
		
		
		chessBoard = new JPanel();
		layeredPane.add(chessBoard,JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout(new GridLayout(8,8));
		chessBoard.setPreferredSize(boardSize);
		chessBoard.setBounds(0,0,boardSize.width, boardSize.height);
		
		for (int i = 0;i<64 ;i++)
		{
			JPanel square = new JPanel(new BorderLayout());
			chessBoard.add( square);
			int row =(i/8)%2;
			if (row==0)
				square.setBackground(i%2== 0? Color.getHSBColor((76F/360F),1F,0.5F) : Color.getHSBColor((51F/360F),.35F,0.80F));
			else
				square.setBackground(i%2==0? Color.getHSBColor((51F/360F),.35F,0.80F) : Color.getHSBColor((76F/360F),1F,0.5F));
			
		}
		for (int i = 0;i<8;i++)
		{
		JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/pionczarny.png"));
		JPanel panel = (JPanel)chessBoard.getComponent(8+i);
		panel.add(piece);
		}
		
		for (int i = 0;i<8;i++)
		{
		JLabel piece = new JLabel (new ImageIcon("pliki/zdjecia/pionbialy.png"));
		JPanel panel = (JPanel)chessBoard.getComponent(48+i);
		panel.add(piece);
		}
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
		Component c = chessBoard.findComponentAt(e.getX(), e.getY());
		
		if(c instanceof JPanel)
			return;
		Point parentLocation =c.getParent().getLocation();
		xAdjustment = parentLocation.x -e.getX();
		yAdjustment = parentLocation.y -e.getY();
		chessPiece = (JLabel)c;
		chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
	}
	
	public void mouseDragged(MouseEvent me)
	{
		  if (chessPiece == null) return;
		 chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	}
	
	
	public void mouseReleased(MouseEvent e) {
		  if(chessPiece == null) return;
		 
		  chessPiece.setVisible(false);
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		  if (c instanceof JLabel){
		  Container parent = c.getParent();
		  parent.remove(0);
		  parent.add( chessPiece );
		  }
		  else {
		  Container parent = (Container)c;
		  parent.add( chessPiece );
		  }
		 
		  chessPiece.setVisible(true);
		  }
	
	public void mouseClicked(MouseEvent e) {
		  
	  }
	  public void mouseMoved(MouseEvent e) {
	 }
	  public void mouseEntered(MouseEvent e){
	  
	  }
	  public void mouseExited(MouseEvent e) {
	  
	  }
	 

	
}
