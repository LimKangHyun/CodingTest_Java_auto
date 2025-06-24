import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	    int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1];
		long[][][] dp = new long[n+1][n+1][3];
		for (int i = 1; i <= n; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for (int j = 1; j <= n; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    } 
		} 
		dp[1][2][0] = 1; // 시작할때 가로 파이프 위치해있으므로(가로 dp[1][2][0] = 1)
		for (int i = 1; i <= n ; i++) {
		    for (int j = 1; j <= n; j++) {
		        if (map[i][j] == 1) continue;
		        // 가로·세로 이동 시 → 이전 파이프 위치는 이미 유효함 → 도착지(map[i][j])만 검사하면 충분
		        if (j-1 >= 1) dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2]; // 가로는 가로와 대각선에서 가능한 방향
		        if (i-1 >= 1) dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2]; // 세로는 세로와 대각선에서 가능한 방향
		        // 대각선은 모든 위치에서 만들수 있는 방향
		        if (i-1 >= 1 && j-1 >= 1 && map[i-1][j] == 0 && map[i][j-1] == 0 && map[i-1][j-1] == 0) {
		            dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]; 
		        }
		    } 
		} 
		bw.write(String.valueOf(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]));
		bw.flush();
	}
}