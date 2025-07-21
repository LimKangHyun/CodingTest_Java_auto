import java.io.*;
import java.util.*;

public class Main {
    private static int N, K;
    private static int[] arr;
    private static boolean[] visit;
    private static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		} 
		dfs(500, 0);
		bw.write(String.valueOf(count));
		bw.flush();
	}
	private static void dfs(int weight, int depth) {
	    if (weight < 500) return;
	    if (depth == N) {
	        count++;
	        return;
	    } 
	    for (int i = 0; i < arr.length; i++) {
	        if (!visit[i]) {
	            visit[i] = true;
	            dfs(weight - K + arr[i], depth + 1);
	            visit[i] = false;
	        } 
	    } 
	}
 }