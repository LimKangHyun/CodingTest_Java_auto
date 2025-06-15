import java.io.*;

public class Main {
    private static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
		    int k = Integer.parseInt(br.readLine());
		    int n = Integer.parseInt(br.readLine());
		    dp = new int[k+1][n+1];
		    sb.append(countPeople(k, n) + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static int countPeople(int k, int n) {
	    if (n == 0) return 0;
	    if (k == 0) return n;
	    if (dp[k][n] != 0) return dp[k][n];
	    dp[k][n] = countPeople(k - 1, n) + countPeople(k, n - 1);
	    return dp[k][n];
	}
}