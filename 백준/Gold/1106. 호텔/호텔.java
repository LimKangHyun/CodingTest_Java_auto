import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[c + 101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 0; i < n; i++) {
		    st = new StringTokenizer(br.readLine());
		    int cost = Integer.parseInt(st.nextToken());
		    int customer = Integer.parseInt(st.nextToken());
		    for (int j = customer; j < c + 101; j++) {
		        if (dp[j - customer] != Integer.MAX_VALUE) {
		            dp[j] = Math.min(dp[j], cost + dp[j-customer]);
		        } 
		    } 
		} 
		int minCost = Integer.MAX_VALUE;
		for (int i = c; i < dp.length; i++) {
		    minCost = Math.min(minCost, dp[i]);
		}
		bw.write(String.valueOf(minCost));
		bw.flush();
	}
}