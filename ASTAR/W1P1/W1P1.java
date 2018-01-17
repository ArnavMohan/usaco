import java.util.Scanner;
public class W1P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ctiming());

	}
	public static int ctiming(){
	    /* ctiming() -> int
	        returns minutes taken */
	    System.out.print("Enter the end time seperated by spaces: ");
	    Scanner time_scan = new Scanner(System.in);
	    String time_str = time_scan.nextLine();
	    String[] strs = time_str.split(" ");
	    
	    int[] times = {0,0,0};
	    
	    for (int i=0; i<strs.length; i++){
	        times[i] = Integer.parseInt(strs[i]);
	    }
	    // ALG 1
	    /*int numDays = times[0]-11;
	    if (numDays < 0){
	        return -1;
	    }
	    
	    int numHours = numDays * 24 + (times[1]-11);
	    if (numHours < 0){
	        return -1;
	    }
	    
	    int numMins = numHours * 60 + (times[2]-11);
	    if (numMins < 0){
	        return -1;
	    }
	    return numMins;*/
	    
	    // ALG 2
	    int start_time = 11 + 11*60 + 11*60*24;
	    int end_time = times[2] + times[1]*60 + times[0]*60*24;
	    if (end_time < start_time){
	    	return -1;
	    }
	    else{
	    	return end_time - start_time;
	    }
	    
	}

}
