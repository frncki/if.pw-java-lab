package pw.java.wyk4.watki;

public class KilkaWyjatkow {
   public static void main(String[] args) {
     int[] licznik = {1, 2, 3 , 0 };
     int mianownik[] = {2, 0, 1, 0, 5};
     double ulamek = 0.0;
     
     for (int i=0; i<6; i++){
    	 try{
    	    ulamek = (double) (licznik[i] / mianownik[i]);
    	    ulamek = (double) licznik[i]  /mianownik[i]; // brak wyjatku dzielenia przez zero
    	 }
    	 catch (IndexOutOfBoundsException e) {
    		 System.out.println("Indeks tablicy poza zakresem");
    	 }
    	 catch (ArithmeticException e) {
    		 System.out.println("Proba dzielenia przez zero");
    	 }
    	 finally {
    		 System.out.println("Blok finally wykonany zawsze"); 
    		 System.out.println("wartosc zmiennej ulamek: " + ulamek);
       	 }    	 
      } //koniec petli for
    } // koniec metody main()
}
