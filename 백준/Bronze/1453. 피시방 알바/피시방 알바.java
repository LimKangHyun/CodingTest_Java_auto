import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] seat = new int[101];
        int cnt = 0;

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(s[i]);
            if (seat[x] == 0) {
                seat[x] = 1;
            } else {
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt) + "\n");
        bw.flush();
    }
}