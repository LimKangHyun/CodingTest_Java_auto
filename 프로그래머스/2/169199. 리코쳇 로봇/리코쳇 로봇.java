import java.util.*;

class Solution {
    static int row, col;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String[] board;
    static boolean[][] visited;
    public int solution(String[] _board) {
        board = _board;
        row = board.length;
        col = board[0].length();
        visited = new boolean[row][col];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i].charAt(j) == 'R') {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        return bfs(queue);
    }
    private static int bfs(Queue<int[]> queue) {
        int answer = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                if (board[cur[0]].charAt(cur[1]) == 'G') return answer;
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                    if (board[nx].charAt(ny) == 'D') continue;
                    while(true) {
                        int tx = nx + dx[i];
                        int ty = ny + dy[i];
                        if (tx < 0 || ty < 0 || tx >= row || ty >= col) break;
                        if (board[tx].charAt(ty) == 'D') break;
                        nx = tx;
                        ny = ty;
                    }
                    if (visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
            answer++;
        }
        return -1;
    }
}