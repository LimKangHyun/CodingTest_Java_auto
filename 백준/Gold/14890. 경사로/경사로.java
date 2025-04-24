import java.io.*;
import java.util.*;

public class Main {
    private static int N, ramp;
    private static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ramp = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    } 
		} 
		int count = 0;
		for (int i = 0; i < N; i++) {
		    if (findRoadRow(i)) count++;
		    if (findRoadCol(i)) count++; 
		} 
		bw.write(String.valueOf(count));
		bw.flush();
	}
	private static boolean findRoadRow(int row) {
	    boolean[] installed = new boolean[N];
	    for (int i = 0; i < N-1; i++) {
	        int gap = map[row][i] - map[row][i+1];
	        if (Math.abs(gap) > 1) return false;
	        if (gap == 1) {
                for (int j = ramp; j > 0; j--) {
                    // 0보다 작아 맵을 벗어나서 설치해야하거나 or 이미 설치되있는곳에 설치해야하거나
    	            if (i + j >= N || installed[i+j]) return false;
    	            // 경사로를 깔 곳의 길이만큼이 전부 1만큼 낮은지 확인(i=0이 i=1보다 높으므로)
    	            if (map[row][i] - 1 != map[row][i+j]) return false;
    	            installed[i+j] = true;
	            } 
            } else if(gap == -1) {
                for (int j = 0; j < ramp; j++) {
    	            if (i - j < 0 || installed[i-j]) return false;
    	            // 경사로를 깔 곳의 길이만큼이 전부 1만큼 낮은지 확인
    	            //(i=0부터 경사로의 길이만큼 높이가 같은지 확인)
    	            if (map[row][i] != map[row][i-j]) return false;
    	            installed[i-j] = true;
	            } 
            }
	    } 
	    return true;
	}
	private static boolean findRoadCol(int col) {
	    boolean[] installed = new boolean[N];
	    for (int i = 0; i < N-1; i++) {
	        int gap = map[i][col] - map[i+1][col];
	        if (Math.abs(gap) > 1) return false;
	        if (gap == 1) {
                for (int j = ramp; j > 0; j--) {
    	            if (i + j >= N || installed[i+j]) return false;
    	            if (map[i][col] - 1 != map[i+j][col]) return false;
    	            installed[i+j] = true;
	            } 
            } else if(gap == -1) {
                for (int j = 0; j < ramp; j++) {
    	            if (i - j < 0 || installed[i-j]) return false;
    	            if (map[i][col] != map[i-j][col]) return false;
    	            installed[i-j] = true;
	            } 
            }
	    } 
	    return true;
	}
}