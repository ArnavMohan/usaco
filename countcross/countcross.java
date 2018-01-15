
import java.io.*;
import java.util.*;


public class countcross { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("countcross.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
        
        int n = f.nextInt();
        int k = f.nextInt();
        int r = f.nextInt();
        boolean[][][] roads = new boolean[n][n][4];
        for(int i = 0; i < r; i++){
        	int x1 = f.nextInt() - 1;
        	int y1 = f.nextInt() - 1;
            int x2 = f.nextInt() - 1;
            int y2 = f.nextInt() - 1;
            
            if(x2>x1){
            	roads[x1][y1][0] = true;
            	roads[x2][y2][2] = true;
            } else if (x1 > x2) {
                roads[x1][y1][2] = true;
                roads[x2][y2][0] = true;
            }
            if(y2>y1){
            	roads[x1][y1][1] = true;
            	roads[x2][y2][3] = true;
            }
            else if (y1>y2){
            	roads[x1][y1][3] = true;
            	roads[x2][y2][1] = true;
            }
        }
        
        for(int i = 0; i < n; i++){
            roads[0][i][2] = true;
            roads[n-1][i][0] = true;
            roads[i][0][3] = true;
            roads[i][n-1][1] = true;
        }
        
        int[][] components = new int[n][n];
        int nextComponent = 1;
        for(int x = 0; x < n; x++){
        	for(int y = 0; y < n; y++){
        		if(components[x][y] == 0){
        			Queue<Coordinate> q = new LinkedList<Coordinate>();
        			components[x][y] = nextComponent;
                    q.add(new Coordinate(x, y));
                    while(!q.isEmpty()){
                    	Coordinate cur = q.poll();
                    	if(!roads[cur.x][cur.y][0]){
                    		if(components[cur.x+1][cur.y] == 0) {
                    		components[cur.x+1][cur.y] = nextComponent;
                            q.add(new Coordinate(cur.x+1, cur.y));
                    		}
                        } 
                    	if (!roads[cur.x][cur.y][2]){
                    		if(components[cur.x-1][cur.y] == 0) {
                    		components[cur.x-1][cur.y] = nextComponent;
                    		q.add(new Coordinate(cur.x-1, cur.y));
                    		}
                    	}
                    	if (!roads[cur.x][cur.y][1]){
                    		if(components[cur.x][cur.y+1] == 0) {
                    		components[cur.x][cur.y+1] = nextComponent;
                    		q.add(new Coordinate(cur.x, cur.y+1));
                    		}
                    	}
                    	if (!roads[cur.x][cur.y][3]){
                    		if(components[cur.x][cur.y-1] == 0) {
                    		components[cur.x][cur.y-1] = nextComponent;
                    		q.add(new Coordinate(cur.x, cur.y-1));
                    		}
                    	}
                    }
                    nextComponent ++;
        		}
        	}
        }
        
        Coordinate[] cows = new Coordinate[k];
        for(int i = 0; i<k; i++){
        	cows[i] = new Coordinate(f.nextInt()-1, f.nextInt()-1);
        }
        
        
        int result = 0;
        for(int i = 0; i < k; i++){
        	for(int j = i+1; j < k; j++){
        		int x1 = cows[i].x;
        		int x2 = cows[j].x;
        		int y1 = cows[i].y;
        		int y2 = cows[j].y;
        		if(components[x1][y1] != components[x2][y2]){
        			result++;
        		}
        	}
        }
        out.println(result);
        
        out.close();
    }
    
    public static class Coordinate {
        int x;
        int y;
        
        public Coordinate(int x_in, int y_in){
            x = x_in;
            y = y_in;
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
