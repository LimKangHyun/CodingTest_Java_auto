import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int round = 1;
        
        Set<Integer> mine = new HashSet<>();
        Set<Integer> candidate = new HashSet<>();
        
        for (int i = 0; i < n / 3; i++) {
            mine.add(cards[i]);
        }
        
        for (int i = n / 3; i < n; i+=2) {
            int card1 = cards[i];
            int card2 = cards[i + 1];
            
            candidate.add(card1);
            candidate.add(card2);
            
            if (removePair(mine, mine, n)) {
                round++;
                continue;
            }
            if (coin >= 1 && removePair(mine, candidate, n)) {
                coin--;
                round++;
                continue;
            }
            if (coin >= 2 && removePair(candidate, candidate, n)) {
                coin -= 2;
                round++;
                continue;
            }
            break;
        }
        return round;
    }
    
    private boolean removePair(Set<Integer> set1, Set<Integer> set2, int n) {
        for (int card : new HashSet<>(set1)) {
            int target = n + 1 - card;
            if (set2.contains(target)) {
                set1.remove(card);
                set2.remove(target);
                return true;
            }
        }
        return false;
    }
}