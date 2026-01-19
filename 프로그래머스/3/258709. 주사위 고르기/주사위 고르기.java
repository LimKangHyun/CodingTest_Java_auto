import java.util.*;

class Solution {
    static List<Integer> mine;
    static List<Integer> yours;
    static int[][] dice;
    static boolean[] selected;
    static int[] answer;
    static int maxWin = 0;
    public int[] solution(int[][] diceInput) {
        dice = diceInput;
        mine = new ArrayList<>();
        yours = new ArrayList<>();
        selected = new boolean[dice.length];
        answer = new int[dice.length / 2];
        dfs(0, 0);
        return answer;
    }
    private static void dfs(int depth, int start) {
        if (depth == dice.length / 2) {
            mine.clear();
            yours.clear();
            for (int i = 0; i < dice.length; i++) {
                if (selected[i]) mine.add(i);
                else yours.add(i);
            }
            Map<Integer, Integer> mineDist = buildDistMap(mine);
            Map<Integer, Integer> yoursDist = buildDistMap(yours);
            int win = compare(mineDist, yoursDist);
            if (maxWin <= win) {
                maxWin = win;
                int idx = 0;
                for (int i = 0; i< dice.length; i++) {
                    if (selected[i]) answer[idx++] = i + 1;
                }
            }
            return;
        }
        for (int i = start; i < dice.length; i++) {
            selected[i] = true;
            dfs(depth + 1, i + 1);
            selected[i] = false;
        }
    }
    private static Map<Integer, Integer> buildDistMap(List<Integer> list) {
        Map<Integer, Integer> dp = new HashMap<>(); // 굴린 주사위 합이 몇 번 나오는지
        dp.put(0, 1); // 더해질 첫 값이 필요, null에 더할 수 는 없으므로
        for (int idx : list) {
            Map<Integer, Integer> next = new HashMap<>();
            for (int sum : dp.keySet()) {
                for (int face : dice[idx]) {
                    int newSum = sum + face;
                    next.put(newSum, next.getOrDefault(newSum, 0) + dp.get(sum));
                }
            }
            dp = next;
        }
        return dp;
    }
    private static int compare(Map<Integer, Integer> mine, Map<Integer, Integer> yours) {
        int win = 0;
        for (int m : mine.keySet()) {
            for (int y : yours.keySet()) {
                if (m > y) win += mine.get(m) * yours.get(y);
            }
        }
        return win;
    }
}