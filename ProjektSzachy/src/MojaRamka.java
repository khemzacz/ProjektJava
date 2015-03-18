import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class MojaRamka extends JFrame {
	JPanel p=new JPanel();
	JPanel zewP=new JPanel();
	JButton zalogujButton=new JButton("Zaloguj");
	JButton rejestrujButton=new JButton("Rejestracja");
	JTextField Login=new JTextField("",12);
	JLabel LoginLabel= new JLabel("Login: ");
	JTextField Pass=new JTextField("",12);
	JLabel PassLabel= new JLabel("Hasło: ");
	
	public MojaRamka(String tekst){
		super(tekst);

		
		
		
		setSize(800,600); //rozmiar ramki-okna
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//p.setLayout(new GridLayout(14,2)); //(wiersze, kolumny, luka pozioma, pionowa)
		
		//p.setBorder();
		p.setLayout(null);
		
		LoginLabel.setBounds(100, 100, 45, 20);
		Login.setBounds(150,100,151,20);
		
		PassLabel.setBounds(100,120,45,20);
		Pass.setBounds(150,120,151,20);
		
		zalogujButton.setBounds(100,140,90,20);
		rejestrujButton.setBounds(190,140,110,20);
		/*JLabel odstep[]=new JLabel[18];
		for (int i=0;i<18;i++)
		{
			odstep[i]=new JLabel("");
			p.add(odstep[i]);
		}*/
		
		p.add(LoginLabel);
		p.add(Login);
		p.add(PassLabel);
		p.add(Pass);
		p.add(zalogujButton);
		p.add(rejestrujButton);
		add(p);
		add(p);
		
		setVisible(true);
		
		
	}
	
}
