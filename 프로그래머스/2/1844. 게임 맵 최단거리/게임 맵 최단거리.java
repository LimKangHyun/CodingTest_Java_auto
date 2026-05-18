import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dis = cur[2];
            if (x == row - 1 && y == col - 1) {
                return dis;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, dis + 1});
                }
            }
        }
        return -1;
    }
}