import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int end;
    int weight;
    
    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node n) {
        return Integer.compare(this.weight, n.weight);
    }
}
public class Main{
    static int N, M;
    static List<List<Node>> list = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        } 
        
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node (b, cost));
        } 
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        bw.write(String.valueOf(dijkstra(start, end)));
        bw.flush();
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.end;
            int currentCost = current.weight;
            if (currentNode == end) return currentCost; 
            if (dist[currentNode] >= currentCost) {
                for (Node node : list.get(currentNode)) {
                    int nextNode = node.end;
                    int nextCost = node.weight;
                    if (dist[nextNode] > currentCost + nextCost) {
                        dist[nextNode] = currentCost + nextCost;
                        pq.offer(new Node (nextNode, dist[nextNode]));
                    }
                } 
            }
        }
        return dist[end];
    }
}