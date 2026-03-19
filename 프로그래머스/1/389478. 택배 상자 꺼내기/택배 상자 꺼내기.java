import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int row = (num - 1) / w;
        int col;
        if (row % 2 == 0) {
            col = (num - 1) % w;
        } else col = w - 1 - (num - 1) % w;
        int totalRow = (n + w - 1) / w;
        for (int i = row; i < totalRow; i++) {
            int lastRow = totalRow - 1;
            if (i == lastRow) {
                int lastCount = n % w == 0 ? w : n % w; // 1-based
                if (i % 2 == 0) {
                    if (col < lastCount) answer++;
                } else {
                    if (col >= w - lastCount) answer++;
                }
            } else answer++;
        }
        return answer;
    }
}