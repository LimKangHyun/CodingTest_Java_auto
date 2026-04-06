import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = convert(m);
        String answer = "(None)";
        int n = musicinfos.length;
        int maxLen = -1;
        
        for (int i = 0; i < n; i++) {
            String[] musicinfo = musicinfos[i].split(",");
            int start = changeTimeToNum(musicinfo[0]);
            int end = changeTimeToNum(musicinfo[1]);
            int playLen = end - start;
            
            String title = musicinfo[2];
            String melody = convert(musicinfo[3]);
            
            String played = "";
            for (int p = 0; p < playLen; p++) {
                played += melody.charAt(p % melody.length());
            }
            
            if (played.indexOf(m) != -1) {
                if (playLen > maxLen) {
                    maxLen = playLen;
                    answer = title;
                }
            }
        }
        return answer;
    }
    private String convert(String s) {
        return s.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("E#", "e")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a")
            .replaceAll("B#", "b");
    }
    private int changeTimeToNum(String time) {
        return Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
    }
}