import java.util.*;
public class W1P8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] pos = new int[scan.nextInt()];
		int[][] coord = new int[pos.length][2];
		
		for(int n = 0; n < pos.length; n++){
			String strx = scan.next();
			coord[n][0] = Integer.parseInt(strx);
			String stry = scan.next();
			coord[n][1] = Integer.parseInt(stry);
		}
		double highest = Integer.MIN_VALUE;
		int currenta = 0;
		int currentb = 0;
		for(int r = 0; r < pos.length; r++){
			for(int i = 0; i < r; i ++){
				double dist = distance(coord[r][0], coord[r][1], coord[i][0], coord[i][1]);
				if (dist > highest){
					highest = dist;
					currenta = r+1;
					currentb = i+1;
				}
			}
		}
		System.out.println(Math.min(currenta, currentb) + " " + Math.max(currenta, currentb));
		

	}
	
	public static double distance(int x1, int y1, int x2, int y2){
		return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	}

}
