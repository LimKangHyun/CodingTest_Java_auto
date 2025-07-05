import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        int weight;
        
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    private static List<List<Edge>> tree;
    private static boolean[] visit;
    private static int maxLen = 0;
    private static int farthestNode = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int v = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		visit = new boolean[v + 1];
		for (int i = 0; i <= v; i++) {
		    tree.add(new ArrayList<>());
		} 
		for (int i = 0; i < v; i++) {
		    String[] input = br.readLine().split(" ");
		    int from = Integer.parseInt(input[0]);
		    for (int j = 1; j < input.length - 1; j += 2) {
		        int to = Integer.parseInt(input[j]);
		        int weight = Integer.parseInt(input[j+1]);
		        tree.get(from).add(new Edge(to, weight));
		    } 
		} 
		// 트리에서 어느쪽이든 가장 먼 거리를 가지는 노드 중 하나를 찾기
		visit[1] = true;
		dfs(1, 0);
		
		// 위의 계산으로 사용된 visit과 maxLen 초기화
		visit = new boolean[v + 1];
		visit[farthestNode] = true;
		maxLen = 0;
		dfs(farthestNode, 0);
		bw.write(String.valueOf(maxLen));
		bw.flush();
	}
	private static void dfs(int node, int len) {
	    if (len > maxLen) {
	        maxLen = len;
	        farthestNode = node;
	    } 
	    for (Edge edge : tree.get(node)) {
	        if (!visit[edge.to]) {
	            visit[edge.to] = true;
	            dfs(edge.to, len + edge.weight);
	        } 
	    } 
	}
}