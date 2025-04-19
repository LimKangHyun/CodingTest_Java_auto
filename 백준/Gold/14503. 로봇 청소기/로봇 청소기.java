import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int count = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < M; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    } 
		}
		cleaned(r, c, dir);
		bw.write(String.valueOf(count));
		bw.flush();
	}
	private static void cleaned(int r, int c, int dir) {
	    map[r][c] = 2;
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = r + dx[dir];
            int ny = c + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == 0) {
                    count++;
                    cleaned(nx, ny, dir);
                    return;
                } 
            } 
	    }
	    int back = (dir + 2) % 4;
	    int nx = r + dx[back];
	    int ny = c + dy[back];
	    if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 1) {
	        cleaned(nx, ny, dir);
	    } 
	}
}