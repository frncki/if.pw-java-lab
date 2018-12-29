package pojava.lab3;

public class ZadanieA {
	public static void main(String[] args) {
		Kolo k = new Kolo(5.5);
		System.out.println("Obwod kola: " + k.obliczObwod());
		System.out.println("Pole kola: " + k.obliczPole());
		
		Trojkat t = new Trojkat(3.0, 4.0, 5.0);
		System.out.println("Obwod trojkata: " + t.obliczObwod());
		System.out.println("Pole trojkata: " + t.obliczPole());
	}

}
