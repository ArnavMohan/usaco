import java.io.*;
import java.util.*;
public class CowRoute {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("cowroute.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		int[] route;
		int lowest = Integer.MAX_VALUE;
		for(int i = 0; i < num; i++){
			StringTokenizer line = new StringTokenizer(f.readLine());
			int cost = Integer.parseInt(line.nextToken());
			int stops = Integer.parseInt(line.nextToken());
			route = new int[stops];
			StringTokenizer stop = new StringTokenizer(f.readLine());
			for(int j = 0; j < stops; j++){
				route[j] = Integer.parseInt(stop.nextToken());
			}
			if (contains(route, start) != -1 && contains(route, dest) != -1){
				if(contains(route, dest) > contains(route, start)){
					if(cost < lowest){
						lowest = cost;
					}
				}
			}
		}
		out.println(lowest);
		f.close();
		out.close();
	}
	
	public static int contains(int[] a, int val){
		for(int i = 0; i < a.length; i++){
			if (a[i] == val){
				return i;
			}
		}
		return -1;
	}

}
