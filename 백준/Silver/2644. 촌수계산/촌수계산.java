import java.io.*;
import java.util.*;

public class Main {
    private static int n, a, b;
    private static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= n; i++) {
		    list.add(new ArrayList<>());
		} 
		for (int i = 0; i < m; i++) {
		    st = new StringTokenizer(br.readLine());
		    int p = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    list.get(p).add(c);
		    list.get(c).add(p);
		}
		bw.write(String.valueOf(bfs()));
		bw.flush();
	}
	private static int bfs() {
	    Queue<int[]> queue = new ArrayDeque<>();
	    boolean[] visit = new boolean[n + 1];
	    queue.add(new int[] {a, 0});
	    while(!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        if (cur[0] == b) return cur[1]; 
	        for(int i = 0; i < list.get(cur[0]).size(); i++) {
	            int next = list.get(cur[0]).get(i);
	            if (!visit[next]) {
	                visit[next] = true;
	                queue.offer(new int[] {next, cur[1] + 1});
	            } 
	        }
	    }
	    return -1;
	}
}