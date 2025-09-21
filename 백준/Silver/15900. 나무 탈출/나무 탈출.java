import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] tree;
    private static boolean[] visit;
    private static int sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
		    tree[i] = new ArrayList<>();
		} 
		while(N-- > 1) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    tree[a].add(b);
		    tree[b].add(a);
		}
		bfs();
		bw.write((sum % 2) == 1 ? "Yes" : "No"); 
		bw.flush();
	}
	private static void bfs() {
	    visit[1] = true;
	    Queue<int[]> queue = new ArrayDeque<>();
	    queue.offer(new int[] {1, 0});
	    while(!queue.isEmpty()) {
	        boolean isLeaf = true;
	        int[] cur = queue.poll();
	        for (int next : tree[cur[0]]) {
	            if (visit[next]) continue;
	            visit[next] = true;
	            isLeaf = false;
	            queue.offer(new int[] {next, cur[1] + 1});
	        }
	        if (isLeaf) sum += cur[1];
	    } 
	}
}