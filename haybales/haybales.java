import java.io.*;
import java.util.*;


public class haybales { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("haybales.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        
        int n = f.nextInt();
        int q = f.nextInt();
        ArrayList<Integer> bales = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
        	bales.add(f.nextInt());
        }
        
        Collections.sort(bales);
        
        for(int i = 0; i < q; i++){
        	int l = f.nextInt();
        	int r = f.nextInt();
        	int a = Collections.binarySearch(bales, l);
        	if(a < 0){
        		a = a*-1 -1;
        	}
        	int b = Collections.binarySearch(bales, r);
        	if(b < 0){
        		b = b*-1 -2;
        	}
        	
        	out.println(b-a+1);
        	
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
