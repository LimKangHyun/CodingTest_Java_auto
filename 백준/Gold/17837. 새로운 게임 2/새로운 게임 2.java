import java.io.*;
import java.util.*;

public class Main {
    private static int N, K;
    private static int[][] board;
    private static List<Integer>[][] stackBoard;
    private static int[][] chessMen;
    private static int[] pieceDir;
    private static int[] dx = {0, 0, 0, -1, 1};
    private static int[] dy = {0, 1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		stackBoard = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        stackBoard[i][j] = new ArrayList<>();
		    }
		}
		chessMen = new int[K + 1][2];
		pieceDir = new int[K + 1];
		
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        board[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		for (int i = 1; i <= K; i++) {
		    st = new StringTokenizer(br.readLine());
		    int r = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    int d = Integer.parseInt(st.nextToken());
		    chessMen[i][0] = r - 1;
		    chessMen[i][1] = c - 1;
		    pieceDir[i] = d;
		    stackBoard[r - 1][c - 1].add(i);
		}
		int turn = 1;
		while(turn <= 1000) {
		    if (simulate()) {
		        System.out.println(turn);
		        return;
		    }
		    turn++;
		}
		System.out.println(-1);
	}
	private static boolean simulate() {
	    for (int i = 1; i <= K; i++) {
	        int x = chessMen[i][0];
            int y = chessMen[i][1];
            int nx = x + dx[pieceDir[i]];
            int ny = y + dy[pieceDir[i]];
            
            List<Integer> curList = stackBoard[x][y];
            int idx = curList.indexOf(i);
            List<Integer> moving = new ArrayList<>(curList.subList(idx, curList.size()));
            curList.subList(idx, curList.size()).clear();
            
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 2) {
                pieceDir[i] = reverseDir(pieceDir[i]);
                nx = x + dx[pieceDir[i]];
                ny = y + dy[pieceDir[i]];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 2) {
                    stackBoard[x][y].addAll(moving);
                    continue;
                }
            }
            if (board[nx][ny] == 1) Collections.reverse(moving);
            stackBoard[nx][ny].addAll(moving);
            
            for (int num : moving) {
                chessMen[num][0] = nx;
                chessMen[num][1] = ny;
            }
            if (stackBoard[nx][ny].size() >= 4) return true;
	    }
	    return false;
	}
	private static int reverseDir(int dir) {
	    int[] temp = {0, 2, 1, 4, 3};
	    return temp[dir];
	}
}