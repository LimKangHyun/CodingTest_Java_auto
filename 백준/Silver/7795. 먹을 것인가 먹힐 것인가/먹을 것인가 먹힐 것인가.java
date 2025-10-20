import java.io.*;
import java.util.*;

public class Main {
    private static int[] A;
    private static int[] B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int N = Integer.parseInt(st.nextToken());
		    int M = Integer.parseInt(st.nextToken());
		    A = new int[N];
		    B = new int[M];
		    st = new StringTokenizer(br.readLine());
		    for (int i = 0; i < N; i++) {
		        A[i] = Integer.parseInt(st.nextToken());
		    }
		    st = new StringTokenizer(br.readLine());
		    for (int i = 0; i < M; i++) {
		        B[i] = Integer.parseInt(st.nextToken());
		    }
		    Arrays.sort(B);
		    int count = 0;
		    for (int a : A) {
		        count += aBiggerThanB(a);
		    }
		    sb.append(count).append("\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
	private static int aBiggerThanB(int num) {
	    int left = 0;
	    int right = B.length;
	    while(left < right) {
	        int mid = (left + right) / 2;
	        if (B[mid] < num) {
	            left = mid + 1;
	        } else {
	            right = mid;
	        }
	    }
	    return left;
	}
}