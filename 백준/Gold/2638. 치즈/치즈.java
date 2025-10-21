import java.io.*;
import java.util.*;

public class Main {
    private static String[] input;
    private static int N, M;
	private static int[][] cheese;
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
		    melt();
		    time++;
		}
		bw.write(String.valueOf(time));
		bw.flush();
	}
	private static void checkSide() {
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            if (cheese[i][j] == -1) cheese[i][j] = 0;
	        }
	    }
	    Queue<int[]> outside = new ArrayDeque<>();
	    cheese[0][0] = -1;
	    outside.offer(new int[] {0, 0});
	    while(!outside.isEmpty()) {
	        int[] cur = outside.poll();
	        for (int i = 0; i < 4; i++) {
	            int nx = cur[0] + dx[i];
	            int ny = cur[1] + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
	            if (cheese[nx][ny] != 0) continue;
	            cheese[nx][ny] = -1;
	            outside.offer(new int[] {nx, ny});
	        }
	    }
	}
	private static void melt() {
	    List<int[]> list = new ArrayList<>();
	    for (int i = 1; i < N - 1; i++) {
	        for (int j = 1; j < M - 1; j++) {
	            int count = 0;
	            if (cheese[i][j] != 1) continue;
	            for (int d = 0; d < 4; d++) {
	                int nx = i + dx[d];
	                int ny = j + dy[d];
	                if (cheese[nx][ny] == -1) count++;
	                if (count >= 2) break;
	            }
	            if (count < 2) continue;
	            list.add(new int[] {i, j});
	        }
	    }
	    for (int[] pos : list) {
	        cheese[pos[0]][pos[1]] = 0;
	        total--;
	    }
	}
}