import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] result = new int[N];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(arr);
            int left = 0;
            int right = N - 1;
            for (int i = 0; i < N; i++) {
                if (i % 2 != 0) {
                    result[left] = arr[i];
                    left++;
                } else {
                    result[right] = arr[i];
                    right--;
                }
            }
            int min = Math.abs(result[0] - result[N-1]);
            for (int i = 0; i < N - 1; i++) {
                min = Math.max(min, Math.abs(result[i+1]-result[i]));
            } 
            sb.append(min + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}