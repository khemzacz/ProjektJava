import java.util.ArrayList;
import java.util.List;


public class SzachyLogika {
	MojCharacter plansza[][];
	int tura=1;
	Boolean sprawdzamSzach =false;
	//public enum bierki {PUSTE,PION, WIEZA, KON, GONIEC, HETMAN, KROL}
		
	SzachyLogika()
	{
		resetujplansze(); //ffd
	}
	
	SzachyLogika(MojCharacter[][] org)
	{
		MojCharacter kopiarka= new MojCharacter();
		resetujplansze();
		this.plansza=kopiarka.kopiaTablicy2D(org,8,8);		
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
				 {new MojCharacter('W'),new MojCharacter('S'),new MojCharacter('G'),new MojCharacter('H'),new MojCharacter('K'),new MojCharacter('G'),new MojCharacter('S'),new MojCharacter('W')}};
	}
	
	public List<Pozycja> possibleMoves(Pozycja pos, SzachyLogika gra )
	{
		List<Pozycja> pMoves = new ArrayList<Pozycja>();
		if((gra.plansza[pos.row][pos.column].rowne('p') && (tura ==2 || sprawdzamSzach))||
				(gra.plansza[pos.row][pos.column].rowne('P') && (tura ==1 || sprawdzamSzach)))
		{
			System.out.println("Wykryto pionka");
			return this.ruchyPionka(pos,gra);
		}
		if((gra.plansza[pos.row][pos.column].rowne('w') && (tura ==2 || sprawdzamSzach)) ||
				(gra.plansza[pos.row][pos.column].rowne('W') && (tura==1 || sprawdzamSzach)) )
		{
			System.out.println("Wykryto wieze");
			return this.ruchyWiezy(pos,gra);
		}
		if((gra.plansza[pos.row][pos.column].rowne('s') && (tura==2 || sprawdzamSzach))
				|| (gra.plansza[pos.row][pos.column].rowne('S') && (tura ==1 || sprawdzamSzach)))
		{
			System.out.println("Wykryto skoczka");
			return this.ruchySkoczka(pos,gra);
			
		}
		if ((gra.plansza[pos.row][pos.column].rowne('g') && (tura ==2 || sprawdzamSzach))
				|| (gra.plansza[pos.row][pos.column].rowne('G') && (tura ==1 || sprawdzamSzach)) )
		{
			System.out.println("Wykryto Gonca");
			return this.ruchyGonca(pos,gra);
		}
		if ((gra.plansza[pos.row][pos.column].rowne('h') && (tura ==2 || sprawdzamSzach))
				|| (gra.plansza[pos.row][pos.column].rowne('H') && (tura ==1 || sprawdzamSzach)))
		{
			System.out.println("Wykryto Hetmana");
			return this.ruchyHetmana(pos,gra);			
		}
		if ((gra.plansza[pos.row][pos.column].rowne('k') && (tura==2 || sprawdzamSzach))
				|| (gra.plansza[pos.row][pos.column].rowne('K') && (tura ==1 || sprawdzamSzach)))
		{
			System.out.println("Wykryto króla");
			return this.ruchyKrola(pos,gra);			
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
			//System.out.println("czarnego");
			//System.out.println(pos.row -1);
			if((pos.row-1)>=0)
			{
				//System.out.println("Tutaj");
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
					//System.out.println("Tutaj");
					if(gra.plansza[pos.row+1][pos.column-2].rowne(' '))
					{
					//	System.out.println("Tutaj2");
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
			//System.out.println("czarnego");
			//System.out.println(pos.row -1);
			if((pos.row-1)>=0)
			{
				//System.out.println("Tutaj");
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
					//System.out.println("Tutaj");
					if(gra.plansza[pos.row+1][pos.column-2].rowne(' '))
					{
						//System.out.println("Tutaj2");
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
	
	public List <Pozycja> ruchyKrola(Pozycja pos, SzachyLogika gra)
	{
		List <Pozycja> pMoves =new ArrayList <Pozycja>();
		
		if(gra.plansza[pos.row][pos.column].rowne('k'))
		{
			if(pos.row-1 >=0 && pos.column-1 >=0) // polnocny-zachod
			{
				if(gra.plansza[pos.row-1][pos.column-1].rowne(' ') || gra.plansza[pos.row-1][pos.column-1].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row-1,pos.column-1));
				}
				
			}
			if(pos.row-1 >=0) // polnoc
			{
				if(gra.plansza[pos.row-1][pos.column].rowne(' ') || gra.plansza[pos.row-1][pos.column].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row-1,pos.column));
				}
				
			}
			if(pos.row-1 >=0 && pos.column+1 <=7) // polncny-wschod
			{
				if(gra.plansza[pos.row-1][pos.column+1].rowne(' ') || gra.plansza[pos.row-1][pos.column+1].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row-1,pos.column+1));
				}
				
			}
			if(pos.column+1 <=7) // wschod
			{
				if(gra.plansza[pos.row][pos.column+1].rowne(' ') || gra.plansza[pos.row][pos.column+1].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row,pos.column+1));
				}
				
			}
			
			if(pos.row+1 <=7 && pos.column+1 <=7) // poludniowy-wschod
			{
				if(gra.plansza[pos.row+1][pos.column+1].rowne(' ') || gra.plansza[pos.row+1][pos.column+1].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row+1,pos.column+1));
				}
				
			}
			
			if(pos.row+1 <=7) // poludnie
			{
				if(gra.plansza[pos.row+1][pos.column].rowne(' ') || gra.plansza[pos.row+1][pos.column].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row+1,pos.column));
				}
				
			}
			if(pos.row+1 <=7 && pos.column-1 >=0) // poludniowy-zachod
			{
				if(gra.plansza[pos.row+1][pos.column-1].rowne(' ') || gra.plansza[pos.row+1][pos.column-1].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row+1,pos.column-1));
				}
				
			}
			if(pos.column-1 >=0) // zachod
			{
				if(gra.plansza[pos.row][pos.column-1].rowne(' ') || gra.plansza[pos.row][pos.column-1].isUpperCase())
				{
					pMoves.add(new Pozycja(pos.row,pos.column-1));
				}
				
			}
		}
		
		
		if(gra.plansza[pos.row][pos.column].rowne('K'))
		{
			if(pos.row-1 >=0 && pos.column-1 >=0) // polnocny-zachod
			{
				if(gra.plansza[pos.row-1][pos.column-1].rowne(' ') || gra.plansza[pos.row-1][pos.column-1].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row-1,pos.column-1));
				}
				
			}
			if(pos.row-1 >=0) // polnoc
			{
				if(gra.plansza[pos.row-1][pos.column].rowne(' ') || gra.plansza[pos.row-1][pos.column].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row-1,pos.column));
				}
				
			}
			if(pos.row-1 >=0 && pos.column+1 <=7) // polncny-wschod
			{
				if(gra.plansza[pos.row-1][pos.column+1].rowne(' ') || gra.plansza[pos.row-1][pos.column+1].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row-1,pos.column+1));
				}
				
			}
			if(pos.column+1 <=7) // wschod
			{
				if(gra.plansza[pos.row][pos.column+1].rowne(' ') || gra.plansza[pos.row][pos.column+1].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row,pos.column+1));
				}
				
			}
			
			if(pos.row+1 <=7 && pos.column+1 <=7) // poludniowy-wschod
			{
				if(gra.plansza[pos.row+1][pos.column+1].rowne(' ') || gra.plansza[pos.row+1][pos.column+1].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row+1,pos.column+1));
				}
				
			}
			
			if(pos.row+1 <=7) // poludnie
			{
				if(gra.plansza[pos.row+1][pos.column].rowne(' ') || gra.plansza[pos.row+1][pos.column].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row+1,pos.column));
				}
				
			}
			if(pos.row+1 <=7 && pos.column-1 >=0) // poludniowy-zachod
			{
				if(gra.plansza[pos.row+1][pos.column-1].rowne(' ') || gra.plansza[pos.row+1][pos.column-1].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row+1,pos.column-1));
				}
				
			}
			if(pos.column-1 >=0) // zachod
			{
				if(gra.plansza[pos.row][pos.column-1].rowne(' ') || gra.plansza[pos.row][pos.column-1].isLowerCase())
				{
					pMoves.add(new Pozycja(pos.row,pos.column-1));
				}
				
			}
			
		}
		
		return pMoves;
	}
	
	
	public Boolean sprawdzSzachBialym(SzachyLogika gra)
	{
		List <Pozycja> pMoves = new ArrayList <Pozycja>();
		Pozycja pozycjaKrola = new Pozycja();
		for(int i =0 ;i<=7;i++)
		{
			for( int j=0;j<=7;j++)
			{
				if(gra.plansza[i][j].isLowerCase())
				{
					pMoves.addAll(gra.possibleMoves(new Pozycja(i,j),gra));
				}
				if(gra.plansza[i][j].rowne('K'))
				{
					pozycjaKrola = new Pozycja(i,j);
				}
			}
		}
		
		for (int i = 0;i<pMoves.size();i++)
		{
			if (pozycjaKrola.row == pMoves.get(i).row && pozycjaKrola.column == pMoves.get(i).column)
			{
				return true;
			}
			
		}
		return false;
	}
	
	public Boolean sprawdzSzachCzarnym(SzachyLogika gra)
	{
		gra.sprawdzamSzach= true;
		List <Pozycja> pMoves = new ArrayList <Pozycja>();
		Pozycja pozycjaKrola = new Pozycja();
		for(int i =0 ;i<=7;i++)
		{
			for( int j=0;j<=7;j++)
			{
				if(gra.plansza[i][j].isUpperCase())
				{
					pMoves.addAll(gra.possibleMoves(new Pozycja(i,j),gra));
				}
				if(gra.plansza[i][j].rowne('k'))
				{
					pozycjaKrola = new Pozycja(i,j);
				}
			}
		}
		
		for (int i = 0;i<pMoves.size();i++)
		{
			if (pozycjaKrola.row == pMoves.get(i).row && pozycjaKrola.column == pMoves.get(i).column)
			{
				gra.sprawdzamSzach=false;
				return true;
			}
			
		}
		gra.sprawdzamSzach=false;
		return false;
	}
	
	public List <Pozycja> sprawdzWMRB(SzachyLogika gra) // sprawdź wszystkie mozliwe ruchy białym
	{
		List <Pozycja> pMoves = new ArrayList<Pozycja>();
		for (int i =0;i<=7;i++)
		{
			for (int j =0;j<=7;j++)
			{
				if(gra.plansza[i][j].isUpperCase())
				{
					pMoves.addAll(gra.possibleMoves(new Pozycja(i,j), gra));
				}
				
			}
		}
		return pMoves;
	}

	public List <Pozycja> sprawdzWMRC(SzachyLogika gra) // sprawdź wszystkie możliwe ruchy czarnym
	{
		List <Pozycja> pMoves = new ArrayList<Pozycja>();
		for (int i =0;i<=7;i++)
		{
			for (int j =0;j<=7;j++)
			{
				if(gra.plansza[i][j].isLowerCase())
				{
					pMoves.add(new Pozycja(i,j));
				}
				
			}
		}
		return pMoves;
		
	}
	
	public void ruchLogiczny(Pozycja pocz, Pozycja cel) // w celach testowania szachu i matu - Do napisania konieczne
	{
		Character tmp = this.plansza[pocz.row][pocz.column].get();
		this.plansza[pocz.row][pocz.column].set(' '); // ustawia puste
		this.plansza[cel.row][cel.column].set(tmp);
		
	}
	
	public List<Pozycja> sprawdzSDWMRB(SzachyLogika gra) // sprawdza czy dla 
	// mozliwych ruchow dlaej wystepuje szach i zwraca wlasciwa liste ruchow
	{
		List <Pozycja> pMoves = new ArrayList<Pozycja>();
		MojCharacter kopiarka = new MojCharacter();
		List <Pozycja> ruchyTMP = new ArrayList<Pozycja>();
		//ruchyTMP = sprawdzWMRB(gra); // same ruchy nie mam pozycji poczatkowej ;/
		// ***************************** NAJPIERW KOPIA PLANSZY *******************************
		//MojCharacter planszaTMP[][]= new MojCharacter[8][8];
		SzachyLogika graTMP = new SzachyLogika(kopiarka.kopiaTablicy2D(gra.plansza, 8, 8));
		for (int i =0; i<=7;i++)
		{
			for(int j = 0 ;j<=7;j++)
			{
				if (graTMP.plansza[i][j].isUpperCase()) // jesli znalazles Biala bierke
				{
					ruchyTMP=graTMP.possibleMoves(new Pozycja(i,j), graTMP); // lista pobierz jej ruchy
					for (int k =0;k<ruchyTMP.size();k++)
					{
						graTMP.ruchLogiczny(new Pozycja(i,j),ruchyTMP.get(k)); // wykonaj ruch k-ty;
						if (!graTMP.sprawdzSzachBialym(graTMP))
						{
							pMoves.add(ruchyTMP.get(k)); // do tablicy ruch ktory spowoduje ze nie ma szacha
						}
						graTMP = new SzachyLogika(kopiarka.kopiaTablicy2D(gra.plansza, 8, 8));
					}
				}
			}
		}
		return pMoves;
	}
	
	
	public List<Pozycja> sprawdzSDWMRC(SzachyLogika gra) // sprawdza czy dla 
	// mozliwych ruchow dlaej wystepuje szach i zwraca wlasciwa liste ruchow
	{
		List <Pozycja> pMoves = new ArrayList<Pozycja>();
		MojCharacter kopiarka = new MojCharacter();
		List <Pozycja> ruchyTMP = new ArrayList<Pozycja>();
		//ruchyTMP = sprawdzWMRB(gra); // same ruchy nie mam pozycji poczatkowej ;/
		// ***************************** NAJPIERW KOPIA PLANSZY *******************************
		//MojCharacter planszaTMP[][]= new MojCharacter[8][8];
		SzachyLogika graTMP = new SzachyLogika(kopiarka.kopiaTablicy2D(gra.plansza, 8, 8)); // kopia planszy
		for (int i =0; i<=7;i++)
		{
			for(int j = 0 ;j<=7;j++)
			{
				if (graTMP.plansza[i][j].isLowerCase()) // jesli znalazles czarna bierke //null pointer exception
				{
					
					ruchyTMP= new ArrayList<Pozycja>(graTMP.possibleMoves(new Pozycja(i,j), graTMP)); // lista pobierz jej ruchy
					for (int k =0;k<ruchyTMP.size();k++)
					{
/* To ma blad--> */		graTMP.ruchLogiczny(new Pozycja(i,j),ruchyTMP.get(k)); // wykonaj ruch k-ty; // jakis exception tutaj
						if (!graTMP.sprawdzSzachBialym(graTMP))
						{
							pMoves.add(ruchyTMP.get(k)); // do tablicy ruch ktory spowoduje ze nie ma szacha
						}
						graTMP = new SzachyLogika(kopiarka.kopiaTablicy2D(gra.plansza, 8, 8));
					}
				}
			}
		}
		return pMoves;
	}
}


