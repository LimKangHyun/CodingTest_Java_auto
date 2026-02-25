import java.util.*;

class Solution {
    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '*' || c == '+' || c == '-') {
                ops.add(c);
                numbers.add(Long.parseLong(expression.substring(idx, i)));
                idx = i + 1;
            }
        }
        numbers.add(Long.parseLong(expression.substring(idx)));
        char[][] priority = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '*', '+'},
            {'-', '+', '*'},
            {'*', '+', '-'},
            {'*', '-', '+'}
        };
        long answer = 0;
        for (char[] order : priority) {
            List<Long> tempNumbers = new ArrayList<>(numbers);
            List<Character> tempOps = new ArrayList<>(ops);
            for (char o : order) {
                for (int i = 0; i < tempOps.size(); ) {
                    if (tempOps.get(i) == o) {
                        long result = calc(tempNumbers.get(i), tempNumbers.get(i + 1), o);
                        tempNumbers.remove(i);
                        tempNumbers.remove(i);
                        tempNumbers.add(i, result);
                        tempOps.remove(i);
                    }
                    else i++;
                }
            }
            answer = Math.max(answer, Math.abs(tempNumbers.get(0)));
        }
        return answer;
    }
    private long calc (long a, long b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }
}