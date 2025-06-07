import java.util.*;

class Solution {
    // MST 프림
    static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        Edge (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
    public int solution(int n, int[][] costs) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];
            graph.get(from).add(new Edge(to, weight));
            graph.get(to).add(new Edge(from, weight));
        }
        return prim(n, graph);
    }
    private static int prim(int n, List<List<Edge>> graph) {
        int total = 0;
        boolean[] visit = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));
        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            if(!visit[current.to]) {
                visit[current.to] = true;
                total += current.weight;
                for(Edge e : graph.get(current.to)) {
                    int nextTo = e.to;
                    int nextWeight = e.weight;
                    if (!visit[nextTo]) {
                        pq.offer(new Edge(nextTo, nextWeight));
                    }
                }
            }
        }
        return total;
    }
}