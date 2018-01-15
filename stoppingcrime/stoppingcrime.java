import java.io.*;
import java.util.*;

public class stoppingcrime {

	public static void main(String[] args) throws IOException{
		FastScanner f = new FastScanner(); //Replace "problem" with problem name
        
        Queue<int[]> q = new LinkedList<int[]>();
        ArrayList<ArrayList<Integer>> way = new ArrayList<ArrayList<Integer>>();
        int[] v = new int[300005];
        int[] res = new int[300005];
        
        int n = f.nextInt();
        int k = f.nextInt();
        int d = f.nextInt();
        
        for(int i = 0; i < k; i++){
        	int p = f.nextInt();
        	int[] add = {p, 0};
        	q.add(add);
        }
        
        for(int i = 0; i < n-1; i++){
        	int a = f.nextInt();
        	int b = f.nextInt();
        	ArrayList<Integer> roada = new ArrayList<Integer>();
        	roada.add(b); roada.add(i+1);
        	ArrayList<Integer> roadb = new ArrayList<Integer>();
        	roadb.add(a); roadb.add(i+1);
        	
        	way.add(a, roada);
        	way.add(b, roadb);
        }
		
        while (!q.isEmpty()){
        	int pos = q.peek()[0];
        	int from = q.peek()[1];
        	q.poll();
        	if(v[pos] != 0){
        		continue;
        	}
        	v[pos] = 1;
        	for(int i = 0; i < way.get(pos).size(); i++){
        		if(way.get(pos).get(i) != from){
        			if(v[way.get(pos).get(i)] != 0){
        				res[way.get(pos).get(i)] = 1;
        			}
        			else{
        				int[] ans = {way.get(pos).get(i), pos};
        				q.add(ans);
        			}
        		}
        	}
        }
        
        int rescnt = 0;
        for(int i = 1; i <= n-1; i++){
        	if(res[i] != 0){
        		rescnt++;
        	}
        }
        System.out.println(rescnt);
        for(int i = 1; i <= n-1; i++){
        	if(res[i] != 0){
        		System.out.println(i);
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
