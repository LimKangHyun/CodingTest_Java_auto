import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static int cycleCount = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	    parent = new int[N + 1];
	    for (int i = 1; i <= N; i++) {
	        parent[i] = i;
	    } 
		while(M-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    if (!union(u, v)) cycleCount++;
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
		    set.add(find(i));
		} 
		bw.write(String.valueOf(cycleCount + set.size() - 1));
		bw.flush();
	}
	private static int find(int x) {
	    if (parent[x] == x) return x;
	    return parent[x] = find(parent[x]);
	}
	private static boolean union(int x, int y) {
	    int rootA = find(x);
	    int rootB = find(y);
	    if (rootA == rootB) return false;
	    parent[rootB] = rootA;
	    return true;
	}
}