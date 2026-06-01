import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        Integer[] temp = new Integer[map.size()];
        int idx = 0;
        for (int value : map.values()) {
            temp[idx++] = value;
        }
        Arrays.sort(temp, Collections.reverseOrder());
        int answer = 0;
        for (int t : temp) {
            k -= t;
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}