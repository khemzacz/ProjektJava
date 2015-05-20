package maleOkienka;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class NajpierwSieWyloguj extends JFrame implements Runnable
{
	private JButton ok = new JButton("OKEY");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private int width = 360;
	private int height = 100;
	
	public NajpierwSieWyloguj()
	{
		super("Error!");
		
	}
	@Override
	public void run()
	{
		setSize(width,height);
		setLocationRelativeTo(null);
		label.setBounds(45,-5,300,40);
		label.setText("Zanim powrócisz do menu głównego najpierw się wyloguj");
		ok.setBounds(width/2-35,35,70,20);
		ok.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ev)
			{
				dispose();	
			}
		});
		panel.add(label);
		panel.add(ok);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}

}
