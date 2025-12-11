import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] forest;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		forest = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < n; j++) {
		        forest[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n; j++) {
		        max = Math.max(max, dfs(i, j));
		    }
		}
		bw.write(String.valueOf(max));
		bw.flush();
	}
    private static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (forest[nx][ny] > forest[x][y]) {
                // 현재 x, y좌표로부터 갈 수 있는 최장거리 dp[x][y]에 저장
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }
}