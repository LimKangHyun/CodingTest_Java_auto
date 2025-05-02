import java.util.*;

class Solution {
    private static String[] answer;
    private static boolean[] visit;
    private static boolean isFinish;
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        visit = new boolean[tickets.length];
        //tickets 정렬(맨 처음 재귀에 들어갈 원소를 찾아야 하므로)
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals("ICN")) return -1; // 반환값이 음수이면 a, b 유지
            if (b[0].equals("ICN")) return 1; // 반환값이 양수이면 b, a로 변환
            return a[1].compareTo(b[1]); // 둘다 아니면 2번째 원소로 비교
        });
        System.out.println(Arrays.deepToString(tickets));
        dfs("ICN", "ICN", tickets, 0);
        return answer;
    }
    private static void dfs(String departure, String path, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            answer = path.split(",");
            isFinish = true;
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            if (!visit[i] && tickets[i][0].equals(departure)) {
                visit[i] = true;
                dfs(tickets[i][1], path + "," + tickets[i][1], tickets, depth+1);
                if (isFinish) break;
                visit[i] = false;
            }
        }
    }
}