import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		} 
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
		    while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
		        result[stack.pop()] = arr[i];
		    }
		    stack.push(i);
		} 
		while(!stack.isEmpty()) {
		    result[stack.pop()] = -1;
		}
		Arrays.stream(result).forEach(i -> sb.append(i + " "));
		bw.write(sb.toString());
		bw.flush();
	}
}