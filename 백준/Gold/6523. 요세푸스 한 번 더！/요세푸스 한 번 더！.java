import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 🔥 싸이클 탐색을 위한 토끼와 거북이 알고리즘 적용
            int slow = 0, fast = 0;

            // 1. 싸이클이 발생하는 지점 찾기
            while (true) {
                slow = f(slow, a, b, N);       // 거북이 한 칸 이동
                fast = f(f(fast, a, b, N), a, b, N); // 토끼 두 칸 이동

                if (slow == fast) break; // 싸이클 발견하면 중단
            }

            // 2. 싸이클 길이 구하기
            int cycleStart = slow;
            int cycleLength = 0;
            do {
                cycleLength++;
                slow = f(slow, a, b, N);
            } while (slow != cycleStart);

            // 3. 싸이클이 발생하기 전에 방문한 사람 카운트
            slow = 0;
            int beforeCycle = 0;
            while (slow != cycleStart) {
                beforeCycle++;
                slow = f(slow, a, b, N);
            }

            // 결과 출력
            bw.write(String.valueOf(N - cycleLength));
            bw.newLine();
        }
        bw.flush();
    }

    // 🎯 x = (a * x^2 + b) % N 계산 함수 (안전한 모듈러 연산 적용)
    private static int f(int x, int a, int b, int N) {
        return (int) (((1L * a * x % N) * x % N + b) % N);
    }
}