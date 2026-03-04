import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        List<String> cache = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            if (cacheHit(cache, city)) {
                cache.remove(city); // LRU 타겟 변경
                cache.add(city);
                count+=1;
            } else {
                cache.add(city);
                if (cache.size() > cacheSize) cache.remove(0); // LRU 제거
                count+=5;
            }
        }
        return count;
    }
    private boolean cacheHit(List<String> cache, String city) {
        for (String str : cache) {
            if (city.equals(str)) return true;
        }
        return false;
    }
}