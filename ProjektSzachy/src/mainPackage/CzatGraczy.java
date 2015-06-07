package mainPackage;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import maleOkienka.RageQuitNotice;

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
	ArrayList <CzatGraczy> watkiCzatow;
	
	public String getRozmowca()
	{
		return rozmowca;
	}
	
	public JTextArea getMessageBox()
	{
		return messageBox;
	}
	
	public CzatGraczy(String nadawca,String rozmowca, ObjectOutputStream pisarz, ArrayList<CzatGraczy> watkiCzatow)
	{
		super(rozmowca);
		this.nadawca = nadawca;
		this.rozmowca = rozmowca;
		this.pisarz = pisarz;
		this.watkiCzatow=watkiCzatow;
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
		//Thread JPK = new Thread (this);
		setSize(width,height);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		CzatGraczy reference = this;
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt)
			{
				dispose();
				watkiCzatow.remove(reference);
				//JPK.stop();
				//JPK.destroy();
			}
		});
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
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
	}

}
