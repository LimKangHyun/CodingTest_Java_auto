import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		int maxNum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    int num = Integer.parseInt(st.nextToken());
		    arr[i] = num;
		    sum += num;
		    maxNum = Math.max(maxNum, num);
		} 
		int M = Integer.parseInt(br.readLine());
		if (sum < M) {
	        bw.write(String.valueOf(maxNum));
	    } else {
	        int low = 0;
		    int high = maxNum;
    		int answer = 0;    
	        while(low <= high) {
	            int mid = (low + high) / 2;
	            long total = 0;
	            for (int i = 0; i < N; i++) {
	                total += Math.min(arr[i], mid);
	            } 
	            if (total <= M) {
	                answer = mid;
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	        bw.write(String.valueOf(answer));
	    }
		bw.flush();
	}
}