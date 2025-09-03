import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}; // 8방위
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
		    st = new StringTokenizer(br.readLine());
		    w = Integer.parseInt(st.nextToken());
		    h = Integer.parseInt(st.nextToken());
		    if (w == 0) break;
		    map = new int[h][w];
		    visit = new boolean[h][w];
		    for (int i = 0; i < h; i++) {
		        st = new StringTokenizer(br.readLine());
		        for (int j = 0; j < w; j++) {
		            map[i][j] = Integer.parseInt(st.nextToken());
		        } 
		    } 
		    int landCount = 0;
		    for (int i = 0; i < h; i++) {
		        for (int j = 0; j < w; j++) {
		            if (!visit[i][j] && map[i][j] == 1) {
		                dfs(i, j);
		                landCount++;
		            }
		        } 
		    } 
		    sb.append(landCount + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	static void dfs(int cx, int cy) {
	    visit[cx][cy] = true;
	    for (int i = 0; i < 8; i++) {
	        int nx = cx + dx[i];
	        int ny = cy + dy[i];
	        if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
	        if (visit[nx][ny] || map[nx][ny] == 0) continue;
	        dfs(nx, ny);
	    } 
	}
}