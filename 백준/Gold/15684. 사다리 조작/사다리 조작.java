import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, H;
    private static int[][] ladder;
    private static boolean found = false;
    private static int answer = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		H = Integer.parseInt(input[2]);
		ladder = new int[H+2][N+2];
		for (int i = 0; i < M; i++) {
		    String[] bridge = br.readLine().split(" ");
		    ladder[Integer.parseInt(bridge[0])][Integer.parseInt(bridge[1])] = 1;
		} 
		for (int i = 0; i <= 3; i++) {
		    dfs(0, i, 1, 1);
		}
		bw.write(String.valueOf(answer));
		bw.flush();
	}
	private static void dfs(int depth, int limit, int row, int col) {
	    if (found) return; // 이미 계산값이 나온 경우 불필요한 백트래킹 종료
	    if (depth == limit) {
	        if (isPair()) {
    	        answer = depth;
    	        found = true;
    	    }
    	    return;
	    }
	    for (int i = row; i <= H; i++) {
	        int jStart = (i == row) ? col : 1;
	        for (int j = jStart; j < N; j++) {
	            if (ladder[i][j-1] == 0 && ladder[i][j] == 0 && ladder[i][j+1] == 0) {
	                ladder[i][j] = 1;
	                dfs(depth+1, limit, i, j+2);
	                ladder[i][j] = 0;
	                if (found) return; // 이미 계산값이 나온 경우 불필요한 백트래킹 종료
	            }
	        } 
	    } 
	}
	private static boolean isPair() {
	    for (int i = 1; i <= N; i++) {
	        int line = i;
	        int row = 1;
	        while(row <= H) {
	            if (ladder[row][line] == 1) {
	                line ++;
	            } else if (ladder[row][line-1] == 1) {
	                line --;
	            }
	            row++;
	        }
	        if (line != i) return false;
	    } 
	    return true;
	}
}