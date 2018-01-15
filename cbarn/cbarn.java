
import java.io.*;
import java.util.*;

public class cbarn {

	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		int n = Integer.parseInt(f.readLine());
		int[] r = new int[n];
		
		for(int i = 0; i < n; i++){
			r[i] = Integer.parseInt(f.readLine());
		}
		int lowest = Integer.MAX_VALUE;
		int[] barn;
		for(int i = 0; i < n; i++){
			int sum = 0;
			barn = rotate(r, i);
			//System.out.println(Arrays.toString(r));
			for(int j = 1; j < barn.length; j++){
				sum += barn[j] * j;
			}
			if(sum < lowest){
				lowest = sum;
			}
			//System.out.println(sum);
		}
		
		out.println(lowest);
		f.close();
		out.close();
		
	}
	
	public static int[] rotate(int[] a, int l){
		int[] res = a.clone();
		for (int i = 0; i < l; i++) {
			for (int j = a.length - 1; j > 0; j--) {
				int temp = res[j];
				res[j] = res[j - 1];
				res[j - 1] = temp;
			}
		}
		//System.out.println(Arrays.toString(res));
		return res;
	}

}
