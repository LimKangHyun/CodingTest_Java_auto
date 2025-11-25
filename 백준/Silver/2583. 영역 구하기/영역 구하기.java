import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringJoiner sj = new StringJoiner(" ");
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[M][N];
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
		    st = new StringTokenizer(br.readLine());
		    int y1 = Integer.parseInt(st.nextToken());
		    int x1 = Integer.parseInt(st.nextToken());
		    int y2 = Integer.parseInt(st.nextToken()) - 1;
		    int x2 = Integer.parseInt(st.nextToken()) - 1;
		    fillSquare(x1, y1, x2, y2);
		}
		int count = 0;
		for (int i = 0; i < M; i++) {
		    for (int j = 0; j < N; j++) {
		        if (visited[i][j]) continue;
		        count++;
		        list.add(bfs(i, j));
		    }
		}
		Collections.sort(list);
		for (int n : list) {
		    sj.add(String.valueOf(n));
		}
		bw.write(String.valueOf(count));
		bw.newLine();
		bw.write(sj.toString());
		bw.flush();
	}
	private static void fillSquare(int x1, int y1, int x2, int y2) {
	    for (int i = x1; i <= x2; i++) {
	        for (int j = y1; j <= y2; j++) {
	            if (visited[i][j]) continue;
	            visited[i][j] = true;
	        }
	    }
	}
	private static int bfs(int x, int y) {
	    int extent = 1;
	    Queue<int[]> queue = new ArrayDeque<>();
	    queue.offer(new int[] {x, y});
	    visited[x][y] = true;
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        for (int i = 0; i < 4; i++) {
	            int nx = cur[0] + dx[i];
	            int ny = cur[1] + dy[i];
	            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
	            if (visited[nx][ny]) continue;
	            visited[nx][ny] = true;
	            extent++;
	            queue.offer(new int[] {nx, ny});
	        }
	    }
	    return extent;
	}
}