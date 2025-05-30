import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int num;
        String cmd;
        
        Node(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
		    String[] input = br.readLine().split(" ");
		    int start = Integer.parseInt(input[0]);
		    int target = Integer.parseInt(input[1]);
		    sb.append(bfs(start, target) + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static String bfs(int start, int target) {
	    boolean[] visit = new boolean[10000];
	    Queue<Node> queue = new LinkedList<>();
	    queue.add(new Node(start, ""));
	    visit[start] = true;
	    while(!queue.isEmpty()) {
	        Node current = queue.poll();
	        if (current.num == target) return current.cmd; 
	        int d = (current.num * 2) % 10000;
	        if (!visit[d]) {
	            visit[d] = true;
	            queue.offer(new Node(d, current.cmd + "D"));
	        }
	        int s = (current.num == 0) ? 9999 : current.num - 1;
	        if (!visit[s]) {
	            visit[s] = true;
	            queue.offer(new Node(s, current.cmd + "S"));
	        } 
	        // 1234 -> 2341
	        int l = (current.num % 1000) * 10 + (current.num / 1000);
	        if (!visit[l]) {
	            visit[l] = true;
	            queue.offer(new Node(l, current.cmd + "L"));
	        } 
	        // 1234 -> 4123
	        int r = (current.num % 10) * 1000 + (current.num / 10);
	        if (!visit[r]) {
	            visit[r] = true;
	            queue.offer(new Node(r, current.cmd + "R"));
	        } 
	    }
	    return "";
	}
}