import java.util.*;

class Solution {
    public String solution(String p) {
        return amend(p);
    }
    private String amend(String w) {
        if (w.isEmpty()) return "";
        int balance = 0;
        int idx = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') balance++;
            else balance--;
            if (balance == 0) {
                idx = i + 1;
                break;
            }
        }
        String u = w.substring(0, idx);
        String v = w.substring(idx);
        if (isCorrect(u)) {
            return u + amend(v);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(amend(v)).append(")");
        for (int i = 1; i < u.length() - 1; i++) {
            sb.append(u.charAt(i) == '(' ? ')' : '(');
        }
        return sb.toString();
    }
    private boolean isCorrect(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}