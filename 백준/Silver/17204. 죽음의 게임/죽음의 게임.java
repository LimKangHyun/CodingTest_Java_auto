import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 게임 참여자 수
		K = Integer.parseInt(st.nextToken()); // 보성이의 번호
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		} 
		visit = new boolean[N];
		bw.write(String.valueOf(findBosung()));
		bw.flush();
	}
	private static int findBosung() {
	    int count = 0;
	    int cur = 0;
	    while(true) {
	        if (cur == K) return count;
	        if (visit[cur]) return -1;
	        visit[cur] = true;
	        cur = arr[cur];
	        count++;
	    }
	}
}