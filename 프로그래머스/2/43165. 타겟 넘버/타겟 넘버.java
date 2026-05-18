class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return count;
    }
    public void dfs(int[] numbers, int depth, int calc, int target) {
        if (depth == numbers.length) {
            if (calc == target) count++;
            return;
        }
        dfs(numbers, depth + 1, calc - numbers[depth], target);
        dfs(numbers, depth + 1, calc + numbers[depth], target);
    }
}