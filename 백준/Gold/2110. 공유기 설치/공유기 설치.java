import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int minDis = 0;
		int left = 1;
		int right = arr[N - 1] - arr[0];
		while (left <= right) {
		    int mid = (left + right) / 2;
		    int count = 1; // arr[0]은 무조건 설치
		    int last = arr[0];
		    for (int i = 1; i < N; i++) {
		        if (arr[i] - last >= mid) {
		            count++;
		            last = arr[i];
		        }
		    }
		    if (count >= C) {
		        minDis = mid;
		        left = mid + 1;
		    } else right = mid - 1;
		}
		bw.write(String.valueOf(minDis));
		bw.flush();
	}
}