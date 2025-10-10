import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> map = new HashMap<>();
        int[][] giveList = new int[friends.length][friends.length];
        int[] jisoo = new int[friends.length];
        for(int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        for(String gift : gifts) {
            String[] temp = gift.split(" ");
            int a = map.get(temp[0]);
            int b = map.get(temp[1]);
            giveList[a][b]++;
            jisoo[a]++;
            jisoo[b]--;
        }
        int answer = 0;
        for(int i = 0; i < friends.length; i++) {
            int count = 0; // i 기준 카운트
            for(int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                if (giveList[i][j] > giveList[j][i] || (giveList[i][j] == giveList[j][i] && jisoo[i] > jisoo[j])) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}