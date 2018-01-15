import java.util.Scanner;
import java.util.ArrayList;
public class W1P2 {
	public static int br1(){
		Scanner numScan = new Scanner(System.in);
		final int num = numScan.nextInt();
		
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i=1;i<(int)Math.sqrt(num)+1;i++){
			if (num%i == 0){
				factors.add(i);
				factors.add(num/i);
			}
		}
		
		int total = 0;
		for (int item : factors){
			total += item;
		}
		
		return total;
	}
	
	public static void main(String[] args){
		System.out.println(br1());
	}
}
