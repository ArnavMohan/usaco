/*
ID: arnavmo1
LANG: JAVA
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class ariprog { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("ariprog.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        
        int n = f.nextInt();
        int m = f.nextInt();
        boolean[] bisquares = new boolean[2*m*m + 1];
        ArrayList<Integer> squares = new ArrayList<Integer>();
        ArrayList<Progression> prog = new ArrayList<Progression>();
        
        for(int p = 0; p <= m; p++){
        	for(int q = p; q <= m; q++){
        		if(!bisquares[p*p + q*q]){
        		bisquares[p*p + q*q] = true;
                squares.add(p*p + q*q);
        		}
        	}
        }
        
        Collections.sort(squares);
        
        for(int i = 0; i < squares.size(); i++){
        	for(int j = i+1; j < squares.size(); j++){
        		int d = squares.get(j) - squares.get(i);
                boolean exit = false;
            		for(int t = 1; t < n-1; t++){
            			if(squares.get(j) + t*d >= bisquares.length || !bisquares[squares.get(j) + t*d]){
            				exit = true;
                          	break;
            			}
            		}
                if(!exit){
            		prog.add(new Progression(squares.get(i), d));
            	}
        	}
        }
        
        Collections.sort(prog);
        for(int i = 0; i < prog.size(); i++){
        	out.println(Integer.toString(prog.get(i).a) + " " + Integer.toString(prog.get(i).n));
        }
        if(prog.size()==0){
        	out.println("NONE");
        }
        
        
        out.close();
    }
    
   
    public static class Progression implements Comparable<Progression>{
    	int a;
    	int n;
    	
    	public Progression(int start, int inc){
    		a = start;
    		n = inc;
    	}
    	
    	public int compareTo(Progression p){
    		if(n < p.n){
    			return -1;
    		}
    		if(n > p.n){
    			return 1;
    		}
    		else{
    			if(a < p.a){
    				return -1;
    			}
    			if(a > p.a){
    				return 1;
    			}
    			else{
    				return 0;
    			}
    		}
    	}
    	
    	public String toString(){
    		return Integer.toString(a) + " " + Integer.toString(n);
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
