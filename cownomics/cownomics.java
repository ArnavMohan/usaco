import java.io.*;
import java.util.*;


public class cownomics { //Class name
    public static void main(String[] args) throws IOException{
        FastScanner f = new FastScanner("cownomics.in"); //Replace "problem" with problem name
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        
        int n = f.nextInt();
        int m = f.nextInt();
        int[][] plain = new int[n][m];
        int[][] spots = new int[n][m];
        for(int i = 0; i < n; i++){
        	String line = f.nextLine();
        	for(int x = 0; x < m; x++){
        		char c = line.charAt(x);
        		if(c == 'A'){
        			spots[i][x]=0;
        		}
        		if(c == 'C'){
        			spots[i][x]=1;
        		}
        		if(c == 'G'){
        			spots[i][x]=2;
        		}
        		if(c == 'T'){
        			spots[i][x]=3;
        		}
        	}
        }
        
        for(int i = 0; i < n; i++){
        	String line = f.nextLine();
        	for(int x = 0; x < m; x++){
        		char c = line.charAt(x);
        		if(c == 'A'){
        			plain[i][x]=0;
        		}
        		if(c == 'C'){
        			plain[i][x]=1;
        		}
        		if(c == 'G'){
        			plain[i][x]=2;
        		}
        		if(c == 'T'){
        			plain[i][x]=3;
        		}
        	}
        }
        long count = 0;
        for(int a = 0; a < m-2; a++){
        	for(int b = a+1; b < m-1; b++){
        		for(int c = b+1; c < m; c++){
        			ArrayList<String> spairs = new ArrayList<String>();
        			ArrayList<String> ppairs = new ArrayList<String>();
        			boolean exit = false;
        			for(int i = 0; i < n; i++){
        				String s = Integer.toString(spots[i][a]) + Integer.toString(spots[i][b]) + Integer.toString(spots[i][c]);
        				String p = Integer.toString(plain[i][a]) + Integer.toString(plain[i][b]) + Integer.toString(plain[i][c]);
        				int sindex = Collections.binarySearch(spairs, s);
        				int pindex = Collections.binarySearch(ppairs, p);
        				if(sindex < 0){
        					sindex = sindex*-1 -1;
        					spairs.add(sindex, s);
        				}
        				if(pindex < 0){
        					pindex = pindex*-1 - 1;
        					ppairs.add(pindex, p);
        				}
        				
        				
        				if(Collections.binarySearch(spairs, p) >= 0 || Collections.binarySearch(ppairs, s) >= 0){
        					exit = true;
        					break;
        				}

        			}
        			if(exit){
        				continue;
        			}
        			else{count ++;}
        		}
        	}
        }
        
        System.out.println(count);
        
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
