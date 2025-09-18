import java.io.*;
import java.util.*;

public class Main { 
    private static List<List<Integer>> tree;
    private static Queue<int[]> queue;
    private static boolean[] visit;
    private static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int idx = 1;
		while(true) {
		    st = new StringTokenizer(br.readLine());
		    n = Integer.parseInt(st.nextToken());
		    int m = Integer.parseInt(st.nextToken());
		    if (n == 0) break;
		    
		    tree = new ArrayList<>();
		    visit = new boolean[n + 1];
		    for (int i = 0; i <= n; i++) {
		        tree.add(new ArrayList<>());
		    } 
		    while(m-- > 0) {
		        st = new StringTokenizer(br.readLine());
		        int a = Integer.parseInt(st.nextToken());
		        int b = Integer.parseInt(st.nextToken());
		        tree.get(a).add(b);
		        tree.get(b).add(a);
		    }
		    int count = 0;
		    for (int i = 1; i <= n; i++) {
		        if (!visit[i] && bfs(i)) count++;
		    } 
		    sb.append("Case ").append(idx++).append(": ");
		    if (count == 0) sb.append("No trees.").append("\n");
		    else if (count == 1) sb.append("There is one tree.").append("\n"); 
		    else sb.append("A forest of ").append(count).append(" trees.").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static boolean bfs(int start) {
	    queue = new ArrayDeque<>();
	    visit[start] = true;
	    queue.offer(new int[] {start, 0});
	    boolean isTree = true;
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        int node = cur[0];
	        int parent = cur[1];
	        for (int next : tree.get(node)) {
	            if (!visit[next]) {
	                visit[next] = true;
	                queue.offer(new int[] {next, node});
	            } else if (next != parent) {
	                isTree = false;
	            }
	        } 
	    }
	    return isTree;
	}
}