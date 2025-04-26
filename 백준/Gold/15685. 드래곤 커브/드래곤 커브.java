import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static boolean[][] map = new boolean[101][101];
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    int d = Integer.parseInt(st.nextToken());
		    int g = Integer.parseInt(st.nextToken());
		    dragonCurve(x, y, d, g);
		}
		bw.write(String.valueOf(countSquare()));
		bw.flush();
	}
	// 커브 모양에 신경쓰지말고, 다음 직선이 어느방향으로 그려지는지가 핵심
	private static void dragonCurve(int x, int y, int d, int g) {
	    List<Integer> dir = new ArrayList<>();
	    dir.add(d);
	    map[y][x] = true;
	    x += dx[d];
	    y += dy[d];
	    map[y][x] = true;
	    while(g-- > 0) {
    	    for (int i = dir.size() - 1; i >= 0; i--) {
    	        d = (dir.get(i) + 1) % 4;
    	        dir.add(d);
    	        x += dx[d];
    	        y += dy[d];
    	        map[y][x] = true;
    	    } 
	    }
	}
	private static int countSquare() {
	    int count = 0;
	    for (int i = 0; i < 100; i++) {
	        for (int j = 0; j < 100; j++) {
	            if (map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
	                count++;
	            } 
	        }
	    } 
	    return count;
	}
}