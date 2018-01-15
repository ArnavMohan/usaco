/*
ID; armavmo1
LANG: JAVA
TASK: transform
 */

import java.io.*;
import java.util.StringTokenizer;
public class transform {

	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		
		int n = Integer.parseInt(f.readLine());
		int[][] b = new int[n][n];
		int[][] a = new int[n][n];
		for(int i = 0; i < n; i++){
			String line = f.readLine();
			for(int j = 0; j < n; j++){
				if(line.charAt(j) == '@'){ b[i][j] = 0; }
				else{ b[i][j] = 1; }
			}
		}
		for(int i = 0; i < n; i++){
			String line = f.readLine();
			for(int j = 0; j < n; j++){
				if(line.charAt(j) == '@'){ a[i][j] = 0; }
				else{ a[i][j] = 1; }
			}
		}
		
		if(compare(turn90(b), a)){
			out.println("1");
		}
		else if(compare(turn180(b), a)){
			out.println("2");
		}
		else if(compare(turn270(b), a)){
			out.println("3");
		}
		else if(compare(reflect(b), a)){
			out.println("4");
		}
		else if(isFive(b, a)){
			out.println("5");
		}
		else if(compare(b, a)){
			out.println("6");
		}
		else{
			out.println("7");
		}
		f.close();
		out.close();

		
		
	}
	
	public static int[][] turn90(int[][] b){
		int[][] res = new int[b.length][b.length];
		for(int r = 0; r < b.length; r++){
			for(int c = 0; c < b.length; c++){
				res[c][b.length-r-1] = b[r][c];
			}
		}
		
		return res;
	}
	
	public static int[][] turn180(int[][] b){
		int[][] res = new int[b.length][b.length];
		res = turn90(b);
		res = turn90(res);
		return res;
	}
	
	public static int[][] turn270(int[][] b){
		int[][] res = new int[b.length][b.length];
		res = turn180(b);
		res = turn90(res);
		return res;
	}
	
	public static int[][] reflect(int[][] b){
		int[][] res = new int[b.length][b.length];
		for(int r = 0; r < b.length; r++){
			for(int c = 0; c < b.length; c++){
				res[r][b.length-c-1] = b[r][c];
			}
		}
		return res;
	}
	
	public static boolean compare(int[][] b, int[][] a){
		for(int r = 0; r < b.length; r++){
			for(int c = 0; c < b.length; c++){
				if(b[r][c] != a[r][c]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isFive(int[][] b, int[][] a){
		int[][] res = reflect(b);
		if(compare(turn90(res), a)){
			return true;
		}
		if(compare(turn180(res), a)){
			return true;
		}
		if(compare(turn270(b), a)){
			return true;
		}
		return false;
	}
	
	
	
}
