import java.util.*;

class Solution {
    static HashMap<String, Integer> map;
    static StringBuilder sb;
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        for (int size : course) {
            map = new HashMap<>();
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                comb(arr, new StringBuilder(), 0, 0, size);
            }
            int max = 0;
            for (int val : map.values()) {
                if (max < val) {
                    max = val;
                }
            }
            for (String key : map.keySet()) {
                if (map.get(key) == max && max >= 2) {
                    result.add(key);
                }
            }
            Collections.sort(result);
        }
        return result.toArray(new String[0]);
    }
    private void comb(char[] arr, StringBuilder sb, int depth, int idx, int size) {
        if (depth == size) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            sb.append(arr[i]);
            comb(arr, sb, depth + 1, i + 1, size);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}