import java.io.*;
import java.util.*;

public class Main {
    static int N, M, G, R;
    static int[][] garden;
    static boolean[][] visited;
    static List<int[]> list = new ArrayList<>();
    static List<int[]> choice = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		garden = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < M; j++) {
		        garden[i][j] = Integer.parseInt(st.nextToken());
		        if (garden[i][j] == 2) list.add(new int[] {i, j});
		    }
		}
		comb(0, 0);
	    bw.write(String.valueOf(max));
		bw.flush();
	}
	private static void comb(int depth, int start) {
	    if (depth == G + R) {
	        boolean[] greenVisited = new boolean[G + R];
	        choiceGreen(0, 0, greenVisited);
	        return;
	    }
	    for (int i = start; i < list.size(); i++) {
	        choice.add(new int[] {list.get(i)[0], list.get(i)[1]});
	        comb(depth + 1, i + 1);
	        choice.remove(choice.size() - 1);
	    }
	}
	private static void choiceGreen(int depth, int start, boolean[] greenVisited) {
	    if (depth == G) {
	        List<int[]> green = new ArrayList<>();
	        List<int[]> red = new ArrayList<>();
	        for (int i = 0; i < G + R; i++) {
	            int x = choice.get(i)[0];
	            int y = choice.get(i)[1];
	            if (greenVisited[i]) green.add(new int[] {x, y});
	            else red.add(new int[] {x, y});
	        }
	        max = Math.max(max, bfs(green, red));
	        return;
	    }
	    for (int i = start; i < choice.size(); i++) {
	        greenVisited[i] = true;
	        choiceGreen(depth + 1, i + 1, greenVisited);
	        greenVisited[i] = false;
	    }
	}
	private static int bfs(List<int[]> green, List<int[]> red) {
	    int flower = 0;
	    int[][] color = new int[N][M];
	    int[][] time = new int[N][M];
	    Queue<int[]> queue = new ArrayDeque<>();
	    for (int[] g : green) {
	        queue.offer(new int[] {g[0], g[1], 1, 1});
	        color[g[0]][g[1]] = 1;
	        time[g[0]][g[1]] = 1;
	    }
	    for (int[] r : red) {
	        queue.offer(new int[] {r[0], r[1], 1, 2});
	        color[r[0]][r[1]] = 2;
	        time[r[0]][r[1]] = 1;
	    }
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        if (color[cur[0]][cur[1]] == 3) continue; // 꽃 피운 경우 continue;
	        for (int i = 0; i < 4; i++) {
	            int nx = cur[0] + dx[i];
	            int ny = cur[1] + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
	            if (garden[nx][ny] == 0 || color[nx][ny] == 3) continue;
	            // 꽃 피워주기
	            if (time[nx][ny] == cur[2] + 1 && cur[3] + color[nx][ny] == 3) {
	                color[nx][ny] = 3;
	                flower++;
	                continue;
	            }
	            if (time[nx][ny] == 0) {
	                time[nx][ny] = cur[2] + 1;
	                color[nx][ny] = cur[3];
	                queue.offer(new int[] {nx, ny, time[nx][ny], color[nx][ny]});
	            }
	        }
	    }
	    return flower;
	}
}