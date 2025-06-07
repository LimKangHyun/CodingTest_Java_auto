import java.util.*;
// 구간 커버
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int cam = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (cam < route[0]) {
                answer++;
                cam = route[1];
            }
        }
        return answer;
    }
}