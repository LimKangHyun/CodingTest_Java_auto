import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] temp;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		temp = new int[M];
		dfs(0, 0);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int depth, int start) {
	    if (depth == M) {
	        for (int num : temp) {
	            sb.append(num).append(" ");
	        }
	        sb.append("\n");
	        return;
	    }
	    int prev = -1;
	    for (int i = start; i < N; i++) {
	        if (arr[i] == prev) continue;
	        prev = arr[i];
	        temp[depth] = arr[i];
            dfs(depth + 1, i + 1);
	    }
	}
}