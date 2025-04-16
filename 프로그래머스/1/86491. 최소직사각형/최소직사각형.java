import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int walletW = 0;
        int walletH = 0;
        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);

            walletW = Math.max(walletW, w);
            walletH = Math.max(walletH, h);
        }
        answer = walletW * walletH;
        return answer;
    }
}