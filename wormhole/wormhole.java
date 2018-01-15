/*
ID: arnavmo1
LANG: JAVA
TASK: wormhole
 */

import java.io.*;
import java.util.*;
public class wormhole {
	
	public static int n;
	public static int[] pairings;
	public static int[] x;
	public static int[] y;
	public static int[] right;							//position i has the wh is closest right from wh i
	
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		n = Integer.parseInt(f.readLine());
		pairings = new int[n];
		x = new int[n];
		y = new int[n];
		right = new int[n];
		for(int i = 0; i < n; i++){
			String line = f.readLine();
			StringTokenizer st = new StringTokenizer(line);
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < right.length; i++){ 						//initializes right to -1, i.e. all have nothing to the right
			right[i] = -1;
			pairings[i] = -1;
		}
		
		// fills right with final values
		for(int i = 0; i < n; i++){									//i = the current position in right
			for(int j = 0; j < n; j++){ 							//j = the wh being tested for NEXT_RIGHT property
				if (x[j]>x[i]){ 									//checks if it is to the right
					if(y[i]==y[j]){ 								//checks if y values are the same
						if(right[i]==-1 || x[right[i]] > x[j]){ 	//checks if undefined or if new right is closer
							right[i] = j;
						}
					}
				}
			}
		}
		int ans = countPairings();
		/*pairings[0] = 2;
		pairings[1] = 5;
		pairings[2] = 0;
		pairings[3] = 4;
		pairings[4] = 3;
		pairings[5] = 1;
		System.out.println(Arrays.toString(right));
		System.out.println(check_cycle());*/
		out.println(ans);
		f.close();
		out.close();
		
	}
	
	public static int countPairings(){
		int notPaired = -1;
		int total = 0;
		for(int i = 0; i < pairings.length; i++){
			if(pairings[i] == -1){
				notPaired = i;
				break;
			}
		}
		
		if (notPaired == -1){
			if(check_cycle()){
				return 1;
			}
			/*for(int a = 0; a < n; a++){
				boolean loop = false;
				int c = a;
				boolean[] been_there = new boolean[n];
				been_there[c] = true;
				for(int j = 0; j < n; j++){
					if (right[pairings[c]] == -1){
						break;
					}
					c = right[pairings[c]];
					if(been_there[c] == true){
						loop = true;
						break;
					}
					been_there[c] = true;
				}
				if (loop){
					return 1;
				}
			}*/
		}
		else{
			for(int a = 0; a < pairings.length; a++){
				if(pairings[a]==-1 && a != notPaired){
					pairings[notPaired] = a;
					pairings[a] = notPaired;
					
					int cur_cp = countPairings();
					total = total + cur_cp;
					pairings[a] = -1;
					pairings[notPaired] = -1;
				}
			}
		}
		return total;
		
	}
	
	public static boolean check_cycle(){
		for(int start = 0; start < n; start ++){
			int cp = start;
			boolean loop = false;
			boolean[] seen = new boolean[n];
			for(int i = 0; i < n; i++){
				cp = pairings[cp];
				/*if(seen[cp]){
					loop = true;
					break;
				}*/
				//seen[cp] = true;
				if(right[cp] == -1){
					break;
				}
				cp = right[cp];
				if(seen[cp]){
					loop = true;
					break;
				}
				
				seen[cp] = true;
			}
			if(loop){
				return true;
			}
			//System.out.println("DONE");
		}
		return false;
	}

}
