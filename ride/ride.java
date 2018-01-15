/*
 ID: arnavmo1
 LANG: JAVA
 TASK: ride
 */
import java.util.*;
import java.io.*;

public class ride {
	public static String test(String comet, String group){
		
		ArrayList<Integer> com_vals = new ArrayList<Integer>();
		ArrayList<Integer> gro_vals = new ArrayList<Integer>();
		for (int i=0; i<comet.length(); i++){
			com_vals.add((int)comet.charAt(i));
		}
		for (int i=0; i<group.length(); i++){
		    gro_vals.add((int)group.charAt(i));
		}
		int com_tot = 1;
		int gro_tot = 1;
		for (int i=0;i<comet.length();i++){
			com_tot *= com_vals.get(i) - 64;
		}
		for (int i=0; i<group.length();i++){
		    gro_tot *= gro_vals.get(i) - 64;
		}
		if (com_tot % 47 == gro_tot % 47){
			return "GO";
		}
		else{
			
			return "STAY";
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		
		String comet = f.readLine();
		String group = f.readLine();
		
		
		out.println(test(comet, group));
		out.close();
	}
}

