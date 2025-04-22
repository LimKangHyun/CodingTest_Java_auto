import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
		    arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		} 
		while(M-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int start = Integer.parseInt(st.nextToken());
		    int end = Integer.parseInt(st.nextToken());
		    
		    int result = arr[end] - arr[start - 1];
		    sb.append(result + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}