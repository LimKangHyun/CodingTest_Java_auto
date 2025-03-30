import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break; // 입력 종료 조건

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // Floyd's Cycle Detection Algorithm
            int slow = 0, fast = 0;

            // 1. Find the meeting point inside the cycle
            do {
                slow = nextValue(slow, a, b, N);
                fast = nextValue(nextValue(fast, a, b, N), a, b, N);
            } while (slow != fast);

            // 2. Find the start of the cycle
            int cycleStart = 0;
            slow = 0;
            while (slow != fast) {
                slow = nextValue(slow, a, b, N);
                fast = nextValue(fast, a, b, N);
                cycleStart++;
            }

            // 3. Calculate the length of the cycle
            int cycleLength = 1;
            fast = nextValue(slow, a, b, N);
            while (slow != fast) {
                fast = nextValue(fast, a, b, N);
                cycleLength++;
            }

            // 술을 마시지 않은 사람의 수는 전체 인원 - 사이클 내부 사람 수
            bw.write(String.valueOf(N - cycleLength));
            bw.newLine();
        }

        bw.flush();
    }

    // f(x) 계산 공식
    private static int nextValue(int x, int a, int b, int N) {
        return (int) (((1L * a * x % N) * x % N + b) % N);
    }
}
