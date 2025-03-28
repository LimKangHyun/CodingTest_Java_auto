import java.io.*;
import java.util.*;

public class Main {
    private static long min = 3000000001L;
    private static long[] answer = new long[3];
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    long[] arr = new long[N];
	    String[] input = br.readLine().split(" ");
	    for (int i = 0; i < N; i++) {
	        arr[i] = Integer.parseInt(input[i]);
	    } 
	    Arrays.sort(arr);
	    for (int i = 0; i < N - 2; i++) {
	        twoPointer(i, arr, i + 1, answer);
	    }
	    Arrays.sort(answer);
	    Arrays.stream(answer).forEach(i -> sb.append(i + " "));
	    bw.write(sb.toString());
		bw.flush();
	}
	private static void twoPointer(int fix, long[] arr, int start, long[] answer) {
	    int left = start;
	    int right = arr.length - 1;
	    
	    while(left < right) {
	        long sum = arr[left] + arr[right] + arr[fix];
	        if (min > Math.abs(sum)) {
	            min = Math.abs(sum);
	            answer[0] = arr[left];
	            answer[1] = arr[right];
	            answer[2] = arr[fix];
	        }
	        if (sum > 0) {
	            right--;
	        } else if (sum <= 0){
	            left++;
	        }
	    }
	}
}