import java.io.*;
import java.util.*;

public class Main {
    static int N, LOG;
    static List<int[]>[] tree;
    static int[][] parent;
    static int[] depth;
    static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		LOG = (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
		    tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    tree[u].add(new int[] {v, w});
		    tree[v].add(new int[] {u, w});
		}
		parent = new int[LOG + 1][N + 1]; // N개의 노드에 대해 최대깊이 LOG까지 2의 제곱 단위의 부모 노드를 저장하는 배열
		depth = new int[N + 1]; // 루트 노드로부터 각 노드에 대한 거리(몇개의 노드를 거쳐야 하는지)
		dist = new int[N + 1];
		dfs(1, 0);
		buildParent();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int lca = findLca(a, b);
		    int answer = dist[a] + dist[b] - 2 * dist[lca]; // 두 노드 사이의 거리 구하기
		    sb.append(answer).append('\n');
		}
	    bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int node, int par) {
	    parent[0][node] = par; // 1은 루트이므로 부모가 없다. 따라서 0을 삽입
	    for (int[] next : tree[node]) {
	        int v = next[0];
	        int weight = next[1];
	        if (v == par) continue;
	        depth[v] = depth[node] + 1;
	        dist[v] = dist[node] + weight;
	        dfs(v, node);
	    }
	}
	private static void buildParent() {
	    for (int k = 1; k <= LOG; k++) {
	        for (int i = 1; i <= N; i++) {
	            parent[k][i] = parent[k - 1][parent[k - 1][i]];
	        }
	    }
	}
	private static int findLca(int a, int b) {
	    if (depth[a] < depth[b]) { // a를 깊게
	        int temp = a;
	        a = b;
	        b = temp;
	    }
	    int diff = depth[a] - depth[b];
	    for (int k = 0; k <= LOG; k++) {
	        if ((diff & (1 << k)) != 0) { // 높이 맞춰주기
	            a = parent[k][a];
	        }
	    }
	    if (a == b) return a;
	    for (int k = LOG; k >= 0; k--) {
	        if (parent[k][a] != parent[k][b]) {
	            a = parent[k][a];
	            b = parent[k][b];
	        }
	    }
	    return parent[0][a];
	}
}