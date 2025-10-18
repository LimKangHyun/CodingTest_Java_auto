import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		long[] counts = new long[10];
		long p = 1;
		while (p <= N) {
		    long higher = N / (p * 10); // 1 0
		    long current = (N / p) % 10; // 9 1
		    long lower = N % p; // 0 9
		    for (int i = 0; i <= 9; i++) {
		        counts[i] += higher * p;
		        if (i < current) {
		            counts[i] += p;
		        } else if (i == current) {
		            counts[i] += lower + 1;
		        }
		    }
		    counts[0] -= p;
		    p *= 10;
		}
		for (long count : counts) sb.append(count).append(" ");
		bw.write(sb.toString());
		bw.flush();
	}
}