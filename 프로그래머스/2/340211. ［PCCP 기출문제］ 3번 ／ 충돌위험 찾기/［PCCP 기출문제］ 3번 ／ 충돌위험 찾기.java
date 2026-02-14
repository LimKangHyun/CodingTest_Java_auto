import java.util.*;

class Solution {
    static Queue<int[]>[] record;
    static int size;
    static int answer = 0;
    public int solution(int[][] points, int[][] routes) {
        size = routes.length;
        record = new ArrayDeque[size];
        for (int i = 0; i < size; i++) {
            record[i] = new ArrayDeque<>();
        }
        recordRoute(points, routes);
        findCollision();
        return answer;
    }
    private static void recordRoute(int[][] points, int[][] routes) {
        for(int i = 0; i < size; i++) {
            int from = routes[i][0] - 1;
            int fromR = points[from][0] - 1;
            int fromC = points[from][1] - 1;
            record[i].add(new int[] {fromR, fromC});
            for (int j = 1; j < routes[i].length; j++) {
                int to = routes[i][j] - 1;
                int toR = points[to][0] - 1;
                int toC = points[to][1] - 1;
                while(fromR != toR) {
                    if (fromR < toR) {
                        fromR++;
                    } else {
                        fromR--;
                    }
                    record[i].add(new int[] {fromR, fromC});
                }
                while(fromC != toC) {
                    if (fromC < toC) {
                        fromC++;
                    } else {
                        fromC--;
                    }
                    record[i].add(new int[] {fromR, fromC});
                }
            }
        }
    }
    private static void findCollision() {
        int escapeBots = 0;
        while(escapeBots != size) {
            escapeBots = 0; // 매 초마다 탈출로봇개수 초기화(모두 나가는 시간 측정)
            int[][] map = new int[101][101]; // 매 초마다 맵 초기화(겹치는 좌표 측정)
            for (int i = 0; i < size; i++) {
                if (record[i].isEmpty()) {
                    escapeBots++;
                    continue;
                }
                int[] temp = record[i].poll();
                map[temp[0]][temp[1]]++;
            }
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] > 1) {
                        answer++;
                    }
                }
            }
        }
    }
}