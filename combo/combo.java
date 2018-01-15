/*
ID: arnavmo1
LANG: JAVA
TASK: combo
 */

import java.io.*;
import java.util.*;
public class combo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		int num = Integer.parseInt(f.readLine());
		int total = 0;
		StringTokenizer fj = new StringTokenizer(f.readLine());
		StringTokenizer ms = new StringTokenizer(f.readLine());
		int f1 = Integer.parseInt(fj.nextToken());
		int f2 = Integer.parseInt(fj.nextToken());
		int f3 = Integer.parseInt(fj.nextToken());
		int m1 = Integer.parseInt(ms.nextToken());
		int m2 = Integer.parseInt(ms.nextToken());
		int m3 = Integer.parseInt(ms.nextToken());
		
		for(int i = 1; i <= num; i++){
			for(int j = 1; j <= num; j++){
				for(int k = 1; k <= num; k++){
					if(isValidLock(i, j, k, f1, f2, f3, m1, m2, m3, num)){
						total ++;
					}
				}
			}
		}
		
		out.println(total);
		out.close();
		f.close();
	}
	
	public static boolean isValid(int a, int b, int n){
		return(abs(a-b) <= 2 || abs(a-b) >= n-2);
	}
	
	public static boolean isValidSet(int a, int b, int c, int x, int y, int z, int n){
		return(isValid(a,x,n) && isValid(b, y, n) && isValid(c, z, n));
	}
	
	public static boolean isValidLock(int i, int j, int k, int f1, int f2, int f3, int m1, int m2, int m3, int n){
		return(isValidSet(i, j, k, f1, f2, f3, n) || isValidSet(i, j, k, m1, m2, m3, n));
	}
	
	public static double abs(int i){
		return Math.abs(i);
	}

}
