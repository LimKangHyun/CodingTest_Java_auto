import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][2];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
		    st = new StringTokenizer(br.readLine());
		    matrix[i][0] = Integer.parseInt(st.nextToken());
		    matrix[i][1] = Integer.parseInt(st.nextToken());
		} 	
		int[][] dp = new int[n][n];
		
		for (int length = 2; length <= n ; length++) {
		    for (int i = 0; i <= n - length; i++) {
		        int j = i + length - 1;
		        dp[i][j] = Integer.MAX_VALUE;
		        for (int k = i; k < j; k++) {
		            int cost = dp[i][k] + dp[k+1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1];
		            dp[i][j] = Math.min(cost, dp[i][j]);
		        } 
		    } 
		} 
		bw.write(String.valueOf(dp[0][n - 1]));
		bw.flush();
	}
}