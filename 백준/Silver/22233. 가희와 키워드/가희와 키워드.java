import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
		    set.add(br.readLine());
		} 
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine(), ",");
		    while(st.hasMoreTokens()) {
		        set.remove(st.nextToken());
		    }
		    sb.append(set.size() + "\n");
		} 
		bw.write(sb.toString());
		bw.flush();
	}
}