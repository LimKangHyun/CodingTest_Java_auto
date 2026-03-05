import java.util.*;

class Solution {
    int count = 0;
    public String solution(long n, String[] bans) {
        StringBuilder sb = new StringBuilder();
        long[] spells = changeBans(bans);
        Arrays.sort(spells);
        for (long spell : spells) {
            if (spell <= n) n++;
        }
        while(n > 0) {
            sb.append((char) ('a' + (--n % 26)));
            n /= 26;
        }
        return sb.reverse().toString();
    }
    private long[] changeBans(String[] bans) {
        long[] spells = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            spells[i] = changeSpell(bans[i]);
        }
        return spells;
    }
    private long changeSpell(String str) {
        long num = 0L;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            num = num * 26 + (c - 'a' + 1);
        }
        return num;
    }
}