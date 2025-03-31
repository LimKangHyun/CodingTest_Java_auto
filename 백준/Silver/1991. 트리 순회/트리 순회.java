import java.io.*;
import java.util.*;

class Node {
    int left;
    int right;
    
    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {
    private static List<Node>[] graph;
    private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
		    graph[i] = new ArrayList<>();
		} 
		for (int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int s = st.nextToken().charAt(0) - 'A' + 1;
		    int left = st.nextToken().charAt(0) - 'A' + 1;
		    int right = st.nextToken().charAt(0) - 'A' + 1;
		    graph[s].add(new Node(left, right));
		} 
		preOrder(1);
		sb.append("\n");
		inOrder(1);
		sb.append("\n");
		postOrder(1);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void preOrder(int start) {
	    for (Node node : graph[start]) {
	        int l = node.left;
	        int r = node.right;
	        sb.append((char)(start + 'A' - 1));
	        if (l != -18) preOrder(l);
	        if (r != -18) preOrder(r);
	    } 
	}
	private static void inOrder(int start) {
	    for (Node node : graph[start]) {
	        int l = node.left;
	        int r = node.right;
	        if (l != -18) inOrder(l);
	        sb.append((char)(start + 'A' - 1));
	        if (r != -18) inOrder(r);
	    } 
	}
	private static void postOrder(int start) {
	    for (Node node : graph[start]) {
	        int l = node.left;
	        int r = node.right;
	        if (l != -18) postOrder(l);
	        if (r != -18) postOrder(r);
	        sb.append((char)(start + 'A' - 1));
	    } 
	}
}