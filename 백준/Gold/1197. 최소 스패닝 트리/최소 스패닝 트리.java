import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int parent[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
		    parent[i] = i;
		} 
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		for (int i = 0; i < M; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    pq.add(new int[] {a, b, c});
		}
		int total = 0;
		for (int i = 0; i < M; i++) {
		    int[] current = pq.poll();
		    int start = find(current[0]);
		    int end = find(current[1]);
		    if (!isSameParent(start, end)) {
		        total += current[2];
		        union(current[0], current[1]);
		    } 
		} 
		bw.write(String.valueOf(total));
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
	    if(parent[x] == x) return x;
	    return parent[x] = find(parent[x]); 
	}
	private static boolean isSameParent(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x == y) {
	        return true;
	    } else {
	        return false;
	    }
	}
}