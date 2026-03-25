import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int row = park.length;
        int col = park[0].length;
        int[][] grid = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                grid[r][c] = park[r][c].equals("-1") ? 0 : 1;
            }
        }
        int[][] psum = new int[row + 1][col + 1];
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                psum[r][c] = psum[r - 1][c] + psum[r][c - 1] - psum[r - 1][c - 1] + grid[r - 1][c - 1];
            }
        }
        Arrays.sort(mats);
        for (int m = mats.length - 1; m >= 0; m--) {
            int len = mats[m];
            if (len > row || len > col) continue;
            
            boolean found = false;
            for (int i = 0; i <= row - len; i++) {
                for (int j = 0; j <= col - len; j++) {
                    int total = psum[i + len][j + len] - psum[i + len][j] - psum[i][j + len] + psum[i][j];
                    if (total == 0) return len;
                }
            }
        }
        return -1;
    }
}