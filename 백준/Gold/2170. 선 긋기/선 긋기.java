import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] lines = new int[N][2];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken()); //start
		    int y = Integer.parseInt(st.nextToken()); //end
		    lines[i][0] = x;
		    lines[i][1] = y;
		} 
		Arrays.sort(lines, (a, b) -> Integer.compare(a[0], b[0]));
		
		long sum = 0;
		int end = lines[0][1];
		int start = lines[0][0];
		for (int i = 1; i < N; i++) {
		    if (lines[i][0] <= end) {
		        end = Math.max(end, lines[i][1]);
		    } else {
		        sum += end - start;
		        start = lines[i][0];
		        end = lines[i][1];
		    }
		} 
		sum += end - start;
		
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}