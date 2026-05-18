import java.util.*;

class Task {
    String name;
    int remain;
    
    Task(String name, int remain) {
        this.name = name;
        this.remain = remain;
    }
}
class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (a, b) -> toMin(a[1]) - toMin(b[1]));
        Stack<Task> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int start = toMin(plans[i][1]);
            int play = Integer.parseInt(plans[i][2]);
            
            int nextStart = (i == plans.length - 1) ? Integer.MAX_VALUE : toMin(plans[i + 1][1]);
            int available = nextStart - start;
            if (available >= play) {
                result.add(name);
                available -= play;
                
                while (!stack.isEmpty() && available > 0) {
                    Task t = stack.pop();
                    
                    if (available >= t.remain) {
                        available -= t.remain;
                        result.add(t.name);
                    } else {
                        t.remain -= available;
                        stack.push(t);
                        break;
                    }
                }
            } else {
                stack.push(new Task(name, play - available)); // 연주하지 못한 시간을 Stack에 push
            }
        }
        
        while (!stack.isEmpty()) {
            result.add(stack.pop().name);
        }
        
        return result.toArray(new String[0]);
    }
    public int toMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}