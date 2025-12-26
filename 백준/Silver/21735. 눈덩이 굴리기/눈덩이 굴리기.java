import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0, 1);
		bw.write(String.valueOf(max));
		bw.flush();
	}
	private static void dfs(int depth, int start, int snow) {
	    if (depth == M || start == N) {
	        max = Math.max(max, snow);
	        return;
	    }
	    if (start + 1 <= N) dfs(depth + 1, start + 1, snow + arr[start + 1]);
        if (start + 2 <= N) dfs(depth + 1, start + 2, snow / 2 + arr[start + 2]);
	}
}