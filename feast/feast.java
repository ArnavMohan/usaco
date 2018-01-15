/*
ID: arnavmo1
LANG: JAVA
TASK: bcount
 */

import java.io.*;
import java.util.*;

public class feast { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("feast.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        
        int t = f.nextInt();
        int x = f.nextInt();
        int y = f.nextInt();
        
        boolean[][] full = new boolean[2][t+1];
        full[0][0]=true;
        for(int i = 0; i < full.length; i++){
        	for(int j = 0; j < full[i].length; j++){
        		if(!full[i][j]){
        			continue;
        		}
        		if(j+x <= t){
        			full[i][j+x]=true;
        		}
        		if(j + y <= t){
        			full[i][j+y]=true;
        		}
        		if(i==0){
        			full[i+1][j/2]=true;
        		}
        	}
        }
        int max = 0;
        for(int i = 0; i <= t; i++){
        	if(full[1][i]){
        		max=i;
        	}
        }
        out.println(max);
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
