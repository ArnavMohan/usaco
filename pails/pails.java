
import java.io.*;
import java.util.*;

public class pails {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("pails.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int highest = 0;
		for(int i = 0; i < (int) m/x + 1; i++){
			for(int j = 0; j < (int) m/y + 1; j++){
				if(i*x + j*y > highest && i*x + j*y <= m){
					highest = i*x + j*y;
				}
			}
		}
		
		out.println(highest);
		f.close();
		out.close();
	}

}
