import java.io.*;
import java.util.*;

public class Main {
    static int R, C, K;
    static int count = 0;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
		    String input = br.readLine();
		    for (int j = 0; j < C; j++) {
		        arr[i][j] = input.charAt(j);
		    }
		}
		visited[R - 1][0] = true;
		dfs(R - 1, 0, 1);
		bw.write(String.valueOf(count));
		bw.flush();
	}
	private static void dfs(int x, int y, int depth) {
	    if (depth == K && x == 0 && y == C - 1) {
	        count++;
	        return;
	    }
	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        if (nx < 0 || ny < 0 || nx >= R || ny >= C || arr[nx][ny] == 'T') continue;
	        if (visited[nx][ny]) continue;
	        visited[nx][ny] = true;
	        dfs(nx, ny, depth + 1);
	        visited[nx][ny] = false;
	    }
	}
}