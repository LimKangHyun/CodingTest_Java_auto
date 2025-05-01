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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
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
            } 
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        } 
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (!visit[nx][ny]) { 
                    visit[nx][ny] = true;
                    // T자를 위한 분기 1번
                    if (depth == 2) {
                        dfs(x, y, depth+1, sum+arr[nx][ny]);
                    }
                    // 일반 모양 분기 2번
                    dfs(nx, ny, depth+1, sum+arr[nx][ny]);
                    // depth==2에서 뻗어나온 두 분기를 한번에 false처리하여 depth == 2를 종료
                    visit[nx][ny] = false;
                }
            } 
        } 
    }
}