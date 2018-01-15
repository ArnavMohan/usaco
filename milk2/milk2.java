/*
ID: arnavmo1
LANG: JAVA
TASK: milk2
 */

import java.io.*;
import java.util.*;
public class milk2 {

	private static boolean[] times = new boolean[1000000];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		
		int num = Integer.parseInt(f.readLine());
		
		for (int i = 0; i < num; i++){
			StringTokenizer st = new StringTokenizer(f.readLine());
			fill(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		boolean foundTrue = false;
		int highest = 0;
		int nhigh = 0;
		int streak = 0;
		int nstreak = 0;
		for (int i = 0; i < times.length; i++){
			if (times[i]){
				foundTrue = true;
				streak += 1;
			}
			else{
				if (streak > highest){
					highest = streak;
				}
				streak = 0;
			}
			
			if (!times[i]){
				if (foundTrue){
					nstreak += 1;
				}
				
			}
			else{
				if (nstreak > nhigh){
					nhigh = nstreak;
				}
				nstreak = 0;
			}
		}
		
		out.println(highest + " " + nhigh);
		out.close();
		
	}
	public static void fill(int start, int finish){
		for(int i = start; i < finish; i++){
			times[i] = true;
		}
	}

}
