import java.io.*;
import java.util.*;

public class card04 {

	public static void main(String[] args) throws IOException{
		FastScanner f = new FastScanner(); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
        
        int n = f.nextInt();
        ArrayList<Integer> opp = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
        	opp.add(f.nextInt());
        }
        Collections.sort(opp);
        
        ArrayList<Integer> self = new ArrayList<Integer>();
        for(int i = 1; i <= 2*n; i++){
        	if(Collections.binarySearch(opp, i) < 0){
        		self.add(i); 
        	}
        }
        
        int currI = 0;
        int points = 0;
        for(int i = 0; i < n; i++){
        	while(currI < n && self.get(currI) < opp.get(i)){
          	currI++;
        	}
          if(currI == n){
          	break;
          }
          points++;
          currI++;
        }
        System.out.println(points);
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
