import java.io.*;
import java.util.*;

public class moocast { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("moocast.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        
        int n = f.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        Cow[] cows = new Cow[n];
        
        for(int i = 0; i < n; i++){
        	cows[i] = new Cow(f.nextInt(), f.nextInt(), f.nextInt());
        }
        
        for(int i = 0; i < n; i++){
        	adj.add(new ArrayList<Integer>());
        	for(int j = 0; j < n; j++){
        		if (i == j) continue;
        		if(cows[i].canReach(cows[j])){
        			adj.get(i).add(j);
        		}
        	}
        }
        
        int result = 0;
        for(int i = 0; i < n; i++){
        	int current = 1;
        	boolean[] tau = new boolean[n];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(i);
			tau[i] = true;
			while (!q.isEmpty()){
				int pull = q.poll();
				for(int c = 0; c < adj.get(pull).size(); c++){
					if (!tau[adj.get(pull).get(c)]) {
						q.add(adj.get(pull).get(c));
						tau[adj.get(pull).get(c)] = true;
						current ++;
				    }
				}
			}
			if(current > result){
				result = current;
			}
        }
        out.println(result);
        
        out.close();
    }

    
    public static class Cow {
    	int x;
    	int y;
    	int power;
    	public Cow(int _x, int _y, int p){
    		x = _x;
    		y = _y;
    		power = p;
    	}
    	
    	public boolean canReach(Cow c){
    		double cx = c.x;
    		double cy = c.y;
    		double dist = Math.sqrt((x*1.0 - cx)*(x*1.0 - cx) + (y*1.0 - cy)*(y*1.0 - cy));
    		return dist <= power;
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
