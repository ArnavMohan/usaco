/*
ID; armavmo1
LANG: JAVA
TASK: barn1
 */

import java.io.*;
import java.util.*;
public class barn1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		if(m>c){
			out.println(c);
			f.close();
			out.close();
			return;
		}
		
		int[] cows = new int[c];
		for(int i = 0; i < c; i++){
			cows[i] = Integer.parseInt(f.readLine());
		}
		for(int i = 1; i < cows.length; i++){
			for(int j = 0; j < i; j++){
				if(cows[j] > cows[i]){
					int temp = cows[i];
					cows[i] = cows[j];
					cows[j] = temp;
				}
			}
		}
		
		out.println(s-(sumGaps(m-1, cows)+bt(cows, s)));
		f.close();
		out.close();
	}
	
	public static int[] findGaps(int[] cows){
		int[] gaps = new int[cows.length];
		for(int i = 1; i < cows.length; i++){
			gaps[i] = cows[i] - cows[i-1];
		}
		for(int i = 1; i < gaps.length; i++){
			for(int j = 0; j < i; j++){
				if(gaps[j] < gaps[i]){
					int temp = gaps[i];
					gaps[i] = gaps[j];
					gaps[j] = temp;
				}
			}
		}
		
		return gaps;
		
	}
	
	public static int sumGaps(int m, int[] cows){
		int[] gaps = findGaps(cows);
		int sum = 0;
		for(int i = 0; i < m && i < gaps.length; i++){
			sum += gaps[i]-1;
		}
		
		return sum;
	}
	
	public static int bt(int[] cows, int s){
		return cows[0]-1 + s-cows[cows.length-1];
	}
	

}
