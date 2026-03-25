class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        final int TIME_TERM = 10;
        
        int curTime = convertStringToTime(pos);
        int totalLen = convertStringToTime(video_len);
        
        for (String command : commands) {
            curTime = checkIsOpening(curTime, op_start, op_end);
            if (command.equals("prev")) {
                curTime = curTime < TIME_TERM ? 0 : curTime - TIME_TERM;
            } else {
                curTime = curTime + TIME_TERM > totalLen ? totalLen : curTime + TIME_TERM; 
            }
        }
        curTime = checkIsOpening(curTime, op_start, op_end);
        return convertTimeToString(curTime);
    }
    private int checkIsOpening(int time, String op_start, String op_end) {
        int start = convertStringToTime(op_start);
        int end = convertStringToTime(op_end);
        return time >= start && time <= end ? end : time;
    }
    private int convertStringToTime(String time) {
        int result = 0;
        String[] str = time.split(":");
        int minute = Integer.parseInt(str[0]);
        int second = Integer.parseInt(str[1]);
        result += (minute * 60) + second;
        return result;
    }
    private String convertTimeToString(int time) {
        String minuteStr = String.valueOf(time / 60);
        String secondStr = String.valueOf(time % 60);
        String minute = time / 60 < 10 ? "0" + minuteStr : minuteStr;
        String second = time % 60 < 10 ? "0" + secondStr : secondStr;
        return minute + ":" + second;
    }
}