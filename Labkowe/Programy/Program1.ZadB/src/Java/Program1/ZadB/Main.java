package Java.Program1.ZadB;

public class Main {
	
    public static void main(String[] args) {
    	
		String[] tab = new String[4];
		if(args.length == 0) {
			System.out.println("ERROR!");
		} else { 
			for(int i = 0; i < tab.length; i++) {
				tab[i] = args[i];
				System.out.print(args[i] + " ");
			}
		}
    }
}
