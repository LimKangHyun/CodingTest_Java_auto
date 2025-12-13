import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        arr[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		floyd();
		visited[K] = true;
		findMinDist(K, 0, 0);
		bw.write(String.valueOf(min));
		bw.flush();
	}
	private static void floyd() {
	    for (int k = 0; k < N; k++) {
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
	            }
	        }
	    }
	}
	private static void findMinDist(int start, int depth, int dist) {
	    if (depth == N - 1) {
	        min = Math.min(min, dist);
	        return;
	    }
	    for (int i = 0; i < N; i++) {
	        if (visited[i]) continue;
	        if (i == start) continue;
	        visited[i] = true;
	        findMinDist(i, depth + 1, dist + arr[start][i]);
	        visited[i] = false;
	    }
	}
}