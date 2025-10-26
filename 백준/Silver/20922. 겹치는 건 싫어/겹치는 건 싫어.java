import java.io.*;
import java.util.*;

public class Main {
    private static int max = 0;
    private static HashMap<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		while (end < N) {
		    map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
		    while (map.getOrDefault(arr[end], 0) > K) {
		        map.put(arr[start], map.getOrDefault(arr[start], 0) - 1);
		        start++;
		    }
		    end++;
		    max = Math.max(max, end - start);
		}
		bw.write(String.valueOf(max));
		bw.flush();
	}
}