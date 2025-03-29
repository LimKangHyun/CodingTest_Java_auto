import java.io.*;
import java.util.*;

public class Main {
    private static int[][] app;
    private static int[][] dp;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    app = new int[N+1][2];
	    int totalCost = 0;

        String[] memory = br.readLine().split(" ");
        String[] cost = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            app[i][0] = Integer.parseInt(memory[i-1]);
            app[i][1] = Integer.parseInt(cost[i-1]);
            totalCost += Integer.parseInt(cost[i-1]);
        } 
        dp = new int[N+1][totalCost+1];
        findMinCost(N, totalCost);
        for (int i = 0; i <= totalCost; i++) {
            if(dp[N][i] >= M) {
                bw.write(String.valueOf(i));
                break;
            }
        } 
		bw.flush();
	}
	private static void findMinCost(int N, int totalCost) {
	    for (int i = 1; i <= N; i++) {
	        for (int j = 0; j <= totalCost; j++) {
	            if (app[i][1] <= j) {
	                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - app[i][1]] + app[i][0]);
	            } else {
	                dp[i][j] = dp[i-1][j];
	            }
	        } 
	    } 
	}
}