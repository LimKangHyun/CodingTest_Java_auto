import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean [][] visit;
    private static boolean [][] finishTag;
    private static int safeZone = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		finishTag = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
		    String input = br.readLine();
		    for (int j = 0; j < M; j++) {
		        if (input.charAt(j) == 'U') map[i][j] = 0;
		        if (input.charAt(j) == 'D') map[i][j] = 1;
		        if (input.charAt(j) == 'L') map[i][j] = 2;
		        if (input.charAt(j) == 'R') map[i][j] = 3;
		    } 
		} 
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < M; j++) {
		        if (!visit[i][j]) dfs(i, j);
		    } 
		}
		bw.write(String.valueOf(safeZone));
		bw.flush();
	}
	private static void dfs(int x, int y) {
	    visit[x][y] = true;
	    int nx = 0, ny = 0;
	    switch(map[x][y]) {
	        case 0:
	            nx = x - 1;
	            ny = y;
	            break;
	        case 1:
	            nx = x + 1;
	            ny = y;
	            break;
	        case 2:
	            nx = x;
	            ny = y - 1;
	            break;
	        case 3:
	            nx = x;
	            ny = y + 1;
	            break;
	    }
	    if (!visit[nx][ny]) dfs(nx, ny);
	    else {
	        if (!finishTag[nx][ny]) safeZone++;
	    }
	    finishTag[x][y] = true;
	}
}