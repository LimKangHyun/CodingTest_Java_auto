import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input1 = br.readLine().split(" ");
		int N = Integer.parseInt(input1[0]);
		int S = Integer.parseInt(input1[1]);
	    int[] arr = new int[N];
		int result = 0;
		long impos = 0;
		String[] input2 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(input2[i]);
		    impos += arr[i];
		    if (arr[i] >= S) {
		        bw.write(String.valueOf(1));
		        bw.flush();
		        return;
		    } 
		} 
		if (impos < S) {
	        result = 0;
	    } else {
	        int left = 0;
	        int sum = 0;
	        int minL = Integer.MAX_VALUE;
	        for (int right = 0; right < N; right++) {
	            sum += arr[right];
	            while (sum >= S) {
	                minL = Math.min(minL, right - left + 1);
	                sum -= arr[left++];
	            } 
	        } 
	        result = minL == Integer.MAX_VALUE ? 0 : minL;
	    }
		bw.write(String.valueOf(result));
		bw.flush();
	}
}