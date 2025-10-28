import java.io.*;
import java.util.*;

public class Main {
    private static String input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		int[] young = new int[N];
		for (int i = 0; i < N; i++) {
		    map.put(br.readLine(), i);
		}
		for (int i = 0; i < N; i++) {
		    young[i] = map.get(br.readLine());
		}
		int count = 0;
		for (int i = 0; i < N - 1; i++) {
		    for (int j = i + 1; j < N; j++) {
		        if (young[i] > young[j]) {
		            count++;
		            break;
		        }
		    }
		}
		System.out.println(count);
	}
}