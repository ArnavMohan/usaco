/*
ID: arnavmo1
LANG: JAVA
TASK: div7
 */

import java.io.*;
import java.util.*;

public class angryGold { //Class name
	
	public static int[] coord;
	
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("angry.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        
        int n = f.nextInt();
        int k = f.nextInt();
        coord = new int[n];
        
        for(int i = 0; i < n; i++){
        	coord[i] = f.nextInt();
        }
        
        Arrays.sort(coord);
        
        int hX = 500000000;
        int lX = 0;
        for(int i = 0; i < 32; i++){
        	int mid = (lX + hX)/2;
        	if(test(mid, k)){
        		hX = mid;
        	}
        	else{
        		lX = mid + 1;
        	}
        }
        
        out.println(hX);
        
        out.close();
    }
    
    public static boolean test(int l, int k){
    	int n = 0;
    	int s = 0;
    	int pos = 0;
    	while (s < coord.length){
    		n ++;
    		pos = s + 1;
    		while(pos < coord.length && coord[pos] - coord[s] <= 2*l){
    			pos++;
    		}
    		s = pos;
    	}
    	if(n <= k){
    		return true;
    	}
    	return false;
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
