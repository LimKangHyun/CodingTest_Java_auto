import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N + 1];
		dfs(0);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int depth) {
	    if (depth == M) {
	        for (int num : arr) {
	            sb.append(num + " ");
	        } 
	        sb.append("\n");
	        return;
	    }
	    for (int i = 1; i <= N; i++) {
	        if (visit[i]) continue;
	        arr[depth] = i;
	        visit[i] = true;
	        dfs(depth + 1);
	        visit[i] = false;
	    } 
	}
}