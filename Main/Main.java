import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		FastScanner f = new FastScanner(); //Replace "problem" with problem name
        
        long k = f.nextLong();
        
        if(k % 50 == 0){
        	System.out.println("50");
        	for(int i = 0; i < 50; i++){
            System.out.print((49+k/50) + " ");
          }
          System.out.println();
          return;
        }
        
        long[] list = new long[50];
        for(int i = 0; i < 50; i++){
        	list[i] = (k/50) + 50;
        	
        }
        for(int i = 0; i < 50 - k%50; i++){
        	long max = 0; int maxi = 0;
        	for(int j = 0; j < 50; j++){
        		if(list[j] > max){
        			max = list[j];
        			maxi = j;
        		}
        	}
        	list[maxi] -= 50;
        	for(int j = 0; j < 50; j++){
        		if(j == maxi){
        			continue;
        		}
        		list[j]++;
        	}
        }
        
        System.out.println(50);
        for(int i = 0; i < 50; i++){
        	System.out.print(list[i] + " ");
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
