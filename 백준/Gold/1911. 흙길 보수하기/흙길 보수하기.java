import java.io.*;
import java.util.*;

public class Main {
    private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] puddles = new int[N][2];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    puddles[i][0] = Integer.parseInt(st.nextToken());
		    puddles[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(puddles, (a, b) -> a[0] - b[0]);
		int cover = 0;
		int count = 0;
		for (int[] puddle : puddles) {
		    if (cover < puddle[0]) {
		        cover = puddle[0];
		    }
		    if (cover < puddle[1]) {
		        int need = (puddle[1] - cover + L - 1) / L;
		        count += need;
		        cover += need * L;
		    }
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}