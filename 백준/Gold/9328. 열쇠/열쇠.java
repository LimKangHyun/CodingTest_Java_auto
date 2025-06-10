import java.io.*;
import java.util.*;

public class Main {
    private static int h, w;
    private static char[][] map;
    private static boolean[][] visit;
    private static boolean[] keys;
    private static List<int[]>[] doors;
    private static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    h = Integer.parseInt(st.nextToken());
		    w = Integer.parseInt(st.nextToken());
		    
		    map = new char[h + 2][w + 2];
		    visit = new boolean[h + 2][w + 2];
		    keys = new boolean[26];
		    doors = new ArrayList[26];
		    for (int i = 0; i < 26; i++) doors[i] = new ArrayList<>(); 
		    
		    for (int i = 1; i <= h; i++) {
		        String input = br.readLine();
		        for (int j = 1; j <= w; j++) {
		            map[i][j] = input.charAt(j - 1);
		        } 
		    } 
		    String keyInput = br.readLine();
		    if (!keyInput.equals("0")) {
		        for (char c : keyInput.toCharArray()) {
		            keys[c - 'a'] = true;
		        } 
		    } 
		    sb.append(bfs() + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static int bfs() {
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[] {0, 0});
	    visit[0][0] = true;
	    int count = 0;
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        int x = cur[0];
	        int y = cur[1];
	        for (int i = 0; i < 4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	            if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2) continue;
	            if (visit[nx][ny] || map[nx][ny] == '*') continue;
	            visit[nx][ny] = true;
	            char c = map[nx][ny];
	            if (c >= 'A' && c <= 'Z') {
	                if (keys[c - 'A']) {
	                    queue.add(new int[] {nx, ny});
	                } else {
	                    doors[c - 'A'].add(new int[] {nx, ny});
	                }
	            } else if (c >= 'a' && c <= 'z') {
	                queue.add(new int[] {nx, ny});
	                if (!keys[c - 'a']) {
	                    keys[c - 'a'] = true;
	                    for (int[] pos : doors[c - 'a']) { // 막혔던 문들의 위치 불러오기
	                        queue.add(pos); // 막혔던 문 부터 다시 bfs
	                    } 
	                    doors[c - 'a'].clear();
	                } 
	            } else if (c == '$') {
	                count++;
	                queue.add(new int[] {nx, ny});
	            } else {
	                queue.add(new int[] {nx, ny});
	            }
	        } 
	    }
	    return count;
	}
}