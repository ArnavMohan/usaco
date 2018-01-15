/*
ID: armavmo1
LANG: JAVA
TASK: palsquare
 */

import java.io.*;
public class palsquare {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		

		boolean failed = false;
		for(int d = 0; d < 100000; d++){
			for(int b = 2; b < 37; b++){
				String n = Integer.toString(d);
				String base = toBase(n, b);
				int dec = toDec(base, b);
				if(Integer.parseInt(n) != dec){
					System.out.println("" + n + " " + b);
					failed = true;
					break;
				}
			}
			if(failed){
				break;
			}
			
		}
		
		
		
		
		
		int b = 19;
		for(int i = 1; i < 301; i++){
			String n = Integer.toString(i, b);
			String sqr = square(n, b);
			
			if(isPal(sqr)){
				System.out.print(n.toUpperCase());
				System.out.print(" " + sqr.toUpperCase());
				System.out.println();
			}
		}
		f.close();
		out.close();
	}
	
	public static boolean isPal(String n){
		String num = n;
		String res = "";
		for(int i = 0; i < num.length(); i++){
			res += num.charAt(num.length()-i-1);
		}
		
		return num.equals(res);
	}
	
	public static String square(String n, int b){
		int dec = Integer.parseInt(n, b);
		return Integer.toString(dec*dec, b);
		
	}
	
	public static int indexOf(char[] l, char i){
		for(int j = 0; j < l.length; j++){
			if (l[j] == i){
				return j;
			}
		}
		return -1;
	}
	
	public static int toDec(String n, int b){
		int num = 0;
		char[] alpha = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(int i = 0; i < n.length()-1; i++){
			num += indexOf(alpha, n.charAt(i));
			num = num*b;
		}
		num += indexOf(alpha, n.charAt(n.length()-1));
		return num;
	}
	
	public static String toBase(String n, int b){
		String num = n;
		String res = "";
		
		if(n.equals("0")){
			return "0";
		}
		while(Integer.parseInt(num)!=0)
        {
            long rem = Integer.parseInt(num)%b;
            long div = Integer.parseInt(num)/b;
            if(rem<10)
                rem+=(int)'0';
            else
                rem+=(int)'A' - 10;
            
            res = Character.toString((char)rem) + res;
            num = Long.toString(div);
        }
		
		return res;
	}

}
