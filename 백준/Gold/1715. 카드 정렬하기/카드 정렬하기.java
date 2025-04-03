import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
		    pq.offer(Integer.parseInt(br.readLine()));
		} 
		bw.write(String.valueOf(findMinSum(pq)));
		bw.flush();
	}
	private static int findMinSum(PriorityQueue<Integer> pq) {
	    int result = 0;
	    while(!pq.isEmpty()) {
	        if (pq.size() != 1) {
	            int sum = pq.poll() + pq.poll();
	            result += sum;
	            pq.offer(sum);
	        } else break;
	    }
	    return result;
	}
}