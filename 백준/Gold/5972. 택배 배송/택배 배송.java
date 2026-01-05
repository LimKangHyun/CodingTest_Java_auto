import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dist;
    static List<int[]>[] graph;
    static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
		    graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int start = Integer.parseInt(st.nextToken());
		    int end = Integer.parseInt(st.nextToken());
		    int weight = Integer.parseInt(st.nextToken());
		    graph[start].add(new int[] {end, weight});
		    graph[end].add(new int[] {start, weight});
		}
		dijkstra(1);
		bw.write(String.valueOf(dist[N]));
		bw.flush();
	}
	private static void dijkstra(int start) {
        // weight가 큰 순서
        // 오버플로우 방지 : PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
	    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
	    dist[1] = 0;
	    pq.offer(new int[] {1, 0});
	    
	    while (!pq.isEmpty()) {
	        int[] cur = pq.poll();
	        int curNode = cur[0];
	        int curWeight = cur[1];
	        if (dist[curNode] < curWeight) continue; // 더 짧은 경로가 있다면 스킵
	        if (curNode == N) return;
	        for (int[] edge : graph[curNode]) {
	            int nextNode = edge[0];
	            int weight = edge[1];
	            int nextWeight = dist[curNode] + weight;
	            if (dist[nextNode] > nextWeight) {
	                dist[nextNode] = nextWeight;
	                pq.offer(new int[] {nextNode, nextWeight});
	            }
	        }
	    }
	}
}