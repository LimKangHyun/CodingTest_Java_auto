import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] snack = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    snack[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(snack);
		int max = 0;
		int left = 1;
		int right = snack[N - 1];
		while (left <= right) {
		    int mid = (left + right) / 2;
		    int count =  0;
		    for (int i = 0; i < N; i++) {
		        count += snack[i] / mid;
		    }
		    if (count >= M) {
		        max = mid;
		        left = mid + 1;
		    } else right = mid - 1;
		}
		System.out.println(max);
	}
}