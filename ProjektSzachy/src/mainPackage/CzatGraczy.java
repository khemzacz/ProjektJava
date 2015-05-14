package mainPackage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CzatGraczy extends JFrame implements Runnable
{
	String rozmowca;
	JPanel panel=new JPanel();
	int width=300, height=250;
	JTextArea messageBox = new JTextArea();
	JButton wyslijButton = new JButton();
	JTextField doWyslania = new JTextField();
	
	public CzatGraczy(String rozmowca)
	{
		super(rozmowca);
		this.rozmowca = rozmowca;
	}
	
	public void dodajWiadomosc(String message)
	{
		panel.setLayout(null);
		
		messageBox.setBounds(10,10,290,220);
		wyslijButton.setBounds(240,230,40,20);
		doWyslania.setBounds(10,230,230,20);
		
		panel.add(messageBox);
		panel.add(wyslijButton);
		panel.add(doWyslania);
		
		this.add(panel);
		this.setVisible(true);
		
		
	}
	
	
	@Override
	public void run() 
	{
		
		
	}

}
