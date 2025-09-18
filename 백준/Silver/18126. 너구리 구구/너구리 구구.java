import java.io.*;
import java.util.*;

class Edge {
    int to;
    long weight;
    
    Edge(int to, long weight) {
        this.to = to;
        this.weight = weight;
    }
}
public class Main { 
    private static List<Edge>[] tree;
    private static long maxLength = 0;
    private static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
		    tree[i] = new ArrayList<>();
		} 
		while(N-- > 1) {
		    st = new StringTokenizer(br.readLine());
		    int A = Integer.parseInt(st.nextToken());
		    int B = Integer.parseInt(st.nextToken());
		    int C = Integer.parseInt(st.nextToken());
		    tree[A].add(new Edge(B, C));
		    tree[B].add(new Edge(A, C));
		}
		dfs(1, 0);
		bw.write(String.valueOf(maxLength));
		bw.flush();
	}
	private static void dfs(int start, long length) {
	    visit[start] = true;
	    maxLength = Math.max(length, maxLength);
	    for (Edge e : tree[start]) {
	        if (visit[e.to]) continue;
	        dfs(e.to, length + e.weight);
	    }
	}
}