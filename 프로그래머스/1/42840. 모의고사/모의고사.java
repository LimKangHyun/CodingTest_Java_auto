import java.util.*;

class Solution {
    int[] first = {1,2,3,4,5};
    int[] second = {2,1,2,3,2,4,2,5};
    int[] third = {3,3,1,1,2,2,4,4,5,5};
    int max = 0;
    public int[] solution(int[] answers) {
        int firstCnt = 0;
        int secondCnt = 0;
        int thirdCnt = 0;
        for (int i = 0; i < answers.length; i++) {
            int num = answers[i];
            if (num == first[i % 5]) firstCnt++;
            if (num == second[i % 8]) secondCnt++;
            if (num == third[i % 10]) thirdCnt++;
        }
        max = Math.max(firstCnt, Math.max(secondCnt, thirdCnt));
        
        List<Integer> list = new ArrayList<>();
        if (max == firstCnt) list.add(1);
        if (max == secondCnt) list.add(2);
        if (max == thirdCnt) list.add(3);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}