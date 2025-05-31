import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[][] arr;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		int startX = 0, startY = 0;
		
		for (int i = 0; i < n; i++){
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < m; j++) {
		        arr[i][j] = Integer.parseInt(st.nextToken());
		        if (arr[i][j] == 2) {
		            startX = i;
		            startY = j;
		        } 
		    } 
		} 
		bfs(startX, startY);
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        if (arr[i][j] == 0) {
	                sb.append(arr[i][j] + " ");
	            } else {
	                sb.append(visit[i][j] == true ? arr[i][j] + " " : "-1 ");
	            }
		    } 
		    sb.append("\n");
		} 
		bw.write(sb.toString());
		bw.flush();
	}
    private static void bfs(int x, int y) {
        visit = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visit[x][y] = true;
        arr[x][y] = 0;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny]) continue; 
                if (arr[nx][ny] == 0) continue;
                queue.offer(new int[] {nx, ny});
                arr[nx][ny] = arr[cx][cy] + 1;
                visit[nx][ny] = true;
            } 
        }
    }
}