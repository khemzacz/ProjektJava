import java.util.ArrayList;
import java.util.List;


public class Ruch
{
	MojCharacter czym;
	Pozycja pocz;
	List <Pozycja> cele;
	
	Ruch (Character c, Pozycja pocz, List <Pozycja> cele)
	{
		this.czym = new MojCharacter(c);
		this.pocz = new Pozycja(pocz);
		this.cele = new ArrayList<Pozycja>(cele);
	}
	
	public Pozycja get(int index)
	{
		return cele.get(index);
	}
}
