import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int x;
    int y;
    int weight;
    
    public Node(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.weight - n.weight;
    }
}
public class Main {
    private static int N;
    private static int attempt = 1;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
		    N = Integer.parseInt(br.readLine());
		    if(N == 0) break;
		    int[][] map = new int[N][N];
		    int[][] minRoad = new int[N][N];
		    boolean[][] visit = new boolean[N][N];
		    for (int i = 0; i < N; i++) {
		        String[] input = br.readLine().split(" ");
		        for (int j = 0; j < N; j++) {
		            map[i][j] = Integer.parseInt(input[j]);
		        } 
		    } 
		    for (int i = 0; i < N; i++) {
		        Arrays.fill(minRoad[i], Integer.MAX_VALUE);
		    } 
		    minRoad[0][0] = map[0][0];
		    bw.write("Problem " + attempt++ +": " + dijkstra(map, minRoad, 0, 0, minRoad[0][0]) + "\n");
		}
		bw.flush();
	}
	private static int dijkstra(int[][] map, int[][] minRoad, int x, int y, int w) {
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.offer(new Node (x, y, w));
	    while(!pq.isEmpty()) {
	        Node current = pq.poll();
	        int cx = current.x;
	        int cy = current.y;
	        int cw = current.weight;
	        if (cx == N-1 && cy == N-1) return cw;
	        for (int i = 0; i < 4; i++) {
	            int nx = cx + dx[i];
	            int ny = cy + dy[i];
	            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
	                if(cw + map[nx][ny] < minRoad[nx][ny]) {
	                    minRoad[nx][ny] = cw + map[nx][ny];
	                    pq.offer(new Node (nx, ny, minRoad[nx][ny]));
	                }
	            } 
	        } 
	    }
	    return -1;
	}
}