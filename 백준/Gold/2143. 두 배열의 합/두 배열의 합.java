import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    // HashMap 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long T = Long.parseLong(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
		    a[i] = Integer.parseInt(st.nextToken());
		} 
		
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
		    b[i] = Integer.parseInt(st.nextToken());
		} 
		
		HashMap<Long, Integer> aSum = new HashMap<>();
		for (int i = 0; i < n; i++) {
		    long sum = 0;
		    for (int j = i; j < n; j++) {
		        sum += a[j];
		        aSum.put(sum, aSum.getOrDefault(sum, 0) + 1);
		    } 
		}
		long count = 0;
		for (int i = 0; i < m; i++) {
		    long sum = 0;
		    for (int j = i; j < m; j++) {
		        sum += b[j];
		        if (aSum.containsKey(T - sum)) {
		            count += aSum.get(T - sum);
		        } 
		    } 
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}