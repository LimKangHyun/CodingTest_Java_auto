import java.util.*;
import java.io.*;

public class Main {
    private static int r, c;
    private static int total = 0;
    private static String[] input;
    private static int[][] arr;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int time = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input = br.readLine().split(" ");
		r = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
		    input = br.readLine().split(" ");
		    for (int j = 0; j < c; j++) {
		        arr[i][j] = Integer.parseInt(input[j]);
		        if (arr[i][j] == 1) total++;
		    }
		}
		int lastCheese = 0;
		while(total > 0) {
            lastCheese = total;
		    markOutside();
		    melt();
		    time++;
		}
		bw.write(String.valueOf(time));
		bw.newLine();
		bw.write(String.valueOf(lastCheese));
		bw.flush();
	}
	private static void markOutside() {
	    Queue<int[]> queue = new ArrayDeque<>();
	    for (int i = 0; i < r; i++) {
	        for (int j = 0; j < c; j++) {
	            if (arr[i][j] == -1) arr[i][j] = 0;
	        }
	    }
	    arr[0][0] = -1; // -1이면 outside
	    queue.offer(new int[] {0, 0});
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        for (int d = 0; d < 4; d++) {
	            int nx = cur[0] + dx[d];
	            int ny = cur[1] + dy[d];
	            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
	            if (arr[nx][ny] == -1 || arr[nx][ny] == 1) continue;
	            arr[nx][ny] = -1;
	            queue.offer(new int[] {nx, ny});
	        }
	    }
	}
	private static void melt() {
	    List<int[]> list = new ArrayList<>();
	    for (int i = 1; i < r - 1; i++) {
	        for (int j = 1; j < c - 1; j++) {
	            if (arr[i][j] != 1) continue;
	            for (int d = 0; d < 4; d++) {
    	            int nx = i + dx[d];
    	            int ny = j + dy[d];
    	            if (arr[nx][ny] == -1) {
    	                list.add(new int[] {i, j});
    	                break;
    	            }
	            }
	        }
	    }
	    for (int[] pos : list) {
	        arr[pos[0]][pos[1]] = 0;
            total--;
	    }
	}
}