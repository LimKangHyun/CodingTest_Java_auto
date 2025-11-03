import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		int max = 0;
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		    max = Math.max(max, arr[i]);
		}
		long maxLiter = 0;
		long left = 1;
		long right = max;
		while(left <= right) {
		    long mid = (left + right) / 2;
		    int count = 0;
		    for (int i = 0; i < N; i++) {
		        count += arr[i] / mid;
		    }
		    if (count >= K) {
		        maxLiter = mid;
		        left = mid + 1;
		    } else right = mid - 1;
		}
		bw.write(String.valueOf(maxLiter));
		bw.flush();
	}
}