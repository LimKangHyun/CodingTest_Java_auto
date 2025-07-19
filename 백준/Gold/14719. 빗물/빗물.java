import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] h = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
		    h[i] = Integer.parseInt(st.nextToken());
		} 
		int result = 0;
		for (int i = 1; i < W - 1; i++) {
		    int left = 0;
		    int right = 0;
		    for (int j = 0; j < i; j++) {
		        left = Math.max(left, h[j]);
		    } 
		    for (int j = i + 1; j < W; j++) {
		        right = Math.max(right, h[j]);
		    } 
		    if (h[i] < left && h[i] < right) result += Math.min(left, right) - h[i];
		} 
		bw.write(String.valueOf(result));
		bw.flush();
	}
}