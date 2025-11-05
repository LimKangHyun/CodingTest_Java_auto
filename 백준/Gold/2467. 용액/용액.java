import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		int num1 = 0;
		int num2 = 0;
		int left = 0;
		int right = N - 1;
		int result = Integer.MAX_VALUE;
		while(left < right) {
		    int sum = arr[left] + arr[right];
		    if (Math.abs(sum) < result) {
		        num1 = arr[left];
		        num2 = arr[right];
		        result = Math.abs(sum);
		    }
		    if (sum <= 0) left++;
		    else right--;
		}
		bw.write(num1 + " " + num2);
		bw.flush();
	}
}