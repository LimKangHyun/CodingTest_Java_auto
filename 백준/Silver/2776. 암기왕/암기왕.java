import java.io.*;
import java.util.*;

public class Main {
    private static int[] note1;
    private static int[] note2;
    private static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
		    int N = Integer.parseInt(br.readLine());
		    st = new StringTokenizer(br.readLine());
		    note1 = new int[N];
		    for (int i = 0; i < N; i++) {
		        note1[i] = Integer.parseInt(st.nextToken());
		    }
		    int M = Integer.parseInt(br.readLine());
		    st = new StringTokenizer(br.readLine());
		    note2 = new int[M];
		    count = new int[M];
		    for (int i = 0; i < M; i++) {
		        note2[i] = Integer.parseInt(st.nextToken());
		    }
		    Arrays.sort(note1);
		    for (int i = 0; i < M; i++) {
		        int left = 0;
    		    int right = N - 1;
    		    while (left <= right) {
    		        int mid = (left + right) / 2;
    		        if (note1[mid] == note2[i]) {
    		            count[i]++;
    		            break;
    		        }
    		        else if (note2[i] < note1[mid]) {
    		            right = mid - 1;
    		        } else left = mid + 1;
    		    }
		    }
		    for (int n : count) sb.append(n).append("\n");
		}
	    bw.write(sb.toString());
		bw.flush();
	}
}