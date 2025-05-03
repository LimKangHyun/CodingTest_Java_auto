import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
		    N = Integer.parseInt(br.readLine());
		    arr = new int[N][2];
		    
		    for (int i = 0; i < N; i++) {
		        String[] input = br.readLine().split(" ");
		        arr[i][0] = Integer.parseInt(input[0]);
		        arr[i][1] = Integer.parseInt(input[1]);
		    } 
		    Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
		    sb.append(findMaxCount() + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static int findMaxCount() {
	    int min = arr[0][1];
	    int count = 1;
	    for (int i = 1; i < N; i++) {
	        if (arr[i][1] < min) {
	            min = arr[i][1];
	            count++;
	        } 
	    } 
	    return count;
	}
}