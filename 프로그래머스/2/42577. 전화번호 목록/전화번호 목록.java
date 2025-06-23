import java.util.*;

class Solution {
	public boolean solution(String[] phone_book) {

		HashMap<String, Integer> map = new HashMap<>();
		for (String s : phone_book) {
			map.put(s, 1);
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