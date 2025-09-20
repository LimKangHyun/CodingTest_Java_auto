import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] tree;
    private static int[][] parent;
    private static int[] depths;
    private static int[] above;
    private static int maxDepthLog;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		depths = new int[N + 1];
		above = new int[N + 1];
		tree = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
		    tree[i] = new ArrayList<>();
		} 
		for(int i = 0; i < N - 1; i++) {
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    tree[u].add(v);
		    tree[v].add(u);
		} 
		dfs(1, 0, 0); // 1을 루트노드로 설정
		maxDepthLog = (int) Math.ceil(Math.log(maxDepthLog) / Math.log(2));
		parent = new int[maxDepthLog][N + 1];
		parent[0] = above;
		for (int i = 1; i <maxDepthLog; i++) {
		    for (int j = 1; j <= N; j++) {
		        parent[i][j] = parent[i - 1][parent[i - 1][j]];
		    } 
		} 
		int M = Integer.parseInt(br.readLine());
		while(M-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    sb.append(findLCA(a, b)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int node, int depth, int parent) {
	    depths[node] = depth;
	    above[node] = parent;
	    maxDepthLog = Math.max(maxDepthLog, depth);
	    for (int next : tree[node]) {
	        if (next == parent) continue;
	        dfs(next, depth + 1, node);
	    } 
	}
	private static int findLCA(int a, int b) {
	    if (depths[a] < depths[b]) { // 무조건 a가 깊게
	        int temp = a;
	        a = b;
	        b = temp;
	    }
	    for (int i = maxDepthLog; i >= 0; i--) {
	        if (depths[a] - depths[b] >= 1 << i) {
	            a = parent[i][a];
	        }
	    } 
	    if (a == b) return a; 
	    for (int i = maxDepthLog - 1; i >= 0; i--) {
	        if (parent[i][a] != parent[i][b]) {
	            a = parent[i][a];
	            b = parent[i][b];
	        } 
	    } 
	    return parent[0][a];
	}
}