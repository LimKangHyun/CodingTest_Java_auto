import java.io.*;
import java.util.*;

class Solution {
    private static int minDis = Integer.MAX_VALUE;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int del = 0;
        int pic = 0;
        for (int i = n - 1; i >= 0; i--) {
            del += deliveries[i];
            pic += pickups[i];
            while(del > 0 || pic > 0) {
                del -= cap;
                pic -= cap;
                answer += (i + 1) * 2L;
            }
        }
        return answer;
    }
}