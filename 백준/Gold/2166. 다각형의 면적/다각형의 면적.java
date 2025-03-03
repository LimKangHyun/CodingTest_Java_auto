import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        long[][] arr = new long[num][2];
        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Long.parseLong(input[0]);
            arr[i][1] = Long.parseLong(input[1]);
        } 
        double result = 0;
        for (int i = 0; i < num; i++) {
            result += arr[i][0] * arr[(i+1) % num][1];
            result -= arr[i][1] * arr[(i+1) % num][0];
        } 
        bw.write(String.format("%.1f", Math.abs(result / 2)));
		bw.flush();
	}
}