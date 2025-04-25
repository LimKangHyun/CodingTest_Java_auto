import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 0, 1}; // 위, 좌, 우, 아래
    static int[] dx = {0, -1, 1, 0};

    static int sharkY, sharkX;
    static int size = 2;
    static int eatCount = 0;
    static int time = 0;

    static class Fish implements Comparable<Fish> {
        int y, x, dist;

        Fish(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist == o.dist) {
                if (this.y == o.y) {
                    return this.x - o.x;
                }
                return this.y - o.y;
            }
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                    map[i][j] = 0; // 상어 위치 초기화
                }
            }
        }

        while (true) {
            Fish fish = bfs();
            if (fish == null) break;

            sharkY = fish.y;
            sharkX = fish.x;
            time += fish.dist;
            eatCount++;

            if (eatCount == size) {
                size++;
                eatCount = 0;
            }

            map[sharkY][sharkX] = 0; // 물고기 먹고 빈칸으로
        }

        System.out.println(time);
    }

    static Fish bfs() {
        visited = new boolean[N][N];
        Queue<Fish> queue = new LinkedList<>();
        PriorityQueue<Fish> fishes = new PriorityQueue<>();

        queue.offer(new Fish(sharkY, sharkX, 0));
        visited[sharkY][sharkX] = true;

        while (!queue.isEmpty()) {
            Fish cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if (visited[ny][nx] || map[ny][nx] > size) continue;

                visited[ny][nx] = true;
                queue.offer(new Fish(ny, nx, cur.dist + 1));

                if (map[ny][nx] > 0 && map[ny][nx] < size) {
                    fishes.offer(new Fish(ny, nx, cur.dist + 1));
                }
            }
        }

        if (fishes.isEmpty()) return null;
        return fishes.poll();
    }
}