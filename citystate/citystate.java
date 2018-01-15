import java.io.*;
import java.util.*;


public class citystate { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("citystate.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        
        int n = f.nextInt();
        int[][] array = new int[676][676];
        for(int i = 0; i < n; i++){
        	array[toInt(f.nextToken())][toInt(f.nextToken())]++;
        }
        
        int count = 0;
        for(int x = 0; x < 676; x++){
        	for(int y = x+1; y < 676; y++){
        		count += array[x][y] * array[y][x];
        	}
        }
        
        out.println(count);
        out.close();
    }
    
    public static int toInt(String s){
    	return (s.charAt(0) - 65) * 26 + s.charAt(1)-65;
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
