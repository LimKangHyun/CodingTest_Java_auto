import java.io.*;
import java.util.*;

public class Main {
    private static List<int[]>[] list;
    private static boolean[] visited;
    private static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
		    list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int weight = Integer.parseInt(st.nextToken());
		    list[a].add(new int[] {b, weight});
		    list[b].add(new int[] {a, weight});
		}
		
		for (int i = 0; i < Q; i++) {
		    st = new StringTokenizer(br.readLine());
		    int K = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    visited = new boolean[N + 1];
		    count = 0;
		    visited[v] = true;
		    dfs(K, v);
		    sb.append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int minUsado, int node) {
	    for (int[] next : list[node]) {
	        int weight = next[1];
	        if (!visited[next[0]] && weight >= minUsado) {
	            visited[next[0]] = true;
	            count++;
	            dfs(minUsado, next[0]);
	        }
	    }
	}
}