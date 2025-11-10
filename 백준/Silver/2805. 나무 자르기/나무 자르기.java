import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lan = new int[N];
        long max = 0;
        long min = 1;
        long mid = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lan[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lan[i]);
        }
        
        while(min <= max) {
            mid = (min + max) / 2;
            long count = 0;
            for (int i = 0; i < lan.length; i++) {
                if(mid < lan[i]) {
                    count += lan[i] - mid;
                }
            } 
            if (count < M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}