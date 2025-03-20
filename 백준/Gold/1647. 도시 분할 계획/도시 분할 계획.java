import java.io.*;
import java.util.*;
public class Main {
    private static int N, M;
    private static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
		    parent[i] = i;
		} 
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken()); //weight
		    pq.offer(new int[] {a, b, c});
		} 
		
		// 크루스칼 알고리즘
		int total = 0;
		int max = 0;
		for (int i = 0; i < M; i++) {
            int[] current = pq.poll();
            int start = find(current[0]);
            int end = find(current[1]);
            if (!isSameParent(start, end)) {
                total += current[2];
                union(start, end);
                max = Math.max(max, current[2]);
            } 
		} 
		bw.write(String.valueOf(total - max));
		bw.flush();
	}
	
	private static void union(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x != y) {
	        parent[y] = x;
	    } 
	}
	private static int find(int x) {
	    if (parent[x] == x) return x;
	    return parent[x] = find(parent[x]);
	}
	
	private static boolean isSameParent(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if(x == y) {
	        return true;
	    }
	    return false;
	}
}