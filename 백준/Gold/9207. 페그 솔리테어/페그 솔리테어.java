import java.io.*;

public class Main {
    static char[][] board;
    static int minMove, minPin;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
		    minMove = Integer.MAX_VALUE;
		    int initPin = 0;
		    board = new char[5][9];
		    for (int i = 0; i < 5; i++) {
		        String input = br.readLine();
		        if (input.isEmpty()) {
	                i--;
	                continue;
	            }
		        for (int j = 0; j < 9; j++) {
		            board[i][j] = input.charAt(j);
		            if (board[i][j] == 'o') initPin++;
		        }
		    }
		    minPin = initPin;
		    dfs(initPin, 0);
		    sb.append(minPin).append(" ").append(minMove).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int pinCnt, int move) {
	    // 핵심은 핀이 이동된 경우 다시 0, 0부터 새로 훑어야함
	    boolean moved = false;
	    for (int x = 0; x < 5; x++) {
	        for (int y = 0; y < 9; y++) {
	            if (board[x][y] != 'o') continue;
	            for (int d = 0; d < 4; d++) {
    	            int nextPinX = x + dx[d];
    	            int nextPinY = y + dy[d];
    	            int nextPosX = nextPinX + dx[d];
    	            int nextPosY = nextPinY + dy[d];
    	            if (nextPinX < 0 || nextPinY < 0 || nextPinX >= 5 || nextPinY >= 9) continue;
    	            if (nextPosX < 0 || nextPosY < 0 || nextPosX >= 5 || nextPosY >= 9) continue;
    	            if (board[nextPinX][nextPinY] == '#' || board[nextPosX][nextPosY] == '#') continue;
        	        if (board[nextPinX][nextPinY] == 'o' && board[nextPosX][nextPosY] == '.') {
        	            moved = true;
        	            board[x][y] = '.';
        	            board[nextPinX][nextPinY] = '.';
        	            board[nextPosX][nextPosY] = 'o';
        	            dfs(pinCnt - 1, move + 1);
        	            board[x][y] = 'o';
        	            board[nextPinX][nextPinY] = 'o';
        	            board[nextPosX][nextPosY] = '.';
        	        }
	            }
	        }
	    }
	    if (!moved) {
	        if (minPin == pinCnt) minMove = Math.min(minMove, move);
	        else if (pinCnt < minPin) {
	            minPin = pinCnt;
	            minMove = move;
	        }
	    }
	}
}