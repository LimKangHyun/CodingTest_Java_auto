import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        dist[1] = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                queue.offer(next);
            }
        }
        int max = 0;
        int maxCount = 0;
        for (int d : dist) {
            if (d > max) {
                max = d;
                maxCount = 1;
            } else if (d == max) maxCount++;
        }
        return maxCount;
    }
}