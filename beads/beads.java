/*
ID: arnavmo1
LANG: JAVA
TASK: beads
 */

import java.io.*;
import java.util.Arrays;
public class beads {
	
	public static String[] chain;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int num = Integer.parseInt(f.readLine());
		
		chain = new String[num];
		String str = f.readLine();
		for(int i = 0; i < num; i++){
			chain[i] = Character.toString(str.charAt(i));
		}
		String[] test = new String[num];
		int highest = 0;
		int current = 0;
		int pos = 0;

		for (int i = 0; i < num; i++){
			//System.out.println(i);
			test = cut(i);
			current = collect(test);
	//System.out.println(current);
			if (current > highest){
				highest = current;
				pos = i;
			}
			if (highest > test.length){
				highest = test.length;
				break;
			}
		}
		//System.out.println(Arrays.toString(cut(4)));
		//System.out.println(highest);
		out.println(highest);
		out.close();
	}
	
	public static String[] cut(int pos){
		String[] res = new String[chain.length];
		for(int i = pos; i < chain.length; i++){
			res[i-pos] = chain[i];
		}
		for(int j = 0; j < pos; j++){
			res[chain.length-pos + j] = chain[j];
		}
		//System.out.println(Arrays.toString(res));
		return res;
	}
	
	public static int collect(String[] test){
		//System.out.println(Arrays.toString(test));
		int leftCount = 0;
		int rightCount = 0;
		String lEnd = test[0];
		for (int i = 0; i < test.length; i++){
			if (!test[i].equals("w")){
				lEnd = test[i];
				break;
			}
		}
		String rEnd = test[test.length-1];
		for (int i = test.length-1; i >= 0; i--){
			if (! test[i].equals("w")){
				rEnd = test[i];
				break;
			}
		}

		for (int i = 0; i < test.length; i++){
			
			if(test[i].equals(lEnd) || test[i].equals("w")){
				leftCount++;
			}
			else{
				break;
			}
			
			if(i == test.length-1){ return leftCount;}
		}
		
		for(int i = test.length-1; i > -1; i--){
			
			if(test[i].equals(rEnd) || test[i].equals("w")){
				rightCount++;
			}
			else{
				break;
			}
			
			if(i == 0){ return rightCount;}
		}
		return leftCount + rightCount;
		
	}
}
