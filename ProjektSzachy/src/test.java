import javax.swing.SwingUtilities;




public class test {


	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new MojaRamka("preAlpha JavaSzachy v.001");	
			}//new MojaRamka("preAlpha JavaSzachy v.001");	
		});
	}

	

	
}
