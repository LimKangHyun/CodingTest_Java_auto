import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
		    int N = Integer.parseInt(br.readLine());
		    int[] arr = new int[N];
		    st = new StringTokenizer(br.readLine());
		    for (int i = 0; i < N; i++) {
		        arr[i] = Integer.parseInt(st.nextToken());
		    } 
		    int maxValue = arr[N - 1];
		    long maxProfit = 0;
		    for (int i = N - 2; i >= 0; i--) {
		        if (maxValue > arr[i]) maxProfit += maxValue - arr[i];
	            else maxValue = arr[i];
		    } 
		    sb.append(maxProfit + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}