/*
ID: arnavmo1
LANG: JAVA
TASK: milk3
 */

import java.io.*;
import java.util.*;

public class cowjog {
	
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("cowjog.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjog.out")));
        
        int n = f.nextInt();
        long t = f.nextInt();
        
        long[] start = new long[n];
        for(int i = 0; i < n; i++){
        	start[i] = f.nextInt() + t*f.nextLong();
        }
        
        int count = 1;
        long slow = start[n-1];
        for(int i = n-1; i > -1; i--){
        	if(start[i] < slow){
        		count++;
        	}
        	slow = Math.min(slow, start[i]);
        }
        
        out.println(count);
        
        out.close();
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