import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        double max = 0;
        max = Math.max((double)A/(double)C, (double)B / (double)D);
        max = Math.ceil(max);
        L -= (int)max;
        bw.write(String.valueOf(L));
        bw.flush();
    }
}