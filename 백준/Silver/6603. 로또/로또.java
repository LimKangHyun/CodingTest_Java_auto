import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] lotto;
    static int[] temp = new int[6];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
		    st = new StringTokenizer(br.readLine());
		    k = Integer.parseInt(st.nextToken());
		    if (k == 0) break;
		    lotto = new int[k];
		    for (int i = 0; i < k; i++) {
		        lotto[i] = Integer.parseInt(st.nextToken());
		    }
		    dfs(0, 0);
		    sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int depth, int start) {
	    if (depth == 6) {
	        for (int num : temp) {
	            sb.append(num).append(" ");
	        }
	        sb.append("\n");
	        return;
	    }
	    for (int i = start; i < k; i++) {
	        temp[depth] = lotto[i];
	        dfs(depth + 1, i + 1);
	    }
	}
}