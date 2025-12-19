import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D;
    static int[][] board;
    static int[] archerPosX = new int[3];
    static int max = 0;
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
		    }
		}
		dfs(0, 0);
		bw.write(String.valueOf(max));
		bw.flush();
	}
    private static void dfs(int start, int idx) {
        if (idx == 3) {
            // 이제 몇 명 지울 수 있는지 함수 호출
            int killCount = playGame();
            max = Math.max(max, killCount);
            return;
        }
        for (int i = start; i < M; i++) {
            archerPosX[idx] = i;
            dfs(i + 1, idx + 1);
        }
    }
    private static int playGame() {
        int count = 0;
        int[][] status = new int[N][M];
        for (int line = N; line > 0; line--) {
            for (int posX : archerPosX) {
                for (int d = 1; d <= D; d++) {
                    int killCount = attack(status, line, posX, d);
                    if (killCount < 0) continue;
                    count += killCount;
                    break; // 한 턴에 한 번 씩만 공격하도록
                }
            }
        }
        return count;
    }
    private static int attack(int[][] status, int line, int posX, int dist) {
        for (int x = posX - dist; x <= posX + dist; x++) {
            int y = line - dist + Math.abs(x - posX);
            if (x < 0 || y < 0 || x >= M || y >= line) continue;
            if (board[y][x] == 0) continue;
            if (status[y][x] == 0) {
                status[y][x] = line;
                return 1;
            } else if (status[y][x] == line) return 0;
        }
        return -1;
    }
}