import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[N+1];
		Arrays.fill(isPrime, 2, N+1, true);
		List<Integer> list = new ArrayList<>();
		
		for (int i = 2; i * i <= N; i++) {
		    if(isPrime[i]) {
		        for (int j = i * i; j <= N; j += i) {
    		        isPrime[j] = false;
    		    }     
		    }
		}
		for (int i = 2; i <= N; i++) {
		    if(isPrime[i]) {
		        list.add(i);
		    }
		} 
		int[] arr = list.stream().mapToInt(i -> i).toArray();
		int answer = CountSubSum(N, arr);
		bw.write(String.valueOf(answer));
		bw.flush();
	}
	private static int CountSubSum (int N, int[] arr) {
	    int left = 0;
	    int sum = 0;
	    int count = 0;
	    
	    for (int right = 0; right < arr.length; right++) {
	        sum += arr[right];
	        while(sum > N && left <= right) {
	            sum -= arr[left];
	            left++;
	        }
	        if (sum == N) {
	            count++;
	        } 
	    } 
	    return count;
	}
}