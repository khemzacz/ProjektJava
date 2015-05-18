package maleOkienka;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class NieMozeszCzatowacSamZeSoba extends JFrame implements Runnable
{
	private JButton ok = new JButton("OKEY");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private int width = 320;
	private int height = 100;
	
	public NieMozeszCzatowacSamZeSoba()
	{
		super("Error!");
		
	}
	@Override
	public void run()
	{
		setSize(width,height);
		setLocationRelativeTo(null);
		label.setBounds(10,10,300,20);
		label.setText("Nie możesz czatować sam ze sobą ( ͡° ͜ʖ ͡°)");
		ok.setBounds(width/2,height/2+40,75,20);
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
