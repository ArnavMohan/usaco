/*
ID; armavmo1
LANG: JAVA
TASK: dualpal
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class dualpal {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int numOuts = 0;
		s++;
		while(numOuts < n){
			int numPal = 0;
			for(int b = 2; b < 11; b++){
				if(isPal(toBase(Integer.toString(s), b))){
					numPal ++;
					if (numPal == 2){
						out.println(s);
						numOuts ++;
					}
				}
			}
			s++;
		}
		f.close();
		out.close();
		
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
	
	public static boolean isPal(String n){
		String num = n;
		String res = "";
		for(int i = 0; i < num.length(); i++){
			res += num.charAt(num.length()-i-1);
		}
		
		return num.equals(res);
	}

}
