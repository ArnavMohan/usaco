import java.util.Scanner;

public class W1P5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String num_str = scan.nextLine();
		String[] nums = num_str.split(" ");
		System.out.println(cowmult(nums[0], nums[1]));
	}

	public static int cowmult(String a_str, String b_str) {
		String a = a_str + "0000000000".substring(a_str.length());
		String b = b_str + "0000000000".substring(b_str.length());

		int total = 0;
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				total += Integer.parseInt(a.substring(i, i + 1))
						* Integer.parseInt(b.substring(j, j + 1));
			}
		}
		return total;
	}

}
