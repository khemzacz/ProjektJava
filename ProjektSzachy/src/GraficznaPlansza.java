import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class GraficznaPlansza extends JPanel implements MouseListener, MouseMotionListener, Runnable {
	static int x=0, y=0;
	
	@Override
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g); // 
		this.setBackground(Color.yellow); //color tła
		this.addMouseListener(this);
		g.setColor(Color.getHSBColor((51F/360F),.46F,0.77F));
		g.fillRect(x-20, y-20, 40, 40);
		g.setColor(new Color(190,81,215));
		g.fillRect(40, 20, 80, 50);
		g.drawString("Java", x, y);
		
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		y=arg0.getY();
		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x=arg0.getX();
		y=arg0.getY();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
