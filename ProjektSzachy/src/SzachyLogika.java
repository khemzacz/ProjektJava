
public class SzachyLogika {
	private int plansza[][];
	public enum figury {PUSTE,PION, WIEZA, KON, GONIEC, HETMAN, KROL}
	
	void SzachyLogika()
	{
		resetujplansze();
	}
	
	void resetujplansze()
	{
		for (int w =0;w<8;w++)
		{
			for (int k=0;k<8;k++)
			{
				if(w==1 || w==6)
					plansza[w][k]=1;
				if (w==0 || w==7)
				{
					if (k==0 || k==7)
					{
						plansza[w][k]=2;
					}
					if (k==1 || k==6)
					{
						plansza[w][k]=3;
					}
					if (k==2 || k==5)
					{
						plansza [w][k]=4;						
					}
					if (k==3)
					{
						plansza[w][k]=7;
					}
					if (k==4)
					{
						plansza[w][k]=6;
					}
					
				}
				else
				{
					plansza[w][k]=0;
					
				}
				
				
			}
			
		}	
		
	}
	
	
}
