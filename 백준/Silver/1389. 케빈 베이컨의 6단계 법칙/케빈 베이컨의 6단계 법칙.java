import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dist = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
		    for (int j = 1; j <= n; j++) {
		        dist[i][j] = Integer.MAX_VALUE;
		        if (i == j) dist[i][j] = 0; 
		    } 
		} 
		for (int i = 0; i < m; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    dist[a][b] = dist[b][a] = 1;
		} 
		floyd();
		int max = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 1; i <= n; i++) {
		    int total = 0;
		    for (int j = 1; j <= n; j++) {
		        total += dist[i][j];
		    } 
		    if (max > total) {
		        max = total; 
		        idx = i;
		    }
		} 
		bw.write(String.valueOf(idx));
		bw.flush();
	}
	private static void floyd() {
	    for (int k = 1; k <= n; k++) {
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n; j++) {
	                if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
	                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
    	                    dist[i][j] = dist[i][k] + dist[k][j];
    	                } 
	                } 
	            } 
	        } 
	    } 
	}
}