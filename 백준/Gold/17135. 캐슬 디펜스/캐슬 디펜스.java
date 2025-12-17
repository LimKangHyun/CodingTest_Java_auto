import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D, max = 0;
    static int[][] board;
    static List<int[]> originalEnemies = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) originalEnemies.add(new int[]{i, j});
            }
        }

        // 궁수 위치 조합
        combination(0, 0, new int[3]);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    static void combination(int start, int depth, int[] archers) {
        if (depth == 3) {
            simulate(archers);
            return;
        }
        for (int i = start; i < M; i++) {
            archers[depth] = i;
            combination(i + 1, depth + 1, archers);
        }
    }

    static void simulate(int[] archers) {
        List<int[]> enemies = new ArrayList<>();
        for (int[] e : originalEnemies) enemies.add(new int[]{e[0], e[1]});

        int removed = 0;

        while (!enemies.isEmpty()) {
            Set<int[]> targets = new HashSet<>();

            // 각 궁수별 공격 후보 선정
            for (int archer : archers) {
                List<int[]> candidates = new ArrayList<>();
                for (int[] e : enemies) {
                    int dist = Math.abs(N - e[0]) + Math.abs(archer - e[1]);
                    if (dist <= D) candidates.add(e);
                }
                if (!candidates.isEmpty()) {
                    candidates.sort((a, b) -> {
                        int d1 = Math.abs(N - a[0]) + Math.abs(archer - a[1]);
                        int d2 = Math.abs(N - b[0]) + Math.abs(archer - b[1]);
                        if (d1 != d2) return d1 - d2;
                        return a[1] - b[1];
                    });
                    targets.add(candidates.get(0));
                }
            }

            // 공격
            for (int[] t : targets) {
                enemies.removeIf(e -> e[0] == t[0] && e[1] == t[1]);
                removed++;
            }

            // 적 이동
            List<int[]> remaining = new ArrayList<>();
            for (int[] e : enemies) {
                if (e[0] + 1 < N) remaining.add(new int[]{e[0] + 1, e[1]});
            }
            enemies = remaining;
        }

        max = Math.max(max, removed);
    }
}