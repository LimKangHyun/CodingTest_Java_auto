import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
		    int N = Integer.parseInt(br.readLine());
		    sb.append((N+1) / 2 + "\n");
		    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		    int count = 0;
		    for (int i = 0; i < N; i++) {
		        if(i % 10 == 0) {
		            st = new StringTokenizer(br.readLine());
		        }
		        int num = Integer.parseInt(st.nextToken());
		        if (minHeap.size() == maxHeap.size()) {
		            maxHeap.offer(num);
    		    } else {
    		        minHeap.offer(num);
    		    }
    		    if (!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
    	            int minHeapMax = minHeap.poll();
    		        int maxHeapMin = maxHeap.poll();
    		        minHeap.offer(maxHeapMin);
    		        maxHeap.offer(minHeapMax);
    		    } 
    		    if (i % 2 == 0) {
    		        count++;
    		        sb.append(maxHeap.peek() + " ");
    		        if (count % 10 == 0) sb.append("\n"); 
    		    }
		    } 
		    sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}