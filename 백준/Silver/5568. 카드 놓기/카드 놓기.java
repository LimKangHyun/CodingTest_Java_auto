import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();
    static int[] arr;
    static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n;  i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		}
		dfs(0);
		bw.write(String.valueOf(set.size()));
		bw.flush();
	}
	private static void dfs(int depth) {
	    if (depth == k) {
	        set.add(sb.toString());
	        return;
	    }
	    for (int i = 0; i < n; i++) {
	        if (visited[i]) continue;
	        visited[i] = true;
	        int prev = sb.length();
	        sb.append(arr[i]);
	        dfs(depth + 1);
	        sb.setLength(prev);
	        visited[i] = false;
	    }
	}
}