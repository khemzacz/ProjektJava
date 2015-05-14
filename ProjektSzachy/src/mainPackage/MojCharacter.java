package mainPackage;

public class MojCharacter
{
	public Character c;
	private Character duzeLitery[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','R','S','T','U','W','X','Y','Z'};
	private Character maleLitery[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','t','u','w','x','y','z'};
	public boolean isUpperCase()
	{
		for (int i =0 ;i<24;i++)
		{
			if (c.equals(duzeLitery[i]))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isLowerCase()
	{
		for(int i =0;i<24;i++)
		{
			if(this.rowne(maleLitery[i]))
			{
				return true;
			}
			
		}
		return false;
	}
	
	MojCharacter(Character c)
	{
		this.c=c;
	}
	
	MojCharacter()
	{
		this.c=' ';
	}
	
	public boolean rowne(Character c)
	{
		if (this.c.equals(c))
		{
			return true;
		}
		else
			return false;
	}
	
	public void set(Character c)
	{
		this.c=c;		
	}
	public Character get()
	{
		return this.c;
	}
	
	public MojCharacter[][] kopiaTablicy2D(MojCharacter[][] org, int r1, int r2)
	{
		MojCharacter[][] planszaTMP= new MojCharacter[8][8]; 
		for(int i =0;i<r1;i++)
		{
			for(int j=0;j<r2;j++)
			{
				planszaTMP[i][j] = new MojCharacter( org[i][j].get()); // MIAŁEM BŁAD BO ROZWALAŁEM TABLICE PRZYPISANIEM bez NEW!!!
			}
		}
		return planszaTMP;
	}
}
