import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;
    static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < m; j++) {
		        paper[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (visited[i][j] || paper[i][j] == 0) continue;
	            count++;
	            max = Math.max(max, bfs(i, j));
	        }
	    }
		bw.write(String.valueOf(count));
		bw.newLine();
		bw.write(String.valueOf(max));
		bw.flush();
	}
	private static int bfs(int x, int y) {
	    int extent = 1;
	    visited[x][y] = true;
	    Queue<int[]> queue = new ArrayDeque<>();
	    queue.offer(new int[] {x, y});
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        for (int i = 0; i < 4; i++) {
    	        int nx = cur[0] + dx[i];
    	        int ny = cur[1] + dy[i];
    	        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
    	        if (visited[nx][ny]) continue;
    	        if (paper[nx][ny] == 0) continue;
    	        visited[nx][ny] = true;
    	        extent++;
    	        queue.offer(new int[] {nx, ny});
    	    }
	    }
	    return extent;
	}
}