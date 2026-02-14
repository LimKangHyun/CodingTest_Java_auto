class Solution {
    static int maxDiff = 0;
    static int[] apeach;
    static int[] best;
    public int[] solution(int n, int[] info) {
        apeach = info;
        dfs(0, n, new int[11]);
        if (best == null) return new int[] {-1};
        return best;
    }
    private static void dfs(int idx, int remain, int[] lion) {
        if (idx == 11) {
            lion[10] += remain;
            calculateScore(lion);
            lion[10] -= remain;
            return;
        }
        int need = apeach[idx] + 1;
        if (remain >= need) {
            lion[idx] = need;
            dfs(idx + 1, remain - need, lion);
            lion[idx] = 0;
        }
        dfs(idx + 1, remain, lion);
    }
    private static void calculateScore(int[] lion) {
        int lionScore = 0;
        int apeachScore = 0;
        for (int i = 0; i < 11; i++) {
            if (lion[i] == 0 && apeach[i] == 0) continue;
            if (lion[i] > apeach[i]) lionScore += (10 - i);
            else apeachScore += (10 - i);
        }
        int diff = lionScore - apeachScore;
        if (diff <= 0) return;
        if (best == null || diff > maxDiff || (diff == maxDiff && isBetter(lion))) {
            maxDiff = diff;
            best = lion.clone();
        }
    }
    private static boolean isBetter(int[] lion) {
        for (int i = 10; i >= 0; i--) {
            if (lion[i] != best[i]) {
                return lion[i] > best[i];
            }
        }
        return false;
    }
}