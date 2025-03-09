import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        // 배열 입력
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터 알고리즘
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;

        for (int right = 0; right < N; right++) {
            sum += arr[right];

            while (sum >= S) {  // 조건 만족하면 최소 길이 갱신 후 left 이동
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }
        }

        // 결과 출력
        bw.write(String.valueOf(minLength == Integer.MAX_VALUE ? 0 : minLength));
        bw.flush();
        bw.close();
        br.close();
    }
}