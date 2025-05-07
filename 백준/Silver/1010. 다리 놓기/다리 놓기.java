import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            long result = 1;
            for(int i = 0; i < N; i++) {
                result *= (M-i);
                result /= (i+1);
            }
            sb.append(result + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}