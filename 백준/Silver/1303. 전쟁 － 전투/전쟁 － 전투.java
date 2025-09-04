import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]); // 세로
		map = new char[M][N];
		visit = new boolean[M][N];
		for (int i = 0; i < M; i++) {
		    String st = br.readLine();
		    for (int j = 0; j < N; j++) {
		        map[i][j] = st.charAt(j);
		    } 
		} 
		int whiteCount = 0;
		int blueCount = 0;
		for (int i = 0; i < M; i++) {
		    for (int j = 0; j < N; j++) {
		        if (visit[i][j]) continue;
		        if (map[i][j] == 'W') whiteCount += Math.pow(bfs(i, j), 2);
		        if (map[i][j] == 'B') blueCount += Math.pow(bfs(i, j), 2);
		    } 
		} 
		bw.write(whiteCount + " " + blueCount);
		bw.flush();
	}
	private static int bfs(int x, int y) {
	    int count = 1;
	    Queue<int[]> queue = new ArrayDeque<>();
	    queue.offer(new int[] {x, y});
	    visit[x][y] = true;
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        for (int i = 0; i < 4; i++) {
	            int nx = cur[0] + dx[i];
	            int ny = cur[1] + dy[i];
	            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
	            if (visit[nx][ny] || map[x][y] != map[nx][ny]) continue;
	            queue.offer(new int[] {nx, ny});
	            visit[nx][ny] = true;
	            count++;
	        } 
	    }
	    return count;
	}
}