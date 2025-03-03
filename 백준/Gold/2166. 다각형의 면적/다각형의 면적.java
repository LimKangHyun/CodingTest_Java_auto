import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        long[][] arr = new long[num][2]; // 좌표 값이 클 수도 있으므로 long 사용

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
        
        // 반올림 적용하여 정확한 출력 보장
        bw.write(String.format("%.1f", Math.round(Math.abs(result / 2) * 10) / 10.0));
        bw.newLine(); // 줄바꿈 추가
		bw.flush();
	}
}