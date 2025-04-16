import java.util.*;

class Solution {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    private static boolean[][] visit;
    private static int[][] dist;
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        visit = new boolean[n][m];
        dist = new int[n][m];
        bfs(maps, n, m);
        answer = dist[n-1][m-1];
        return answer == 0 ? -1 : answer;
    }
    
    private static void bfs(int[][] maps, int n, int m) {
        visit[0][0] = true;
        dist[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        while(!queue.isEmpty()) {
            int current[] = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(!visit[nx][ny] && maps[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        dist[nx][ny] = dist[current[0]][current[1]] + 1;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}