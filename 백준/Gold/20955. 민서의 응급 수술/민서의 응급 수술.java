import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph;
    private static boolean[] visit;
    private static int nodeCount, edgeCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
		    graph.add(new ArrayList<>());
		} 
		visit = new boolean[N + 1];
		while(M-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    graph.get(u).add(v);
		    graph.get(v).add(u);
		}
		int setCount = 0;
		int removeCount = 0; // 사이클 없애기 용
		for (int i = 1; i <= N; i++) {
		    if (visit[i]) continue;
		    nodeCount = 0;
		    edgeCount = 0;
		    dfs(i);
		    edgeCount /= 2;
		    removeCount += edgeCount - (nodeCount - 1); // 트리는 노드가 N, 간선이 N - 1
		    setCount++;
		} 
		bw.write(String.valueOf(removeCount + setCount - 1));
		bw.flush();
	}
	private static void dfs(int node) {
	    visit[node] = true;
	    nodeCount++;
	    for (int next : graph.get(node)) {
	        edgeCount++;
	        if (visit[next]) continue;
	        dfs(next);
	    } 
	}
}