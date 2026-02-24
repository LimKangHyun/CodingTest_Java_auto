import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String str = s.substring(2, s.length() - 2);
        String[] numbers = str.split("\\},\\{");
        for (String num : numbers) {
            String[] arr = num.split(",");
            for (String a : arr) {
                int n = Integer.parseInt(a);
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        int[] answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        return answer;
    }
}