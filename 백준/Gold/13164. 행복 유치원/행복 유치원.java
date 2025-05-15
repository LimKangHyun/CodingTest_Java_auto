import java.io.*;
import java.util.*;

public class Main {

    static int N, K, result;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        arr = new int[N];
        String[] stud = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stud[i]);
        }

        Arrays.sort(arr);
        solve();

        bw.write(String.valueOf(result));
        bw.newLine();
        bw.flush();
    }

    public static void solve() {
        for (int i = 1; i < N; i++) {
            list.add(arr[i] - arr[i - 1]);
        }
        // 키 차이를 정렬해서 키 차이가 가장 작은 순서대로 N - K 개 구분선을 긋겠다.
        // K개로 그룹화를 하려면 N - K의 구분선 필요
        Collections.sort(list);

        for (int i = 0; i < N - K; i++) {
            result += list.get(i);
        }
    }
}