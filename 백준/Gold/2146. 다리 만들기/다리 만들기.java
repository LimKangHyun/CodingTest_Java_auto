import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int minDist = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] set;
    static Queue<int[]> border = new ArrayDeque<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		set = new int[N][N];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int idx = 1;
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        if (map[i][j] == 1 && set[i][j] == 0) {
		            checkIsland(i, j, idx++);
		        }
		    }
		}
		checkMinDist();
		bw.write(String.valueOf(minDist));
		bw.flush();
	}
	private static void checkIsland(int x, int y, int idx) {
	    set[x][y] = idx;
	    Queue<int[]> queue = new ArrayDeque<>();
	    queue.offer(new int[] {x, y});
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        boolean isBorder = false;
	        for (int i = 0; i < 4; i++) {
	            int nx = cur[0] + dx[i];
	            int ny = cur[1] + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	            if (map[nx][ny] == 0) isBorder = true;
	            if (set[nx][ny] == 0 && map[nx][ny] == 1) {
                    set[nx][ny] = idx;
                    queue.offer(new int[] {nx, ny});
                }
	        }
	        if (isBorder) border.add(new int[] {cur[0], cur[1]});
	    }
	}
	private static void checkMinDist() {
	    int[][] dist = new int[N][N];
	    while(!border.isEmpty()) {
	        int[] cur = border.poll();
	        int x = cur[0];
	        int y = cur[1];
	        for (int i = 0; i < 4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	            if (map[nx][ny] == 0 && set[nx][ny] == 0) {
	                set[nx][ny] = set[x][y];
	                dist[nx][ny] = dist[x][y] + 1;
	                border.offer(new int[] {nx, ny});
	            } else if (set[nx][ny] != set[x][y]) { // 다른 섬 번호
	                // dist[x][y] = BFS가 진행중인 섬에서 온거리
	                // dist[nx][ny] = 다른 섬에서 이미 확장한 거리
	                minDist = Math.min(minDist, dist[x][y] + dist[nx][ny]);
	                if (minDist == 1) return;
	            }
	        }
	    }
	}
}