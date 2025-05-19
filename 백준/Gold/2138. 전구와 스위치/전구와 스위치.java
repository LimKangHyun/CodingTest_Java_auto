import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] start;
    private static int[] end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		start = new int[n];
		end = new int[n];
		
		String inputS = br.readLine();
		String inputE = br.readLine();
		for (int i = 0; i < n; i++) {
		    start[i] = inputS.charAt(i) - '0';
		    end[i] = inputE.charAt(i) - '0';
		} 
		int firstOn = simulate(true);
		int firstOff = simulate(false);
		
		int minResult = Math.min(firstOn, firstOff);
		bw.write(minResult == Integer.MAX_VALUE ? "-1" : String.valueOf(minResult));
		bw.flush();
	}
	private static int simulate(boolean pressFirst) {
	    int[] temp = start.clone();
	    int count = 0;
	    if (pressFirst) {
	        toggle(temp, 0);
	        count++;
	    } 
	    for (int i = 1; i < n; i++) {
	        if (temp[i-1] != end[i-1]) {
	            toggle(temp, i);
	            count++;
	        }
	    } 
	    if (Arrays.equals(temp, end)) {
	        return count;
	    } 
	    return Integer.MAX_VALUE;
	}
	private static void toggle(int[] arr, int idx) {
	    for (int i = idx - 1; i <= idx + 1; i++) {
	        if (i >= 0 && i < n) {
	            arr[i] = 1 - arr[i];
	        }
	    } 
	}
}