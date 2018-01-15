import java.util.Scanner;
public class W1P3 {
	public static int sym(int m, int n){
		if ((m%2 == 0 || n%2 == 0)){
			return 0;
		}
		else{
			
			return 1 + 4*sym((m-1)/2,(n-1)/2);
			}
		}
	public static void main(String[] args){
		// input with spaces
		Scanner scan = new Scanner(System.in);
		String mnstr = scan.nextLine();
	    String[] strs = mnstr.split(" ");
	    int m = Integer.parseInt(strs[0]);
	    int n = Integer.parseInt(strs[1]);
	    System.out.println(sym(m,n));
		
	}
}
