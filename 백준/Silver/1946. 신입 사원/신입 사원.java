import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static List<int[]> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                int doc = Integer.parseInt(input[0]);
                int interview = Integer.parseInt(input[1]);
                arr.add(new int[]{doc, interview});
            }

            arr.sort(Comparator.comparingInt(a -> a[0]));
            sb.append(findMaxCount()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int findMaxCount() {
        int min = arr.get(0)[1];
        int count = 1;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i)[1] < min) { // min보다 크다면, arr[0]보다 서류, 면접 둘다 점수가 크므로 X
                min = arr.get(i)[1];
                count++;
            }
        }
        return count;
    }
}