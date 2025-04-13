import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
		    parent[i] = i;
		} 
		for (int i = 1; i <= N; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
		    for (int j = 1; j <= N; j++) {
		        int num = Integer.parseInt(st.nextToken());
		        if (num == 1) {
		            union(i, j);
		        } 
		    } 
		}
		boolean possible = true;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int prevCity = Integer.parseInt(st.nextToken());
		for (int i = 1; i < M; i++) {
		    int nextCity = Integer.parseInt(st.nextToken());
		    if (find(prevCity) != find(nextCity)) {
		        possible = false;
		        break;
		    } 
		    prevCity = nextCity;
		} 
		bw.write(possible ? "YES" : "NO");
		bw.flush();
	}
	private static int find(int x) {
	    if (x == parent[x]) return parent[x];
	    return parent[x] = find(parent[x]);
	}
	private static void union(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x != y) {
	        parent[y] = x;
	    } 
	}
}