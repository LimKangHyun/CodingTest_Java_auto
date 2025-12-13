import java.io.*;

public class Main {
    static int N;
    static boolean done = false;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(0);
	}
	private static void dfs(int depth) {
	    if (done) return;
	    if (depth == N) {
	        System.out.println(sb.toString());
	        done = true;
	        return;
	    }
	    for (int i = 1; i <= 3; i++) {
	        sb.append(i);
	        if (isGood()) dfs(depth + 1);
	        sb.setLength(sb.length() - 1);
	    }
	}
	private static boolean isGood() {
	    for (int i = 1; i <= sb.length() / 2; i++) {
	        boolean same = true;
	        for (int j = 0; j < i; j++) {
	            if (sb.charAt(sb.length() - 1 - j) != sb.charAt(sb.length() - 1 - i - j)) {
	                same = false;
	                break;
	            }
	        }
	        if (same) return false;
	    }
	    return true;
	}
}