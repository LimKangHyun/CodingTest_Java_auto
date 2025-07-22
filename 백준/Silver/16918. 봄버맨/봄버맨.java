import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char[][] land = new char[R][C];
		int[][] countDown = new int[R][C]; // 각 원소는 터지는 시간
		
		for (int i = 0; i < R; i++) {
		    String input = br.readLine();
		    for (int j = 0; j < C; j++) {
		        land[i][j] = input.charAt(j);
		        if (land[i][j] == 'O') {
		            countDown[i][j] = 3;
		        } 
		    } 
		} 
		int time = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		while(time++ < N) {
		    if (time % 2 == 0) {
		        for (int i = 0; i < R; i++) {
        		    for (int j = 0; j < C; j++) {
        		        if (land[i][j] == '.') {
        		            land[i][j] = 'O';
        		            countDown[i][j] = time + 3; // time + 3 초에 터짐
        		        } 
        		    } 
        		} 
		    } else if (time % 2 == 1) {
		        for (int i = 0; i < R; i++) {
        		    for (int j = 0; j < C; j++) {
        		        if (countDown[i][j] == time) {
        		            land[i][j] = '.';
        		            for (int d = 0; d < 4; d++) {
        		                int ni = i + dx[d];
        		                int nj = j + dy[d];
        		                if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;
        		                if (land[ni][nj] == 'O' && countDown[ni][nj] != time) {
        		                    land[ni][nj] = '.';
        		                    countDown[ni][nj] = 0;
        		                }
        		            } 
        		        } 
        		    }
		        }
		    }
		}
		for (int i = 0; i < R; i++) {
		    for (int j = 0; j < C; j++) {
		        sb.append(land[i][j]);
		    } 
		    sb.append("\n");
		} 
		bw.write(sb.toString());
		bw.flush();
	}
}