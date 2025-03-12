import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		    max = Math.max(max, arr[i]);
		} 
		int[] dp = new int[max+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		findDp(4, dp);
		for (int i = 0; i < n; i++) {
		    bw.write(String.valueOf(dp[arr[i]]));
		    bw.newLine();
		} 
		bw.flush();
	}
	
	private static void findDp(int n, int[] dp) {
	    for (int i = n; i < dp.length; i++) {
	        dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
	    }
	}
}