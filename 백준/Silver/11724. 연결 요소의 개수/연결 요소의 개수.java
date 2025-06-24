import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    parent = new int[n+1];
	    rank = new int[n+1];
	    for (int i = 1; i <= n; i++) {
		    parent[i] = i;
		    rank[i] = 0;
		} 

	    for (int i = 0; i < m; i++) {
	        st = new StringTokenizer(br.readLine());
	        int u = Integer.parseInt(st.nextToken());
	        int v = Integer.parseInt(st.nextToken());
	        union(u, v);
	    } 
	    Set<Integer> set = new HashSet<>();
	    for (int i = 1; i <= n; i++) {
	        set.add(find(i));
	    }  
		bw.write(String.valueOf(set.size()));
		bw.flush();
	}
	private static int find(int x) {
	    if (parent[x] != x) return parent[x] = find(parent[x]);
	    return parent[x];
	}
	private static void union(int x, int y) {
	    int rootX = find(x);
	    int rootY = find(y);
	    if (rootX == rootY) return;
	    parent[rootY] = rootX;
	}
}