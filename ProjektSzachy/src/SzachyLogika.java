import java.util.ArrayList;
import java.util.List;


public class SzachyLogika {
	private static String plansza[][];
	public enum bierki {PUSTE,PION, WIEZA, KON, GONIEC, HETMAN, KROL}
	
	
	
	public void SzachyLogika()
	{
		resetujplansze();
	}
	
	public void resetujplansze()
	{
		plansza = new String[][] {	 
					 {"w","s","g","h","k","g","s","w"},
					 {"p","p","p","p","p","p","p","p"},	
					 {" "," "," "," "," "," "," "," "},
					 {" "," "," "," "," "," "," "," "},
					 {" "," "," "," "," "," "," "," "},
					 {" "," "," "," "," "," "," "," "},
					 {"P","P","P","P","P","P","P","P"},
					 {"W","S","G","h","k","G","S","W"}};
	}
	
	public List<Pozycja> possibleMoves(String plansza[][],Pozycja pos )
	{
		//String pMoves[];
		List<Pozycja> pMoves = new ArrayList<Pozycja>();
		switch (plansza[pos.row][pos.column])
		{
			case "p":
			{
				if (pos.row == 6)
				{
					if(plansza[pos.row+1][pos.column].equals(" "))
					{
						pMoves.add(new Pozycja(pos.row+1,pos.column));
						if(plansza[pos.row+2][pos.column].equals(" "))
						{
							pMoves.add(new Pozycja(pos.row+2,pos.column));
						}
					}
				}
				
			}
			case "P":	
			{
				
			}	
		
		}
		
		
		
		
		return pMoves;
	}
	
	public void zbij(String plansza[][], int row, int column)
	{
		
		
	}
	
}
