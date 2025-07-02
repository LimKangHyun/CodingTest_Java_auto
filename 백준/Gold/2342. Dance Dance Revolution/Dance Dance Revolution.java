import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] move;
    private static int[][][] dp;
    private static int minForce = Integer.MAX_VALUE;
    
    private static int getForce(int from, int to) {
        if (from == 0) return 2;
        if (from == to) return 1;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int len = input.length - 1;
		move = new int[len];
		for (int i = 0; i < len; i++) {
		    move[i] = Integer.parseInt(input[i]);
		} 
		dp = new int[len + 1][5][5]; // [순번][왼발][오른발] 순번은 0에서 시작하므로, len + 1
		for (int i = 0; i <= len; i++) {
		    for (int j = 0; j < 5; j++) {
		        Arrays.fill(dp[i][j], Integer.MAX_VALUE);
		    } 
		} 
		// 0,0에서 시작
		dp[0][0][0] = 0;
		
		for (int step = 0; step < len; step++) {
		    int next = move[step];
		    
		    for (int l = 0; l < 5; l++) {
		        for (int r = 0; r < 5; r++) {
		            int cost = dp[step][l][r];
		            if (cost == Integer.MAX_VALUE) continue;
		            // 왼발 이동
		            if (next != r) {
		                dp[step + 1][next][r] = Math.min(dp[step+1][next][r], cost + getForce(l, next));
		            } 
		            // 오른발 이동
		            if (next != l) {
		                dp[step + 1][l][next] = Math.min(dp[step+1][l][next], cost + getForce(r, next));
		            }
		        } 
		    } 
		} 
		int answer = Integer.MAX_VALUE;
		for(int l = 0; l < 5; l++) {
		    for (int r = 0; r < 5; r++) {
		        answer = Math.min(answer, dp[len][l][r]);
		    } 
		}
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}