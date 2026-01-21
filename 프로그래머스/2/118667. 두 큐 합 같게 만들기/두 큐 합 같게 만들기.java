import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int goalNum = 0;
        int len = queue1.length * 2;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < len / 2) arr[i] = queue1[i];
            else arr[i] = queue2[i - len / 2];
            goalNum += arr[i];
        }
        goalNum /= 2;
        System.out.println(Arrays.toString(arr));
        int answer = -2;
        return answer;
    }
}