import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = Arrays.stream(stones).max().getAsInt();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return answer;
    }
    private boolean canCross(int[] stones, int k, int mid) {
        int zeroCount = 0;
        for(int stone : stones) {
            if (stone < mid) zeroCount++;
            else zeroCount = 0;
            if (zeroCount >= k) return false;
        }
        return true;
    }
}