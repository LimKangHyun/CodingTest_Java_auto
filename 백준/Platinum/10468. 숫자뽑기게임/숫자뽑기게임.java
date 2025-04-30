import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();

        while (!(input = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            dp = new int[N][N];
            for (int[] row : dp) Arrays.fill(row, -1);
            sb.append(solve(0, N - 1)).append("\n");
        }
        System.out.print(sb);
    }
    // 구간 [l, r]에서 얻을 수 있는 최대 점수
    static int solve(int l, int r) {
        if (r - l <= 1) return 0; // 구간에 2개 이하만 남으면 더 이상 제거 불가
        if (dp[l][r] != -1) return dp[l][r];

        int max = 0;
        for (int i = l + 1; i < r; i++) {
            // 코드에서 첫 solve함수 진입이라면 탑다운 방식으로,
            // 마지막 점수의 합은 l + i + r일 것이다라고 가정하고 반대로 진행
            int score = arr[l] + arr[i] + arr[r];
            max = Math.max(max, solve(l, i) + solve(i, r) + score);
        }
        return dp[l][r] = max;
    }
}