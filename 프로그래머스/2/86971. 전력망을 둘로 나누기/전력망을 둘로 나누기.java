import java.util.*;

class Solution {
    private static List<Integer>[] list;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            list = new ArrayList[n+1];
            for(int j = 0; j < list.length; j++) {
                list[j] = new ArrayList<>();
            }
            boolean[] visit = new boolean[n+1];
            for(int j = 0; j < n - 1; j++) {
                if (i != j) {
                    list[wires[j][0]].add(wires[j][1]);
                    list[wires[j][1]].add(wires[j][0]);
                }
            }
            dfs(list, 1, visit);
            int count = 0;
            for(int j = 0; j < visit.length; j++) {
                if(visit[j]) count++;
            }
            answer = Math.min(answer, (Math.abs((n - count) - count)));
        }
        
        return answer;
    }
    
    private static void dfs(List<Integer>[] list, int start, boolean[] visit) {
        for(int i : list[start]) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(list, i, visit);
            }
        }
    }
}