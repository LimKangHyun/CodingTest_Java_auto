import java.io.*;
import java.util.*;

public class Main {
    private static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); // 변경
		int K = Integer.parseInt(st.nextToken()); // 구간 합
		
	    arr = new long[N];
		for (int i = 0; i < N; i++) {
		    arr[i] = Long.parseLong(br.readLine());
		} 
		int T = M + K;
		while(T-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    long c = Long.parseLong(st.nextToken());
		    
		    if (a == 1) {
		        changeNum(b, c);
		    } else if (a == 2) {
		        sb.append(addSum(b, c) + "\n");
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static void changeNum(int b, long c) {
	    arr[b - 1] = c;
	}
	private static long addSum(int b, long c) {
	    long result = 0;
	    for (int i = b - 1; i < c; i++) {
	        result += arr[i];
	    } 
	    return result;
	}
}