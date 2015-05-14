package mainPackage;
import java.util.ArrayList;
import java.util.List;


public class Ruch
{
	MojCharacter czym;
	Character czymc;
	Pozycja pocz;
	List <Pozycja> cele;
	
	Ruch (Character c, Pozycja pocz, List <Pozycja> cele)
	{
		this.czym = new MojCharacter(c);
		czymc = new Character(c);
		this.pocz = new Pozycja(pocz);
		this.cele = new ArrayList<Pozycja>(cele);
	}
	Ruch (Ruch kopia)
	{
		this.czym = new MojCharacter(kopia.getCzym());
		czymc = new Character (kopia.getCzym());
		this.pocz = new Pozycja(kopia.getPocz());
		this.cele = new ArrayList<Pozycja>(kopia.cele);
	}
	
	public Pozycja get(int index)
	{
		return cele.get(index);
	}
	
	public int size()
	{
		return cele.size();
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
