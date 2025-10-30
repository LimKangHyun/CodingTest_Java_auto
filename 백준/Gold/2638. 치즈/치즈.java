import java.io.*;
import java.util.*;

public class Main {
    private static String[] input;
    private static int N, M;
	private static int[][] cheese;
	private static boolean[][] visited;
	private static List<int[]> cheeseList = new ArrayList<>();
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
		        if (cheese[i][j] == 1) cheeseList.add(new int[] {i, j});
		    }
		}
		int time = 0;
		while(!cheeseList.isEmpty()) {
		    checkSide();
		    melt();
		    time++;
		}
		bw.write(String.valueOf(time));
		bw.flush();
	}
	private static void checkSide() {
	    visited = new boolean[N][M];
	    Queue<int[]> outside = new ArrayDeque<>();
	    outside.offer(new int[] {0, 0});
	    visited[0][0] = true;
	    while(!outside.isEmpty()) {
	        int[] cur = outside.poll();
	        for (int i = 0; i < 4; i++) {
	            int nx = cur[0] + dx[i];
	            int ny = cur[1] + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
	            if (visited[nx][ny]) continue;
	            if (cheese[nx][ny] == 1) continue;
	            visited[nx][ny] = true;
	            outside.offer(new int[] {nx, ny});
	        }
	    }
	}
	private static void melt() {
	    List<int[]> nextCheese = new ArrayList<>();
	    for (int[] ch : cheeseList) {
	        int count = 0;
	        for (int d = 0; d < 4; d++) {
                int nx = ch[0] + dx[d];
                int ny = ch[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) count++;
            }
            if (count >= 2) {
                cheese[ch[0]][ch[1]] = 0;
            } else {
                nextCheese.add(ch);
            }
	    }
	    cheeseList = nextCheese;
	}
}