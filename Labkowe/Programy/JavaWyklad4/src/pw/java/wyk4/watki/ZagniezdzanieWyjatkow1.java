package pw.java.wyk4.watki;

public class ZagniezdzanieWyjatkow1{
	
	public static void main(String[] args) {
		
		 int[] licznik = {1, 2, 3 , 0 };
	     int mianownik[] = {2, 0, 1, 0, 5};
	     double ulamek = 0.0;
	     
	     try{
	    	 for (int i=0; i<6; i++){
		    	 int l=0, m =0;
	    		 try{
		    	    l = licznik[i];
		    	    m = mianownik[i];
		    	 }
		    	 catch (IndexOutOfBoundsException e) {
		    		 System.out.println("Indeks tablicy poza zakresem");
		    		 System.out.println("Wyjatek z bloku wewnetrznego - przejscie do kolejnej iteracji petli");
		    	 }
	    		 ulamek = (double) (l/m); // zglosi wyjatek zewnetrzny
	    		 //ulamek = (double) l / m;  // nie zglosi wyjatku zewnetrznego
	    		 System.out.println(ulamek); 
		      } //koniec petli for 
	     }
	     catch(ArithmeticException e){
	    	 System.out.println("Proba dzielenia przez zero");
	    	 System.out.println("Wyjatek z bloku zewnetrznego - zakonczenie petli");
	     }
	     	    

	}

}
