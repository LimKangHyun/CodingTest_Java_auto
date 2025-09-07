import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] temp;
    static boolean[][] visit;
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
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < M; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    } 
		}
		int year = 0;
		while(true) {
		    int piece = 0;
		    melting();
		    for (int i = 0; i < N; i++) {
    		    for (int j = 0; j < M; j++) {
        	        if (visit[i][j] || map[i][j] == 0) continue;
        	        dfs(i, j);
        	        piece++;
        	    } 
        	}
        	year++;
        	if (piece >= 2) break; 
        	if (piece == 0) {
        	    year = 0;
        	    break;
        	}
		}
		bw.write(String.valueOf(year));
		bw.flush();
	}
	private static void melting() {
	    temp = new int[N][M];
	    visit = new boolean[N][M];
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            int count = 0;
	            for (int d = 0; d < 4; d++) {
	                int ni = i + dx[d];
	                int nj = j + dy[d];
	                if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
	                if (map[ni][nj] <= 0) count++;
	            } 
	            temp[i][j] = map[i][j] - count > 0 ? map[i][j] - count : 0;
	        } 
	    } 
	    for (int i = 0; i < N; i++) {
	        map[i] = Arrays.copyOf(temp[i], M);
	    } 
	}
	private static void dfs(int x, int y) {
	    visit[x][y] = true;
	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
	        if (visit[nx][ny] || map[nx][ny] == 0) continue; 
	        dfs(nx, ny);
	    } 
	}
}