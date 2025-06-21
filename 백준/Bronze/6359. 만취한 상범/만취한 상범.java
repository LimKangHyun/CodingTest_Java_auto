import java.io.*;
import java.util.*;

public class Main {
    static int room[] = new int[120];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Arrays.fill(room, 0);

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k * j <= n; k++) {
                    if (room[k * j] == 0) {
                        room[k * j]++;
                    } else {
                        room[k * j]--;
                    }
                }
            }
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (room[j] == 1) {
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
    }
}