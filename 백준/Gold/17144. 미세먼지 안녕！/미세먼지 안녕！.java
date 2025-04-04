import java.io.*;
import java.util.*;

public class Main {
    private static int R, C;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int puriTop, puriBottom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        int T = Integer.parseInt(input[2]);
        int[][] room = new int[R][C];

        for (int i = 0; i < R; i++) {
            String[] num = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(num[j]);
            }
        }
        for (int i = 0; i < R; i++) {
            if (room[i][0] == -1) {
                puriTop = i;
                puriBottom = i + 1;
                break;
            }
        }
        for (int i = 0; i < T; i++) {
            room = runPuri(findDust(room));
        }
        int answer = count(room);
        bw.write(String.valueOf(answer));
        bw.flush();
    }
    private static int[][] findDust(int[][] room) {
        int[][] spread = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                spread[i][j] = room[i][j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) {
                    int diffuse = room[i][j] / 5;
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && ny >= 0 && nx < R && ny < C && room[nx][ny] != -1) {
                            spread[nx][ny] += diffuse;
                            spread[i][j] -= diffuse;
                        }
                    }
                }
            }
        }
        return spread;
    }
    private static int[][] runPuri(int[][] room) {
        for (int i = puriTop - 1; i > 0; i--) {
            room[i][0] = room[i - 1][0];
        }
        for (int j = 0; j < C - 1; j++) {
            room[0][j] = room[0][j + 1];
        }
        for (int i = 0; i < puriTop; i++) {
            room[i][C - 1] = room[i + 1][C - 1];
        }
        for (int j = C - 1; j > 1; j--) {
            room[puriTop][j] = room[puriTop][j - 1];
        }
        room[puriTop][1] = 0;

        for (int i = puriBottom + 1; i < R - 1; i++) {
            room[i][0] = room[i + 1][0];
        }
        for (int j = 0; j < C - 1; j++) {
            room[R - 1][j] = room[R - 1][j + 1];
        }
        for (int i = R - 1; i > puriBottom; i--) {
            room[i][C - 1] = room[i - 1][C - 1];
        }
        for (int j = C - 1; j > 1; j--) {
            room[puriBottom][j] = room[puriBottom][j - 1];
        }
        room[puriBottom][1] = 0;
        return room;
    }
    private static int count(int[][] room) {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] != -1) {
                    sum += room[i][j];
                }
            }
        }
        return sum;
    }
}