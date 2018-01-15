/*
ID: arnavmo1
LANG: JAVA
TASK: div7
 */

import java.io.*;
import java.util.*;

public class div7 { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("div7.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        
        int n = f.nextInt();
        int[][] mods = new int[7][2];
        for(int i = 0; i < 7; i++){
        	mods[i][0] = Integer.MAX_VALUE;
        	mods[i][1] = Integer.MAX_VALUE;

        }
        mods[0][0] = -1;
        int c = 0;
        for(int i = 0; i < n; i++){
        	c = c + f.nextInt();
        	c = c % 7;
        	if(i <= mods[c][0]){
        		mods[c][0] = i;
        	}
        		mods[c][1] = i;
        }
        int ans = 0;
        for(int i = 0; i < mods.length; i++){
        	if(ans < mods[i][1] - mods[i][0]){
        		ans = mods[i][1] - mods[i][0];
        	}
        }
        System.out.println(ans);
        
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
