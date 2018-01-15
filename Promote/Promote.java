import java.io.*;
import java.util.*;
public class Promote {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("promote.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
		StringTokenizer bronze = new StringTokenizer(f.readLine());
		int[] b = new int[2];
		int[] s = new int[2];
		int[] g = new int[2];
		int[] p = new int[2];
		
		b[0] = Integer.parseInt(bronze.nextToken());
		b[1] = Integer.parseInt(bronze.nextToken());
		StringTokenizer silver = new StringTokenizer(f.readLine());
		s[0] = Integer.parseInt(silver.nextToken());
		s[1] = Integer.parseInt(silver.nextToken());
		StringTokenizer gold = new StringTokenizer(f.readLine());
		g[0] = Integer.parseInt(gold.nextToken());
		g[1] = Integer.parseInt(gold.nextToken());
		StringTokenizer plat = new StringTokenizer(f.readLine());
		p[0] = Integer.parseInt(plat.nextToken());
		p[1] = Integer.parseInt(plat.nextToken());
		
		int g2p = 0;
		int s2g = 0;
		int b2s = 0;
		
		if(p[1] >= p[0]){
			g2p = p[1] - p[0];
		}
		if(g[1] + g2p > g[0]){
			g[1] = g[1] + g2p;
			s2g = g[1] - g[0];
		}
		if(s[1] + s2g > s[0]){
			s[1] = s[1] + s2g;
			b2s = s[1] - s[0];
		}
		
		out.println(b2s);
		out.println(s2g);
		out.println(g2p);
		f.close();
		out.close();
	}

}
