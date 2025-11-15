import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++)  {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < M; j++) {
		        arr[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int sx = Integer.parseInt(st.nextToken()) - 1;
		    int sy = Integer.parseInt(st.nextToken()) - 1;
		    int ex = Integer.parseInt(st.nextToken()) - 1;
		    int ey = Integer.parseInt(st.nextToken()) - 1;
		    int result = 0;
    		for (int i = sx; i <= ex; i++) {
    		    for (int j = sy; j <= ey; j++) {
    		        result += arr[i][j];
    		    }
    		}
    		sb.append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}