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
		
		int sum = 0;
	    for (int num : arr) {
	        if (num > sum + 1) {
	            break;
	        } 
	        sum += num;
	    } 
		bw.write(String.valueOf(sum + 1));
		bw.flush();
	}
}