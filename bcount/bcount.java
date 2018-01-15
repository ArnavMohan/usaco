/*
ID: arnavmo1
LANG: JAVA
TASK: bcount
 */

import java.io.*;
import java.util.*;

public class bcount { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("bcount.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
        
        int n = f.nextInt();
        int q = f.nextInt();
        ArrayList<Integer> breedA = new ArrayList<Integer>();
        ArrayList<Integer> breedB = new ArrayList<Integer>();
        ArrayList<Integer> breedC = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++){
        	int in = f.nextInt();
        	
        	if(in == 1){
        		breedA.add(i);
        	}
        	if(in == 2){
        		breedB.add(i);
        	}
        	if(in == 3){
        		breedC.add(i);
        	}
        }
        
        for(int i = 0; i < q; i++){
        	int a = f.nextInt()-1;
        	int b = f.nextInt()-1;
        	
        	int ubA = Collections.binarySearch(breedA, b);
        	int lbA = Collections.binarySearch(breedA, a);
        	if(ubA < 0){
        		ubA = -1*ubA - 2;
        	}
        	if(lbA < 0){
        		lbA = -1*lbA - 1;
        	}
        	int valA = ubA - lbA + 1;
        	
        	
        	int ubB = Collections.binarySearch(breedB, b);
        	int lbB = Collections.binarySearch(breedB, a);
        	if(ubB< 0){
        		ubB = -1*ubB - 2;
        	}
        	if(lbB < 0){
        		lbB = -1*lbB - 1;
        	}
        	int valB = ubB - lbB + 1;
        	
        	
        	int ubC = Collections.binarySearch(breedC, b);
        	int lbC = Collections.binarySearch(breedC, a);
        	if(ubC< 0){
        		ubC = -1*ubC - 2;
        	}
        	if(lbC < 0){
        		lbC = -1*lbC - 1;
        	}
        	int valC = ubC - lbC + 1;
        	
        	out.println(valA + " " + valB + " " + valC);
        }
        
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
