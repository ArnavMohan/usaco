/*
ID: arnavmo1
LANG: JAVA
TASK: skidesign
 */

import java.io.*;
public class skidesign {
	
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		int n = Integer.parseInt(f.readLine());
		int[] hill = new int[n];
		for(int i = 0; i < n; i++){
			hill[i] = Integer.parseInt(f.readLine());
		}
		int cost = Integer.MAX_VALUE;
		
		for(int i = 0; i < 84; i++){
			int c = 0;
			int hillcost = 0;
			for(int j = 0; j < n; j++){
				if(hill[j] > i+17){
					hillcost = (hill[j] - (i+17));
				}
				else if(hill[j] < i){
					hillcost = (i-hill[j]);
				}
				else{
					hillcost = 0;
				}
				c += hillcost*hillcost;
			}
			if(c < cost){
				cost = c;
			}
		}
		
		out.println(cost);
		f.close();
		out.close();
	}

}
