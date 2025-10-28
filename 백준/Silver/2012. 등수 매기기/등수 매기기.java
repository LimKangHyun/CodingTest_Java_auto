import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		long count = 0;
		for (int i = 1; i <= N; i++) {
		    count += Math.abs(i - arr[i - 1]);
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}