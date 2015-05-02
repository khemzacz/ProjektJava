
public class Pozycja {
	public int row;
	public int column;
	
	Pozycja (int row, int column)
	{
		
		this.row = row;
		this.column = column;		
	}
	
	Pozycja()
	{}
	
	Pozycja(Pozycja p)
	{
		this.row = p.row;
		this.column = p.column;
	}
	
	Boolean equals(Pozycja pom)
	{
		if (this.row == pom.row && this.column == pom.column)
			return true;
			return false;
	}
}
