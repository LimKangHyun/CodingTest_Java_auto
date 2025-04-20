import java.io.*;
import java.util.*;

public class Main {
    private static int[] dice = new int[6];
    private static int[] dx = {0, 0, -1, 1}; // 동 서 북 남
    private static int[] dy = {1, -1, 0, 0};
    private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < M; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    } 
		} 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
		    int dir = Integer.parseInt(st.nextToken());
		    int nx = x + dx[dir - 1];
		    int ny = y + dy[dir - 1];
		    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
		        rollDice(dir);
		        if (map[nx][ny] == 0) {
		            map[nx][ny] = dice[1];
		        } else {
		            dice[1] = map[nx][ny];
		            map[nx][ny] = 0;
		        }
		        x = nx;
		        y = ny;
		        sb.append(dice[0] + "\n");
		    } 
		} 
		bw.write(sb.toString());
		bw.flush();
	}
	private static void rollDice(int dir) {
	    int[] temp = dice.clone();
	    
	    if (dir == 1) {
	        dice[0] = temp[4];
	        dice[1] = temp[5];
	        dice[4] = temp[1];
	        dice[5] = temp[0];
	    } else if (dir == 2) {
	        dice[0] = temp[5];
	        dice[1] = temp[4];
	        dice[4] = temp[0];
	        dice[5] = temp[1];
	    } else if (dir == 3) {
	        dice[0] = temp[3];
	        dice[1] = temp[2];
	        dice[2] = temp[0];
	        dice[3] = temp[1];
        } else if (dir == 4) {
            dice[0] = temp[2];
            dice[1] = temp[3];
            dice[2] = temp[1];
            dice[3] = temp[0];
        }
	}
}