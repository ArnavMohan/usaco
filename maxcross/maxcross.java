import java.io.*;
import java.util.StringTokenizer;


public class maxcross { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("maxcross.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));

        int n = f.nextInt();
        int k = f.nextInt();
        int b = f.nextInt();
        boolean[] broken = new boolean[n];
        for(int i = 0; i < b; i++){
        	broken[f.nextInt()-1] = true;
        }
        
        int current = 0;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i<k; i++){
        	if(broken[i]){
        		current++;
        	}
        }
        result = current;
        for(int min = 1; min <= n-k; min++){
        	if (broken[min-1]){
        		current--;
        	}
        	if (broken[min+k-1]){
                current++;
            }
        	if (current < result){
        		result = current;
        	}
        }
        out.println(result);
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
