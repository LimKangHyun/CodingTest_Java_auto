import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
		    list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int start = Integer.parseInt(st.nextToken());
		    int end = Integer.parseInt(st.nextToken());
		    list[start].add(end);
		}
		int[] dist = new int[N + 1];
		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(X);
		while(!queue.isEmpty()) {
		    int cur = queue.poll();
		    for (int next : list[cur]) {
		        if (next != X && dist[next] == 0) {
		            dist[next] = dist[cur] + 1;
		            queue.offer(next);
		        }
		    }
		}
		for (int i = 1; i <= N; i++) {
		    if (dist[i] == K) sb.append(i).append("\n");
		}
		if (sb.length() == 0) bw.write(String.valueOf(-1));
		else bw.write(sb.toString());
		bw.flush();
	}
}