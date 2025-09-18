import java.io.*;
import java.util.*;

public class Main { 
    private static int n;
    private static int[] parent;
    private static boolean[] hasCycle;
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
		    
		    parent = new int[n + 1];
		    hasCycle = new boolean[n + 1];
		    for (int i = 1; i <= n; i++) {
		        parent[i] = i;
		    } 
		    while(m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
    		    if (union(a, b)) {
    		        hasCycle[find(a)] = true;
    		    }
		    }
		    int count = 0;
		    for (int i = 1; i <= n; i++) {
		        int root = find(i);
		        if (root == i && !hasCycle[i]) count++;
		    } 
		    sb.append("Case ").append(idx++).append(": ");
		    if (count == 0) sb.append("No trees.").append("\n");
		    else if (count == 1) sb.append("There is one tree.").append("\n"); 
		    else sb.append("A forest of ").append(count).append(" trees.").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static int find(int x) {
	    if (parent[x] == x) return x;
	    return parent[x] = find(parent[x]);
	}
	private static boolean union(int a, int b) {
	    int rootA = find(a);
	    int rootB = find(b);
	    if (rootA == rootB) return true;
	    parent[rootB] = rootA;
	    hasCycle[rootA] = hasCycle[rootA] || hasCycle[rootB];
	    return false;
	}
}