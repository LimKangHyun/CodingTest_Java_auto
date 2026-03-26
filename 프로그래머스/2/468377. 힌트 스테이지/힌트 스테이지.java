class Solution {
    int[][] cost, hint;
    int n;
    int min = Integer.MAX_VALUE;
    public int solution(int[][] _cost, int[][] _hint) {
        cost = _cost;
        hint = _hint;
        n = cost.length;
        int[] hintCount = new int[n];
        dfs(0, 0, hintCount);
        return min;
    }
    private void dfs(int stage, int totalCost, int[] hintCount) {
        if (totalCost >= min) return;
        if (stage == n - 1) {
            for (int i = 0; i < n; i++) {
                int used = Math.min(hintCount[i], n - 1); // 힌트 개수가 더 많을 수 있음
                totalCost += cost[i][used];
            }
            min = Math.min(min, totalCost);
            return;
        }
        buyTickets(stage, hintCount);
        dfs(stage + 1, totalCost + hint[stage][0], hintCount);
        cancelTickets(stage, hintCount);
        
        dfs(stage + 1, totalCost, hintCount);
    }
    private void buyTickets(int stage, int[] hintCount) {
        int hLen = hint[stage].length;
        for (int i = 1; i < hLen; i++) {
            hintCount[hint[stage][i] - 1]++;
        }
    }
    private void cancelTickets(int stage, int[] hintCount) {
        int hLen = hint[stage].length;
        for (int i = 1; i < hLen; i++) {
            hintCount[hint[stage][i] - 1]--;
        }
    }
}