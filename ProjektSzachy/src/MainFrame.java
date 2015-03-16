import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame
{
	public MainFrame(String title)
	{
		super(title);
		//set layout manager
		setLayout(new BorderLayout());
		
		//Create Swing component
		JTextArea textArea = new JTextArea();
		JButton button = new JButton("Zaloguj");
		
		//Add Swing components to content pane
		Container c= getContentPane();
		c.add(textArea, BorderLayout.CENTER);
		c.add(button, BorderLayout.SOUTH);
		
		//add behaviour
		button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("Trwa Logowanie\n");
				
			}
			
		});
		
		
	}
	
	
}
