import java.util.*;

class Solution {
    int answer = 0;
    public int solution(String message, int[][] spoiler_ranges) {
        Set<String> not_important = new HashSet<>();
        Set<String> spoilerSet = new HashSet<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i <= message.length(); i++) {
            if (i == message.length() || message.charAt(i) == ' ') {
                end = i - 1;
                String word = message.substring(start, end + 1);
                if (!isHidden(start, end, spoiler_ranges)) {
                    not_important.add(word);
                } else spoilerSet.add(word);
                start = i + 1;
            }
        }
        for (String spo : spoilerSet) {
            if (!not_important.contains(spo)) {
                not_important.add(spo);
                answer++;
            }
        }
        return answer;
    }
    private boolean isHidden(int wordStart, int wordEnd, int[][] ranges) {
        for (int[] range : ranges) {
            int spoStart = range[0];
            int spoEnd = range[1];
            if (wordEnd >= spoStart && wordStart <= spoEnd) return true;
        }
        return false;
    }
}