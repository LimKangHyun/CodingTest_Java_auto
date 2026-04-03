import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        double union = 0;
        double intersec = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> str1Map = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if (c1 < 'a' || c1 > 'z') {
                continue;
            } else if (c2 < 'a' || c2 > 'z') {
                i++;
                continue;
            }
            String str1Sub = str1.substring(i, i + 2);
            str1Map.put(str1Sub, str1Map.getOrDefault(str1Sub, 0) + 1);
            union++;
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if (c1 < 'a' || c1 > 'z') {
                continue;
            } else if (c2 < 'a' || c2 > 'z') {
                i++;
                continue;
            }
            String str2Sub = str2.substring(i, i + 2);
            if (str1Map.containsKey(str2Sub)) {
                int val = str1Map.get(str2Sub) - 1;
                if (val == 0) str1Map.remove(str2Sub);
                else str1Map.put(str2Sub, val);
                intersec++;
            } else union++;
        }
        if (union == 0 && intersec == 0) return 65536;
        return (int) (intersec / union * 65536);
    }
}