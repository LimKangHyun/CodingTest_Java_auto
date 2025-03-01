import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dist;
    static boolean[][][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        dist = new int[N+1][M+1];
        visit = new boolean[N+1][M+1][2];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = line.charAt(j-1) - '0';
            } 
        } 
        bw.write(String.valueOf(bfs()));
        bw.flush();
    }
    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        visit[1][1][0] = true;
        visit[1][1][1] = true;
        queue.offer(new Node (1, 1, 1, 0));
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.x == N && current.y == M) {
                return current.count;
            } 
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx > 0 && ny > 0 && nx <= N && ny <= M) {
                    if (arr[nx][ny] == 0) {
                        if (!visit[nx][ny][current.wall]) {
                            queue.offer(new Node(nx, ny, current.count+1, current.wall));
                            visit[nx][ny][current.wall] = true;
                        } 
                    } else {
                        if (current.wall == 0 && !visit[nx][ny][1]) {
                            queue.offer(new Node(nx, ny, current.count+1, 1));
                            visit[nx][ny][1] = true;
                        }
                    }
                } 
            } 
        }
        return -1;
    }
    private static class Node {
        private int x;
        private int y;
        private int count;
        private int wall;
        
        public Node(int x, int y, int count, int wall) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall = wall;
        }
    }
}