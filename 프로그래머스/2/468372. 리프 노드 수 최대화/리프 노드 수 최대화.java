class Solution {
    int answer = 1;
    int dist_limit;
    int split_limit;
    public int solution(int _dist_limit, int _split_limit) {
        dist_limit = _dist_limit;
        split_limit = _split_limit;
        dfs(1, 1, 1, 0);
        return answer;
    }
    public void dfs(long split, long distUsed, long cur, long leaf) {
        if (distUsed > dist_limit) return;
        answer = (int) Math.max(answer, leaf + cur);
        for (int b = 2; b <= 3; b++) {
            long nextSplit = split * b;
            if (nextSplit > split_limit) continue;
            long nextNodes = cur * b;
            long remain = dist_limit - distUsed;
            long nextCur = Math.min(remain, nextNodes);
            long nextLeaf = leaf + nextNodes - nextCur;
            dfs(nextSplit, distUsed + nextCur, nextCur, nextLeaf);
        }
    }
    
}