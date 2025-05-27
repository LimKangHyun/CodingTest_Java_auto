import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] paper;
    private static int whiteCnt, blueCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		for (int i = 0; i < n; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < n; j++) {
		        paper[i][j] = Integer.parseInt(st.nextToken());
		    } 
		} 
		cut(0, 0, n);
		bw.write(whiteCnt + "\n" + blueCnt);
		bw.flush();
	}
	private static void cut(int row, int col, int size) {
	    if (cutCheck(row, col, size)) {
	        if (paper[row][col] == 0) whiteCnt++;
	        if (paper[row][col] == 1) blueCnt++;
	        return;
	    } 
	    size = size / 2;
	    cut(row, col, size);
	    cut(row, col + size, size);
	    cut(row + size, col, size);
	    cut(row + size, col + size, size);
	}
	private static boolean cutCheck(int row, int col, int size) {
	    int color = paper[row][col];
	    for (int i = row; i < row + size; i++) {
	        for (int j = col; j < col + size; j++) {
	            if (color != paper[i][j]) return false; 
	        } 
	    } 
	    return true;
	}
}