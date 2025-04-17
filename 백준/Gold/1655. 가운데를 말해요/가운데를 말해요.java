import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		} 
		findMid();
		bw.write(sb.toString());
		bw.flush();
	}
	private static void findMid() {
	    PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
	    PriorityQueue<Integer> pq2 = new PriorityQueue<>();
	    
	    for (int i = 0; i < arr.length; i++) {
	        if (pq1.isEmpty() || arr[i] <= pq1.peek()) {
	            pq1.offer(arr[i]);
	        } else {
	            pq2.offer(arr[i]);
	        }
	        
	        if (pq1.size() > pq2.size() + 1) {
	            pq2.offer(pq1.poll());
	        } else if (pq1.size() < pq2.size()){
	            pq1.offer(pq2.poll());
	        }
	        sb.append(pq1.peek() + "\n");
	    } 
	}
}