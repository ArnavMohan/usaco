/*
ID: arnavmo1
LANG: JAVA
TASK: milk3
 */

import java.io.*;
import java.util.*;

public class milk3 { //Class name
	
	public static boolean[][] searched = new boolean[21][21];
	public static boolean[] amount = new boolean[21];
	public static int a,b,c;
	
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("milk3.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        
        a = f.nextInt();
        b = f.nextInt();
        c = f.nextInt();
        
        
        
        out.close();
    }
    
    public static void sim(int x, int y, int z){
    	if(searched[x][y]){
    		return;
    	}
    	searched[x][y] = true;
    	if(x == 0){
    		amount[z] = true;
    	}
    	
    	
    }
    
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
