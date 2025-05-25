import java.io.*;
import java.util.*;

public class Main {
    private static int[] graph;
    private static boolean[] visit;
    private static boolean[] finish;
    private static int count;
    private static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    graph = new int[n+1];
		    visit = new boolean[n+1];
		    finish = new boolean[n+1];
		    count = 0;
		    st = new StringTokenizer(br.readLine());
		    for (int i = 1; i <= n; i++) {
		        graph[i] = Integer.parseInt(st.nextToken());
		    } 
		    for (int i = 1; i <= n; i++) {
		        if(!visit[i]) {
		            dfs(i);
		        }
		    } 
		    int result = n - count;
		    sb.append(result + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int num) {
	    visit[num] = true;
	    int next = graph[num];
	    if (!visit[next]) {
	        dfs(next);
	    } else if (!finish[next]) {
	        for (int i = next; i != num; i = graph[i]) {
	            count++;
	        } 
	        count++;
	    }
	    finish[num] = true;
	}
}