import java.io.*;
import java.util.*;

public class Main {
    static int sticker;
    static int[][] arr;
    static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		sticker = Integer.parseInt(br.readLine());
		for (int s = 0; s < sticker; s++) {
		    int num = Integer.parseInt(br.readLine());
		    arr = new int[3][num+1];
		    dp = new int[3][num+1];
		    for (int i = 1; i < 3; i++) {
		        StringTokenizer st = new StringTokenizer(br.readLine());
		        for (int j = 1; j <= num; j++) {
		            arr[i][j] = Integer.parseInt(st.nextToken());
		        } 
		    } 
		    dp[1][1] = arr[1][1];
		    dp[2][1] = arr[2][1];
		    bw.write(String.valueOf(findMax(num)));
		    bw.write("\n");
		} 
		bw.flush();
	}
	private static int findMax(int num) {
	    int max = 0;
	    for (int i = 2; i <= num; i++) {
	        dp[1][i] = Math.max(dp[2][i-1], dp[2][i-2]) + arr[1][i];
	        dp[2][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[2][i];
	    } 
	    max = Math.max(dp[1][num], dp[2][num]);
	    return max;
	}
}