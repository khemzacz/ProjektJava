import java.util.ArrayList;
import java.util.List;


public class PojedynczyRuch
{
	MojCharacter czym;
	Character czymc;
	Pozycja pocz;
	Pozycja cel;
	
	PojedynczyRuch (Character c, Pozycja pocz, Pozycja cel)
	{
		this.czym = new MojCharacter(c);
		czymc = new Character(c);
		this.pocz = new Pozycja(pocz);
		this.cel = new Pozycja(cel);
	}
	
	
	PojedynczyRuch (PojedynczyRuch kopia)
	{
		this.czym = new MojCharacter(kopia.getCzym());
		czymc = new Character (kopia.getCzym());
		this.pocz = new Pozycja(kopia.getPocz());
		this.cel = new Pozycja(kopia.cel);
	}
	
	public Pozycja get()
	{
		return cel;
	}

	
	public Character getCzym()
	{
		return czymc;
	}
	
	Pozycja getPocz()
	{
		return pocz;
	}
	
}
