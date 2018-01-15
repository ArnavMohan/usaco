/*
ID: arnavmo1
LANG: JAVA
TASK: friday
 */

import java.util.*;
import java.io.*;
public class friday {
	//list of the basic number of days in month, indexing from 0
	public static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	// returns true if year is a leap year
	public static boolean isLeap(int y){ return y%4 == 0 && (y%100 != 0 || y%400 == 0); }
	// returns number of days in current month and year adjusted for leap year
	public static int monthLength(int m, int y){
		if (isLeap(y) && m == 1){ return DAYS_IN_MONTH[1] + 1; }
		else{ return DAYS_IN_MONTH[m]; }
	}
	//input - number of years. Output - number of times the 13th lands on Sat -> Fri
	public static void main(String[] args) throws IOException{
		//init scanner
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		//read n
		int n = Integer.parseInt(f.readLine());
		int[] dow = {0, 0, 0, 0, 0, 0, 0};
		//tracker for first of month
		int current = 2;
		//loop through years
		for(int y = 1900; y < 1900 + n; y++){
			//loop through months, indexing from 0
			for(int m = 0; m < 12; m++){
				//add 1 to dow tracker
				dow[(current+12)%7] ++;
				//reset current
				current = (current+monthLength(m, y))%7;
			}
		}
		//print items in list, seperated by spaces
		String result = "";
		for(int item : dow){
			result += item + " ";
		}
		out.println(result.substring(0, result.length() - 1));
		
		out.close();
	}
	
}
