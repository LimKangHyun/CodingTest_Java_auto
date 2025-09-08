import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    Map<String, Integer> map = new HashMap<>();
		    for (int i = 0; i < n; i++) {
		        st = new StringTokenizer(br.readLine());
    		    String name = st.nextToken();
    		    String type = st.nextToken();
    		    map.put(type, map.getOrDefault(type, 0) + 1);
		    } 
		    int comb = 1;
		    for (String key : map.keySet()) {
		        comb *= map.get(key) + 1;
		    } 
		    sb.append(comb - 1).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}