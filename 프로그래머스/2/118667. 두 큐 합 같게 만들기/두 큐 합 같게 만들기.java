import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long total = 0;
        int len = n * 2;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < n) arr[i] = queue1[i];
            else arr[i] = queue2[i - n];
            total += arr[i];
        }
        if (total % 2 != 0) return -1;
        long goalNum = total / 2;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += queue1[i];
        }
        int left = 0;
        int right = n;
        int count = 0;
        while (left < right && right < len) {
            if (sum == goalNum) return count;
            else if (sum < goalNum) {
                sum += arr[right++];
            } else {
                sum -= arr[left++];
            }
            count++;
        }
        return -1;
    }
}