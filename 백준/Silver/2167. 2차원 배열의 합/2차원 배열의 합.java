import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++)  {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 1; j <= M; j++) {
		        arr[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		for (int i = 1; i <= N; i++)  {
		    for (int j = 1; j <= M; j++) {
		        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + arr[i][j] - dp[i - 1][j - 1];
		    }
		}
		int K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int sx = Integer.parseInt(st.nextToken());
		    int sy = Integer.parseInt(st.nextToken());
		    int ex = Integer.parseInt(st.nextToken());
		    int ey = Integer.parseInt(st.nextToken());
    		int result = dp[ex][ey] - dp[ex][sy - 1] - dp[sx - 1][ey] + dp[sx - 1][sy - 1];
    		sb.append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}