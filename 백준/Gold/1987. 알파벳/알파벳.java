import java.io.*;
import java.util.*;

public class Main {
    private static int R, C, maxDepth;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    private static final boolean[] alpha = new boolean[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
		    String input = br.readLine();
		    for (int j = 0; j < C; j++) {
		        map[i][j] = input.charAt(j);
		    } 
		} 
		alpha[map[0][0] - 'A'] = true;
		dfs(map, 0, 0, 1);
		bw.write(String.valueOf(maxDepth));
		bw.flush();
	}
	private static void dfs(int[][] map, int x, int y, int depth) {
	    maxDepth = Math.max(maxDepth, depth);
	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
	            if (!alpha[map[nx][ny] - 'A']) {
	                alpha[map[nx][ny] - 'A'] = true;
	                dfs(map, nx, ny, depth+1);
	                alpha[map[nx][ny] - 'A'] = false;
	            }
	        } 
	    } 
	}
}