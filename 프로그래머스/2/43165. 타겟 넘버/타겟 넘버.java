class Solution {
    private static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
    private static void dfs(int[] numbers, int depth, int target, int calc) {
        if (depth == numbers.length) {
            if(calc == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, depth+1, target, calc + numbers[depth]);
        dfs(numbers, depth+1, target, calc - numbers[depth]);
    }
}