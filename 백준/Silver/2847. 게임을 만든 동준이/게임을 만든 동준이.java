import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		} 
		if (N == 1) {
		    bw.write("0\n");
		} else {
		    int count = 0;
		    for (int i = N - 1; i > 0; i--) {
		        int temp = Math.abs(arr[i] - arr[i-1] - 1);
		        if (arr[i-1] >= arr[i]) {
		            count += temp;
		            arr[i-1] -= temp;
		        } 
		    } 
		    bw.write(String.valueOf(count));
		}
		bw.flush();
	}
}