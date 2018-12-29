package pojava.lab3;

public class Kolo implements Figura {

	public Kolo(double r) {
		R = r;
	}

	@Override
	public double obliczObwod() {
		return (2*PI*R);
	}

	@Override
	public double obliczPole() {
		return (R*R*PI);
	}
	
	public double R;

}
