import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int max = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dx = {{-1, 0}, {-1, 0}, {1, 0}, {1, 0}};
    static int[][] dy = {{0, -1}, {0, 1}, {0, -1}, {0, 1}};
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st;
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      arr = new int[N][M];
      visited = new boolean[N][M];
      for (int i = 0; i < N; i++) {
          st = new StringTokenizer(br.readLine());
          for (int j = 0; j < M; j++) {
              arr[i][j] = Integer.parseInt(st.nextToken());
          }
      }
      dfs(0, 0, 0);
      bw.write(String.valueOf(max));
      bw.flush();
   }
   private static void dfs(int x, int y, int sum) {
       if (x >= N) {
           max = Math.max(max, sum);
           return;
       }
       int nx = (y + 1 >= M) ? x + 1 : x;
       int ny = (y + 1 >= M) ? 0 : y + 1;
       if (!visited[x][y]) {
           for (int d = 0; d < 4; d++) {
               int dx1 = x + dx[d][0];
               int dy1 = y + dy[d][0];
               int dx2 = x + dx[d][1];
               int dy2 = y + dy[d][1];
               if (dx1 < 0 || dy1 < 0 || dx1 >= N || dy1 >= M) continue;
               if (dx2 < 0 || dy2 < 0 || dx2 >= N || dy2 >= M) continue;
               if (visited[dx1][dy1] || visited[dx2][dy2]) continue;
               visited[x][y] = true;
               visited[dx1][dy1] = true;
               visited[dx2][dy2] = true;
               dfs(nx, ny, sum + arr[x][y] * 2 + arr[dx1][dy1] + arr[dx2][dy2]);
               // 백트래킹
               visited[x][y] = false;
               visited[dx1][dy1] = false;
               visited[dx2][dy2] = false;
           }
       }
       dfs(nx, ny, sum);
   }
}
