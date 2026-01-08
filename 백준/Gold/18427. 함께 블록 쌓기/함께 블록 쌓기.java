import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
            list[i].add(0);
        }
        int[] dp = new int[H + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            int[] next = new int[H + 1];
            for (int h = 0; h <= H; h++) {
                if (dp[h] == 0) continue;
                for (int x : list[i]) {
                    if (h + x <= H) {
                        next[h + x] = (next[h + x] + dp[h]) % 10007;
                    }
                }
            }
            dp = next;
        }
        bw.write(String.valueOf(dp[H]));
        bw.flush();
    }
}