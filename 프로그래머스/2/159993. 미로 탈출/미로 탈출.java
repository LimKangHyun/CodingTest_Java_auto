import java.util.*;

class Solution {
    int[] start = new int[2];
    int[] lever = new int[2];
    int[] exit = new int[2];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int solution(String[] maps) {
        int answer = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (maps[i].charAt(j) == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        int toLever = bfs(maps, start, lever);
        if (toLever == -1) return -1;
        int toExit = bfs(maps, lever, exit);
        if (toExit == -1) return -1;
        return toLever + toExit;
    }
    private int bfs(String[] maps, int[] start, int[] end) {
        int rowLen = maps.length;
        int colLen = maps[0].length();
        boolean[][] visited = new boolean[rowLen][colLen];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start[0], start[1], 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                return cur[2];
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= rowLen || ny >= colLen) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx].charAt(ny) == 'X') continue;
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny, cur[2] + 1});
            }
        }
        return -1;
    }
}