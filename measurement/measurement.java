import java.io.*;
import java.util.*;

public class measurement {

	public static void main(String[] args) throws IOException{
		FastScanner f = new FastScanner("measurement.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        
        int n = f.nextInt();
        long init = f.nextLong();
        boolean[] days = new boolean[1000001];
        int[] change = new int[1000001];
        long[] ids = new long[1000001];
        Hashtable cows = new Hashtable();
        int numChange = 0;
        for(int i = 0; i < n; i++){
        	int d = f.nextInt();
        	days[d] = true;
        	long id = f.nextLong();
        	ids[d] = id;
        	cows.put(id, init);
        	change[d] = f.nextInt();
        }
        long max = init;
        long numcow = 1000000000;
        for(int i = 0; i < days.length; i++){
        	if(days[i]){
        		cows.put(ids[i], (long)cows.get(ids[i]) + (long)change[i]);
        		if((long)cows.get(ids[i]) > max){
        			max = (long)cows.get(ids[i]);
        			numcow = 1;
        			numChange++;
        		}
        		if((long)cows.get(ids[i]) == max){
        			numcow++;
        			numChange++;
        		}
        		if()
        	}
        }
        
        out.print(numChange-1);
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
