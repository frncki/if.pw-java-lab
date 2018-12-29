package pw.java.wyk4.watki;

import java.util.Scanner;

public class DzieleniePrzezZero {
	
	public static void Funkcja() throws ArithmeticException
	{
		int licznik;
		int mianownik;

		System.out.println("Podaj dwie liczby:");
		Scanner sc = new Scanner(System.in);
		licznik = sc.nextInt();
		mianownik = sc.nextInt();

		if(mianownik==0) throw new ArithmeticException("Mianownik = 0");	
		int wynik = licznik / mianownik;

		System.out.println("Wynikiem dzielenia jest: " + wynik);
		
		sc.close();
		throw new IndexOutOfBoundsException("ala");
	}
	
	public static void main(String[] args) {
			
	try{
		Funkcja();
	}
	catch( ArithmeticException | IndexOutOfBoundsException e)
	{
		
		System.out.println(e.getMessage()+"Nie mogę podzielić przez zero! Podaj inną liczbę.");
	}
		
	}

}


