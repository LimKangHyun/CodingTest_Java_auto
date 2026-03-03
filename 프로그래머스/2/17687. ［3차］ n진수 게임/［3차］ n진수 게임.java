import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int start = 0;
        while (sb.length() < t * m) {
            sb.append(Integer.toString(start++, n));
        }
        for (int i = 0; i < t; i++) {
            result.append(sb.charAt(p - 1 + i * m));
        }
        return result.toString().toUpperCase();
    }
}