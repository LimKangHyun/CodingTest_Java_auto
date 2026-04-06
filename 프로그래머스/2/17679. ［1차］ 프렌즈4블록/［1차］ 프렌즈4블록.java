import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] pan = new char[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pan[i][j] = board[i].charAt(j);
            }
        }
        while(true) {
            Set<List<Integer>> set = new HashSet<>();
            // checkSquare();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i + 1 >= m || j + 1 >= n) continue;
                    char c = pan[i][j];
                    if (c == '.') continue;
                    if (c == pan[i + 1][j] && c == pan[i][j + 1] && c == pan[i + 1][j + 1]) {
                        set.add(Arrays.asList(i, j));
                        set.add(Arrays.asList(i + 1, j));
                        set.add(Arrays.asList(i, j + 1));
                        set.add(Arrays.asList(i + 1, j + 1));
                    }
                }
            }
            if (set.isEmpty()) break;
            // removeSquareAndCount();
            for (List<Integer> pos : set) {
                int x = pos.get(0);
                int y = pos.get(1);
                pan[x][y] = '.';
                count++;
            }
            // reSort();
            for (int j = 0; j < n; j++) {
                int emptyRow = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (pan[i][j] != '.') {
                        char temp = pan[i][j];
                        pan[i][j] = '.';
                        pan[emptyRow][j] = temp;
                        emptyRow--; // 채워지는 경우, 위로 올림
                    }
                }
            }
        }
        return count;
    }
}