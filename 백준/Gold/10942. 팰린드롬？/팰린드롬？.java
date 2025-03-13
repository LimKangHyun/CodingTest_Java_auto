import java.io.*;
import java.util.*;

public class Main {
    private static boolean[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		dp = new boolean[N+1][N+1];
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		} 
		isPalendrome(arr, N);
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int S = Integer.parseInt(st.nextToken());
		    int E = Integer.parseInt(st.nextToken());
		    if (dp[S][E]) sb.append(1).append("\n");
		    else sb.append(0).append("\n");
		} 
		bw.write(sb.toString());
		bw.flush();
	}
	private static void isPalendrome(int[] arr, int n) {
	    for (int i = 1; i <= n; i++) {
	        dp[i][i] = true;
	    }
	    for (int i = 2; i <= n; i++) {
	        if (arr[i-1] == arr[i]) dp[i-1][i] = true; 
	    } 
	    for (int i = 2; i < n; i++) {
	        for (int j = 1; j <= n - i; j++) {
	            if (arr[j] == arr[j+i] && dp[j+1][j+i-1]) {
	                dp[j][j+i] = true;
	            } 
	        } 
	    } 
	}
}