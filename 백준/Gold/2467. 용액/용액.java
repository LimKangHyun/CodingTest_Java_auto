import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int left = 0;
        int right = N - 1;
        int lValue = 0;
        int rValue = 0;
        long min = Long.MAX_VALUE;
        while (left < right) {
            long sum = arr[left] + arr[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                lValue = left;
                rValue = right;
            }
            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }
        bw.write(arr[lValue] + " " + arr[rValue]);
        bw.flush();
    }
}