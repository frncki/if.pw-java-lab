package pw.java.wyk4.watki;

//deklaracja wyjatku:
@SuppressWarnings("serial")
class LiczbaNieparzystaException extends Exception{
	int n;	
	LiczbaNieparzystaException(int liczba){
		n = liczba;
	}
	
	public String toString(){
		return "Wyjatek! Liczba " + n + " jest nieparzysta";
	}
}

public class WlasnyWyjatek {
	
	//deklaracja metody zglaszajacej wyjatek
	 static boolean sprawdzParzystosc(int liczba) throws LiczbaNieparzystaException{
		if (liczba %2 != 0 ) 
			throw new LiczbaNieparzystaException(liczba);
		return true;
	}
	
	public static void main(String[] args)  {
	
		for (int i = 1; i<10; i++){
				
					try {
						sprawdzParzystosc(i);
					} catch (LiczbaNieparzystaException e) {
						System.out.println(e);
					}	
		}
	}
}
