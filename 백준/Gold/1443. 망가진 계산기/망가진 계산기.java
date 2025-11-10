import java.io.*;
import java.util.*;

public class Main {
    private static int D, P;
    private static long max = -1;
    private static long limit = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		limit = (long) Math.pow(10, D);
		dfs(1L, 0, 9);
		bw.write(String.valueOf(max));
		bw.flush();
	}
	private static void dfs(long num, int depth, int start) {
	    if (depth == P) {
	        max = Math.max(max, num);
	        return;
	    }
	    for (int i = start; i >= 2; i--) {
	        if (num * i >= limit) continue;
	        dfs(num * i, depth + 1, i);
	    }
	}
}