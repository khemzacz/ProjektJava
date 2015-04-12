
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
			if(c.equals(maleLitery[i]))
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
	
	public boolean rowne(Character c)
	{
		if (this.c.equals(c))
		return true;
		return false;
	}
}
