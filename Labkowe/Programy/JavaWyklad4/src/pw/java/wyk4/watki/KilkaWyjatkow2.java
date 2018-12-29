package pw.java.wyk4.watki;

public class KilkaWyjatkow2 {
   public static void main(String[] args) {
     int[] licznik = {1, 2, 3 , 0 };
     int mianownik[] = {2, 0, 1, 0, 5};
     @SuppressWarnings("unused")
	double ulamek = 0.0;
     
     for (int i=0; i<6; i++){
    	 try{
    	    ulamek = (double)(licznik[i]/mianownik[i]);    	 
    	    //ulamek = (double) licznik[i]/mianownik[i]; // brak wyjatku dzielenia przez zero
    	 }
    	 catch (IndexOutOfBoundsException | ArithmeticException e) {
    		 System.out.println("Przechwycony wyjatek: "+ e.getClass().getName());
    	 }
    	   	 
      } //koniec petli for
    } // koniec metody main()
}
