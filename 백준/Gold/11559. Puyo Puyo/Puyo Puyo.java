import java.io.*;
import java.util.*;

public class Main {
    private static String input;
    private static char[][] field = new char[12][6];
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int combo = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 12; i++) {
		    input = br.readLine();
		    for (int j = 0; j < 6; j++) {
		        field[i][j] = input.charAt(j);
		    }
		}
		while(true) {
		    visited = new boolean[12][6];
		    boolean isCombo = false;
		    for (int i = 0; i < 12; i++) {
		        for (int j = 0; j < 6; j++) {
		            if (field[i][j] == '.' || visited[i][j]) continue;
		            if (isPuyo(new int[] {i, j})) isCombo = true;
		        }
		    }
		    if (!isCombo) break;
		    combo++;
    		fieldSort();
		}
		bw.write(String.valueOf(combo));
		bw.flush();
	}
	private static boolean isPuyo(int[] block) {
	    List<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(block);
        list.add(block);
        visited[block[0]][block[1]] = true;
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        for (int d = 0; d < 4; d++) {
	            int nx = cur[0] + dx[d];
	            int ny = cur[1] + dy[d];
	            if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
	            if (visited[nx][ny] || field[cur[0]][cur[1]] != field[nx][ny]) continue;
	            visited[nx][ny] = true;
	            queue.offer(new int[] {nx, ny});
	            list.add(new int[] {nx, ny});
	        }
	    }
	    if (list.size() >= 4) {
	        for (int[] pos : list) {
	            field[pos[0]][pos[1]] = '.';
	        }
	        return true;
	    }
	    return false;
	}
	private static void fieldSort() {
	    for (int i = 0; i < 6; i++) {
	        List<Character> list = new ArrayList<>();
	        for (int j = 11; j >= 0; j--) {
	            if (field[j][i] == '.') continue;
	            list.add(field[j][i]);
	            field[j][i] = '.';
	        }
	        int idx = 11;
	        for (char c : list) {
	            field[idx--][i] = c;
	        }
	    }
	    
	}
}