import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int num;
        int count;
        
        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
        @Override
        public int compareTo(Node n) {
            if (this.count == n.count) return this.num - n.num;
            return this.count - n.count;
        }
    }
    private static int r, c, k;
    private static int[][] arr = new int[101][101];
    private static int rowL = 3, colL = 3;
    private static int answer = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		r = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		k = Integer.parseInt(input[2]);
		
		for (int i = 1; i <= 3; i++) {
		    String[] nums = br.readLine().split(" ");
		    for (int j = 1; j <= 3; j++) {
		        arr[i][j] = Integer.parseInt(nums[j-1]);
		    } 
		} 
		for (int i = 0; i <= 100; i++) {
		    if (arr[r][c] == k) {
		        answer = i;
		        break;
		    }
		    if (rowL >= colL) rowCal();
		    else colCal();
		}
		bw.write(String.valueOf(answer));
		bw.flush();
	}
	private static void rowCal() {
	    for (int i = 1; i <= rowL; i++) {
	        PriorityQueue<Node> pq = new PriorityQueue<>();
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int j = 1; j <= colL; j++) {
	            if (arr[i][j] == 0) continue;
	            map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
	        } 
	        map.forEach((k, v) -> pq.offer(new Node(k, v)));
	        int idx = 1;
	        while(!pq.isEmpty()) {
	            Node curNode = pq.poll();
	            arr[i][idx++] = curNode.num;
	            arr[i][idx++] = curNode.count;
	        }
	        colL = Math.max(colL, idx);
	        // 전 배열이 긴 경우도 존재하므로, 그런 경우에 뒤 배열정리
	        for (int j = idx; j <= 100; j++) {
	            arr[i][j] = 0;
	        } 
	    } 
	}
	private static void colCal() {
	    for (int i = 1; i <= colL; i++) {
	        PriorityQueue<Node> pq = new PriorityQueue<>();
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int j = 1; j <= rowL; j++) {
	            if (arr[j][i] == 0) continue;
	            map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
	        } 
	        map.forEach((k, v) -> pq.offer(new Node(k, v)));
	        int idx = 1;
	        while(!pq.isEmpty()) {
	            Node curNode = pq.poll();
	            arr[idx++][i] = curNode.num;
	            arr[idx++][i] = curNode.count;
	        }
	        rowL = Math.max(rowL, idx);
	        // 전 배열이 긴경우도 존재하므로, 그런 경우에 뒤 배열정리
	        for (int j = idx; j <= 100; j++) {
	            arr[j][i] = 0;
	        } 
	    }
	}
}