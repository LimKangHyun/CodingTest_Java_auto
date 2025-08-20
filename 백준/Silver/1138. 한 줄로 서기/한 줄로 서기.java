import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(input[i]);
		} 
		List<Integer> answer = new ArrayList<>();
		
		for (int i = N; i >= 1; i--) {
		    answer.add(arr[i-1], i);
		} 
		for (int num : answer) sb.append(num).append(" "); 
		bw.write(sb.toString());
		bw.flush();
	}
}