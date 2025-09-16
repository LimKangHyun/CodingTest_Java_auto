import java.io.*;
import java.util.*;

public class Main {
    private static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N + 1];
		for (int i = 0; i < Q; i++) {
		    int num = Integer.parseInt(br.readLine());
		    int cur = num;
		    int result = 0;
		    while(cur != 1) {
		        if (visit[cur]) {
		            result = cur; // 맨 앞에서 종료되어야 하므로 break 제거
		        } 
		        cur /= 2;
		    }
		    visit[num] = true;
		    sb.append(result).append("\n");
		} 
		bw.write(sb.toString());
		bw.flush();
	}
}