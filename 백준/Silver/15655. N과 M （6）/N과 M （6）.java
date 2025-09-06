import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] temp;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		} 
		Arrays.sort(arr);
		temp = new int[M];
		visit = new boolean[N];
		dfs(0, 0);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int depth, int idx) {
	    if (depth == M) {
	        for (int num : temp) {
	            sb.append(num + " ");
	        } 
	        sb.append("\n");
	        return;
	    }
	    for (int i = idx; i < N; i++) {
	        if (visit[i]) continue;
	        visit[i] = true;
	        temp[depth] = arr[i];
	        dfs(depth + 1, i + 1);
	        visit[i] = false;
	    } 
	}
}