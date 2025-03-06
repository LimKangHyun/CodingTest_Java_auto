import java.io.*;
import java.util.*;

public class Main {
    static int[][] sudoku = new int[9][9];
    static boolean[][][] visit = new boolean[3][9][10]; //스도쿠에 들어가는 숫자가 1-base-position
    static boolean success = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9 ; j++) {
                sudoku[i][j] = input.charAt(j) - '0';
                if (sudoku[i][j] != 0) {
                    visit[0][i][sudoku[i][j]] = true; //행
                    visit[1][j][sudoku[i][j]] = true; //열
                    visit[2][(i/3)*3+(j/3)][sudoku[i][j]] = true; // 9*9 박스
                }
            }
        }
        findNum(0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(String.valueOf(sudoku[i][j]));
            }
            bw.newLine();
        }
        bw.flush();
    }
    static void findNum(int x, int y) {
        if(x == 8 && y == 8) {
            for (int i = 1; i <= 9; i++) {
                if (!visit[0][8][i]) {
                    sudoku[y][x] = i;
                    break;
                }
            }
            success = true;
            return;
        }
        if (sudoku[y][x] != 0) {
            if (x != 8) {
                findNum(x+1, y);
            } else {
                findNum(0, y+1);
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!visit[0][y][i] && !visit[1][x][i] && !visit[2][(y/3)*3+(x/3)][i]) {
                    visit[0][y][i] = true;
                    visit[1][x][i] = true;
                    visit[2][(y/3)*3+(x/3)][i] = true;
                    sudoku[y][x] = i;
                    if (x != 8) {
                        findNum(x+1, y);
                    } else {
                        findNum(0, y+1);
                    }
                    if (success) {
                        return;
                    }
                    sudoku[y][x] = 0;
                    visit[0][y][i] = false;
                    visit[1][x][i] = false;
                    visit[2][(y/3)*3+(x/3)][i] =false;
                }
            }
        }
    }
}