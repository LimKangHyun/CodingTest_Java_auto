import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] stretch = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            stretch[i][0] = transformTime(book_time[i][0]);
            stretch[i][1] = transformTime(book_time[i][1]);
        }
        Arrays.sort(stretch, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(stretch));
        List<Integer> rooms = new ArrayList<>();
        for (int i = 0; i < stretch.length; i++) {
            int end = stretch[i][1];
            int start = stretch[i][0];
            if (i == 0) {
                rooms.add(end);
                continue;
            }
            int idx = 0;
            boolean isChanged = false;
            while (idx < rooms.size()) {
                if (start >= rooms.get(idx) + 10) {
                    rooms.set(idx, end);
                    isChanged = true;
                    break;
                }
                idx++;
            }
            if (!isChanged) rooms.add(end);
        }
        for (int i = 0; i < rooms.size(); i++) {
            System.out.print(rooms.get(i) + ", ");
        }
        return rooms.size();
    }
    private int transformTime(String time) {
        String[] temp = time.split(":");
        int hour = Integer.parseInt(temp[0]) * 60;
        int minute = Integer.parseInt(temp[1]);
        return hour + minute;
    }
}