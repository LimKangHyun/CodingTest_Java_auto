import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int cur = 0;
        int number = 0;
        while (idx < t) {
            String num = Integer.toString(number++, n).toUpperCase();
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (cur++ % m == p - 1) {
                    sb.append(c);
                    idx++;
                    if (idx == t) break;
                }
            }
        }
        return sb.toString();
    }
}