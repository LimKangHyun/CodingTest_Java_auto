import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
		    int k = Integer.parseInt(br.readLine());
		    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		    HashMap<Integer, Integer> map = new HashMap<>();
		    
		    for (int i = 0; i < k; i++) {
		        String[] input = br.readLine().split(" ");
		        String cmd = input[0];
		        int num = Integer.parseInt(input[1]);
		        if (cmd.equals("I")) {
		            minHeap.offer(num);
		            maxHeap.offer(num);
		            map.put(num, map.getOrDefault(num, 0) + 1);
		        } else if (input[0].equals("D")) {
		            if (map.isEmpty()) continue;
		            // num이 1이면 최대, -1이면 최솟값 뽑아야 하므로 타겟 큐가 달라짐
		            // 얕은 복사
		            PriorityQueue<Integer> targetHeap = (num == 1) ? maxHeap : minHeap;
		            clean(targetHeap, map);
		            if (!targetHeap.isEmpty()) {
		                int target = targetHeap.poll();
		                map.put(target, map.get(target) - 1);
		                if (map.get(target) == 0) map.remove(target); 
		            } 
		        }
		    }
		    // minHeap과 maxHeap의 의미 없는 값 정리
		    clean(minHeap, map);
		    clean(maxHeap, map);
		    
		    if (map.isEmpty()) {
		        sb.append("EMPTY\n");
		    } else {
		        sb.append(maxHeap.peek() + " " + minHeap.peek() + "\n");
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static void clean(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
	    while(!heap.isEmpty()) {
	        int top = heap.peek();
	        if (!map.containsKey(top)) {
	            heap.poll();
	        } else {
	            break;
	        }
	    }
	}
}