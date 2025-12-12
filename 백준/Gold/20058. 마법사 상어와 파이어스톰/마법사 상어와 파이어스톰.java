import java.io.*;
import java.util.*;

public class Main {
    static int p;
    static int[][] map;
    static boolean[][] visited;
    static int total = 0;
    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		p = 1 << N;
		map = new int[p][p];
		visited = new boolean[p][p];
		for (int i = 0; i < p; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < p; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		st = new StringTokenizer(br.readLine());
		while(Q-- > 0) {
		    int num = Integer.parseInt(st.nextToken());
		    int b = 1 << num;
		    divide(b);
		    melt();
		}
		// 남아있는 얼음 합 && 가장 큰 덩어리 개수
		for (int i = 0; i < p; i++) {
	        for (int j = 0; j < p; j++) {
	            total += map[i][j];
	            if (!visited[i][j] && map[i][j] != 0) max = Math.max(max, dfs(i, j));
	        }
	    }
		bw.write(total + "\n" + max);
		bw.flush();
	}
	private static void divide(int b) {
	    for (int i = 0; i < p; i += b) {
	        for (int j = 0; j < p; j += b) {
	            spinBlock(i, j, b);
	        }
	    }
	}
    private static void spinBlock(int x, int y, int b) {
        int[][] temp = new int[b][b];
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < b; j++) {
                temp[j][b - 1 - i] = map[x + i][y + j];
            }
        }
        // 원본 배열 업데이트
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < b; j++) {
                map[x + i][y + j] = temp[i][j];
            }
        }
    }
    private static void melt() {
        // 맵의 양 모서리 || 인접칸의 수가 0이면 녹음
        List<int[]> melts = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < p; j++) {
                if (map[i][j] == 0) continue;
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx >= 0 && ny >= 0 && nx < p && ny < p && map[nx][ny] > 0) count++;
                }
                if (count < 3) melts.add(new int[] {i, j});
            }
        }
        for (int[] melt : melts) {
            map[melt[0]][melt[1]]--;
        }
    }
    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int size = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= p || ny >= p) continue;
            if (!visited[nx][ny] && map[nx][ny] > 0) size += dfs(nx, ny);
        }
        return size;
    }
}