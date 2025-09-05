import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Queue<Integer> queue;
    static int[][] map;
    static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		while(t-- >0) {
		    n = Integer.parseInt(br.readLine());
		    map = new int[n + 2][2];
		    for (int i = 0; i < n + 2; i++) {
		        st = new StringTokenizer(br.readLine());
		        int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());
                map[i][0] = x;
                map[i][1] = y;
		    } 
		    sb.append(bfs() ? "happy\n" : "sad\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static boolean bfs() {
	    queue = new ArrayDeque<>();
	    visit = new boolean[n + 2];
	    queue.offer(0);
	    while(!queue.isEmpty()) {
	        int cur = queue.poll();
	        if (cur == n + 1) return true; 
	        for (int i = 1; i < n + 2; i++) { // 집 제외
	            if (visit[i] || Math.abs(map[i][0] - map[cur][0]) + Math.abs(map[i][1] - map[cur][1]) > 1000) continue;
                visit[i] = true;
                queue.offer(i);
	        } 
	    }
	    return false;
	}
}