import java.util.*;

class Solution {
    private static List<List<Integer>> list = new ArrayList<>();
    private static boolean[] visit;
    public int solution(int n, int[][] edge) {
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        visit = new boolean[n + 1];
        for(int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        return bfs(n);
    }
    private static int bfs(int n) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0});
        visit[1] = true;
        int maxDist = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int dist = cur[1];
            if (dist == maxDist) answer++;
            if (dist > maxDist) {
                maxDist = dist;
                answer = 1;
            }
            for (int i = 0; i < list.get(num).size(); i++) {
                int neighbor = list.get(num).get(i);
                if(!visit[neighbor]) {
                    queue.add(new int[] {neighbor, dist+1});
                    visit[neighbor] = true;
                }
            }
        }
        return answer;
    }
}