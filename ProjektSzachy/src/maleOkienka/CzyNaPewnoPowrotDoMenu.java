package maleOkienka;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.IOException;
import java.io.ObjectOutputStream;

import komunikacja.*;
import mainPackage.*;


public class CzyNaPewnoPowrotDoMenu extends JFrame implements Runnable
{
	private JButton tak = new JButton("TAK");
	private JButton nie = new JButton("NIE");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private int width = 360;
	private int height = 100;
	private MainMenu menu;
	//private ObjectOutputStream pisarz;
	
	public CzyNaPewnoPowrotDoMenu(MainMenu menu)
	{
		super("notice");
		this.menu=menu;
	}
	
	public void run()
	{
		setSize(width,height);
		setLocationRelativeTo(null);
		label.setBounds(10,10,300,20);
		label.setText("Jesteś pewien, że chcesz powrócić do menu głównego?");
		tak.setBounds(width/2-85,height/2+40,75,20);
		tak.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
					menu.getPanel_Menu().removeAll();
					menu.getPanel_Menu().add(menu.getSpButton());
					menu.getPanel_Menu().add(menu.getMpButton());
					//menu.getPanel_Menu().add(menu.getOpButton());
					menu.getPanel_Menu().add(menu.getLoButton());
					menu.getPanel_Menu().add(menu.getTlo());
					menu.getPanel_Menu().repaint();
					menu.getSpButton().setVisible(true);
					menu.getMpButton().setVisible(true);
					//menu.getOpButton().setVisible(true);
					menu.getLoButton().setVisible(true);
					
					//TUTAJ TRZEBA PRZEMALOWAĆ OKNO KLASY MAIN MENU
					dispose();
				
			}
			
		});
		nie.setBounds(width/2+10,height/2+40,75,20);
		nie.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ev)
			{
				dispose();	
			}
		});
		panel.add(label);
		panel.add(tak);
		panel.add(nie);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
}
