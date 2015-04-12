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
	
	public List<Pozycja> possibleMoves(/*MojCharacter plansza[][],*/Pozycja pos )
	{
		//String pMoves[];
		List<Pozycja> pMoves = new ArrayList<Pozycja>();
		if(plansza[pos.row][pos.column].rowne('p') || plansza[pos.row][pos.column].rowne('P') )
		{
			return this.ruchyPionka(pos);
		}
		if(plansza[pos.row][pos.column].rowne('w') || plansza[pos.row][pos.column].rowne('W') )
		{
			return this.ruchyPionka(pos);
		}
		
			
		return null;
	}
		
		
	public List<Pozycja> ruchyPionka(Pozycja pos)
	{
		List<Pozycja> pMoves = new ArrayList<Pozycja>();
		if(plansza[pos.row][pos.column].rowne('p'))
		{
				if(plansza[pos.row-1][pos.column].rowne(' ')) // jesli przed soba ma wolne pole
				{
					pMoves.add(new Pozycja(pos.row-1,pos.column)); // dodaj to pole do mozliwych ruchow
					if(pos.row == 6 && plansza[pos.row-2][pos.column].rowne(' ')) // jesli dwa dalej jest wolne pole
					{
						pMoves.add(new Pozycja(pos.row-2,pos.column)); // dodaj to pole do mozliwych ruchow
					}
				}
				if(pos.column != 0 && plansza[pos.row-1][pos.column-1].isUpperCase()) // jeśli nie stoi na krawedzi i na skos w lewo ma pion przeciwnika
				{
					pMoves.add(new Pozycja(pos.row-1,pos.column-1));
				}
				if(pos.column != 7 && plansza[pos.row-1][pos.column+1].isUpperCase()) 
				{
					pMoves.add(new Pozycja(pos.row-1,pos.column +1));
				}
			return pMoves;
		}
		else if (plansza[pos.row][pos.column].rowne('P'))
		{
			if(plansza[pos.row+1][pos.column].rowne(' ')) // jesli przed soba ma wolne pole
			{
				pMoves.add(new Pozycja(pos.row+1,pos.column)); // dodaj to pole do mozliwych ruchow
				if(pos.row == 1 && plansza[pos.row+2][pos.column].rowne(' ')) // jesli dwa dalej jest wolne pole
				{
					pMoves.add(new Pozycja(pos.row+2,pos.column)); // dodaj to pole do mozliwych ruchow
				}
			}
			if(pos.column != 0 && plansza[pos.row+1][pos.column-1].isUpperCase()) // jeśli nie stoi na krawedzi i na skos w lewo ma pion przeciwnika
			{
				pMoves.add(new Pozycja(pos.row+1,pos.column-1));
			}
			if(pos.column != 7 && plansza[pos.row+1][pos.column+1].isUpperCase()) 
			{
				pMoves.add(new Pozycja(pos.row+1,pos.column +1));
			}
			return pMoves;
		}	
		return null;
	}
		
		
	
	
	public void zbij(String plansza[][], int row, int column)
	{
		
		
	}
	
}
