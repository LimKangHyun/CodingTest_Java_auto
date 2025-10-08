import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(String s : terms) {
            String[] term = s.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        int todayNum = getTotalDay(today);
        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            if (getTotalDay(privacy[0]) + (map.get(privacy[1]) * 28) <= todayNum) {
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    private static int getTotalDay(String date) {
        String[] ymd = date.split("\\.");
        int year = Integer.parseInt(ymd[0]);
        int month = Integer.parseInt(ymd[1]);
        int day = Integer.parseInt(ymd[2]);
        return day + (month * 28) + (year * 28 * 12);
    }
}