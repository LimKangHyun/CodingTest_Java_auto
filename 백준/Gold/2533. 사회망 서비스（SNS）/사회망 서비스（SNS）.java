import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] tree;
    private static int[][] dp;
    private static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
		    tree[i] = new ArrayList<>();
		} 
		for (int i = 0; i < n - 1; i++) {
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    tree[u].add(v);
		    tree[v].add(u);
		} 
		dp = new int[n+1][2];
		visit = new boolean[n+1];
		dfs(1);
		bw.write(String.valueOf(Math.min(dp[1][0], dp[1][1])));
		bw.flush();
	}
	private static void dfs(int node) {
	    visit[node] = true;
	    dp[node][0] = 0;
	    dp[node][1] = 1;
	    
	    for (int next : tree[node]) {
	        if (!visit[next]) {
	            dfs(next);
	            dp[node][0] += dp[next][1];
	            dp[node][1] += Math.min(dp[next][0], dp[next][1]);
	        } 
	    } 
	}
}