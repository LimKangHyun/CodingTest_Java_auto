import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] rooms;
    static List<Integer>[] list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		rooms = new boolean[N][N];
		list = new ArrayList[N * N];
		for (int i = 0; i < N * N; i++) {
		    list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken()) - 1;
	        int y = Integer.parseInt(st.nextToken()) - 1;
	        int a = Integer.parseInt(st.nextToken()) - 1;
	        int b = Integer.parseInt(st.nextToken()) - 1;
	        list[x * N + y].add(a * N + b);
		}
		rooms[0][0] = true;
		bw.write(String.valueOf(findMaxLightNum()));
		bw.flush();
	}
	private static int findMaxLightNum() {
	    int count = 1;
	    boolean[][] visited = new boolean[N][N];
	    Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        int cx = cur[0];
	        int cy = cur[1];
	        int cIdx = cx * N + cy;
	        for (int idx : list[cIdx]) {
	            int nx = idx / N;
	            int ny = idx % N;
	            if (!rooms[nx][ny]) {
	                rooms[nx][ny] = true;
	                count++;
	                for (int i = 0; i < 4; i++) {
	                    int nnx = nx + dx[i];
	                    int nny = ny + dy[i];
	                    if (nnx >= 0 && nny >= 0 && nnx < N && nny < N && visited[nnx][nny]) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                            break;
                        }
	                }
	            }
	        }
	        for (int i = 0; i < 4; i++) {
	            int nx = cx + dx[i];
	            int ny = cy + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	            if (!visited[nx][ny] && rooms[nx][ny]) {
	                visited[nx][ny] = true;
	                queue.offer(new int[] {nx, ny});
	            }
	        }
	    }
	    return count;
	}
}