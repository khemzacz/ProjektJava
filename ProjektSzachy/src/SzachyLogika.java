
public class SzachyLogika {
	private static String plansza[][];
	public enum figury {PUSTE,PION, WIEZA, KON, GONIEC, HETMAN, KROL}
	
	void SzachyLogika()
	{
		resetujplansze();
	}
	
	void resetujplansze()
	{
		plansza = new String[][] {	 
					 {"w","s","g","k","h","g","s","w"},
					 {"p","p","p","p","p","p","p","p"},	
					 {" "," "," "," "," "," "," "," "},
					 {" "," "," "," "," "," "," "," "},
					 {" "," "," "," "," "," "," "," "},
					 {" "," "," "," "," "," "," "," "},
					 {"P","P","P","P","P","P","P","P"},
					 {"W","S","G","K","H","G","S","W"}};
		
	}
	
	
}
