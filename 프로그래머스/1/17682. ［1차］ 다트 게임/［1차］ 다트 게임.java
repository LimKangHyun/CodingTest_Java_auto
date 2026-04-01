import java.util.*;

class Solution {
    public int solution(String dartResult) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        char prev = '0';
        int idx = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (c == '*') {
                if (list.size() > 1) {
                    list.set(list.size() - 2, list.get(list.size() - 2) * 2);
                }
                list.set(list.size() - 1, list.get(list.size() - 1) * 2);
            } else if (c == '#') {
                list.set(list.size() - 1, list.get(list.size() - 1) * -1);
            } else if (c >= '0' && c <= '9') {
                if (prev == '1' && c == '0') {
                    list.remove(list.size() - 1);
                    list.add(10);
                } else {
                    list.add(c - '0');
                }
                prev = c;
            } else if (c == 'D') {
                list.set(list.size() - 1, (int) Math.pow(list.get(list.size() - 1), 2));
            } else if (c == 'T') {
                list.set(list.size() - 1, (int) Math.pow(list.get(list.size() - 1), 3));
            }
        }
        for (int n : list) {
            answer += n;
        }
        return answer;
    }
}