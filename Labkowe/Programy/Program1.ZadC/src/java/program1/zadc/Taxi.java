package java.program1.zadc;

public class Taxi extends Auto {
	
	Taxi() {
		super();
		zarobki = new float[12];
		for(int i = 0; i < zarobki.length; i++) {
			zarobki[i] = (float)(i * 321.0 + 42.42);
		}
	}
	
	float srZarobki() {
		float sum = 0;
		for(int i = 0; i < zarobki.length; i++) {
			sum += zarobki[i];
		}
		return (sum/zarobki.length);
	}
	
	public static void main(String[] args) {
    	Taxi t = new Taxi();
    	System.out.println("Sredni przebieg taksowki to: " + t.srPrzebieg());
    	System.out.println("Srednie zarobki taksowki to: " + t.srZarobki());
    }
	
	float[] zarobki;
	
}
