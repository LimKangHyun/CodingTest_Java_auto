import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] cols;
    static boolean[][] visited;
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        cols = new int[m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || land[i][j] == 0) continue;
                bfs(i, j, n, m, land, cols);
            }
        }
        int max = 0;
        for (int col : cols) {
            max = Math.max(max, col);
        }
        return max;
    }
    private static void bfs(int x, int y, int n, int m, int[][] land, int[] cols) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            count++;
            set.add(cur[1]);
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (land[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
        for (int s : set) {
            cols[s] += count;
        }
    }
}