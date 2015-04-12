import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class MainMenu extends JFrame implements Runnable
{
	private String user;
	private int width=400, height=500;
	MainMenu(String user)
	{
		super("MainMenu"); // nazwa okna
		this.user=user;
		
		
	}
	
	



	@Override
	public void run() {
		// TODO Auto-generated method stub

		JPanel panel_menu= new JPanel();
		JButton sp_button = new JButton("Local Game");
		JButton mp_button = new JButton("Internet Game");
		//JButton st_button = new JButton("Statystyki");
		JButton op_button = new JButton("Opcje");
		JButton lo_button = new JButton("Log Out");
		JLabel dane_usera = new JLabel("Witaj " +user);
		
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
			{
				// TU bede odpalał
			}
		});
		
		
		setResizable(false);
		
		panel_menu.setLayout(null);
		
		dane_usera.setBounds(width-40-8*user.length(),0,40+8*user.length(),20);
		sp_button.setBounds(width/2-80,height/2-120,160,40);
		mp_button.setBounds(width/2-80,height/2-80,160,40);
		op_button.setBounds(width/2-80,height/2-40,160,40);
		lo_button.setBounds(width/2-80,height/2-0,160,40);
		
		panel_menu.add(sp_button);
		panel_menu.add(mp_button);
		panel_menu.add(op_button);
		panel_menu.add(lo_button);
		panel_menu.add(dane_usera);
		add(panel_menu);
		setVisible(true);
		
	}
	
	
}
