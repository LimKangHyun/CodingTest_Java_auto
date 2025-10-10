import java.util.*;

class Solution {
    private static int maxNum = 0;
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        for(int i = 0; i < edges.length; i++) {
            maxNum = Math.max(maxNum, Math.max(edges[i][0], edges[i][1]));
        }
        int[][] arr = new int[maxNum + 1][2];
        for(int i = 0; i < edges.length; i++) {
            arr[edges[i][0]][0]++; // out
            arr[edges[i][1]][1]++; // in
        }
        for(int i = 1; i <= maxNum; i++) {
            if (arr[i][0] >= 2 && arr[i][1] == 0) {
                answer[0] =  i;
                break;
            }
        }
        for(int i = 1; i <= maxNum; i++) {
            if (i == answer[0]) continue;
            if (arr[i][0] == 0 && arr[i][1] > 0) answer[2]++; // 막대
            else if (arr[i][0] == 2 && arr[i][1] >= 2) answer[3]++;// 8자
        }
        answer[1] = arr[answer[0]][0] - answer[2] - answer[3];
        return answer;
    }
}