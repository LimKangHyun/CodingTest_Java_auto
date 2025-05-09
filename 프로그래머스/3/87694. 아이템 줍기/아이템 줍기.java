import java.util.*;

class Solution {
    private static int maxX, maxY;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static boolean[][] visit;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        for(int i = 0; i < rectangle.length; i++) {
            maxX = Math.max(rectangle[i][2], maxX);
            maxY = Math.max(rectangle[i][3], maxY);
        }
        maxX *= 2;
        maxY *= 2;
        int[][] map = new int[maxY+1][maxX+1];
        visit = new boolean[maxY+1][maxX+1];
        
        findBorder(rectangle, map);
        System.out.println(Arrays.deepToString(map));
        return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }
    private static void findBorder(int[][] rectangle, int[][] map) {
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    if (j > x1 && j < x2 && k > y1 && k < y2) {
                        map[k][j] = -1;
                    } else if (map[k][j] != -1) {
                        map[k][j] = 1;
                    }
                }
            }
        }
    }
    private static int bfs(int[][] map, int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {characterY, characterX, 0});
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int dist = current[2];
            visit[cx][cy] = true;
            if(cx == itemY && cy == itemX) return dist;
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && ny >= 0 && nx <= maxY && ny <= maxX) {
                    if (!visit[nx][ny] && map[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        queue.offer(new int[] {nx, ny, dist+1});   
                    }
                }
            }
        }
        return -1;
    }
}