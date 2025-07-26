import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
		    String input = br.readLine();
		    if (input.length() < M) continue;
		    map.put(input, map.getOrDefault(input, 0) + 1);
		} 
		
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
		    @Override
		    public int compare(String o1, String o2) {
		        
		        if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
		            return Integer.compare(map.get(o2), map.get(o1));
		        }
		        if (o1.length() != o2.length()) {
		            return o2.length() - o1.length();
		        }
		        return o1.compareTo(o2); // 왼쪽부터 문자열 하나씩 비교
		    }
		});
		for (String s : list) sb.append(s).append("\n"); 
		bw.write(sb.toString());
		bw.flush();
	}
}