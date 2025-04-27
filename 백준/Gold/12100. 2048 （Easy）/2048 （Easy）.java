import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] initBoard;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int maxBlockValue = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		initBoard = new int[N][N];
		for (int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        initBoard[i][j] = Integer.parseInt(st.nextToken());
		    } 
		} 
		dfs(0, initBoard);
		bw.write(String.valueOf(maxBlockValue));
		bw.flush();
	}
	// currentBoard = move의 대상이 되는 보드 지칭
	private static void dfs(int depth, int[][] currentBoard) {
	    if (depth == 5) {
	        maxBlockValue = Math.max(maxBlockValue, findMaxValue(currentBoard));
	        return;
	    } 
	    // nextBoard = move작업 후의 보드 상태 지칭
	    for (int dir = 0; dir < 4; dir++) {// 상하좌우 다 밀어보기
	        int[][] nextBoard = move(dir, currentBoard);
	        dfs(depth+1, nextBoard);
	    } 
	}
	// newBoard = 상하좌우 작업용 보드 지칭
	private static int[][] move(int dir, int[][] board) {
	    int[][] newBoard = new int[N][N];
	    for (int i = 0; i < N; i++) {
	        newBoard[i] = board[i].clone();
	    } 
	    switch(dir) {
	        case 0: // 위로 미는 동작이므로
	            for (int c = 0; c < N; c++) { // 각 컬럼에 대해 진행
	                int[] temp = new int[N];
	                // 각 컬럼에 대해 존재하는 값들만 계산을 위해 0인 부분은 제외하고 배열에 담기
	                int idx = 0;
	                for (int r = 0; r < N; r++) {
	                    if (newBoard[r][c] != 0) {
	                        temp[idx++] = newBoard[r][c];
	                    } 
	                } 
	                // 같은 숫자인 경우 합쳐진 자리 2배, 빈 자리 0
	                for (int r = 0; r < N - 1; r++) {
	                    if (temp[r] == temp[r+1] && temp[r] != 0) {
	                        temp[r] *= 2;
	                        temp[r+1] = 0;
	                        r++;
	                    } 
	                } 
	                // temp 압축
	                int[] compress = new int[N];
	                idx = 0;
	                for (int i = 0; i < N; i++) {
	                    if (temp[i] != 0) {
	                        compress[idx++] = temp[i];
	                    } 
	                } 
	                // newBoard에 적용
	                for (int r = 0; r < N; r++) {
	                    newBoard[r][c] = compress[r];
	                } 
	            } 
	            break;
	        case 1:
	            for (int c = 0; c < N; c++) {
	                int[] temp = new int[N];
	                int idx = N - 1;
	                for (int r = N - 1; r >= 0; r--) {
	                    if (newBoard[r][c] != 0) {
	                        temp[idx--] = newBoard[r][c];
	                    } 
	                } 
	                for (int r = N - 1; r > 0; r--) {
	                    if (temp[r] == temp[r-1] && temp[r] != 0) {
	                        temp[r] *= 2;
	                        temp[r-1] = 0;
	                        r--;
	                    } 
	                } 
	                int[] compress = new int[N];
	                idx = N - 1;
	                for (int i = N - 1; i >= 0; i--) {
	                    if (temp[i] != 0) {
	                        compress[idx--] = temp[i];
	                    } 
	                } 
	                // 아래를 기준으로 잡았으므로, 담는 순서도 반대
	                for (int r = N - 1; r >= 0; r--) {
	                    newBoard[r][c] = compress[r];
	                } 
	            } 
	            break;
            case 2: // 왼쪽으로 미는 동작이므로
                for (int r = 0; r < N; r++) { // 각 로우에 대해 진행
	                int[] temp = new int[N];
	                // 각 로우에 대해 존재하는 값들만 계산을 위해 0인 부분은 제외하고 배열에 담기
	                int idx = 0;
	                for (int c = 0; c < N; c++) {
	                    if (newBoard[r][c] != 0) {
	                        temp[idx++] = newBoard[r][c];
	                    } 
	                } 
	                for (int c = 0; c < N - 1; c++) {
	                    if (temp[c] == temp[c+1] && temp[c] != 0) {
	                        temp[c] *= 2;
	                        temp[c+1] = 0;
	                        c++;
	                    } 
	                } 
	                int[] compress = new int[N];
	                idx = 0;
	                for (int i = 0; i < N; i++) {
	                    if (temp[i] != 0) {
	                        compress[idx++] = temp[i];
	                    } 
	                } 
	                for (int c = 0; c < N; c++) {
	                    newBoard[r][c] = compress[c];
	                } 
	            } 
	            break;
            case 3:
                for (int r = 0; r < N; r++) {
	                int[] temp = new int[N];
	                int idx = N - 1;
	                for (int c = N - 1; c >= 0; c--) {
	                    if (newBoard[r][c] != 0) {
	                        temp[idx--] = newBoard[r][c];
	                    } 
	                } 
	                for (int c = N - 1; c > 0; c--) {
	                    if (temp[c] == temp[c-1] && temp[c] != 0) {
	                        temp[c] *= 2;
	                        temp[c-1] = 0;
	                        c--;
	                    } 
	                } 
	                int[] compress = new int[N];
	                idx = N - 1;
	                for (int i = N - 1; i >= 0; i--) {
	                    if (temp[i] != 0) {
	                        compress[idx--] = temp[i];
	                    } 
	                } 
                    // 오른쪽을 기준으로 잡았으므로, 담는 순서도 반대
	                for (int c = N - 1; c >= 0; c--) {
	                    newBoard[r][c] = compress[c];
	                } 
	            } 
	            break;
	    }
	    return newBoard;
	}
	private static int findMaxValue(int[][] board) {
	    int max = 0;
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            max = Math.max(max, board[i][j]);
	        } 
	    } 
	    return max;
	}
}