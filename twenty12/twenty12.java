import java.io.*;
import java.util.*;
public class twenty12{
	public static void main(String[] args) throws IOException {
		FastScanner br = new FastScanner();
		int n = Integer.parseInt(br.nextLine());
		int[] list = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(br.nextLine());
		}
		int[][] dp = new int[n][n];
		int ret = 0;
		for(int len = 1; len <= n; len++) {
			for(int i = 0; i + len <= n; i++) {
				int j = i+len-1;
				dp[i][j] = -1;
				if(len == 1) {
					dp[i][j] = list[i];
				}
				for(int k = i; k < j; k++) {
					if(dp[i][k] == dp[k+1][j] && dp[i][k] > 0) {
						dp[i][j] = Math.max(dp[i][j], dp[i][k] + 1);
					}
				}
				ret = Math.max(ret, dp[i][j]);
			}
		}
		System.out.println(ret);
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

