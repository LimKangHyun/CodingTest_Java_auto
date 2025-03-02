import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static List<int[]> zero = new ArrayList<>();
    static List<int[]> virus = new ArrayList<>();
    static int MaxArea = 0;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    zero.add(new int[] {i, j});
                } else if (arr[i][j] == 2) {
                    virus.add(new int[] {i, j});
                }
            } 
        } 
        combination(0, 0);
        bw.write(String.valueOf(MaxArea));
        bw.flush();
    }
    private static void dfs(int x, int y, int[][] tempMap) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > 0 && ny > 0 && nx <= N && ny <= M) {
                if (tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    dfs(nx, ny, tempMap);
                }
            } 
        } 
    }
    private static void combination(int start, int count) {
        if (count == 3) {
            int[][] tempMap = new int[N+1][M+1];
            for (int i = 0; i <= N; i++) {
                tempMap[i] = arr[i].clone();
            } 
            for (int[] i : virus) {
                dfs(i[0], i[1], tempMap);
            } 
            int safeArea = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (tempMap[i][j] == 0) {
                        safeArea++;
                    } 
                } 
            } 
            MaxArea = Math.max(safeArea, MaxArea);
            return;
        } 
        for (int i = start; i < zero.size(); i++) {
            int[] temp = zero.get(i);
            arr[temp[0]][temp[1]] = 1;
            combination(i+1, count+1);
            arr[temp[0]][temp[1]] = 0;
        } 
    }
}