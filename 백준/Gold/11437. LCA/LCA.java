import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> tree;
    private static int[] parent;
    private static int[] depth;
    private static HashSet<Integer> setA = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		depth = new int[N + 1];
		tree = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
		    tree.add(new ArrayList<>());
		} 
		for(int i = 0; i < N - 1; i++) {
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    tree.get(u).add(v);
		    tree.get(v).add(u);
		} 
		setParentAndDepth(1);
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
	private static void setParentAndDepth(int start) {
	    Queue<Integer> queue = new ArrayDeque<>();
	    boolean[] visit = new boolean[parent.length];
	    queue.add(start);
	    visit[start] = true;
	    parent[start] = 0;
	    depth[start] = 0;
	    while(!queue.isEmpty()) {
	        int cur = queue.poll();
	        for (int next : tree.get(cur)) {
	            if (visit[next]) continue;
	            visit[next] = true;
	            parent[next] = cur;
	            depth[next] = depth[cur] + 1;
	            queue.add(next);
	        } 
	    }
	}
	private static int findLCA(int a, int b) {
	    if (depth[a] < depth[b]) { // 무조건 a가 깊게
	        int temp = a;
	        a = b;
	        b = temp;
	    }
	    while (depth[a] > depth[b]) a = parent[a];
	    while (a != b) {
	        a = parent[a];
	        b = parent[b];
	    }
	    return a;
	}
}