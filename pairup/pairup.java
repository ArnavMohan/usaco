import java.io.*;
import java.util.*;

public class pairup { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("pairup.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
        
        int n = f.nextInt();
        ArrayList<Cow> cows = new ArrayList<Cow>();
        for(int i=0; i < n; i++){
        	cows.add(new Cow(f.nextInt(), f.nextInt()));
        }
        
        Collections.sort(cows);
        int l = 0;
        int r = n-1;
        int min = 0;
        boolean exit = false;
        for(int i = 0; i < n; i++){
        	int c = 0;
        	for(int cn = 0; cn < cows.get(l).number; cn++){
        		c = cows.get(l).output + cows.get(r).output;
        		cows.get(r).number--;
        		if(c > min){
        			min = c;
        		}
        		if(cows.get(r).number<=0){
        			r--;
        		}
        		
        	}
        	if(exit){
        		break;
        	}
        	l++;
        }
        out.println(min);
        
        out.close();
    }

    
    public static class Cow implements Comparable<Cow>{
    	int number;
    	int output;
    	
    	public Cow(int n, int o){
    		number = n;
    		output = o;
    	}
    	
    	public int compareTo(Cow c){
    		if(output > c.output){
    			return 1;
    		}
    		else if(output < c.output){
    			return -1;
    		}
    		else{
    			return 0;
    		}
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
