import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        int last = -1;
        int count = 0;
        for (int[] target : targets) {
            if (target[0] >= last) {
                count++;
                last = target[1];
            }
        }
        return count;
    }
}