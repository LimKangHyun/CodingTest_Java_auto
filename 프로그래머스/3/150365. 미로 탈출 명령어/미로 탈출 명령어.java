class Solution {
    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, -1, 1, 0};
    private static String[] move = {"d", "l", "r", "u"};
    private static StringBuilder sb = new StringBuilder();
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int shortcut = Math.abs(x - r) + Math.abs(y - c);
        if (shortcut > k || Math.abs(shortcut - k) % 2 != 0) return "impossible";
        findShortestWords(0, shortcut, new StringBuilder(), n, m, x - 1, y - 1, r - 1, c - 1, k);
        return sb.toString();
    }
    private static void findShortestWords(int depth, int shortcut, StringBuilder temp, int n , int m, int x, int y, int r, int c, int k) {
        if (depth + Math.abs(x - r) + Math.abs(y - c) > k) return;
        if (sb.length() > 0 && temp.toString().compareTo(sb.toString()) > 0) return;
        if (depth == k) {
            if (x == r && y == c) {
                if (sb.length() == 0 || temp.toString().compareTo(sb.toString()) < 0) {
                    sb.setLength(0);
                    sb.append(temp.toString());
                }
                return;
            }
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            findShortestWords(depth + 1, shortcut, temp.append(move[i]), n, m, nx, ny, r, c, k);
            temp.setLength(temp.length() - 1);
        }
    }
}