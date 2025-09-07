import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] visit;
    static Queue<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < M; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    } 
		}
		int year = 0;
		while(countIsland() == 1) {
		    int zeroCount = 0;
		    for (int i = 0; i < N; i++) {
    		    for (int j = 0; j < M; j++) {
    		        // 미리 계산된 visit을 활용해 다음 맵 갱신
    		        if (visit[i][j] != -1) map[i][j] = Math.max(map[i][j] - visit[i][j], 0);
    		        if (map[i][j] == 0) zeroCount++; 
        	    } 
        	}
        	// 모두 녹아버리면 year는 0으로
        	if (zeroCount == N * M) {
        	    year = 0;
        	    break;
        	} 
        	year++;
		}
		bw.write(String.valueOf(year));
		bw.flush();
	}
	private static int countIsland() {
	    int count = 0;
	    for (int i = 0; i < N; i++) {
	        Arrays.fill(visit[i], -1);
        }
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            if (map[i][j] == 0 || visit[i][j] != -1) continue;
	            bfs(i, j);
	            count++;
	        } 
	    } 
	    return count;
	}
	private static void bfs(int x, int y) {
	    queue = new ArrayDeque<>();
	    queue.offer(new int[] {x, y});
	    visit[x][y] = countSea(x, y);
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        for (int i = 0; i < 4; i++) {
    	        int nx = cur[0] + dx[i];
    	        int ny = cur[1] + dy[i];
    	        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
    	        if (visit[nx][ny] != -1 || map[nx][ny] == 0) continue; 
    	        visit[nx][ny] = countSea(nx, ny); // 다음 번 맵 변경 시 얼마나 빼야하는지 계산
    	        queue.offer(new int[] {nx, ny});
    	    } 
	    }
	}
	private static int countSea(int x, int y) {
	    int count = 0;
	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
	        if (map[nx][ny] != 0) continue;
	        count++; 
	    } 
	    return count;
	}
}