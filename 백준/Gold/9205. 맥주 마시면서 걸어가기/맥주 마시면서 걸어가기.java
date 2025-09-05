import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] home;
    static int[][] store;
    static int[] pentaport;
    static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		while(t-- >0) {
		    n = Integer.parseInt(br.readLine());
		    store = new int[n][2];
		    visit = new boolean[n];
		    for (int i = 0; i < n + 2; i++) {
		        st = new StringTokenizer(br.readLine());
		        int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());
	            if (i == 0) {
	                home = new int[] {x, y};
	            } else if (i == n + 1) {
	                pentaport = new int[] {x, y};
	            } else {
                    store[i - 1][0] = x;
                    store[i - 1][1] = y;
	            }
		    } 
		    sb.append(dfs(home[0], home[1]) ? "happy\n" : "sad\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static boolean dfs(int x, int y) {
	    if (Math.abs(x - pentaport[0]) + Math.abs(y - pentaport[1]) <= 1000) return true; 
	    for (int i = 0; i < n; i++) {
	        if (!visit[i]) {
	            if (Math.abs(x - store[i][0]) + Math.abs(y - store[i][1]) <= 1000) {
	                visit[i] = true;
	                if (dfs(store[i][0], store[i][1])) return true;
	            }
	        } 
	    }
	    return false;
	}
}