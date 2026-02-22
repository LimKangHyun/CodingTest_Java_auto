import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String[][] places;
    public int[] solution(String[][] _places) {
        places = _places;
        int pLen = places.length;
        int[] answer = new int[pLen];
        for (int i = 0; i < places.length; i++) {
            if (isSafe(places[i])) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }
    private boolean isSafe(String[] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length(); j++) {
                if (place[i].charAt(j) == 'P') {
                    if (!bfs(place, i, j)) return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(String[] place, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        queue.offer(new int[] {x, y, 0});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[2] >= 2) continue;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (visited[nx][ny]) continue;
                if (place[nx].charAt(ny) == 'X') continue;
                if (place[nx].charAt(ny) == 'P') return false;
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny, cur[2] + 1});
            }
        }
        return true;
    }
}