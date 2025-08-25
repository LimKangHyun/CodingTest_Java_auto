import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> visitCount = new HashMap<>();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = 0, totalCount = 1;

            while (true) {
                if (x == 0) {
                    x = b % N;
                } else {
                    x = (int) (((1L * a * x % N) * x % N + b) % N);
                }
                //사이클이 반드시 첫 번째 사람(0번)부터 시작하는 것이 아니라, 중간에 시작될 수도 있다는 점을 고려
                if (visitCount.containsKey(x)) {
                    // totalCount - visitCount.get(x)가 사이클의 크기
                    // 즉, N - (사이클)은 술은 마시지 않은 사람!!
                    bw.write(String.valueOf(N - (totalCount - visitCount.get(x))));
                    bw.newLine();
                    visitCount.clear();
                    break;
                } else {
                    visitCount.put(x, totalCount++);
                }
            }
        }
        bw.flush();
    }
}