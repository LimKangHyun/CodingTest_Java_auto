import java.io.*;
import java.util.*;

public class Main {
    static class CCTV {
        int x, y, num;
        CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    private static int N, M;
    private static int[][] arr;
    private static int[] dx = {0, 1, 0, -1}; // 상 우 하 좌
    private static int[] dy = {-1, 0, 1, 0};
    private static List<CCTV> cctvList = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;
    private static int[][][] direction = {
        {},
        {{0}, {1}, {2}, {3}},
        {{0, 2}, {1, 3}},
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
        {{0, 1, 2, 3}},
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0 && arr[i][j] != 6) cctvList.add(new CCTV(i, j, arr[i][j]));
            } 
        }
        dfs(0, arr);
        bw.write(String.valueOf(min));
        bw.flush();
    }
    private static void dfs(int depth, int[][] arr) {
        if (depth == cctvList.size()) {
            int blindSpotCount = findBlindSpot(arr);
            min = Math.min(min, blindSpotCount);
            return;
        }
        CCTV cctv = cctvList.get(depth);
        int type = cctv.num;
        
        for (int[] dirs : direction[type]) {
            int[][] copyArr = new int[N][M];
            for (int i = 0; i < N; i++) {
                copyArr[i] = arr[i].clone();
            } 
            for (int dir : dirs) {
                isWatched(copyArr, cctv.x, cctv.y, dir);
            }
            dfs(depth+1, copyArr);
        } 
    }
    private static void isWatched(int[][] copyArr, int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        while(nx >= 0 && ny >= 0 && nx < N && ny < M && copyArr[nx][ny] != 6) {
            if (copyArr[nx][ny] == 0) {
                copyArr[nx][ny] = -1;
            }
            nx += dx[dir];
            ny += dy[dir];
        }
    }
    private static int findBlindSpot(int[][] arr) {
        int count = 0;
        for (int[] row : arr) {
            for (int value : row) {
                if (value == 0) count++; 
            } 
        } 
        return count;
    }
}