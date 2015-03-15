import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class test {

	public static void main(String[] args) 
	{
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame okno = new JFrame("Menu");
				okno.setSize (500,400);
				okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				okno.setVisible(true);
			}
		});
	}

	
}
