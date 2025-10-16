import java.io.*;

public class Main {
    static int[][] sudoku;
    static boolean[][][] visit;
    static boolean success;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		
		sudoku = new int[9][9];
		visit = new boolean[3][9][10]; // 마지막이 10 인 이유는 스도쿠의 숫자가 들어가는 자리이므로 (1 - base - position)
		for (int i = 0; i < 9; i++) {
		    String input = br.readLine();
		    for (int j = 0; j < 9; j++) {
		        sudoku[i][j] = input.charAt(j) - '0';
		        if (sudoku[i][j] != 0) {
		            visit[0][i][sudoku[i][j]] = true;
    		        visit[1][j][sudoku[i][j]] = true;
    		        visit[2][(i/3)*3+(j/3)][sudoku[i][j]] = true;
		        } 
		    } 
		} 
		findNum(0, 0);
		for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
		bw.flush();
	}
	private static void findNum(int x, int y) {
	    if (x == 8 && y == 8) {
	        for (int i = 1; i <= 9; i++) {
	            if (!visit[0][8][i]) {
	                sudoku[x][y] = i;
	                break;
	            } 
	        } 
	        success = true;
	        return;
	    } 
	    if (sudoku[x][y] != 0) {
            if(y != 8) {
                findNum(x, y+1);
            } else {
                findNum(x+1, 0);
            }
	    } else {
	        for (int i = 1; i <= 9; i++) {
	            if (!visit[0][x][i] && !visit[1][y][i] && !visit[2][(x/3)*3 + (y/3)][i]) {
	                visit[0][x][i] = true;
	                visit[1][y][i] = true;
	                visit[2][(x/3)*3 + (y/3)][i] = true;
	                sudoku[x][y] = i;
	                if (y != 8) {
	                    findNum(x, y+1);
	                } else {
	                    findNum(x+1, 0);
	                }
	                if (success) {
	                    return;
	                } 
	                sudoku[x][y] = 0;
	                visit[0][x][i] = false;
                    visit[1][y][i] = false;
                    visit[2][(x/3)*3+(y/3)][i] =false;
	            }
	        } 
	    }
	}
}