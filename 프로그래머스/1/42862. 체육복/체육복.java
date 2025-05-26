import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] stud = new int[n+2];
        for (int i : lost) {
            stud[i]--;
        }
        for (int i : reserve) {
            stud[i]++;
        }
        for(int i = 1; i <= n; i++) {
            if(stud[i] == -1) {
                if(stud[i-1] == 1) {
                    stud[i]++;
                    stud[i-1]--;
                } else if (stud[i+1] == 1) {
                    stud[i]++;
                    stud[i+1]--;
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }
}