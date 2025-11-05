import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] arr = new int[M];
		int maxEnvy = 0;
		for (int i = 0; i < M; i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		    maxEnvy = Math.max(maxEnvy, arr[i]);
		}
		int left = 1;
		int right = maxEnvy;
		int min = 0;
		while(left <= right) {
		    int mid = (left + right) / 2;
		    int count = 0;
		    for (int i = 0; i < M; i++) {
		        count += (arr[i] + mid - 1) / mid;
		    }
		    if (count <= N) {
		        min = mid;
		        right = mid - 1;
		    } else left = mid + 1;
		}
		bw.write(String.valueOf(min));
		bw.flush();
	}
}