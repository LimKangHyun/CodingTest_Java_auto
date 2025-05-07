import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    arr[i][0] = Integer.parseInt(st.nextToken());
		} 
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
		for (int i = 0; i < N - 1; i++) {
		    arr[i][1] = arr[i+1][0] - arr[i][0];
		} 
		Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
		int answer = 0;
		// 간격큰대로 순서대로 짜르기
		for (int i = K - 1; i < N; i++) {
		    answer += arr[i][1];
		} 
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}