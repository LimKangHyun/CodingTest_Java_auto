import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D;
    static int[][] board;
    static int max = 0;
    static Map<Integer, Boolean> enemies = new HashMap<>();
    static int[] dy = {0, -1, 0};
    static int[] dx = {-1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken()); // 공격 거리 제한
		board = new int[N][M]; // 궁수 위치는 N + 1이지만 실제 board는 안쓰기 때문에 배열크기는 N으로 설정
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < M; j++) {
		        int idx = i * M + j;
		        board[i][j] = Integer.parseInt(st.nextToken());
		        if (board[i][j] == 1) enemies.put(idx, true);
		    }
		}
		dfs(0, 0, new int[3]);
		bw.write(String.valueOf(max));
		bw.flush();
	}
    private static void dfs(int start, int idx, int[] archerPosX) {
        // 궁수 3명 배치
        if (idx == 3) {
            // 정상적인 백트래킹을 위해 적 정보 true로 초기화
            initEnemyState();
            // 이제 몇 명 지울 수 있는지 함수 호출
            int killCount = playGame(archerPosX);
            max = Math.max(max, killCount);
            return;
        }
        for (int i = start; i < M; i++) {
            archerPosX[idx] = i;
            dfs(i + 1, idx + 1, archerPosX);
        }
    }
    private static void initEnemyState() {
        enemies.replaceAll((key, value) -> {
           if (!value) return true;
           return value;
        });
    }
    private static int playGame(int[] archerPosX) {
        int archerPosY = N;
        int count = 0;
        while (archerPosY > 0) {
            int firstArcherTargetIdx = move(archerPosY, archerPosX[0], archerPosY);
            int secondArcherTargetIdx = move(archerPosY, archerPosX[1], archerPosY);
            int thirdArcherTargetIdx = move(archerPosY, archerPosX[2], archerPosY);
            count += kill(firstArcherTargetIdx) + kill(secondArcherTargetIdx) + kill(thirdArcherTargetIdx);
            archerPosY--;
        }
        return count;
    }
    private static int move(int y, int x, int limitY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {y, x, D});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[2] <= 0) continue;
            for (int i = 0; i < 3; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                int idx = ny * M + nx;
                if (ny < 0 || nx < 0 || ny >= limitY || nx >= M) continue; // 적의 y위치는 궁수의 y위치보다 작아야하므로
                if (enemies.get(idx) != null && enemies.get(idx)) return idx;
                else queue.offer(new int[] {ny, nx, cur[2] - 1});
            }
        }
        return -1;
    }
    private static int kill(int idx) {
        // 적 idx가 -1이 아니고, 현재 적 idx가 true인 경우만(궁수들이 같은 적을 죽이는 것을 방지)
        if (idx >= 0 && enemies.get(idx)) {
            enemies.put(idx, false);
            return 1;
        }
        return 0;
    }
}