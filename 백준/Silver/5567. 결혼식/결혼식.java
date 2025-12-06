import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<Integer>[] list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
		    list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    list[a].add(b);
		    list[b].add(a);
		}
		int dist = 0;
		int count = 0;
		boolean[] visited = new boolean[n + 1];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {1, 0});
		visited[1] = true;
		while(!queue.isEmpty()) {
		    int[] cur = queue.poll();
		    int node = cur[0];
		    int depth = cur[1];
		    if (depth == 2) continue;
		    for (int next : list[node]) {
		        if (visited[next]) continue;
		        visited[next] = true;
		        count++;
		        queue.offer(new int[] {next, depth + 1});
		    }
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}