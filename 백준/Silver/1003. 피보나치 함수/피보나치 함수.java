import java.io.*;
import java.util.*;

public class Main {
    private static Integer[][] dp = new Integer[41][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    dp[0][0] = 1;
		    dp[0][1] = 0;
		    dp[1][0] = 0;
		    dp[1][1] = 1;
		    fibonacci(n);
		    sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static void fibonacci(int n) {
	    if (dp[n][0] == null || dp[n][1] == null) {
	        fibonacci(n - 1);
	        fibonacci(n - 2);
	        dp[n][0] = dp[n - 1][0] + dp[n - 2][0];
	        dp[n][1] = dp[n - 1][1] + dp[n - 2][1];
	    }
	}
}