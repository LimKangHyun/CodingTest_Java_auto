import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] dp = new int[N+2];
		
		for (int i = 1; i <= N; i++) {
		    String[] input = br.readLine().split(" ");
		    T[i] = Integer.parseInt(input[0]);
		    P[i] = Integer.parseInt(input[1]);
		} 
		for (int i = 1; i <= N; i++) {
		    dp[i] = Math.max(dp[i], dp[i-1]); // 전날까지 받은 페이 다음날도 누적되도록
		    int taskEndDay = i + T[i];
		    if (taskEndDay <= N + 1) { // 상담소요기간이 1인 경우 마지막날 + 1일로 계산되므로 N+1
		        dp[taskEndDay] = Math.max(dp[taskEndDay], dp[i] + P[i]);
		    }
		} 
		bw.write(String.valueOf(Math.max(dp[N], dp[N+1]))); // 마지막날에 1일만에 완료되는 상담을 고려
		bw.flush();
	}
}