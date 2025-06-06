import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
        arr = new int[input];
        dp = new Integer[input];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        findMax(input);
        
        int max = 0;
        for(int i = 0; i < input; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
    }
    
    private static void findMax(int input) {
        for(int i = 0; i < input; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
    }
}