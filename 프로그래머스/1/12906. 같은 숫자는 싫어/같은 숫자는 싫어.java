import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int ar : arr) {
            if (!stack.isEmpty() && stack.peek() == ar) {
                stack.push(ar);
            } else {
                stack.push(ar);
                list.add(ar);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}