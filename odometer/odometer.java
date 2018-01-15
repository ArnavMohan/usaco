import java.io.*;
import java.util.*;

public class odometer {

	public static void main(String[] args) throws IOException{
		FastScanner f = new FastScanner(); //Replace "problem" with problem name
        
        long x, y;
        x = f.nextLong();
        y = f.nextLong();
        int result = 0;
        for(int s = 3; s <= 17; s++){
        	for(int d0 = 0; d0 < 10; d0++){
        		String
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
