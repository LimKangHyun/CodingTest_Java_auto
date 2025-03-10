import java.io.*;
import java.util.*;

public class Main {
    static String a;
    static String b;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        a = br.readLine();
        b = br.readLine();
        dp = new int[a.length() + 1][b.length() + 1];
        
        lcs();
        bw.write(String.valueOf(dp[a.length()][b.length()]));
        bw.flush();
    }
    
    private static void lcs() {
        for (int i = 1; i <= a.length(); i++) {
            for(int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        } 
    }
}