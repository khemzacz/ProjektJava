package komunikacja;

public class RamkaSerwera 
{
	private int rodzaj;
	private String wiadomosc1;
	private String wiadomosc2;
	
	public RamkaSerwera(int r, String w1, String w2)
	{
		this.rodzaj=r;
		this.wiadomosc1=w1;
		this.wiadomosc2=w2;
	}
	
	public String getW1()
	{
		return wiadomosc1;
	}
	
	public String getW2()
	{
		return wiadomosc2;
	}
	
	public int getRodzaj()
	{
		return rodzaj;
	}
	
	
}
