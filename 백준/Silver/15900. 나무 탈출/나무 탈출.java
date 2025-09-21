import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] tree;
    private static boolean[] visit;
    private static int sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
		    tree[i] = new ArrayList<>();
		} 
		while(N-- > 1) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    tree[a].add(b);
		    tree[b].add(a);
		}
		dfs(1, 0);
		bw.write((sum & 1) == 1 ? "Yes" : "No"); 
		bw.flush();
	}
	private static void dfs(int node, int depth) {
	    visit[node] = true;
	    boolean isLeaf = true;
	    for (int next : tree[node]) {
	        if (visit[next]) continue;
	        isLeaf = false;
	        dfs(next, depth + 1);
	    } 
	    if (!isLeaf) return;
	    sum += depth;
	}
}