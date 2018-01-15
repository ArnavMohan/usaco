import java.io.*;
import java.util.*;

public class moocastGold { //Class name
	
    public static Cow[] cows;

    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("moocast.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        
        int n = f.nextInt();
        cows = new Cow[n];
        for(int i = 0; i < n; i++){
        	cows[i] = new Cow(f.nextInt(), f.nextInt());
        }
        
        int hX = 25000*25000*2;
        int lX = 0;
        for(int i = 0; i < 35; i++){
        	int mid = (lX + hX)/2;
        	if(connected(mid)){
        		hX = mid;
        	}
        	else{
        		lX = mid + 1;
        	}
        }
        
        out.println(hX);
        
        out.close();
    }
    
    public static boolean connected(int x){
    
    
    	ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0; i < cows.length; i++){
        	adj.add(new ArrayList<Integer>());
        	for(int j = 0; j < cows.length; j++){
        		if (i == j) continue;
        		if(cows[i].canReach(cows[j], x)){
        			adj.get(i).add(j);
        		}
        	}
        }
    	
      
    	int result = 0;
        int current = 1;
        boolean[] tau = new boolean[cows.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		tau[0] = true;
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
		result = current;
        
        if(result == cows.length){
        	return true;
        }
        return false;
    }

    
    public static class Cow {
    	int x;
    	int y;
    	public Cow(int _x, int _y){
    		x = _x;
    		y = _y;
    	}
    	
    	public boolean canReach(Cow c, int power){
    		return (x - c.x)*(x - c.x) + (y - c.y)*(y - c.y) <= power;
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