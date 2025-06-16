import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String i : participant) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(String i : completion) {
            map.put(i, map.get(i) - 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        return "";
    }
}