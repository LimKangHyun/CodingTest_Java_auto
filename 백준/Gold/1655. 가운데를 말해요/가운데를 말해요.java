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
	    
	    int mid = 0;
	    for (int i = 0; i < arr.length; i++) {
	        if (i % 2 == 0) pq1.offer(arr[i]);
	        else pq2.offer(arr[i]);
	        
	        if (pq2.isEmpty()) {
	            mid = pq1.peek();
	        } else {
	            if (pq1.peek() > pq2.peek()) {
	                int temp1 = pq1.poll();
	                int temp2 = pq2.poll();
	                pq1.offer(temp2);
	                pq2.offer(temp1);
	                mid = pq1.peek();
	            } else {
	                mid = pq1.peek();
	            }
	        }
	        sb.append(mid + "\n");
	    } 
	}
}