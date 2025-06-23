import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
    
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 1);
        }
        for(String num : phone_book) {
            for(int i = 1; i < num.length(); i++) {
                if(map.containsKey(num.substring(0,i))) {
                    return false;
                }
            }
        }
        return true;
    }
}