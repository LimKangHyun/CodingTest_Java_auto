import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> map = new HashMap<>();

        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }
        for (long count : map.values()) {
            answer += count * (count - 1) / 2;
        }
        for (int w : map.keySet()) {
            long count = map.get(w);
            if (map.containsKey(w * 2)) {
                answer += count * map.get(w * 2);
            }
            if (w * 2 % 3 == 0 && map.containsKey(w * 2 / 3)) {
                answer += count * map.get(w * 2 / 3);
            }
            if (w * 3 % 4 == 0 && map.containsKey(w * 3 / 4)) {
                answer += count * map.get(w * 3 / 4);
            }
        }
        return answer;
    }
}