
public class Ruch
{
	MojCharacter czym;
	Pozycja pocz;
	Pozycja cel;
	
	Ruch (Character c, Pozycja pocz, Pozycja cel)
	{
		this.czym = new MojCharacter(c);
		this.pocz = new Pozycja(pocz);
		this.cel = new Pozycja(cel);
	}
	
}
