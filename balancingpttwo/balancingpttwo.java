import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class balancingpttwo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] x = new int[n];
		int[] rpos = new int[2*n];
		int[] cpos = new int[2*n];
		int[] y = new int[n];
		for(int i = 0; i < n; i++){
			StringTokenizer line = new StringTokenizer(f.readLine());
			x[i] = Integer.parseInt(line.nextToken());
			rpos[2*i] = (x[i] != 1) ? x[i] - 1 : x[i] + 1;
			rpos[2*i + 1] = x[i] + 1;
			y[i] = Integer.parseInt(line.nextToken());
			cpos[2*i] = (y[i] != 1) ? y[i] - 1 : y[i] + 1;
			cpos[2*i + 1] = y[i] + 1;
			
		}
		//System.out.println(Arrays.toString(rpos) + " " + Arrays.toString(cpos));
		
		int lowest = Integer.MAX_VALUE;
		for(int r : rpos){
			for(int c : cpos){
				int num = findNum(x, y, r, c);
				if(num < lowest){
					lowest = num; 
				}
			}
		}
		
		out.println(lowest);
		f.close();
		out.close();
	}
	
	public static int findNum(int[] x, int[] y, int r, int c){
		int UL = 0;
		int UR = 0;
		int BL = 0; 
		int BR = 0;
		
		for(int i = 0; i < x.length; i++){
			if (x[i] < r && y[i] < c){
				UL++;
			}
			if(x[i] < r && y[i] > c){
				UR++;
			}
			if(x[i] > r && y[i] < c){
				BL++;
			}
			if(x[i] > r && y[i] > c){
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
