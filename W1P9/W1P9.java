import java.util.*;
public class W1P9 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		
		int[][] map = new int[rows][cols];
		for (int r = 0; r < rows; r++){
			String line = scan.nextLine();
			for (int c = 0; c < cols; c++){
				if (line.charAt(c)=='#'){
					break;
				}
			}
		}
		
		
	}

}
