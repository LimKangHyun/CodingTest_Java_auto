import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
		    int k = Integer.parseInt(br.readLine());
		    TreeMap<Integer, Integer> map = new TreeMap<>();
		    
		    for (int i = 0; i < k; i++) {
		        String[] input = br.readLine().split(" ");
		        String cmd = input[0];
		        int num = Integer.parseInt(input[1]);
		        if (cmd.equals("I")) {
		            map.put(num, map.getOrDefault(num, 0) + 1);
		        } else if (input[0].equals("D")) {
		            if (map.isEmpty()) continue;
		            int key = (num == 1) ? map.lastKey() : map.firstKey();
		            if (map.get(key) == 1) map.remove(key); 
		            else map.put(key, map.get(key) - 1);
		        }
		    }
		    if (map.isEmpty()) {
		        sb.append("EMPTY\n");
		    } else {
		        sb.append(map.lastKey() + " " + map.firstKey() + "\n");
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
}