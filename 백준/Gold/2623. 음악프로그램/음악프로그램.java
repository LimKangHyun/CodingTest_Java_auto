import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static List<Integer> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    String[] input = br.readLine().split(" ");
	    N = Integer.parseInt(input[0]); // 가수
	    int M = Integer.parseInt(input[1]); // pd
	    List<Integer>[] graph = new ArrayList[N+1];
	    int[] inDegree = new int[N+1];
	    
	    for (int i = 1; i <= N; i++) {
	        graph[i] = new ArrayList<>();
	    } 
	    for (int i = 0; i < M; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int num = Integer.parseInt(st.nextToken());
	        int before = Integer.parseInt(st.nextToken());
	        for (int j = 1; j < num; j++) {
	            int singer = Integer.parseInt(st.nextToken());
	            graph[before].add(singer);
	            inDegree[singer]++;
	            before = singer;
	        } 
	    } 
	    bw.write(topology(graph, inDegree));
		bw.flush();
	}
	private static String topology(List<Integer>[] graph, int[] inDegree) {
	    Queue<Integer> queue = new LinkedList<>();
	    for (int i = 1; i < inDegree.length; i++) {
	        if (inDegree[i] == 0) {
	            queue.offer(i);
	        } 
	    } 
	    while(!queue.isEmpty()) {
	        int current = queue.poll();
	        result.add(current);
	        for (int next : graph[current]) {
	            if (--inDegree[next] == 0) {
	                queue.offer(next);
	            }
	        } 
	    }
	    if (result.size() != N) {
	        return "0";
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int s : result) {
	        sb.append(s + "\n");
	    }
	    return sb.toString();
	}
}