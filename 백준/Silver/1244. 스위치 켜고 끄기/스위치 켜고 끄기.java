import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int gender = Integer.parseInt(st.nextToken());
		    int num = Integer.parseInt(st.nextToken());
		    if (gender == 1) {
		        for (int i = num; i <= N; i += num) {
		            arr[i] = change(arr[i]);
		        }
		        continue;
		    }
		    int left = num - 1;
		    int right = num + 1;
		    arr[num] = change(arr[num]);
		    while (left >= 1 && right <= N) {
		        if (arr[left] != arr[right]) break;
		        arr[left] = arr[right] = change(arr[left]);
		        left--;
		        right++;
		    }
		}
		for (int i = 1; i <= N; i++) {
		    sb.append(arr[i]).append(" ");
		    if (i % 20 == 0) sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static int change(int power) {
	    if (power == 1) return 0;
	    return 1;
	}
}