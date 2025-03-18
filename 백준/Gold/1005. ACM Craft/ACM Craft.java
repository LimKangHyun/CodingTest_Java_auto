import java.io.*;
import java.util.*;

public class Main {
    private static int N, K;
    private static List<Integer>[] graph;
    private static int[] time;
    private static int[] inDegree;
    private static int[] dp;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
	    while (t-- > 0) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());
	        graph = new ArrayList[N+1];
	        
	        time = new int[N+1];
	        inDegree = new int[N+1];
	        dp = new int[N+1];
	        
	        st = new StringTokenizer(br.readLine());
	        for (int i = 1; i <= N; i++) {
	            time[i] = Integer.parseInt(st.nextToken());
	            graph[i] = new ArrayList<>();
	        } 
	        
	        for (int i = 0; i < K; i++) {
	            st = new StringTokenizer(br.readLine());
	            int start = Integer.parseInt(st.nextToken());
	            int end = Integer.parseInt(st.nextToken());
	            graph[start].add(end);
	            inDegree[end]++;
	        } 
	        
	        int W = Integer.parseInt(br.readLine());
	        sb.append(findMinValue(W)).append("\n");
	    } 
	    bw.write(sb.toString());
		bw.flush();
	}
	private static int findMinValue(int w) {
	    //작은것부터 정렬을 해야 최소 시간을 구하면서 w까지 도달
	    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));//오름차순
	    for (int i = 1; i <= N; i++) {
	        if (inDegree[i] == 0) {
	            pq.offer(new int[] {i, time[i]});
	            dp[i] = time[i];
	        } 
	    }  
	    while(!pq.isEmpty()) {
	        int current[] = pq.poll();
	        int crtNode = current[0];
	        int crtTime = current[1];
	        if (crtNode == w) {
	            return crtTime;
	        } 
	        
	        for (int next : graph[crtNode]) {
	            dp[next] = Math.max(dp[next], crtTime + time[next]);
	            //해당 건물을 짓기위해 지어야 하는 경우의 수를 모두 비교
	            if(--inDegree[next] == 0) {
	                pq.offer(new int[] {next, dp[next]});
	            }
	        } 
	    }
	    return dp[w];
	}
}