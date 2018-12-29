package pojava.lab3;

public class Trojkat implements Figura {

	public Trojkat(double a, double b, double c) {
		A = a;
		B = b;
		C = c;
	}

	@Override
	public double obliczObwod() {
		return (A+B+C);
		
	}

	@Override
	public double obliczPole() {
		double p = (A+B+C)/2;
		return (Math.sqrt(p * (p - A) * (p - B) * (p - C)));
		
	}
	
	public double A, B, C;

}
