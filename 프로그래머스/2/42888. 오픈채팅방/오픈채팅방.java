import java.util.*;

class Solution {
    Map<String, String> user = new HashMap<>();
    int count = 0;
    public String[] solution(String[] records) {
        for (String r : records) {
            String[] record = r.split(" ");
            checkCmd(record);
        }
        String[] answer = new String[count];
        int idx = 0;
        for (int i = 0; i < records.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] record = records[i].split(" ");
            if (record[0].equals("Enter")) {
                sb.append(user.get(record[1])).append("님이 들어왔습니다.");
            } else if (record[0].equals("Leave")) {
                sb.append(user.get(record[1])).append("님이 나갔습니다.");
            } else continue;
            answer[idx] = sb.toString();
            idx++;
        }
        return answer;
    }
    private void checkCmd(String[] record) {
        if (record[0].equals("Enter") || record[0].equals("Change")) user.put(record[1], record[2]);
        if (record[0].equals("Enter") || record[0].equals("Leave")) count++;
    }
}