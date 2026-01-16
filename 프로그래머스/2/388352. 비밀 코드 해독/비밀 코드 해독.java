import java.util.*;

class Solution {
    static int count = 0;
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        List<Integer> candidate = new ArrayList<>();
        dfs(1, candidate, n, q, ans);
        return count;
    }
    private static void dfs(int start, List<Integer> candidate, int n, int[][] q, int[] ans) {
        if (candidate.size() == 5) {
            if (checkCandidate(candidate, n, q, ans)) {
                count++;
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            candidate.add(i);
            dfs(i + 1, candidate, n, q, ans);
            candidate.remove(candidate.size() - 1);
        }
    }
    private static boolean checkCandidate(List<Integer> candidate, int n, int[][] q, int[] ans) {
        Set<Integer> set = new HashSet<>(candidate);
        for (int i = 0; i < q.length; i++) {
            int common = 0;
            for (int num : q[i]) {
                if (set.contains(num)) {
                    common++;
                }
            }
            if (common != ans[i]) return false;
        }
        return true;
    }
}