import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int minDist = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> borders = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int idx = 1;
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        if (map[i][j] == 1 && !visited[i][j]) {
		            checkIsland(i, j, idx++);
		        }
		    }
		}
		for (int[] border : borders) {
		    checkMinDist(border);
		}
		bw.write(String.valueOf(minDist));
		bw.flush();
	}
	private static void checkIsland(int x, int y, int idx) {
	    visited[x][y] = true;
	    map[x][y] = idx;
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
	            if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = idx;
                    queue.offer(new int[] {nx, ny});
                }
	        }
	        if (isBorder) borders.add(new int[] {cur[0], cur[1], idx, 0});
	    }
	}
	private static void checkMinDist(int[] border) {
	    boolean[][] visitedSea = new boolean[N][N];
	    Queue<int[]> queue = new ArrayDeque<>();
	    queue.offer(border);
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        for (int i = 0; i < 4; i++) {
	            int nx = cur[0] + dx[i];
	            int ny = cur[1] + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	            if (map[nx][ny] == 0 && !visitedSea[nx][ny]) {
	                visitedSea[nx][ny] = true;
	                queue.offer(new int[] {nx, ny, cur[2], cur[3] + 1});
	            } else if (map[nx][ny] != 0 && map[nx][ny] != cur[2]) {
	                minDist = Math.min(minDist, cur[3]);
	                return;
	            }
	        }
	    }
	}
}