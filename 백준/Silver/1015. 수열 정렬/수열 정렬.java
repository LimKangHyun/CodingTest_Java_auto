import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n][2];
		int[] p = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
		    a[i][0] = Integer.parseInt(st.nextToken());
		    a[i][1] = i;
		} 
		// a[i][0] 기준 오름차순
		Arrays.sort(a, Comparator.comparingInt(arr -> arr[0]));
		for (int i = 0; i < n; i++) {
		    p[a[i][1]] = i;
		} 
		for (int num : p) sb.append(num + " "); 
		bw.write(sb.toString());
		bw.flush();
	}
}