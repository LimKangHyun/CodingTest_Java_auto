import java.util.*;

class Solution {
    static int n, m;
    static int answer;
    static Queue<int[]> queue;
    static char[][] store;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        store = new char[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c = storage[i - 1].charAt(j - 1);
                store[i][j] = c;
            }
        }
        answer = n * m;
        for (String request : requests) {
            bfs(request);
        }
        return answer;
    }
    private static void bfs(String request) {
        if (request.length() == 1) {
            List<int[]> list = new ArrayList<>();
            visited = new boolean[n + 2][m + 2];
            queue = new ArrayDeque<>();
            visited[0][0] = true;
            queue.offer(new int[] {0, 0});
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2) continue;
                    if (visited[nx][ny]) continue;
                    if (store[nx][ny] == '\u0000') {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny});
                    }
                    if (store[nx][ny] == request.charAt(0)) {
                        list.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            for (int[] li : list) {
                store[li[0]][li[1]] = '\u0000';
                answer--;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (store[i][j] == request.charAt(0)) {
                        store[i][j] = '\u0000';
                        answer--;
                    }
                }
            }
        }
    }
}