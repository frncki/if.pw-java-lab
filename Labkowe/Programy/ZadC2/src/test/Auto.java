package test;

public class Auto {
	
	Auto(){
		przebieg = new float[12];
		for(int i = 0; i < przebieg.length; i++) {
			przebieg[i] = (float)(i * 123.0 + 42.42);
		}
	}
	
	float srPrzebieg() {
		float sum = 0;
		for(int i = 0; i < przebieg.length; i++) {
			sum += przebieg[i];
		}
		return (sum/przebieg.length);
	}
	
	float[] przebieg;
}
