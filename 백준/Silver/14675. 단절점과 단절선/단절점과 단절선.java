import java.io.*;
import java.util.*;

public class Main {
    private static int[] degree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		degree = new int[N + 1];
		for (int i = 0; i < N - 1; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    degree[a]++;
		    degree[b]++;
		} 
		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int t = Integer.parseInt(st.nextToken());
		    int k = Integer.parseInt(st.nextToken());
		    sb.append(t == 1 && degree[k] == 1 ? "no" : "yes").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}