import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        if (wallet[0] > wallet[1]) {
            int temp = wallet[0];
            wallet[0] = wallet[1];
            wallet[1] = temp;
        }
        while(true) {
            if (bill[0] > bill[1]) {
                int temp = bill[0];
                bill[0] = bill[1];
                bill[1] = temp;
            }
            if (bill[0] <= wallet[0] && bill[1] <= wallet[1]) break;
            bill[1] /= 2;
            answer++;
        }
        return answer;
    }
}