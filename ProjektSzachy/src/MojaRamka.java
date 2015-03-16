import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MojaRamka extends JFrame {
	JPanel p=new JPanel();
	JButton zalogujButton=new JButton("Zaloguj");
	JTextField Login=new JTextField("",12);
	JLabel LoginLabel= new JLabel("Login: ");
	JTextField Pass=new JTextField("",12);
	JLabel PassLabel= new JLabel("Login: ");
	
	public MojaRamka(String tekst){
		super(tekst);
		
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.add(LoginLabel);
		p.add(Login);
		p.add(PassLabel);
		p.add(Pass);
		p.add(zalogujButton);
		add(p);
		setVisible(true);
		
		
	}
	
}
