/*
ID; armavmo1
LANG: JAVA
TASK: namenum
 */

import java.io.*;
public class namenum {
	
	public static char[][] keypad = {
			{},
			{},
			{'A', 'B', 'C'},
			{'D', 'E', 'F'},
			{'G', 'H', 'I'},
			{'J', 'K', 'L'},
			{'M', 'N', 'O'},
			{'P', 'R', 'S'},
			{'T', 'U', 'V'},
			{'W', 'X', 'Y'}
	};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		String numstr = f.readLine();
		String[] output = new String[5000];
		for(int i = 0; i < 5000; i++){
			String line = dict.readLine();
			if (line == null){ break; }
			
			if (matchesNum(line, Long.parseLong(numstr))){
				output[i] = line;
			}
		}
		boolean noSol = true;
		for(String i : output){
			if(i != null){
				out.println(i);
				noSol = false;
			}
		}
		if (noSol){
			out.println("NONE");
		}
		
		f.close();
		out.close();
		dict.close();
	}
	
	public static boolean matchesNum(String word, long num){
		String numstr = "";
		for(int i = 0; i < word.length(); i++){
			switch(word.charAt(i)){
				case 'A' : case 'B' : case 'C' :  numstr += "2"; break;
				case 'D' : case 'E' : case 'F' :  numstr += "3"; break;
				case 'G' : case 'H' : case 'I' :  numstr += "4"; break;
				case 'J' : case 'K' : case 'L' :  numstr += "5"; break;
				case 'M' : case 'N' : case 'O' :  numstr += "6"; break;
				case 'P' : case 'R' : case 'S' :  numstr += "7"; break;
				case 'T' : case 'U' : case 'V' :  numstr += "8"; break;
				case 'W' : case 'X' : case 'Y' :  numstr += "9"; break;
			}
		}
		return Long.parseLong(numstr) == (long)num;
	}
}
	
