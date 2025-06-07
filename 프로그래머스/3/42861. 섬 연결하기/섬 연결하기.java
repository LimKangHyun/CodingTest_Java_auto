import java.util.*;

class Solution {
    // MST 크루스칼
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
        Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
    public int solution(int n, int[][] costs) {
        int total = 0;
        int count = 0; // 이 후 간선 생략용
        List<Edge> graph = new ArrayList<>();
        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];
            graph.add(new Edge(to, from, weight));
        }
        Collections.sort(graph);
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (Edge e : graph) {
            // 이미 이어져있다면 연결하지 않기
            if (union(parent, e.from, e.to)) {
                total += e.weight;
                count++;
                if (count == n - 1) break;
            }
        }
        return total;
    }
    private static int find(int[] parent, int x) {
        if(parent[x] != x) {
            x = find(parent, parent[x]);
        }
        return parent[x];
    }
    private static boolean union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);
        if (x == y) return false;
        parent[y] = x;
        return true;
    }
}