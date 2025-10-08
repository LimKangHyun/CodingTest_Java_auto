class Solution {
    private static int[] rates = {10, 20, 30, 40};
    private static int maxSubNum = 0;
    private static int maxTotalSales = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        dfs(0, emoticons, users, new int[emoticons.length]);
        answer[0] = maxSubNum;
        answer[1] = maxTotalSales;
        return answer;
    }
    private static void dfs(int depth, int[] emoticons, int[][] users, int[] discounts) {
        if (depth == emoticons.length) {
            calc(emoticons, users, discounts);
            return;
        }
        for(int rate : rates) {
            discounts[depth] = rate;
            dfs(depth + 1, emoticons, users, discounts);
        }
    }
    private static void calc(int[] emoticons, int[][] users, int[] discounts) {
        int subNum = 0;
        int totalSales = 0;
        for(int[] user : users) {
            int sum = 0;
            for(int i = 0; i < emoticons.length; i++) {
                if (user[0] <= discounts[i]) {
                    sum += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }
            if (sum >= user[1]) subNum++;
            else totalSales += sum;
        }
        if (subNum > maxSubNum || (subNum == maxSubNum && totalSales > maxTotalSales)) {
            maxSubNum = subNum;
            maxTotalSales = totalSales;
        }
    }
}