import java.util.*;

class Solution {
    int[][] board;
    public int solution(int[][] _board, int[] moves) {
        board = _board;
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int move : moves) {
            int dollNum = checkDollNum(move - 1, board.length);
            if (dollNum == 0) {
                deque.add(dollNum);
                continue;
            }
            if (!deque.isEmpty() && deque.peekLast() == dollNum) {
                deque.removeLast();
                answer += 2;
            } else deque.add(dollNum);
        }
        return answer;
    }
    private int checkDollNum(int move, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i][move] != 0) {
                int dollNum = board[i][move];
                board[i][move] = 0;
                return dollNum; 
            }
        }
        return 0;
    }
}