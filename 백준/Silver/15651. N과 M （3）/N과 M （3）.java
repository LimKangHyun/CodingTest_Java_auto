import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		arr = new int[N];
		dfs(0);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int depth) {
	    if (depth == M) {
	        for (int i = 0; i < M; i++) {
	            sb.append(arr[i] + " ");
	        }
	        sb.append("\n");
	        return;
	    }
	    for (int i = 1; i <= N; i++) {
	        arr[depth] = i;
	        dfs(depth + 1);
	    }
	}
}