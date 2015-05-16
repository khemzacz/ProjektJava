package mainPackage;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

import komunikacja.*;


public class CzatGraczy extends JFrame implements Runnable
{
	String nadawca;
	String rozmowca;
	JPanel panel=new JPanel();
	int width=400, height=350;
	JTextArea messageBox = new JTextArea();
	JButton wyslijButton = new JButton("wyslij");
	JTextField doWyslania = new JTextField();
	ObjectOutputStream pisarz;
	
	public String getRozmowca()
	{
		return rozmowca;
	}
	
	public JTextArea getMessageBox()
	{
		return messageBox;
	}
	
	public CzatGraczy(String nadawca,String rozmowca, ObjectOutputStream pisarz)
	{
		super(rozmowca);
		this.nadawca = nadawca;
		this.rozmowca = rozmowca;
		this.pisarz = pisarz;
	}
	
	public void dodajWiadomosc(String message)
	{
		try {
			pisarz.writeObject(new RamkaKlienta(5,nadawca,rozmowca,doWyslania.getText()));
			pisarz.flush();
			doWyslania.setText("");
			messageBox.append("\n"+nadawca+": "+message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	@Override
	public void run() 
	{
		setSize(width,height);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		panel.setLayout(null);
		
		messageBox.setBounds(10,10,375,240);
		wyslijButton.setBounds(300,250,85,20);
		doWyslania.setBounds(10,250,290,20);
		
		
		wyslijButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent Ev)
			{
				String message = doWyslania.getText();
				dodajWiadomosc(message);
				
			}
			
			
			
		});
		
		panel.add(messageBox);
		messageBox.setEditable(false);
		messageBox.setLineWrap(true);
		messageBox.setWrapStyleWord(true);
		panel.add(wyslijButton);
		panel.add(doWyslania);
		
		add(panel);
		
		setVisible(true);
		setResizable(false);
		
	}

}
