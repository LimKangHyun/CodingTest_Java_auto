import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            graph = new int[M][N];
            visit = new boolean[M][N];
            
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X][Y] = 1;
            }
            
            int result = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (graph[j][k] == 1 && !visit[j][k]) {
                        int num = dfs(j, k);
                        if (num >= 1) {
                            result++;
                        } 
                    }
                } 
            }
            bw.write(String.valueOf(result) + "\n");
        } 
        bw.flush();
    }
    
    private static int dfs(int X, int Y) {
        visit[X][Y] = true;
        int count = 1;
        
        for (int i = 0; i < 4; i++) {
            int nx = X + dx[i];
            int ny = Y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (graph[nx][ny] == 1 && !visit[nx][ny]) {
                    count += dfs(nx, ny);    
                }
            }
        }
        return count;
    }
}