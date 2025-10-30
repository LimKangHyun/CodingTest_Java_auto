import java.io.*;
import java.util.*;

public class Main {
    private static String[] input;
    private static int N, M;
	private static int[][] cheese;
	private static int[][] visited;
	private static int total = 0;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		cheese = new int[N][M];
		for (int i = 0; i < N; i++) {
		    input = br.readLine().split(" ");
		    for (int j = 0; j < M; j++) {
		        cheese[i][j] = Integer.parseInt(input[j]);
		        if (cheese[i][j] == 1) total++;
		    }
		}
		int time = 0;
		while(total > 0) {
		    checkSide();
		    time++;
		}
		bw.write(String.valueOf(time));
		bw.flush();
	}
	private static void checkSide() {
	    visited = new int[N][M];
	    List<int[]> meltingList = new ArrayList<>();
	    Queue<int[]> outside = new ArrayDeque<>();
	    outside.offer(new int[] {0, 0});
	    visited[0][0] = 1;
	    while(!outside.isEmpty()) {
	        int[] cur = outside.poll();
	        for (int i = 0; i < 4; i++) {
	            int nx = cur[0] + dx[i];
	            int ny = cur[1] + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
	            if (cheese[nx][ny] == 1) {
	                visited[nx][ny]++;
	                if (visited[nx][ny] == 2) meltingList.add(new int[] {nx, ny});
	                continue;
	            }
	            if (visited[nx][ny] == 1) continue;
	            visited[nx][ny] = 1;
	            outside.offer(new int[] {nx, ny});
	        }
	    }
	    for (int[] pos : meltingList) {
	        cheese[pos[0]][pos[1]] = 0;
	        total--;
	    }
	}
}