import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int target;
    int weight;
    
    Node(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node n) {
        return weight - n.weight;
    }
}

public class Main {
    static int N, M, X;
    static List<List<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        } 
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, weight));
        } 
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (i != X) {
                result = Math.max(result, dijkstra(i, X) + dijkstra(X, i));
            } 
        } 
        
        bw.write(String.valueOf(result));
        bw.flush();
    }
    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.target;
            int currentWeight = current.weight;
            if (dist[currentNode] >= currentWeight) {
                for (Node next : list.get(currentNode)) {
                    int nextNode = next.target;
                    int nextWeight = next.weight;
                    if (dist[nextNode] > currentWeight + nextWeight) {
                        dist[nextNode] = currentWeight + nextWeight;
                        pq.offer(new Node(nextNode, dist[nextNode]));
                    } 
                } 
            }
        }
        return dist[end];
    }
}