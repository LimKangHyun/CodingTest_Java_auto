import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		String input;
		int attempt = 0;
		while(!(input = br.readLine()).equals("0 0 0")) {
		    attempt++;
		    st = new StringTokenizer(input);
		    int L = Integer.parseInt(st.nextToken());
		    int P = Integer.parseInt(st.nextToken());
		    int V = Integer.parseInt(st.nextToken());
		    int cycle = V / P;
		    int leftDay = V % P;
		    int canUseDay = (L * cycle) + Math.min(leftDay, L);
		    sb.append("Case " + attempt + ": " + canUseDay + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}