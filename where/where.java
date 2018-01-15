import java.io.*;
import java.util.*;


public class where { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("where.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
        
        int n = f.nextInt();
        ArrayList<ArrayList<Character>> grid = new ArrayList<ArrayList<Character>>();
        for(int i = 0; i < n; i++){
        	grid.add(new ArrayList<Character>());
        	String line = f.nextLine();
        	for(int j = 0; j < n; j++){
        		grid.get(i).add(line.charAt(j));
        	}
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