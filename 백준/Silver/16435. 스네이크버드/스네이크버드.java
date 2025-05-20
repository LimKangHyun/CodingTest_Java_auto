import java.io.*;
import java.util.*;

public class Main {
    private static int n, l;
    private static int[] fruit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input1 = br.readLine().split(" ");
		n = Integer.parseInt(input1[0]);
		l = Integer.parseInt(input1[1]);
		fruit = new int[n];
		
		String[] input2 = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
		    fruit[i] = Integer.parseInt(input2[i]);
		} 
		
	    bw.write(String.valueOf(calcMaxLength()));	
		bw.flush();
	}
	private static int calcMaxLength() {
	    Arrays.sort(fruit);
	    for (int i = 0; i < n; i++) {
	        if (l < fruit[i]) break;
	        l++;
	    } 
	    return l;
	}
}