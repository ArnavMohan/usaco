
import java.io.*;
import java.util.*;

public class balancing {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[][] farm = new int[b][b];
		for(int i = 0; i < n; i++){
			StringTokenizer line = new StringTokenizer(f.readLine());
			farm[Integer.parseInt(line.nextToken())][Integer.parseInt(line.nextToken())] = 1;
		}
		
		int lowest = Integer.MAX_VALUE;
		for(int r = 1; r < b-1; r+=2){
			for(int c = 1; c < 2*b-1; c+=2){
				int num = findNum(farm, r, c);
				if(num < lowest){
					lowest = num; 
				}
			}
		}
		
		out.println(lowest);
		f.close();
		out.close();
	}
	
	public static int findNum(int[][] farm, int x, int y){
		int UL = 0;
		int UR = 0;
		int BL = 0; 
		int BR = 0;
		
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				if(farm[i][j] == 1)
					UL++;
			}
		}
		
		for(int i = 0; i < x; i++){
			for(int j = y; j < farm.length; j++){
				if(farm[i][j] == 1)
					BL++;
			}
		}
		
		for(int i = x; i < farm.length; i++){
			for(int j = 0; j < y; j++){
				if(farm[i][j] == 1)
					UR++;
			}
		}
		
		for(int i = x; i < farm.length; i++){
			for(int j = y; j < farm.length; j++){
				if(farm[i][j] == 1)
					BR++;
			}
		}
		int max = 0;
		int[] res = {UL, UR, BL, BR};
		for(int i = 0; i < res.length; i++){
			if (res[i] > max){
				max = res[i];
			}
		}
		return max;
	}

}
