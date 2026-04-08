import java.util.*;

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

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        List<List<Node>> list = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int weight = road[i][2];
            list.get(a).add(new Node(b, weight));
            list.get(b).add(new Node(a, weight));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.end;
            int weight = cur.weight;
            if (dist[node] < weight) continue;
            for (Node next : list.get(node)) {
                int newDist = dist[node] + next.weight;
                if (newDist < dist[next.end]) {
                    dist[next.end] = newDist;
                    pq.offer(new Node(next.end, newDist));
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
}