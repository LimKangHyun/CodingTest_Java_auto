import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n.length(); i++) {
		    int num = n.charAt(i) - 48;
		    if (num != 6 && num != 9) {
		        map.put(num, map.getOrDefault(num, 0) + 1);
		    } else map.put(6, map.getOrDefault(6, 0) + 1);
		} 
		int setCount = 0;
		for(Integer key : map.keySet()) {
		    if (key != 6) setCount = Math.max(setCount, map.get(key));
		    else {
		        if (map.get(key) % 2 == 0) setCount = Math.max(setCount, map.get(key) / 2);
		        else setCount = Math.max(setCount, map.get(key) / 2 + 1);
		    }
		}
		bw.write(String.valueOf(setCount));
		bw.flush();
	}
}