import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static int[][] dist;
    static List<int[]>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		dist = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++) {
		    Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
		    graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    dist[a][b] = c;
		}
		floid();
		bw.write(String.valueOf(findMinCycle()));
		bw.flush();
	}
	private static void floid() {
	    for (int k = 1; k <= V; k++) {
	        for (int i = 1; i <= V; i++) {
	            for (int j = 1; j <= V; j++) {
	                if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
	                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
	            }
	        }
	    }
	}
	private static int findMinCycle() {
	    int answer = Integer.MAX_VALUE;
	    for (int i = 1; i <= V; i++) {
	        for (int j = 1; j <= V; j++) {
	            if (i == j) continue;
	            if (dist[i][j] != Integer.MAX_VALUE && dist[j][i] != Integer.MAX_VALUE) {
	                answer = Math.min(answer, dist[i][j] + dist[j][i]);
	            }
	        }
	    }
	    return answer == Integer.MAX_VALUE ? -1 : answer;
	}
}