class Solution {
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;
        for (String b : board) {
            for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                if (c == 'O') oCount++;
                else if (c == 'X') xCount++;
            }
        }
        
        if (oCount < xCount || oCount > xCount + 1) return 0;
        boolean oWin = win(board, 'O');
        boolean xWin = win(board, 'X');
        if (oWin && xWin) return 0;
        if (oWin && oCount != xCount + 1) return 0;
        if (xWin && xCount != oCount) return 0;
        return 1;
    }
    
    private boolean win(String[] b, char c) {
        for (int i = 0; i < 3; i++) {
            if (b[i].charAt(0) == c &&
                b[i].charAt(1) == c &&
                b[i].charAt(2) == c) return true;
        }
        
        for (int i = 0; i < 3; i++) {
            if (b[0].charAt(i) == c &&
                b[1].charAt(i) == c &&
                b[2].charAt(i) == c) return true;
        }
        
        if (b[0].charAt(0) == c &&
            b[1].charAt(1) == c &&
            b[2].charAt(2) == c) return true;
        
        if (b[0].charAt(2) == c &&
            b[1].charAt(1) == c &&
            b[2].charAt(0) == c) return true;
        
        return false;
    }
}