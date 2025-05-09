import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        for(int[] result : results) {
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;
        }
        for(int p = 1; p <= n; p++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if (graph[i][p] == 1 && graph[p][j] == 1) {
                        graph[i][j] = 1;
                    }
                    if (graph[i][p] == -1 && graph[p][j] == -1) {
                        graph[i][j] = -1;
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            int fightCount = 0;
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] != 0) fightCount++;
            }
            if(fightCount == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}