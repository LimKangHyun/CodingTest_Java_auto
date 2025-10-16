import java.io.*;
import java.util.*;

public class Main {
    private static int count = 0;
    private static char[][] studs = new char[5][5];
    private static int[] selected = new int[7];
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 5; i++) {
		    String input = br.readLine();
		    for (int j = 0; j < 5; j++) {
		        studs[i][j] = input.charAt(j);
		    }
		}
		comb(0, 0, 0);
		bw.write(String.valueOf(count));
		bw.flush();
	}
	private static void comb(int depth, int start, int cntS) {
	    if (depth == 7) {
	        if (cntS >= 4 && isConnected()) count++;
	        return;
	    }
	    for (int i = start; i < 25; i++) {
	        char c = studs[i / 5][i % 5];
	        selected[depth] = i;
	        comb(depth + 1, i + 1, cntS + (c == 'S' ? 1 : 0));
	    }
	}
	private static boolean isConnected() {
	    boolean[] visited = new boolean[7];
	    Queue<Integer> queue = new ArrayDeque<>();
	    queue.offer(0);
	    visited[0] = true;
	    int princessCount = 1;
	    while(!queue.isEmpty()) {
	        int cur = queue.poll();
	        int x = selected[cur] / 5;
	        int y = selected[cur] % 5;
	        for (int i = 0; i < 4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	            int next = nx * 5 + ny;
	            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
	            for (int j = 0; j < 7; j++) {
	                if (!visited[j] && selected[j] == next) {
	                    visited[j] = true;
	                    princessCount++;
	                    queue.offer(j);
	                }
	            }
	        }
	    }
	    return princessCount == 7;
	}
}