import java.io.*;
import java.util.*;


public class closing { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("closing.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        
        int n = f.nextInt();
        int m = f.nextInt();
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
        	array.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; i++){
        	int x = f.nextInt()-1;
        	int y = f.nextInt()-1;
        	array.get(x).add(y);
        	array.get(y).add(y);
        }
        
        boolean[] closed = new boolean[n];
        for(int i = 0; i < n; i++){
        	boolean[] tau = new boolean[n];
        	Queue<Integer> q = new LinkedList<Integer>();
        	int c;
			for(c = 0; c < n; c++){
				if(!closed[c]){
					break;
				}
			}
			q.add(c);
			while (!q.isEmpty()){
				int pull = q.poll();
				for(int x = 0; x < array.get(pull).size(); x++){
					if (!tau[array.get(pull).get(x)]) {
						q.add(array.get(pull).get(x));
						tau[array.get(pull).get(x)] = true;
				    }
				}
			}
			boolean found = false;
			for(int l = 0; l < tau.length; l++){
				if(!tau[l]){
					System.out.println("NO");
					found = true;
					break;
				}
			}
			if(!found){
				System.out.println("YES");
			}
			closed[i] = true;
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
