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
	JButton rejestrujButton=new JButton("Załóż konto");
	JTextField Login=new JTextField("",12);
	JLabel LoginLabel= new JLabel("Login: ");
	JTextField Pass=new JTextField("",12);
	JLabel PassLabel= new JLabel("Hasło: ");
	
	public MojaRamka(String tekst){
		super(tekst);

		
		
		
		setSize(800,600); //rozmiar ramki-okna
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p.setLayout(new GridLayout(14,2)); //(wiersze, kolumny, luka pozioma, pionowa)
		
		//p.setBorder();

		JLabel odstep[]=new JLabel[18];
		for (int i=0;i<18;i++)
		{
			odstep[i]=new JLabel("");
			p.add(odstep[i]);
		}
		
		p.add(LoginLabel);
		p.add(Login);
		p.add(PassLabel);
		p.add(Pass);
		p.add(zalogujButton);
		p.add(rejestrujButton);
		zewP.add(p);
		add(zewP);
		
		setVisible(true);
		
		
	}
	
}
