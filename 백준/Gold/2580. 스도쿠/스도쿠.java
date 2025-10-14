import java.io.*;
import java.util.*;

public class Main {
    private static List<int[]> blanks;
    private static int[][] sdoku = new int[9][9];
    private static boolean[][] rowUsed = new boolean[9][10];
    private static boolean[][] colUsed = new boolean[9][10];
	private static boolean[][] boxUsed = new boolean[9][10];
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for (int i = 0; i < 9; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < 9; j++) {
		        sdoku[i][j] = Integer.parseInt(st.nextToken());
		    } 
		} 
		blanks = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
		    for (int j = 0; j < 9; j++) {
		        if (sdoku[i][j] != 0) {
		            int num = sdoku[i][j];
		            rowUsed[i][num] = true;
		            colUsed[j][num] = true;
		            boxUsed[checkSquare(i, j)][num] = true;
		        } else blanks.add(new int[] {i, j});
		    } 
		} 
		dfs(0);
		bw.write(sb.toString());
		bw.flush();
	}
	private static boolean dfs(int idx) {
	    if (idx == blanks.size()) {
	        for (int[] line : sdoku) {
    		    for (int i = 0; i < 9; i++) {
    		        sb.append(line[i]).append(" ");
    		    }
    		    sb.append("\n");
    		}
    		return true;
	    }
	    int r = blanks.get(idx)[0];
	    int c = blanks.get(idx)[1];
	    for (int i = 1; i <= 9; i++) {
	        if (!rowUsed[r][i] && !colUsed[c][i] && !boxUsed[checkSquare(r, c)][i]) {
	            sdoku[r][c] = i;
	            rowUsed[r][i] = true;
	            colUsed[c][i] = true;
	            boxUsed[checkSquare(r, c)][i] = true;
	            if (dfs(idx + 1)) return true;;
	            sdoku[r][c] = 0;
	            rowUsed[r][i] = false;
	            colUsed[c][i] = false;
	            boxUsed[checkSquare(r, c)][i] = false;
	        }
	    }
	    return false;
	}
	private static int checkSquare(int r, int c) {
	    return (r / 3) * 3 + (c / 3);
	}
}