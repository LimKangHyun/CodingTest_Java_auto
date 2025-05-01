import java.io.*;
import java.util.*;

public class Main {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] arr;
    private static boolean[][] visit;
    private static int N, M, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visit[i][j] = false;

                checkTShape(i, j); // T자 모양 탐색
            }
        }

        System.out.println(max);
    }

    // DFS로 4칸을 연결한 모양 탐색
    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inBounds(nx, ny) && !visit[nx][ny]) {
                visit[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
                visit[nx][ny] = false;
            }
        }
    }

    // T자 모양 탐색
    private static void checkTShape(int x, int y) {
        // 중심 블록을 기준으로 4방향 중 3개를 선택하는 4가지 경우
        int center = arr[x][y];

        for (int i = 0; i < 4; i++) {
            int temp = center;
            boolean isValid = true;

            for (int j = 0; j < 4; j++) {
                if (i == j) continue; // 중심 + 3방향만

                int nx = x + dx[j];
                int ny = y + dy[j];

                if (!inBounds(nx, ny)) {
                    isValid = false;
                    break;
                }

                temp += arr[nx][ny];
            }

            if (isValid) max = Math.max(max, temp);
        }
    }
    private static boolean inBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}