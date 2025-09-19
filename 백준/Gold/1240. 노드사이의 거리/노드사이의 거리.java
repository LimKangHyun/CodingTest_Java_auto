import java.io.*;
import java.util.*;

public class Main {
    private static List<int[]>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
		    tree[i] = new ArrayList<>();
		} 
		while(N-- > 1) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int weight = Integer.parseInt(st.nextToken());
		    tree[a].add(new int[] {b, weight});
		    tree[b].add(new int[] {a, weight});
		}
		while(M-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    sb.append(dfs(u, v, 0, 0)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static int dfs(int node, int end, int parent, int length) {
	    if (node == end) {
	        return length;
	    } 
	    for (int[] edge : tree[node]) {
	        int next = edge[0];
	        int weight = edge[1];
	        if (next == parent) continue;
	        int result = dfs(next, end, node, length + weight);
	        if (result != -1) {
	            return result;
	        }
	    } 
	    return -1;
	}
}