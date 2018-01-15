/*
ID: arnavmo1
LANG: JAVA
TASK: crypt1
 */

import java.io.*;
import java.util.*;
public class crypt1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/* loop through possible values for ABC and DE. If valid, check the product validity. If that is valid, count++ */
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		int num = Integer.parseInt(f.readLine());
		int[] digits = new int[num];
		int numSol = 0;
		StringTokenizer st = new StringTokenizer(f.readLine());
		for(int i = 0; i < num; i++){
			digits[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 10; i++){
			System.out.println(isValid(i, digits));
		}
				
		for(int a = 100; a < 1000; a++){
			for(int b = 10; b < 100; b++){
				if(isValid(a, digits) && isValid(b, digits)){
					int p1 = pp1(a, b);
					int p2 = pp2(a, b);
					if(isValid(p1, digits) && isValid(p2, digits) && p1 < 1000 && p1 > 99 && p2 < 1000 && p2 > 99){
						int prod = p1 + 10*p2;
						if (isValid(prod, digits) && prod < 10000 && prod > 999){
							numSol ++;
						}
					}
				}
			}
		}
		
		out.println(numSol);
		f.close();
		out.close();
	}
	
	public static boolean isValid(int n, int[] digits){
		while(n > 0) {
			int dig=n%10;
			boolean hasFound = false;
			for(int i = 0; i < digits.length; i++){
				if(digits[i] == dig){
					hasFound = true;
					break;
				}
			}
			if(hasFound == false){
				return false;
			}
			n = n/10;
		}
		return true;
	}
	
	public static int pp1(int a, int b){
		b = b%10;
		return a*b;
	}
	
	public static int pp2(int a, int b){
		b = b/10;
		return a*b;
	}
	

}
