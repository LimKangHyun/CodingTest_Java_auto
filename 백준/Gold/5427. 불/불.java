import java.io.*;
import java.util.*;

public class Main {
    private static int w, h, count;
    private static char[][] map;
    private static Queue<int[]> person;
	private static Queue<int[]> fire;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-- > 0) {
		     st = new StringTokenizer(br.readLine());
		     w = Integer.parseInt(st.nextToken());
		     h = Integer.parseInt(st.nextToken());
		     map = new char[h][w];
		     person = new LinkedList<>();
		     fire = new LinkedList<>();
		     for (int i = 0; i < h; i++) {
		         String input = br.readLine();
		         for (int j = 0; j < w; j++) {
		             char c = input.charAt(j);
		             if (c == '*') {
		                 fire.offer(new int[] {i, j});
		             } else if(c == '@') {
		                 person.offer(new int[] {i, j, 0});
		             }
		             map[i][j] = c;
		         } 
		     } 
		     count = 0;
		     bfs();
		     if (count == 0) sb.append("IMPOSSIBLE\n");
		     else sb.append(count + "\n");
		     
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static void bfs() {
	    while(!person.isEmpty()) {
	        int fsize = fire.size();
	        for (int i = 0; i < fsize; i++) {
	            int[] cur = fire.poll();
	            for (int j = 0; j < 4; j++) {
	                int nx = cur[0] + dx[j];
	                int ny = cur[1] + dy[j];
	                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
	                if (map[nx][ny] != '#' && map[nx][ny] != '*') {
	                    map[nx][ny] = '*';
	                    fire.offer(new int[] {nx, ny});
	                }
	            } 
	        } 
	        int psize = person.size();
	        for (int k = 0; k < psize; k++) {
	            int[] per = person.poll();
    	        for (int l = 0; l < 4; l++) {
    	            int nx = per[0] + dx[l];
    	            int ny = per[1] + dy[l];
    	            if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
    	                count = per[2] + 1;
    	                return;
    	            }
    	            if (map[nx][ny] == '.') {
    	                map[nx][ny] = '@';
    	                person.offer(new int[] {nx, ny, per[2] + 1});
    	            }
    	        } 
	        } 
	    }
	}
}