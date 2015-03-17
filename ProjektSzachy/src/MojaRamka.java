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
	JButton zalogujButton=new JButton("Zaloguj");
	JButton rejestrujButton=new JButton("Załóż konto");
	JTextField Login=new JTextField("",12);
	JLabel LoginLabel= new JLabel("Login: ");
	JTextField Pass=new JTextField("",12);
	JLabel PassLabel= new JLabel("Hasło: ");
	
	public MojaRamka(String tekst){
		super(tekst);
		
		setSize(800,600); //rozmiar ramki-okna
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p.setLayout(new GridLayout(4,2)); //(wiersze, kolumny, luka pozioma, pionowa)
		
		//p.setBorder();

		
		p.add(LoginLabel);
		p.add(Login);
		p.add(PassLabel);
		p.add(Pass);
		p.add(zalogujButton);
		p.add(rejestrujButton);
		add(p);
		setVisible(true);
		
		
	}
	
}
