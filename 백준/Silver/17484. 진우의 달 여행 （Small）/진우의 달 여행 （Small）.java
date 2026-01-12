import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] space = new int[N][M];
		int[][][] dp = new int[N][M][3];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < M; j++) {
		        space[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		for (int j = 0; j < M; j++) {
		    for (int dir = 0; dir < 3; dir++) {
		        dp[0][j][dir] = space[0][j];
		    }
		}
		int answer = 0;
		for (int j = 0; j < M; j++) {
		    for (int dir = 0; dir < 3; dir++) {
		        dp[0][j][dir] = space[0][j];
		    }
		}
		for (int i = 1; i < N; i++) {
		    for (int j = 0; j < M; j++) {
		        if (j == 0) {
		            dp[i][j][0] = Integer.MAX_VALUE; // 이전 위치가 왼위대각에서 온 경우는 없으므로 매핑 X
		            dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + space[i][j]; // 바로위 위치에서 온 경우 0번과 2번 가능
		            dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + space[i][j]; // 오른 위치에서 온 경우 1번과 2번 가능
		        } else if (j == M - 1) {
		            dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + space[i][j];
		            dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + space[i][j];
		            dp[i][j][2] = Integer.MAX_VALUE;
		        } else {
		            dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + space[i][j]; // 왼쪽에서 온 값이므로 j - 1
		            dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + space[i][j];
		            dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + space[i][j]; // 오른쪽에서 온 값이므로 j + 1
		        }
		    }
		}
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < M; j++) {
		    for (int dir = 0; dir < 3; dir++) {
		        min = Math.min(min, dp[N - 1][j][dir]);
		    }
		}
		bw.write(String.valueOf(min));
		bw.flush();
	}
}