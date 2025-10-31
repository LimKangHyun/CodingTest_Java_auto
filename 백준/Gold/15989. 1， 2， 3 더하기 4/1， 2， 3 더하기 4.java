import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[4][10001];
		for (int i = 1; i <= 3; i++) {
		    dp[i][0] = 1;
		}
		for (int i = 1; i <= 3; i++) {
	        for (int j = 1; j <= 10000; j++) {
	            dp[i][j] = dp[i - 1][j];
	            if (j - i >= 0) dp[i][j] += dp[i][j - i];
	        }
	    }
		while (T-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    sb.append(dp[3][n]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static int fill(int n) {
	    if (n == 1) return 1;
	    if (n == 2) return 2;
	    if (n == 3) return 3;
	    return fill(n - 3) + fill(n - 2) + 1;
	}
}