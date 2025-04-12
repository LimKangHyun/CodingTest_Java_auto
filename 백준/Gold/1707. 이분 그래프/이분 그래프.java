import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] graph;
    private static int[] color;
    private static boolean isPartite;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int V = Integer.parseInt(st.nextToken());
		    int E = Integer.parseInt(st.nextToken());
		    color = new int[V + 1];
		    isPartite = true;
		    graph = new ArrayList[V + 1];
		    for (int i = 1; i <= V; i++) {
		        graph[i] = new ArrayList<>();
		    } 
		    
		    for (int i = 0; i < E; i++) {
		        st = new StringTokenizer(br.readLine());
		        int u = Integer.parseInt(st.nextToken());
		        int v = Integer.parseInt(st.nextToken());
		        graph[u].add(v);
		        graph[v].add(u);
		    } 
		    for (int i = 1; i <= V; i++) {
		        if (color[i] == 0) {
		            if(!dfs(i, 1)) {
		                isPartite = false;
		                break;
		            }
		        } 
		    }
		    bw.write(isPartite ? "YES\n" : "NO\n");
		}
		bw.flush();
	}
	private static boolean dfs(int now, int c) {
	    color[now] = c;
	    for (int next : graph[now]) {
	        if (color[next] == 0) {
	            if(!dfs(next, -c)) return false;
	        } else if (color[now] == color[next]) {
	            return false;
	        }
	    } 
	    return true;
	}
}