import java.util.*;

class Solution {
    int h;
    String[] grid;
    int[][] panels;
    int[][] seqs;
    
    char[][] map;
    int[][] dist;
    int[] distToElev;
    int ex, ey;
    
    int[] prev;
    int[][] dp;
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int solution(int h, String[] grid, int[][] panels, int[][] seqs) {
        this.h = h;
        this.grid = grid;
        this.panels = panels;
        this.seqs = seqs;
        int n = panels.length;
        
        int row = grid.length;
        int col = grid[0].length();
        
        makeMap(row, col, grid);
        findElevator(row, col);
        
        makeDist();
        
        prev = new int[n + 1];
        for (int[] s : seqs) {
            int a = s[0];
            int b = s[1];
            prev[b] |= (1 << a - 1);
        }
        
        dp = new int[1 << n][n + 1];
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        
        for (int mask = 0; mask < (1 << n); mask++) {
            for (int last = 0; last <= n; last++) {
                if (dp[mask][last] == Integer.MAX_VALUE) continue;
                
                for (int next = 1; next <= n; next++) {
                    if ((mask & (1 << (next - 1))) != 0) continue; // 이미 켜진 패널
                    if ((mask & prev[next]) != prev[next]) continue; // 선행 조건 미충족
                    
                    int cost;
                    if (last == 0) {
                        if (panels[0][0] == panels[next - 1][0]) {
                            if (dist[1][next] == Integer.MAX_VALUE) continue;
                            cost = dist[1][next];
                        } else {
                            if (dist[1][0] == Integer.MAX_VALUE || dist[0][next] == Integer.MAX_VALUE) continue;
                            cost = dist[1][0] + Math.abs(panels[0][0] - panels[next - 1][0]) + dist[0][next];
                        }
                    } else {
                        if (panels[last - 1][0] == panels[next - 1][0]) {
                            if (dist[last][next] == Integer.MAX_VALUE) continue;
                            cost = dist[last][next];
                        } else {
                            if (dist[last][0] == Integer.MAX_VALUE || dist[0][next] == Integer.MAX_VALUE) continue;
                            cost = dist[last][0] + Math.abs(panels[last - 1][0] - panels[next - 1][0]) + dist[0][next];
                        }
                    }
                    int newMask = mask | (1 << (next - 1));
                    dp[newMask][next] = Math.min(dp[newMask][next], dp[mask][last] + cost);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        int fullMask = (1 << n) - 1;
        for (int last = 1; last <= n; last++) {
            answer = Math.min(answer, dp[fullMask][last]);
        }
        return answer;
    }
    private void makeDist() {
        int n = panels.length;
        dist = new int[n + 1][n + 1];
        distToElev = new int[n + 1];
        for (int i = 0; i < n; i++) {
            bfs(i + 1);
        }
    }
    private void bfs(int start) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        int[] s = panels[start - 1];
        int sx = s[1] - 1;
        int sy = s[2] - 1;
            
        queue.offer(new int[] {sx, sy, 0});
        visited[sx][sy] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            if (x == ex && y == ey) {
                dist[start][0] = d;
                dist[0][start] = d;
            }   
            for (int i = 0; i < panels.length; i++) {
                if (panels[i][1] - 1 == x && panels[i][2] - 1 == y) {
                    dist[start][i + 1] = d;
                    dist[i + 1][start] = d;
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                if (map[nx][ny] == '#') continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny, d + 1});
            }
        }
    }
    private void makeMap(int row, int col, String[] grid) {
        map = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = grid[i].charAt(j);
            }
        }
    }
    private void findElevator(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == '@') {
                    ex = i;
                    ey = j;
                    return;
                }
            }
        }
    }
}