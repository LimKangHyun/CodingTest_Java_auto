import java.io.*;
import java.util.*;

public class Main {
    private static int D, P;
    private static long max = -1;
    private static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dfs(1L, 0, 2);
		bw.write(String.valueOf(max));
		bw.flush();
	}
	private static void dfs(long num, int depth, int start) {
	    if (String.valueOf(num).length() > D) return;
	    if (depth == P) {
	        max = Math.max(max, num);
	        return;
	    }
	    
	    String key = num + " " + depth;
	    if (set.contains(key)) return;
	    set.add(key);
	    
	    for (int i = start; i <= 9; i++) {
	        long next = num * i;
	        dfs(next, depth + 1, i);
	    }
	}
}