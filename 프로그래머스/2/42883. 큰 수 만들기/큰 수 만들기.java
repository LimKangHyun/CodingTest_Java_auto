import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int n = number.length();
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && count < k && stack.peek() < number.charAt(i)) {
                stack.pop();
                count++;
            }
            stack.push(number.charAt(i));
        }
        while (stack.size() != n - k) stack.pop();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }
}