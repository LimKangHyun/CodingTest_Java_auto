import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] synergy;
    private static boolean[] visit;
    private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		synergy = new int[N][N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        synergy[i][j] = Integer.parseInt(st.nextToken());
		    } 
		} 
		visit[0] = true;
		dfs(1, 1);
		bw.write(String.valueOf(min));
		bw.flush();
	}
	private static void dfs(int depth, int start) {
	    if (min == 0) return; 
	    if (depth == N / 2) {
	        min = Math.min(min, getDiff());
	        return;
	    } 
	    for (int i = start; i < N; i++) {
	        visit[i] = true;
            dfs(depth+1, i+1);
            visit[i] = false;
	    } 
	}
	private static int getDiff() {
	    int start = 0;
	    int link = 0;
	    for (int i = 0; i < N - 1; i++) {
	        for (int j = i + 1; j < N; j++) {
	            if (visit[i] && visit[j]) {
	                start += synergy[i][j] + synergy[j][i];
	            } 
	            else if(!visit[i] && !visit[j]) {
	                link += synergy[i][j] + synergy[j][i];
	            }
	        } 
	    } 
	    return Math.abs(start - link);
	}
}