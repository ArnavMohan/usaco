/*
ID: armavmo1
LANG: JAVA
TASK: gift1
 */
import java.io.*;
import java.util.*;
public class gift1 {

	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		
		int N = Integer.parseInt(f.readLine());
		//int[] amount = new int[N];
		int[] net = new int[N];

		String[] names = new String[N];
		for (int i = 0; i < N; i++){
			names[i] = f.readLine();
		}
		for (int i = 0; i < N; i++){
			
			int pos = getPlace(names, f.readLine());
			StringTokenizer st = new StringTokenizer(f.readLine());
			int gifttot = Integer.parseInt(st.nextToken());
			int numGifts = Integer.parseInt(st.nextToken());
			int giftamt;
			if (numGifts == 0){
				giftamt = 0;
			}
			else{ giftamt = gifttot/numGifts; }

			for (int p = 0; p < numGifts; p++){
				int giftpos = getPlace(names, f.readLine());
				net[giftpos] += giftamt;

				net[pos] -= giftamt;
			}

		}
		
		for (int i = 0; i < N; i++){
			
			out.println(names[i] + " " + net[i]);
			
		}
		out.close();
		f.close();
	}
	
	public static int getPlace(String[] names, String name){
		for (int i = 0; i < names.length; i++){
			if (name.equals(names[i])){
				return i;
			}
		}
		return -1;
	}

}
