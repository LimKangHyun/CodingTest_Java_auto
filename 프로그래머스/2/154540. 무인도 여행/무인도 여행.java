import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] islands;
    public int[] solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        islands = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') continue;
                islands[i][j] = c - '0';
            }
        }
        System.out.println(Arrays.deepToString(islands));
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = islands[i][j];
                if (visited[i][j] || islands[i][j] == 0) continue;
                visited[i][j] = true;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[] {i, j});
                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];
                        if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                        if (visited[nx][ny] || islands[nx][ny] == 0) continue;
                        visited[nx][ny] = true;
                        sum += islands[nx][ny];
                        queue.offer(new int[] {nx, ny});
                    }
                }
                list.add(sum);
            }
        }
        if (list.isEmpty()) list.add(-1);
        Collections.sort(list);
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}