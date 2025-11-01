import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] tower = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
		    tower[i] = Integer.parseInt(st.nextToken());
		}
		Stack<int[]> stack = new Stack<>();
		for (int i = 1; i <= N; i++) {
		    int height = tower[i];
		    while(!stack.isEmpty() && stack.peek()[0] < height) {
		        stack.pop();
		    }
		    if (stack.isEmpty()) sb.append("0 ");
		    else sb.append(stack.peek()[1]).append(" ");
		    stack.push(new int[] {height, i});
		}
		bw.write(sb.toString());
		bw.flush();
	}
}