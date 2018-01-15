import java.io.*;
import java.util.*;

public class homework {

	public static void main(String[] args) throws IOException{
		FastScanner f = new FastScanner("homework.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
        int n = f.nextInt();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
        	scores.add(f.nextInt());
        }
        
        
        double max = 0;
        int min=10001;
        List<Integer> c = scores.subList(n-1, n);
        int sum = scores.get(scores.size()-1);
        ArrayList<Integer> kfin = new ArrayList<Integer>();
        for(int k = n-2; k > 0; k--){
        	int sk = scores.get(k);
        	sum = sum + sk;
        	if(sk<min){
        		min = sk;
        	}else{
        		c.add(sk);
        		c.remove(new Integer(min));
        	}
        	int tsum = sum - min;
        	double score = (double)tsum / (double)(c.size());
        	if(score > max){
        		max =score;
        		kfin.clear();
        		kfin.add(k);
        	}
        	if(score == max && kfin.get(0) != k){
        		kfin.add(k);
        	}
        	c.add(0, min);
        }
        Collections.sort(kfin);
        for(int i : kfin){
        	out.println(i);
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
