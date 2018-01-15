/*
 ID: arnavmo1
 LANG: JAVA
 TASK: test
 */

import java.io.*;
import java.util.*;
public class test {

	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("test.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		out.println((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())));
		out.close();

	}

}
