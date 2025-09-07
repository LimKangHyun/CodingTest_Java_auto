import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = 0;
    static boolean[][] visit;
    static int[][] map;
    static Queue<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		        min = Math.min(min, map[i][j] - 1);
		        max = Math.max(max, map[i][j]);
		    } 
		} 
		int result = 0;
		while(min < max) {
		    visit = new boolean[N][N];
		    int count = 0;
		    for (int i = 0; i < N; i++) {
    		    for (int j = 0; j < N; j++) {
    		        if (map[i][j] <= min) visit[i][j] = true;
    		    } 
    		} 
    		for (int i = 0; i < N; i++) {
    		    for (int j = 0; j < N; j++) {
    		        if (visit[i][j]) continue;
		            visit[i][j] = true;
		            bfs(i, j);
		            count++;
    		    } 
    		} 
    		result = Math.max(result, count);
    		min++;
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
	private static void bfs(int x, int y) {
	    queue = new ArrayDeque<>();
	    queue.offer(new int[] {x, y});
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        for (int i = 0; i < 4; i++) {
	            int nx = cur[0] + dx[i];
	            int ny = cur[1] + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	            if (visit[nx][ny]) continue;
	            visit[nx][ny] = true;
	            queue.offer(new int[] {nx, ny});
	        } 
	    }
	}
}