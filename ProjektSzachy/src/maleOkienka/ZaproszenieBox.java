package maleOkienka;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ZaproszenieBox extends JFrame implements Runnable
{
	private JButton akceptuj = new JButton("Akceptuj");
	private JButton odrzuc = new JButton("Odrzuc");
	private JButton ignoruj = new JButton("ignoruj");
	private JPanel panel = new JPanel();
	private int width = 320;
	private int height = 100;
	
	
	public ZaproszenieBox(String zapraszajacy)
	{
		super("Zaproszenie do gry od: "+zapraszajacy);
	}
	
	
	public void run()
	{
		setSize(width,height);
		akceptuj.setBounds(10,height/2,90,20);
		odrzuc.setBounds(110,height/2,90,20);
		ignoruj.setBounds(210,height/2,90,20);
		panel.add(akceptuj);
		panel.add(odrzuc);
		panel.add(ignoruj);
		add(panel);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
	}

}
