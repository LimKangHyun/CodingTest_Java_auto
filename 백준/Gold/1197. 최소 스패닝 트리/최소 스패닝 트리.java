import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visit;
    static List<int[]>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		visit = new boolean[N+1];
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
		    list[i] = new ArrayList<>();
		} 
		for (int i = 0; i < M; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    list[a].add(new int[] {b, c});
		    list[b].add(new int[] {a, c});
		}
		bw.write(String.valueOf(primSpanning()));
		bw.flush();
	}
	private static int primSpanning() {
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
	    pq.offer(new int[] {1, 0});
	    int total = 0;
	    while(!pq.isEmpty()) {
	        int[] current = pq.poll();
	        int currentNode = (int) current[0];
	        int currentWeight = current[1];
	        if (!visit[currentNode]) {
	            visit[currentNode] = true;
	            total += currentWeight;
	            for (int[] next : list[(int) current[0]]) {
    	            int nextNode = (int) next[0];
    	            int nextWeight = next[1];
    	            if(!visit[nextNode]) {
    	                pq.offer(new int[] {nextNode, nextWeight});
    	            }
    	        }
	        } 
	    }
	    return total;
	}
}