import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        int gemTotal = gemSet.size();
        Map<String, Integer> map = new HashMap<>();
        
        int start = 0;
        int minLength = 100000;
        int[] answer = new int[2];
        
        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            while (map.size() == gemTotal) {
                if (end - start < minLength) {
                    minLength = end - start;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++; // 위의 if문이 만족되는 경우에는 start를 하나 줄여보기
            }
        }
        return answer;
    }
}