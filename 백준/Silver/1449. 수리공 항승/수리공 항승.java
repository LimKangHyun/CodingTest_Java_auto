import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		int[] leak = new int[N];
		int answer = 1;
		String[] leakPoint = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
		    leak[i] = Integer.parseInt(leakPoint[i]);
		} 
		Arrays.sort(leak);
		int cover = leak[0] + L - 1;
		for (int i = 1; i < N; i++) {
		    if (leak[i] <= cover) {
		        continue;
		    } 
		    cover = leak[i] + L - 1;
		    answer++;
		} 
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}