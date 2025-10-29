import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int Q;
    static int K;
    static List<int[]>[] graph;
    static boolean[] visited;
    static int cnt = 0;
    private static void dfs(int cur, int minWeight) {
        visited[cur] = true;
        for(int i=0;i<graph[cur].size();i++){
            int[] node = graph[cur].get(i);
            if(visited[node[0]]) continue;
            int next = node[0];
            int weight = node[1];
            if(Math.min(weight, minWeight) >= K) cnt++;
            if(Math.min(weight, minWeight) < K) continue;
            dfs(next, Math.min(weight, minWeight));
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for(int i=1;i<=N;i++){
		    graph[i] = new ArrayList<>();
		}
		for(int i=0;i<N-1;i++){
		    st = new StringTokenizer(br.readLine());
		    int n1 = Integer.parseInt(st.nextToken());
		    int n2 = Integer.parseInt(st.nextToken());
		    int weight = Integer.parseInt(st.nextToken());
		    graph[n1].add(new int[]{n2, weight});
		    graph[n2].add(new int[]{n1, weight});
		}
		while(Q-->0) {
		    cnt=0;
		    visited = new boolean[N+1];
		    st = new StringTokenizer(br.readLine());
		    K = Integer.parseInt(st.nextToken());
		    int start = Integer.parseInt(st.nextToken());
		    dfs(start, Integer.MAX_VALUE);
		    sb.append(cnt+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}