import java.io.*;
import java.util.*;
public class Angry {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("angry.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		
		int[] row = new int[Integer.parseInt(f.readLine())];
		
		for(int i = 0; i < row.length; i++){
			row[i] = Integer.parseInt(f.readLine());
		}
		
		boolean swapped = true;
	    while (swapped) {
	       swapped = false;
	       for(int i=1; i<row.length; i++) {
	           int temp=0;
	           if(row[i-1] > row[i]) {
	               temp = row[i-1];
	                row[i-1] = row[i];
	                row[i] = temp;
	                swapped = true;
	            }
	        }
	    }

		int highest = 0;
		int blastCount = 0;
		for(int p = 0; p < row.length; p++){
			int startval = row[p];
			blastCount = 1;
			int br = 1;
			int lmi = p;
			int rmi = p;
			int lmv = row[p];
			int rmv = row[p];
			row[p] = -1;
			boolean noMore = false;
			while(!noMore){
				int[] row1 = row.clone();
				while(row[lmi] >= lmv-br){
					row[lmi] = -1;
					lmi--;
				}
				lmv = row[lmi];
				while(row[rmi] <= rmv + br){
					row[rmi] = -1;
					rmi++;
				}
				rmv = row[rmi];
				noMore = row.equals(row1);
			}
			
		}
		
	}
	
	
	
	

}
