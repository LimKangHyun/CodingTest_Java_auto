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
    private static int[][] copyArr;
    private static int[] dx = {0, 1, 0, -1}; // 상 우 하 좌
    private static int[] dy = {-1, 0, 1, 0};
    private static List<CCTV> list = new ArrayList<>();
    private static int[] cctvArr;
    private static int min = Integer.MAX_VALUE;
    
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
                if (arr[i][j] != 0 && arr[i][j] != 6) list.add(new CCTV(i, j, arr[i][j]));
            } 
        }
        cctvArr = new int[list.size()];
        combination(0, list.size());
        bw.write(String.valueOf(min));
        bw.flush();
    }
    private static void combination(int depth, int totalCCTV) {
        if (depth == totalCCTV) {
            copyArr = new int[N][M];
            for (int i = 0; i < arr.length; i++) {
                copyArr[i] = arr[i].clone();
            } 
            for (int i = 0; i < list.size(); i++) {
                direction(list.get(i), cctvArr[i]);
            } 
            findMinBlindSpot();
            return;
        } 
        for (int i = 0; i < 4; i++) {
            cctvArr[depth] = i;
            combination(depth+1, totalCCTV);
        } 
    }
    private static void direction(CCTV cctv, int d) {
        int cctvNum = cctv.num;
        if (cctvNum == 1) {
            if (d == 0) isWatched(cctv, 0);
            else if (d == 1) isWatched(cctv, 1);
            else if (d == 2) isWatched(cctv, 2);
            else if (d == 3) isWatched(cctv, 3);
        } else if (cctvNum == 2) {
            if (d == 0 || d == 2) {
                isWatched(cctv, 0);
                isWatched(cctv, 2);
            } else {
                isWatched(cctv, 1);
                isWatched(cctv, 3);
            }
        } else if (cctvNum == 3) {
            if (d == 0) {
                isWatched(cctv, 0);
                isWatched(cctv, 1);
            } else if (d == 1) {
                isWatched(cctv, 1);
                isWatched(cctv, 2);
            } else if (d == 2) {
                isWatched(cctv, 2);
                isWatched(cctv, 3);
            } else if (d == 3) {
                isWatched(cctv, 3);
                isWatched(cctv, 0);
            }
        } else if (cctvNum == 4) {
            if (d == 0) {
                isWatched(cctv, 3);
                isWatched(cctv, 0);
                isWatched(cctv, 1);
            } else if (d == 1) {
                isWatched(cctv, 0);
                isWatched(cctv, 1);
                isWatched(cctv, 2);
            } else if (d == 2) {
                isWatched(cctv, 1);
                isWatched(cctv, 2);
                isWatched(cctv, 3);
            } else if (d == 3) {
                isWatched(cctv, 2);
                isWatched(cctv, 3);
                isWatched(cctv, 0);
            }
        } else if (cctvNum == 5) {
            isWatched(cctv, 0);
            isWatched(cctv, 1);
            isWatched(cctv, 2);
            isWatched(cctv, 3);
        }
    }
    private static void findMinBlindSpot() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyArr[i][j] == 0) count++; 
            } 
        } 
        min = Math.min(min, count);
    }
    private static void isWatched(CCTV cctv, int d) {
        int nx = cctv.x;
        int ny = cctv.y;
        while(true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || copyArr[nx][ny] == 6) {
                break;
            } 
            if (copyArr[nx][ny] == 0) {
                copyArr[nx][ny] = -1;
            }
        }
    }
}