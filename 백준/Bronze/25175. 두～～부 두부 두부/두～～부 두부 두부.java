import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int next = 0;
		
		if (n >= 3) {
			
			int[] arr = new int[n + 1];
			
			arr[1] = m - 2 > 0 ? m - 2 : m - 2 + n;
			arr[2] = m - 1 > 0 ? m - 1 : m - 1 + n;
			arr[3] = m;
			
			for (int i = 4; i <= n; i++) {
				arr[i] = arr[i - 1] + 1 > n ? arr[i - 1] + 1 - n : arr[i - 1] + 1;
			}
			
			if (k < 0) { 
				next = arr[k % n + n];
			} else { 
				next = arr[k % n == 0 ? n : k % n];
			}
		} else if (n == 1) { 
			next = 1;
		} else if (n == 2) { 
			if (k % 2 == 0) {
				next = m == 1 ? 2 : 1;
			} else {
				next = m == 1 ? 1 : 2;
			}
		}
		bw.write(String.valueOf(next));
		bw.flush();
	}
}