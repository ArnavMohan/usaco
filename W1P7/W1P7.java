import java.util.*;
public class W1P7 {
	public static void main(String[] args){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		nums.add(n);
		while(nums.indexOf(getRand(n)) == -1){
			n = getRand(n);
			nums.add(n);
		}
		System.out.println(nums.size());
		
	}
	
	public static int getRand(int num){
		return ((num/10)%100)*((num/10)%100);
	}
}