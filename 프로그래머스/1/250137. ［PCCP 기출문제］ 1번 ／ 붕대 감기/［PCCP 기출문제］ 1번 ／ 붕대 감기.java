import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int maxHealth = health;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] attack : attacks) {
            map.put(attack[0], attack[1]);
            time = Math.max(time, attack[0]);
        }
        int idx = 0;
        for (int i = 1; i <= time; i++) {
            if (map.containsKey(i)) {
                health -= map.get(i);
                idx = 0;
                if (health <= 0) {
                    return -1;
                }
                continue;
            }
            idx++;
            if (idx == bandage[0]) {
                idx = 0;
                health += bandage[1] + bandage[2];
            } else health += bandage[1];
            if (health > maxHealth) health = maxHealth;
        }
        return health;
    }
}