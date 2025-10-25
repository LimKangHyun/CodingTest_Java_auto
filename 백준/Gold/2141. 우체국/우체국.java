import java.io.*;
import java.util.*;

public class Main {
    private static int[][] villages;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		villages = new int[N][2];
		long population = 0;
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    villages[i][0] = Integer.parseInt(st.nextToken());
		    villages[i][1] = Integer.parseInt(st.nextToken());
		    population += villages[i][1];
		}
		Arrays.sort(villages, (a, b) -> a[0] - b[0]);
		long total = 0;
		int office = 0;
		for (int i = 0; i < N; i++) {
		    total += villages[i][1];
		    if (total >= (population + 1) / 2) {
		        office = villages[i][0];
		        break;
		    }
		}
		bw.write(String.valueOf(office));
		bw.flush();
	}
}