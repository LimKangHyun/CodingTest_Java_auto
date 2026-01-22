import java.util.*;

class Solution {
    static int count = 0;
    static int[] liveServer = new int[24];
    public int solution(int[] players, int m, int k) {
        int n = players.length;
        for (int i = 0; i < n; i++) {
            int needServerNum = players[i] / m;
            if (needServerNum > liveServer[i]) {
                int add = needServerNum - liveServer[i];
                count += add;
                manageServerTime(i, add, n, k);
            }
        }
        return count;
    }
    private static void manageServerTime(int time, int add, int n, int k) {
        for (int i = time; i < time + k && i < n; i++) {
            liveServer[i] += add;
        }
    }
}