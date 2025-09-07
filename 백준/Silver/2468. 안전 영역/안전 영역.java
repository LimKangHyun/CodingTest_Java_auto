import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = 0;
    static boolean[][] visit;
    static int[][] map;
    static Set<Integer> set = new HashSet<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		        set.add(map[i][j]);
		    } 
		} 
		int result = 0;
		for(int num : set) {
		    for (int i = 0; i < N; i++) {
                Arrays.fill(visit[i], false);
		    }
		    int count = 0;
    		for (int i = 0; i < N; i++) {
    		    for (int j = 0; j < N; j++) {
    		        if (visit[i][j] || map[i][j] <= num) continue;
		            dfs(i, j, num);
		            count++;
    		    } 
    		} 
    		result = Math.max(result, count);
		}
		bw.write(String.valueOf(result == 0 ? 1 : result)); // 0은 불가능하므로 0인 경우는 1이 나오도록
		bw.flush();
	}
	private static void dfs(int x, int y, int num) {
	    visit[x][y] = true;
	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	        if (visit[nx][ny] || map[nx][ny] <= num) continue;
	        dfs(nx, ny, num);
	    } 
	}
}