import java.util.ArrayList;
import java.util.List;


public class SzachyLogika {
	private static MojCharacter plansza[][];
	public enum bierki {PUSTE,PION, WIEZA, KON, GONIEC, HETMAN, KROL}
	
	
	
	public void SzachyLogika()
	{
		resetujplansze();
	}
	
	public void resetujplansze()
	{
		plansza = new MojCharacter[][] {	 
				 {new MojCharacter('w'),new MojCharacter('s'),new MojCharacter('g'),new MojCharacter('h'),new MojCharacter('k'),new MojCharacter('g'),new MojCharacter('s'),new MojCharacter('w')},
				 {new MojCharacter('p'),new MojCharacter('p'),new MojCharacter('p'),new MojCharacter('p'),new MojCharacter('p'),new MojCharacter('p'),new MojCharacter('p'),new MojCharacter('p')},	
				 {new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' ')},
				 {new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' ')},
				 {new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' ')},
				 {new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' ')},
				 {new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P')},
				 {new MojCharacter('W'),new MojCharacter('S'),new MojCharacter('G'),new MojCharacter('h'),new MojCharacter('k'),new MojCharacter('G'),new MojCharacter('S'),new MojCharacter('W')}};
	}
	
	public List<Pozycja> possibleMoves(Character plansza[][],Pozycja pos )
	{
		//String pMoves[];
		List<Pozycja> pMoves = new ArrayList<Pozycja>();
		switch (plansza[pos.row][pos.column])
		{
			case 'p':
			{
				if (pos.row == 6)
				{
					if(plansza[pos.row+1][pos.column].equals(' '))
					{
						pMoves.add(new Pozycja(pos.row+1,pos.column));
						if(plansza[pos.row+2][pos.column].equals(' '))
						{
							pMoves.add(new Pozycja(pos.row+2,pos.column));
						}
					}
					if(plansza[pos.row-1][pos.column+1] == plansza[pos.row-1][pos.column+1].)
					{
						
					}
				}
				
			}
			case 'P':	
			{
				
			}	
		
		}
		
		
		
		
		return pMoves;
	}
	
	public void zbij(String plansza[][], int row, int column)
	{
		
		
	}
	
}
