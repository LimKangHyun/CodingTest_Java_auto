class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            int limit = addSchedule(schedules[i]);
            boolean success = true;
            int day = startday;
            for (int t = 0; t < timelogs[0].length; t++) {
                if (day % 7 != 0 && day % 7 != 6) {
                    if (timelogs[i][t] > limit) {
                        success = false;
                        break;
                    }
                }
                day++;
            }
            if (success) answer++;
        }
        return answer;
    }
    
    private int addSchedule(int time) {
        return time % 100 >= 50 ? time + 50 : time + 10;
    }
}