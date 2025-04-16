class Solution {
    private static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visit = new boolean[dungeons.length];
        dfs(k, dungeons, visit, 0);
        return answer;
    }
    
    private void dfs(int k, int[][] dungeons, boolean[] visit, int count) {
        answer = Math.max(answer, count);
        for(int i = 0; i < dungeons.length; i++) {
            if(!visit[i] && k >= dungeons[i][0]) {
                visit[i] = true;
                dfs(k - dungeons[i][1], dungeons, visit, count+1);
                visit[i] = false;
            }
        }
    }
}