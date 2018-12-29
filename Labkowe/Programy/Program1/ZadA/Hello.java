//package 

class Hello {
	
    public static void main(String[] args) {
		String s = args[0];
		if(args.length == 0) {
			System.out.println("ERROR!");
		} else { 
			int X = Integer.parseInt(s);
			for(int i = 1; i < X + 1; i++) System.out.println(i);
		}
    }
}
