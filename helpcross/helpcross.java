import java.io.*;
import java.util.*;


public class helpcross { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("helpcross.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        
        int C = f.nextInt();
        int N = f.nextInt();
        ArrayList<Integer> c_list = new ArrayList<Integer>();
        ArrayList<Cow> n_list = new ArrayList<Cow>();
        for(int i = 0; i < C; i++){
        	c_list.add(f.nextInt());
        }
        for(int i = 0; i < N; i++){
        	n_list.add(new Cow(f.nextInt(), f.nextInt()));
        }
        
        Collections.sort(c_list);
        Collections.sort(n_list);
        
        int total = 0;
        for(int i = 0; i < n_list.size(); i++){
            Cow c = n_list.get(i);
            int index = Collections.binarySearch(c_list, c.start);
            if (index < 0){
                index = index*-1 - 1;
                if (index >= c_list.size())
                    continue;
            }
            if(c_list.get(index) > c.end){
            	continue;
            }
            c_list.remove(index);
            total ++;
            
        }
        
        out.println(total);
        out.close();
    }
    
    public static class Cow implements Comparable<Cow>{
    	int start;
    	int end;
    	public Cow(int s, int e){
    		start = s;
    		end = e;
    	}
    	
    	public int compareTo(Cow c){
    		if (end < c.end){
                return -1;
            }
            else if (end > c.end){
                return 1;
            }
            if (start < c.start) {
                return 1;
            } else if (start > c.start) {
                return -1;
            }
            return 0;
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
