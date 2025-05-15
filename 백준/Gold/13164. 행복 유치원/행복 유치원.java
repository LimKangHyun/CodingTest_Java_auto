import java.io.*;
import java.util.*;

public class Main {

    static int n, k, result;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);

        arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);
        solve();

        bw.write(String.valueOf(result));
        bw.newLine();
        bw.flush();
    }

    public static void solve() {
        for (int i = 1; i < n; i++) {
            list.add(arr[i] - arr[i - 1]);
        }

        Collections.sort(list);

        for (int i = 0; i < n - k; i++) {
            result += list.get(i);
        }
    }
}