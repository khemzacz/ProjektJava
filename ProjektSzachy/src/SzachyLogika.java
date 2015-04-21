import java.util.ArrayList;
import java.util.List;


public class SzachyLogika {
	MojCharacter plansza[][];
	//public enum bierki {PUSTE,PION, WIEZA, KON, GONIEC, HETMAN, KROL}
		
	public SzachyLogika()
	{
		resetujplansze(); //ffd
	}
	
	public void resetujplansze()
	{
		plansza = new MojCharacter[][] {	 
				 {new MojCharacter('w'),new MojCharacter('s'),new MojCharacter('g'),new MojCharacter('h'),new MojCharacter('k'),new MojCharacter('g'),new MojCharacter('s'),new MojCharacter('w')},
				 {new MojCharacter('p'),new MojCharacter('p'),new MojCharacter('p'),new MojCharacter('p'),new MojCharacter('p'),new MojCharacter('p'),new MojCharacter('p'),new MojCharacter(' ')},	
				 {new MojCharacter(' '),new MojCharacter(' '),new MojCharacter('G'),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' ')},
				 {new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter('h'),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' ')},
				 {new MojCharacter(' '),new MojCharacter(' '),new MojCharacter('H'),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' ')},
				 {new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' '),new MojCharacter(' ')},
				 {new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P'),new MojCharacter('P')},
				 {new MojCharacter('W'),new MojCharacter('S'),new MojCharacter('G'),new MojCharacter('H'),new MojCharacter('K'),new MojCharacter('G'),new MojCharacter('S'),new MojCharacter('W')}};
	}
	
	public List<Pozycja> possibleMoves(Pozycja pos, SzachyLogika gra )
	{
		List<Pozycja> pMoves = new ArrayList<Pozycja>();
		if(gra.plansza[pos.row][pos.column].rowne('p') || gra.plansza[pos.row][pos.column].rowne('P') )
		{
			System.out.println("Wykryto pionka");
			return this.ruchyPionka(pos,gra);
		}
		if(gra.plansza[pos.row][pos.column].rowne('w') || gra.plansza[pos.row][pos.column].rowne('W') )
		{
			System.out.println("Wykryto wieze");
			return this.ruchyWiezy(pos,gra);
		}
		if(gra.plansza[pos.row][pos.column].rowne('s') || gra.plansza[pos.row][pos.column].rowne('S') )
		{
			System.out.println("Wykryto skoczka");
			return this.ruchySkoczka(pos,gra);
			
		}
		if (gra.plansza[pos.row][pos.column].rowne('g') || gra.plansza[pos.row][pos.column].rowne('G') )
		{
			System.out.println("Wykryto Gonca");
			return this.ruchyGonca(pos,gra);
		}
		if (gra.plansza[pos.row][pos.column].rowne('h') || gra.plansza[pos.row][pos.column].rowne('H') )
		{
			System.out.println("Wykryto Hetmana");
			return this.ruchyHetmana(pos,gra);			
		}
		if (gra.plansza[pos.row][pos.column].rowne('k') || gra.plansza[pos.row][pos.column].rowne('K') )
		{
			System.out.println("Wykryto króla");
			// return this.ruchyKrola(pos,gra);			
		}
		return pMoves;
	}
		
		
	public List<Pozycja> ruchyPionka(Pozycja pos, SzachyLogika gra)
	{
		
		List<Pozycja> pMoves = new ArrayList<Pozycja>();
		//System.out.println("wiersz" + pos.row); System.out.println("kolumna" +pos.column); // wchodzi
		if(pos.row >0 && gra.plansza[pos.row][pos.column].rowne('P'))
		{
			System.out.println("wiersz" + pos.row); System.out.println("kolumna" +pos.column);
			if(gra.plansza[pos.row-1][pos.column].rowne(' ')) // jesli przed soba ma wolne pole
			{
				
				pMoves.add(new Pozycja(pos.row-1,pos.column)); // dodaj to pole do mozliwych ruchow
				if((pos.row == 6) && (gra.plansza[pos.row-2][pos.column].rowne(' '))) // jesli dwa dalej jest wolne pole
				{
					pMoves.add(new Pozycja(pos.row-2,pos.column)); // dodaj to pole do mozliwych ruchow
					
				}
			}
			if(pos.column != 0 && gra.plansza[pos.row-1][pos.column-1].isLowerCase()) // jeśli nie stoi na krawedzi i na skos w lewo ma pion przeciwnika
			{
				pMoves.add(new Pozycja(pos.row-1,pos.column-1));
			}
			if(pos.column != 7 && gra.plansza[pos.row-1][pos.column+1].isLowerCase()) 
			{
				pMoves.add(new Pozycja(pos.row-1,pos.column +1));
			}
			return pMoves;
		}
		else if (gra.plansza[pos.row][pos.column].rowne('p'))
		{
			if(gra.plansza[pos.row+1][pos.column].rowne(' ')) // jesli przed soba ma wolne pole
			{
				pMoves.add(new Pozycja(pos.row+1,pos.column)); // dodaj to pole do mozliwych ruchow
				if(pos.row == 1 && gra.plansza[pos.row+2][pos.column].rowne(' ')) // jesli dwa dalej jest wolne pole
				{
					pMoves.add(new Pozycja(pos.row+2,pos.column)); // dodaj to pole do mozliwych ruchow
				}
			}
			if(pos.column != 0 && gra.plansza[pos.row+1][pos.column-1].isUpperCase()) // jeśli nie stoi na krawedzi i na skos w lewo ma pion przeciwnika
			{
				pMoves.add(new Pozycja(pos.row+1,pos.column-1));
			}
			if(pos.column != 7 && gra.plansza[pos.row+1][pos.column+1].isUpperCase()) 
			{
				pMoves.add(new Pozycja(pos.row+1,pos.column +1));
			}
			return pMoves;
		}	
		return pMoves;
	}
		
	
	public List<Pozycja> ruchyWiezy(Pozycja pos, SzachyLogika gra)
	{
		List<Pozycja> pMoves = new ArrayList<Pozycja>();
		if(gra.plansza[pos.row][pos.column].rowne('w')) // czarna wieza
		{
			for (int i = pos.column-1 ; i>=0;i--) // petla do sprawdzanie ruchu w lewo
			{
				if(gra.plansza[pos.row][i].rowne(' ')) // i jest kolumną
				{
					pMoves.add(new Pozycja(pos.row,i)); 
					continue;
				}
				if(gra.plansza[pos.row][i].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row,i));
					break;
				}
				if(gra.plansza[pos.row][i].isLowerCase())
				{
					break;
				}
			}
			for (int i = pos.column+1;i<=7;i++)	//ruch w prawo
			{
				if(gra.plansza[pos.row][i].rowne(' '))
				{
					pMoves.add(new Pozycja(pos.row,i));
					continue;
				}
				if(gra.plansza[pos.row][i].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row,i));
					break;
				}
				if(gra.plansza[pos.row][i].isLowerCase())
				{
					break;
				}
			}
			for (int j=pos.row-1;j>=0;j--)// sprawdzanie ruchu w górę
			{
				if(gra.plansza[j][pos.column].rowne(' '))
				{
					pMoves.add(new Pozycja(j,pos.column));
					continue;
				}
				if (gra.plansza[j][pos.column].isUpperCase())
				{
					pMoves.add(new Pozycja(j, pos.column));
					break;
				}
				if (gra.plansza[j][pos.column].isLowerCase())
				{
					break;
				}
			}
			for (int j=pos.row+1;j<=7;j++) // sprawdzanie ruchu w dol
			{
				if (gra.plansza[j][pos.column].rowne(' '))
				{
					pMoves.add(new Pozycja(j,pos.column));
					continue;
				}
				if (gra.plansza[j][pos.column].isUpperCase())
				{
					pMoves.add(new Pozycja(j,pos.column));
					break;
				}
				if(gra.plansza[j][pos.column].isLowerCase())
				{
					break;
				}
			}
			
			return pMoves;
		}
		if(gra.plansza[pos.row][pos.column].rowne('W'))
		{
			for (int i = pos.column -1 ; i>=0;i--) // petla do sprawdzenie ruchu w lewo
			{
				if(gra.plansza[pos.row][i].rowne(' '))
				{
					pMoves.add(new Pozycja(pos.row,i));
					continue;
				}
				if(gra.plansza[pos.row][i].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row,i));
					break;
				}
				if (gra.plansza[pos.row][i].isUpperCase())
				{
					break;
				}
			}
			for (int i = pos.column+1;i<=7;i++)	//ruch w prawo
			{
				if(gra.plansza[pos.row][i].rowne(' '))
				{
					pMoves.add(new Pozycja(pos.row,i));
					continue;
				}
				if(gra.plansza[pos.row][i].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row,i));
					break;
				}
				if(gra.plansza[pos.row][i].isUpperCase())
				{
					break;
				}
			}
			for (int j=pos.row-1;j>=0;j--)// sprawdzanie ruchu w górę
			{
				if(gra.plansza[j][pos.column].rowne(' '))
				{
					pMoves.add(new Pozycja(j,pos.column));
					continue;
				}
				if (gra.plansza[j][pos.column].isLowerCase())
				{
					pMoves.add(new Pozycja(j, pos.column));
					break;
				}
				if (gra.plansza[j][pos.column].isUpperCase())
				{
					break;
				}
			}
			for (int j=pos.row+1;j<=7;j++) // sprawdzanie ruchu w dol
			{
				if (gra.plansza[j][pos.column].rowne(' '))
				{
					pMoves.add(new Pozycja(j,pos.column));
					continue;
				}
				if (gra.plansza[j][pos.column].isLowerCase())
				{
					pMoves.add(new Pozycja(j,pos.column));
					break;
				}
				if (gra.plansza[j][pos.column].isUpperCase())
				{
					break;
				}
			}
			
		}
		return pMoves;
	}
		
	
	public List <Pozycja> ruchySkoczka(Pozycja pos, SzachyLogika gra)
	{
		List<Pozycja> pMoves = new ArrayList<Pozycja>();
		System.out.println("wiersz" + pos.row); System.out.println("kolumna" +pos.column);
		if(gra.plansza[pos.row][pos.column].rowne('s')) // czarny skoczek
		{
			System.out.println("czarnego");
			//System.out.println(pos.row -1);
			if((pos.row-1)>=0)
			{
				System.out.println("Tutaj");
				if(pos.column -2>=0)
				{
					
					if(gra.plansza[pos.row-1][pos.column -2].rowne(' '))
					{
						
						pMoves.add(new Pozycja(pos.row-1,pos.column -2));
					}
					if(gra.plansza[pos.row-1][pos.column -2].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row-1,pos.column -2));
					}
				}
				if(pos.column +2<=7)
				{
					if(gra.plansza[pos.row-1][pos.column +2].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-1,pos.column +2));
					}
					if(gra.plansza[pos.row-1][pos.column +2].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row-1,pos.column +2));
					}
				}
		
			}
			
			if(pos.row+1 <=7)
			{
				
				if(pos.column -2>=0)
				{
					System.out.println("Tutaj");
					if(gra.plansza[pos.row+1][pos.column-2].rowne(' '))
					{
						System.out.println("Tutaj2");
						pMoves.add(new Pozycja(pos.row+1,pos.column -2));
					}
					if(gra.plansza[pos.row+1][pos.column -2].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row+1,pos.column -2));
					}
				}
				if(pos.column +2<=7)
				{
					if(gra.plansza[pos.row+1][pos.column +2].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+1,pos.column +2));
					}
					if(gra.plansza[pos.row+1][pos.column +2].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row+1,pos.column +2));
					}
				}
		
			}
			
			if(pos.column -1 >=0)
			{
				if(pos.row-2>=0)
				{
					if(gra.plansza[pos.row-2][pos.column-1].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-2,pos.column-1));
					}
					if(gra.plansza[pos.row-2][pos.column-1].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row-2,pos.column-1));
					}
				}
				if(pos.row+2<=7)
				{
					if(gra.plansza[pos.row+2][pos.column-1].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+2,pos.column-1));
					}
					if(gra.plansza[pos.row+2][pos.column-1].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row+2,pos.column-1));
					}
				}
			}
			
			if(pos.column +1 <=7)
			{
				if(pos.row-2>=0)
				{
					if(gra.plansza[pos.row-2][pos.column+1].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-2,pos.column+1));
					}
					if(gra.plansza[pos.row-2][pos.column+1].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row-2,pos.column+1));
					}
				}
				if(pos.row+2<=7)
				{
					if(gra.plansza[pos.row+2][pos.column+1].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+2,pos.column+1));
					}
					if(gra.plansza[pos.row+2][pos.column+1].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row+2,pos.column+1));
					}
				}
			}
			
		}
		
		if(gra.plansza[pos.row][pos.column].rowne('S'))
		{
			System.out.println("czarnego");
			//System.out.println(pos.row -1);
			if((pos.row-1)>=0)
			{
				System.out.println("Tutaj");
				if(pos.column -2>=0)
				{
					
					if(gra.plansza[pos.row-1][pos.column -2].rowne(' '))
					{
						
						pMoves.add(new Pozycja(pos.row-1,pos.column -2));
					}
					if(gra.plansza[pos.row-1][pos.column -2].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row-1,pos.column -2));
					}
				}
				if(pos.column +2<=7)
				{
					if(gra.plansza[pos.row-1][pos.column +2].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-1,pos.column +2));
					}
					if(gra.plansza[pos.row-1][pos.column +2].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row-1,pos.column +2));
					}
				}
		
			}
			
			if(pos.row+1 <=7)
			{
				
				if(pos.column -2>=0)
				{
					System.out.println("Tutaj");
					if(gra.plansza[pos.row+1][pos.column-2].rowne(' '))
					{
						System.out.println("Tutaj2");
						pMoves.add(new Pozycja(pos.row+1,pos.column -2));
					}
					if(gra.plansza[pos.row+1][pos.column -2].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row+1,pos.column -2));
					}
				}
				if(pos.column +2<=7)
				{
					if(gra.plansza[pos.row+1][pos.column +2].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+1,pos.column +2));
					}
					if(gra.plansza[pos.row+1][pos.column +2].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row+1,pos.column +2));
					}
				}
		
			}
			
			if(pos.column -1 >=0)
			{
				if(pos.row-2>=0)
				{
					if(gra.plansza[pos.row-2][pos.column-1].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-2,pos.column-1));
					}
					if(gra.plansza[pos.row-2][pos.column-1].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row-2,pos.column-1));
					}
				}
				if(pos.row+2<=7)
				{
					if(gra.plansza[pos.row+2][pos.column-1].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+2,pos.column-1));
					}
					if(gra.plansza[pos.row+2][pos.column-1].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row+2,pos.column-1));
					}
				}
			}
			
			if(pos.column +1 <=7)
			{
				if(pos.row-2>=0)
				{
					if(gra.plansza[pos.row-2][pos.column+1].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-2,pos.column+1));
					}
					if(gra.plansza[pos.row-2][pos.column+1].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row-2,pos.column+1));
					}
				}
				if(pos.row+2<=7)
				{
					if(gra.plansza[pos.row+2][pos.column+1].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+2,pos.column+1));
					}
					if(gra.plansza[pos.row+2][pos.column+1].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row+2,pos.column+1));
					}
				}
			}
		}		
		return pMoves;
	}
	
	
	public List <Pozycja> ruchyGonca(Pozycja pos, SzachyLogika gra)
	{
		List <Pozycja> pMoves = new ArrayList<Pozycja>();
		System.out.println("wiersz" + pos.row); System.out.println("kolumna" +pos.column);
		if(gra.plansza[pos.row][pos.column].rowne('g'))
		{
			//System.out.println("tutaj");
			for (int i=1;i<=7;i++)
			{
				
				if((pos.row+i)<=7 && (pos.column+i) <=7)
				{
					//System.out.println(pos.row + " "+ pos.column); 3 1
					if(gra.plansza[pos.row+i][pos.column+i].rowne(' '))
					{
						//System.out.println("tutaj"); // nie wchodzi
						pMoves.add(new Pozycja(pos.row+i,pos.column+i));
						continue;
					}
					if(gra.plansza[pos.row+i][pos.column+i].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column+i));
						break;
					}
					if(gra.plansza[pos.row+i][pos.column+i].isLowerCase())
					{
						break;
					}					
				}
				
				else
					{break;}
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row-i>=0 && pos.column-i >=0)
				{
					if(gra.plansza[pos.row-i][pos.column-i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column-i));
						continue;
					}
					if(gra.plansza[pos.row-i][pos.column-i].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column-i));
						break;
					}
					if(gra.plansza[pos.row-i][pos.column-i].isLowerCase())
					{
						break;
					}					
				}
				else break;				
				
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row-i>=0 && pos.column+i <=7)
				{
					if(gra.plansza[pos.row-i][pos.column+i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column+i));
						continue;
					}
					if(gra.plansza[pos.row-i][pos.column+i].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column+i));
						break;
					}
					if(gra.plansza[pos.row-i][pos.column+i].isLowerCase())
					{
						break;
					}					
				}
				else break;					
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row+i<=7 && pos.column-i >=0)
				{
					if(gra.plansza[pos.row+i][pos.column-i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column-i));
						continue;
					}
					if(gra.plansza[pos.row+i][pos.column-i].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column-i));
						break;
					}
					if(gra.plansza[pos.row+i][pos.column-i].isLowerCase())
					{
						break;
					}					
				}
				else break;					
			}			
			
			
		}
		if(gra.plansza[pos.row][pos.column].rowne('G'))
		{
			for (int i=1;i<=7;i++)
			{
				if(pos.row+i <= 7 && pos.column+i <= 7)
				{
					if(gra.plansza[pos.row+i][pos.column+i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column+i));
						continue;
					}
					if(gra.plansza[pos.row+i][pos.column+i].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column+i));
						break;
					}
					if(gra.plansza[pos.row+i][pos.column+i].isUpperCase())
					{
						break;
					}					
				}
				else break;
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row-i >=0 && pos.column-i >= 0)
				{
					if(gra.plansza[pos.row-i][pos.column-i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column-i));
						continue;
					}
					if(gra.plansza[pos.row-i][pos.column-i].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column-i));
						break;
					}
					if(gra.plansza[pos.row-i][pos.column-i].isUpperCase())
					{
						break;
					}					
				}
				else break;				
				
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row-i >= 0 && pos.column+i <= 7)
				{
					if(gra.plansza[pos.row-i][pos.column+i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column+i));
						continue;
					}
					if(gra.plansza[pos.row-i][pos.column+i].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column+i));
						break;
					}
					if(gra.plansza[pos.row-i][pos.column+i].isUpperCase())
					{
						break;
					}					
				}
				else break;					
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row+i <= 7 && pos.column-i >= 0)
				{
					if(gra.plansza[pos.row+i][pos.column-i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column-i));
						continue;
					}
					if(gra.plansza[pos.row+i][pos.column-i].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column-i));
						break;
					}
					if(gra.plansza[pos.row+i][pos.column-i].isUpperCase())
					{
						break;
					}					
				}
				else break;					
			}			
		}	
		
		
		return pMoves;
	}
	
	public List <Pozycja> ruchyHetmana(Pozycja pos, SzachyLogika gra)
	{
		List <Pozycja> pMoves = new ArrayList<Pozycja>();
		if(gra.plansza[pos.row][pos.column].rowne('h'))
		{
			//System.out.println("tutaj");
			for (int i=1;i<=7;i++)
			{
				
				if((pos.row+i)<=7 && (pos.column+i) <=7)
				{
					//System.out.println(pos.row + " "+ pos.column); 3 1
					if(gra.plansza[pos.row+i][pos.column+i].rowne(' '))
					{
						//System.out.println("tutaj"); // nie wchodzi
						pMoves.add(new Pozycja(pos.row+i,pos.column+i));
						continue;
					}
					if(gra.plansza[pos.row+i][pos.column+i].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column+i));
						break;
					}
					if(gra.plansza[pos.row+i][pos.column+i].isLowerCase())
					{
						break;
					}					
				}
				
				else
					{break;}
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row-i>=0 && pos.column-i >=0)
				{
					if(gra.plansza[pos.row-i][pos.column-i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column-i));
						continue;
					}
					if(gra.plansza[pos.row-i][pos.column-i].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column-i));
						break;
					}
					if(gra.plansza[pos.row-i][pos.column-i].isLowerCase())
					{
						break;
					}					
				}
				else break;				
				
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row-i>=0 && pos.column+i <=7)
				{
					if(gra.plansza[pos.row-i][pos.column+i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column+i));
						continue;
					}
					if(gra.plansza[pos.row-i][pos.column+i].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column+i));
						break;
					}
					if(gra.plansza[pos.row-i][pos.column+i].isLowerCase())
					{
						break;
					}					
				}
				else break;					
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row+i<=7 && pos.column-i >=0)
				{
					if(gra.plansza[pos.row+i][pos.column-i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column-i));
						continue;
					}
					if(gra.plansza[pos.row+i][pos.column-i].isUpperCase())
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column-i));
						break;
					}
					if(gra.plansza[pos.row+i][pos.column-i].isLowerCase())
					{
						break;
					}					
				}
				else break;					
			}			
			
			
		}
		if(gra.plansza[pos.row][pos.column].rowne('H'))
		{
			for (int i=1;i<=7;i++)
			{
				if(pos.row+i <= 7 && pos.column+i <= 7)
				{
					if(gra.plansza[pos.row+i][pos.column+i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column+i));
						continue;
					}
					if(gra.plansza[pos.row+i][pos.column+i].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column+i));
						break;
					}
					if(gra.plansza[pos.row+i][pos.column+i].isUpperCase())
					{
						break;
					}					
				}
				else break;
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row-i >=0 && pos.column-i >= 0)
				{
					if(gra.plansza[pos.row-i][pos.column-i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column-i));
						continue;
					}
					if(gra.plansza[pos.row-i][pos.column-i].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column-i));
						break;
					}
					if(gra.plansza[pos.row-i][pos.column-i].isUpperCase())
					{
						break;
					}					
				}
				else break;				
				
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row-i >= 0 && pos.column+i <= 7)
				{
					if(gra.plansza[pos.row-i][pos.column+i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column+i));
						continue;
					}
					if(gra.plansza[pos.row-i][pos.column+i].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row-i,pos.column+i));
						break;
					}
					if(gra.plansza[pos.row-i][pos.column+i].isUpperCase())
					{
						break;
					}					
				}
				else break;					
			}
			
			for (int i =1;i<=7;i++)
			{
				if(pos.row+i <= 7 && pos.column-i >= 0)
				{
					if(gra.plansza[pos.row+i][pos.column-i].rowne(' '))
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column-i));
						continue;
					}
					if(gra.plansza[pos.row+i][pos.column-i].isLowerCase())
					{
						pMoves.add(new Pozycja(pos.row+i,pos.column-i));
						break;
					}
					if(gra.plansza[pos.row+i][pos.column-i].isUpperCase())
					{
						break;
					}					
				}
				else break;					
			}			
		}	
		
		if(gra.plansza[pos.row][pos.column].rowne('h')) // czarna wieza
		{
			for (int i = pos.column-1 ; i>=0;i--) // petla do sprawdzanie ruchu w lewo
			{
				if(gra.plansza[pos.row][i].rowne(' ')) // i jest kolumną
				{
					pMoves.add(new Pozycja(pos.row,i)); 
					continue;
				}
				if(gra.plansza[pos.row][i].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row,i));
					break;
				}
				if(gra.plansza[pos.row][i].isLowerCase())
				{
					break;
				}
			}
			for (int i = pos.column+1;i<=7;i++)	//ruch w prawo
			{
				if(gra.plansza[pos.row][i].rowne(' '))
				{
					pMoves.add(new Pozycja(pos.row,i));
					continue;
				}
				if(gra.plansza[pos.row][i].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row,i));
					break;
				}
				if(gra.plansza[pos.row][i].isLowerCase())
				{
					break;
				}
			}
			for (int j=pos.row-1;j>=0;j--)// sprawdzanie ruchu w górę
			{
				if(gra.plansza[j][pos.column].rowne(' '))
				{
					pMoves.add(new Pozycja(j,pos.column));
					continue;
				}
				if (gra.plansza[j][pos.column].isUpperCase())
				{
					pMoves.add(new Pozycja(j, pos.column));
					break;
				}
				if (gra.plansza[j][pos.column].isLowerCase())
				{
					break;
				}
			}
			for (int j=pos.row+1;j<=7;j++) // sprawdzanie ruchu w dol
			{
				if (gra.plansza[j][pos.column].rowne(' '))
				{
					pMoves.add(new Pozycja(j,pos.column));
					continue;
				}
				if (gra.plansza[j][pos.column].isUpperCase())
				{
					pMoves.add(new Pozycja(j,pos.column));
					break;
				}
				if(gra.plansza[j][pos.column].isLowerCase())
				{
					break;
				}
			}
			
			return pMoves;
		}
		if(gra.plansza[pos.row][pos.column].rowne('H'))
		{
			for (int i = pos.column -1 ; i>=0;i--) // petla do sprawdzenie ruchu w lewo
			{
				if(gra.plansza[pos.row][i].rowne(' '))
				{
					pMoves.add(new Pozycja(pos.row,i));
					continue;
				}
				if(gra.plansza[pos.row][i].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row,i));
					break;
				}
				if (gra.plansza[pos.row][i].isUpperCase())
				{
					break;
				}
			}
			for (int i = pos.column+1;i<=7;i++)	//ruch w prawo
			{
				if(gra.plansza[pos.row][i].rowne(' '))
				{
					pMoves.add(new Pozycja(pos.row,i));
					continue;
				}
				if(gra.plansza[pos.row][i].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row,i));
					break;
				}
				if(gra.plansza[pos.row][i].isUpperCase())
				{
					break;
				}
			}
			for (int j=pos.row-1;j>=0;j--)// sprawdzanie ruchu w górę
			{
				if(gra.plansza[j][pos.column].rowne(' '))
				{
					pMoves.add(new Pozycja(j,pos.column));
					continue;
				}
				if (gra.plansza[j][pos.column].isLowerCase())
				{
					pMoves.add(new Pozycja(j, pos.column));
					break;
				}
				if (gra.plansza[j][pos.column].isUpperCase())
				{
					break;
				}
			}
			for (int j=pos.row+1;j<=7;j++) // sprawdzanie ruchu w dol
			{
				if (gra.plansza[j][pos.column].rowne(' '))
				{
					pMoves.add(new Pozycja(j,pos.column));
					continue;
				}
				if (gra.plansza[j][pos.column].isLowerCase())
				{
					pMoves.add(new Pozycja(j,pos.column));
					break;
				}
				if (gra.plansza[j][pos.column].isUpperCase())
				{
					break;
				}
			}
			
		}

		
		
		
		
		return pMoves;
	}
	
	public void zbij(String plansza[][], int row, int column)
	{
		
		
	}
	
}
