/*
ID; armavmo1
LANG: JAVA
TASK: milk
 */

import java.io.*;
import java.util.*;

public class milk {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int units = Integer.parseInt(st.nextToken());
		int numF = Integer.parseInt(st.nextToken());
		if(units == 0 && numF == 0){
			out.println(0);
			f.close();
			out.close();
			return;
		}
		int[] totals = new int[numF];
		int[] prices = new int[numF];
		int spent = 0;
		for(int i = 0; i < numF; i++){
			StringTokenizer line = new StringTokenizer(f.readLine());
			prices[i] = Integer.parseInt(line.nextToken());
			totals[i] = Integer.parseInt(line.nextToken());
		}
		for(int i = 1; i < prices.length; i++){
			for(int j = 0; j < i; j++){
				if(prices[j] > prices[i]){
					int temp = prices[i];
					prices[i] = prices[j];
					prices[j] = temp;
					int temp2 = totals[i];
					totals[i] = totals[j];
					totals[j] = temp2;
				}
			}
		}
		boolean empty = true;
		while (empty){
			int ind = findLowestPrice(prices, totals);
			if(totals[ind] < units){
				spent += prices[ind]*totals[ind];
				prices[ind] = -1;
				units -= totals[ind];
			}
			else{
				spent += prices[ind]*units;
				prices[ind] = -1;
				units -= totals[ind];
				empty = false;
			}
		}
		
		out.println(spent);
		f.close();
		out.close();
	}
	
	public static int findLowestPrice(int[] price, int[] totals){
		int lowest = 1001;
		int lowesti = 0;
		for(int i = 0; i < price.length; i++){
			if(price[i]<lowest){
				if(price[i] == -1){
					continue;
				}
				else{
					lowest = price[i];
					lowesti = i;
				}
			}
		}
		return lowesti;
	}


}
