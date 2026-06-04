import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int round = enemy.length;
        if (k >= round) return round;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < round; i++) {
            n -= enemy[i];
            pq.offer(enemy[i]);
            if (n < 0) {
                if (k > 0) {
                    n += pq.poll();
                    k--;
                } else break;
            }
            answer++;
        }
        return answer;
    }
}