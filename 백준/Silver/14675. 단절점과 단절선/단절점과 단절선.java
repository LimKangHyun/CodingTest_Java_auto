import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++) {
		    graph.add(new ArrayList<>());
		} 
		for (int i = 0; i < N - 1; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    graph.get(a).add(b);
		    graph.get(b).add(a);
		} 
		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int t = Integer.parseInt(st.nextToken());
		    int k = Integer.parseInt(st.nextToken());
		    if (t == 1) {
		        sb.append(graph.get(k).size() == 1 ? "no" : "yes").append("\n");
		        continue;
		    }
		    sb.append("yes").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}