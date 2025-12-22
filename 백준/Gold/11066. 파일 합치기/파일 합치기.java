import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
		    int K = Integer.parseInt(br.readLine());
		    int[] arr = new int[K + 1];
		    int[] sum = new int[K + 1];
		    st = new StringTokenizer(br.readLine());
		    for (int i = 1; i <= K; i++) {
		        arr[i] = Integer.parseInt(st.nextToken());
		        sum[i] = sum[i - 1] + arr[i];
		    }
		    int[][] dp = new int[K + 1][K + 1];
		    for (int len = 2; len <= K; len++) { // 길이가 2인 것부터 비용 발생하므로
		        for (int i = 1; i + len - 1 <= K; i++) {
		            int j = i + len - 1; // j는 끝 구간
		            dp[i][j] = INF;
		            for (int k = i; k < j; k++) {
		                dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + (sum[j] - sum[i - 1]));
		            }
		        }
		    }
		    sb.append(dp[1][K]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}